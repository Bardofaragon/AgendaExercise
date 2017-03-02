/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.model;

/**
 *
 * @author Baradofaragon
 */
public class Appointment {
    private String agenda;
    private String place;
    private String start_hour;
    private String end_hour;
    private String interviewer_name;
    private String interviewed_name;

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public Appointment(String agenda, String place, String start_hour, String end_hour, String interviewer_name, String interviewed_name) {
        this.agenda = agenda;
        this.place = place;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
        this.interviewer_name = interviewer_name;
        this.interviewed_name = interviewed_name;
    }
    public Appointment(String place, String start_hour, String end_hour, String interviewer_name, String interviewed_name) {
        this.place = place;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
        this.interviewer_name = interviewer_name;
        this.interviewed_name = interviewed_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public String getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(String end_hour) {
        this.end_hour = end_hour;
    }

    public String getInterviewer_name() {
        return interviewer_name;
    }

    public void setInterviewer_name(String interviewer_name) {
        this.interviewer_name = interviewer_name;
    }

    public String getInterviewed_name() {
        return interviewed_name;
    }

    public void setInterviewed_name(String interviewed_name) {
        this.interviewed_name = interviewed_name;
    }
    
    
}
