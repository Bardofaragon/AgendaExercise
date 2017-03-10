/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;
import com.agenda.db.ConnectionFactory;
import com.agenda.db.DbUtil;
import com.agenda.model.Interviewer;
import com.agenda.model.InterviewerHours;
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
public class InterviewerDAO {
    private Connection connection;
    private Statement statement;
    
    public InterviewerDAO(){}
    
    public Interviewer getInterviewer(int interviewerId) throws SQLException {
        String query = "SELECT * FROM interviewer WHERE interviewer_id=" + interviewerId + ";";
        ResultSet rs = null;
        Interviewer interviewer = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int id = rs.getInt("interviewer_id");
            String name = rs.getString("interviewer_name");
            interviewer = new Interviewer(id,name);
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return interviewer;
    }
    public List<Interviewer> getInterviewerList() throws SQLException {
        String query = "SELECT * FROM interviewer;";
        ResultSet rs = null;
        Interviewer interviewer = null;
        List irList = new ArrayList<Interviewer>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("interviewer_id");
                String name = rs.getString("interviewer_name");
                interviewer = new Interviewer(id,name);
                irList.add(interviewer);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return irList;
    }
    public List<InterviewerHours> getInterviewerHours() throws SQLException {
        String query = "SELECT * FROM interviewerhours;";
        ResultSet rs = null;
        InterviewerHours irh = null;
        List irhList = new ArrayList<InterviewerHours>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int interviewer_id = rs.getInt("interviewer_id");
                int hours_id = rs.getInt("hours_id");
                irh = new InterviewerHours(interviewer_id,hours_id);
                irhList.add(irh);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return irhList;
    }
}
