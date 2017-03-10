/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;
import com.agenda.db.AppointmentSQL;
import com.agenda.db.ConnectionFactory;
import com.agenda.db.DbUtil;
import com.agenda.model.Appointment;
import com.agenda.model.Interviewer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Baradofaragon
 */
public class AppointmentDAO {
    private Connection connection;
    private Statement statement;
    
    public AppointmentDAO(){}
    
    public List<Appointment> getAppointments() throws SQLException, ParseException {
        String query = "select daydesc, appointment.place_id, interview_start, interview_end, interviewer_name, interviewed_name from appointment, place, hours, interviewer, interviewed where place.place_id = appointment.place_id AND hours.hours_id = appointment.hours_id AND interviewer.interviewer_id = appointment.interviewer_id AND interviewed.interviewed_id = appointment.interviewed_id ORDER BY daydesc, interview_start;";
        ResultSet rs = null;
        List aList = new ArrayList<Appointment>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            while (rs.next()) {
                //java.util.Date date = formatter.parse(rs.getString("daydesc"));
                //Date sqlDate =  new java.sql.Date(date.getTime());
                Date sqlDate = rs.getDate("daydesc");
                int place = rs.getInt("place_id");
                String start = rs.getString("interview_start");
                String end = rs.getString("interview_end");
                String interviewer = rs.getString("interviewer_name");
                String interviewed = rs.getString("interviewed_name");
                aList.add(new Appointment(sqlDate,place+"",start,end,interviewer,interviewed));
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return aList;
    }
    
    public List<Appointment> getAppointmentsByIr(String user) throws ParseException {
        String query = "select daydesc, Appointment.place_id, interview_start, interview_end, interviewer_name, interviewed_name, appointment.interviewer_id from appointment, place, hours, interviewer, interviewed where place.place_id = appointment.place_id AND hours.hours_id = appointment.hours_id AND interviewer.interviewer_id = appointment.interviewer_id AND interviewed.interviewed_id = appointment.interviewed_id AND ";  
        if(user != null && !user.equals("")){
            query += "appointment.interviewer_id = " + user;
        }
        query+=" ORDER BY daydesc,interview_start;";
        ResultSet rs = null;
        List aList = new ArrayList<Appointment>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            while (rs.next()) {
            //java.util.Date date = formatter.parse(rs.getString("daydesc"));
            //Date sqlDate =  new java.sql.Date(date.getTime());
                Date sqlDate = rs.getDate("daydesc");
                int place = rs.getInt("place_id");
                String start = rs.getString("interview_start");
                String end = rs.getString("interview_end");
                String interviewer = rs.getString("interviewer_name");
                String interviewed = rs.getString("interviewed_name");
                int interviewer_id = rs.getInt("interviewer_id");
                aList.add(new Appointment(sqlDate,place+"",start,end,interviewer,interviewed, interviewer_id));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return aList;
    }
    public List<Appointment> getAppointmentsByDay(String day) throws SQLException, ParseException {
        String query = "select daydesc, Appointment.place_id, interview_start, interview_end, interviewer_name, interviewed_name from appointment, place, hours, interviewer, interviewed where place.place_id = appointment.place_id AND hours.hours_id = appointment.hours_id AND interviewer.interviewer_id = appointment.interviewer_id AND interviewed.interviewed_id = appointment.interviewed_id AND ";  
        //if(day != null && !day.equals("")){
        query += "appointment.daydesc = \"" + day + "\"" ;
       // }
        query+=" ORDER BY daydesc,interview_start;";
        ResultSet rs = null;
        List aList = new ArrayList<Appointment>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            while (rs.next()) {
            //java.util.Date date = formatter.parse(rs.getString("daydesc"));
            //Date sqlDate =  new java.sql.Date(date.getTime());
                Date sqlDate = rs.getDate("daydesc");
                int place = rs.getInt("place_id");
                String start = rs.getString("interview_start");
                String end = rs.getString("interview_end");
                String interviewer = rs.getString("interviewer_name");
                String interviewed = rs.getString("interviewed_name");
                aList.add(new Appointment(sqlDate,place+"",start,end,interviewer,interviewed));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return aList;
    }
    
    public List<Appointment> getAppointmentsByPlace(String place) throws SQLException, ParseException {
        String query = "select daydesc, Appointment.place_id, interview_start, interview_end, interviewer_name, interviewed_name from appointment, place, hours, interviewer, interviewed where place.place_id = appointment.place_id AND hours.hours_id = appointment.hours_id AND interviewer.interviewer_id = appointment.interviewer_id AND interviewed.interviewed_id = appointment.interviewed_id ";  
        if(place != null && !place.equals("")){
            query += "AND appointment.place_id = " + place + " ";
        }
        query+="ORDER BY daydesc,interview_start;";
        ResultSet rs = null;
        List aList = new ArrayList<Appointment>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            while (rs.next()) {
            //java.util.Date date = formatter.parse(rs.getString("daydesc"));
            //Date sqlDate =  new java.sql.Date(date.getTime());
                Date sqlDate = rs.getDate("daydesc");
                int place1 = rs.getInt("place_id");
                String start = rs.getString("interview_start");
                String end = rs.getString("interview_end");
                String interviewer = rs.getString("interviewer_name");
                String interviewed = rs.getString("interviewed_name");
                aList.add(new Appointment(sqlDate,place1+"",start,end,interviewer,interviewed));
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return aList;
    }
    
    public Boolean isEmpty() throws SQLException {
        String query = "select * from appointment;";
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
    public Boolean insertAppointment(List<AppointmentSQL> alist) throws SQLException {
        if(alist == null){
            return false;
        }
        String query;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            for(AppointmentSQL a:alist){
                query = "INSERT INTO appointment VALUES (?,?,?,?,?);";
                PreparedStatement prepared = connection.prepareStatement(query);
                prepared.setInt(1,a.getPlace_id());
                prepared.setInt(2, a.getHours_id());
                prepared.setDate(3,a.getDate());
                prepared.setInt(4, a.getInterviewer_id());
                prepared.setInt(5,a.getInterviewed_id());
                prepared.execute();
            }
            
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return true;
    }
}
