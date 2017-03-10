/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;
import com.agenda.db.ConnectionFactory;
import com.agenda.db.DbUtil;
import com.agenda.model.Interviewed;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Baradofaragon
 */
public class InterviewedDAO {
    private Connection connection;
    private Statement statement;
    
    public InterviewedDAO(){}
    
     public List<Interviewed> getInterviewedList() throws SQLException {
        String query = "SELECT * FROM interviewed;";
        ResultSet rs = null;
        Interviewed interviewed;
        List itdList = new ArrayList<Interviewed>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("interviewed_id");
                String name = rs.getString("interviewed_name");
                interviewed = new Interviewed(id,name);
                itdList.add(interviewed);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return itdList;
    }
      public Boolean isEmpty() throws SQLException {
        String query = "select * from interviewed;";
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
