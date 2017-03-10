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
public class Interviewer {
    private int irId;
    private String irName;

    public Interviewer(int irId, String irName) {
        this.irId = irId;
        this.irName = irName;
    }

    public int getIrId() {
        return irId;
    }

    public void setIrId(int irId) {
        this.irId = irId;
    }

    public String getIrName() {
        return irName;
    }

    public void setIrName(String irName) {
        this.irName = irName;
    }
}
