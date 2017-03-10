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
public class Interviewed {
    private int itdId;
    private String itdName;

    public int getItdId() {
        return itdId;
    }

    public void setItdId(int itdId) {
        this.itdId = itdId;
    }

    public String getItdName() {
        return itdName;
    }

    public void setItdName(String itdName) {
        this.itdName = itdName;
    }

    public Interviewed(int itdId, String itdName) {
        this.itdId = itdId;
        this.itdName = itdName;
    }
    
}
