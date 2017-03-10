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
public class InterviewerHours {
    private int interviewer_id;
    private int hours_id;

    public int getInterviewer_id() {
        return interviewer_id;
    }

    public void setInterviewer_id(int interviewer_id) {
        this.interviewer_id = interviewer_id;
    }

    public int getHours_id() {
        return hours_id;
    }

    public void setHours_id(int hours_id) {
        this.hours_id = hours_id;
    }

    public InterviewerHours(int interviewer_id, int hours_id) {
        this.interviewer_id = interviewer_id;
        this.hours_id = hours_id;
    }
}
