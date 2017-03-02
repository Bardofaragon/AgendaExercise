/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Baradofaragon
 */
public class GetAgendaData {
/*
 *
 * Para que el driver funcione, debe agregarse a la librería el .jar que conecta a mysql con jdbc.
 * USER y PASS dependen de los usuarios que tenga mysql en el servidor que se corra, si no existe
 * el usuario o no coincide la contraseña, el programa no mostrará nada.
 */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/agendaexercise";
    static final String USER = "admin";
    static final String PASS = "admin";
    public List<Appointment> getAgendaOf(String user){
    Connection conn = null;
    Statement stmt = null;
    List<Appointment> Agenda;
    Agenda = new ArrayList<Appointment>();
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "select agenda_id, Appointment.place_id, interview_start, interview_end, interviewer_name, interviewed_name from appointment, place, hours, interviewer, interviewed where place.place_id = appointment.place_id AND hours.hours_id = appointment.hours_id AND interviewer.interviewer_id = appointment.interviewer_id AND interviewed.interviewed_id = appointment.interviewed_id ORDER BY agenda_id,interview_start;";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int agenda = rs.getInt("agenda_id");
        int place = rs.getInt("place_id");
        String start = rs.getString("interview_start");
        String end = rs.getString("interview_end");
        String interviewer = rs.getString("interviewer_name");
        String interviewed = rs.getString("interviewed_name");
        Agenda.add(new Appointment(agenda+"",place+"",start,end,interviewer,interviewed));
        System.out.print("agenda: " + agenda);
        System.out.print(", place: " + place);
        System.out.print(", start: " + start);
        System.out.print(", end: " + end);
        System.out.println(", interviewer: " + interviewer);
        System.out.println(", interviewer: " + interviewed);
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (stmt != null)
          stmt.close();
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
    return Agenda;
  }
}
