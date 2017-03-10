/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.db;
import java.sql.Date;
/**
 *
 * @author Baradofaragon
 */
public class AppointmentSQL {
    private Date date;
    private int place_id;
    private int hours_id; 
    private int interviewer_id;
    private int interviewed_id;

    @Override
    public String toString() {
        return date + "," + place_id + "," + hours_id + "," + interviewer_id + "," + interviewed_id; //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getHours_id() {
        return hours_id;
    }

    public void setHours_id(int hours_id) {
        this.hours_id = hours_id;
    }

    public int getInterviewer_id() {
        return interviewer_id;
    }

    public void setInterviewer_id(int interviewer_id) {
        this.interviewer_id = interviewer_id;
    }

    public int getInterviewed_id() {
        return interviewed_id;
    }

    public void setInterviewed_id(int interviewed_id) {
        this.interviewed_id = interviewed_id;
    }

    public AppointmentSQL(Date date, int place_id, int hours_id, int interviewer_id, int interviewed_id) {
        this.date = date;
        this.place_id = place_id;
        this.hours_id = hours_id;
        this.interviewer_id = interviewer_id;
        this.interviewed_id = interviewed_id;
    }
    
}
