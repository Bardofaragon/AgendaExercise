/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;

import com.agenda.db.ConnectionFactory;
import com.agenda.db.DbUtil;
import com.agenda.model.Interviewed;
import com.agenda.model.Place;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Baradofaragon
 */
public class PlaceDAO {
    private Connection connection;
    private Statement statement;
    
    public PlaceDAO(){}
    
     public List<Place> getPlaceList() throws SQLException {
        String query = "SELECT * FROM place;";
        ResultSet rs = null;
        List placeList = new ArrayList<Interviewed>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("place_id");
                placeList.add(new Place(id));
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return placeList;
    }
      public Boolean isEmpty() throws SQLException {
        String query = "select * from place;";
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
           if(rs == null){
               return true;
           }
           else{
               return false;
           }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }
}
