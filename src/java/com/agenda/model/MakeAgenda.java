/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.model;

import com.agenda.dao.*;
import com.agenda.db.AppointmentSQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Baradofaragon
 */
public class MakeAgenda {
    public static void main(String[] args){
        MakeAgenda mkagenda = new MakeAgenda();
       System.out.println(""+mkagenda.createAgenda());
    }
    public Boolean createAgenda(){
        System.out.println("OK");
        try{
        InterviewedDAO iwdDAO = new InterviewedDAO();
        if(iwdDAO.isEmpty()){
            return false;
        }
        InterviewerDAO irDAO = new InterviewerDAO();
        PlaceDAO pDAO = new PlaceDAO();
        Date date = DateUtil.addDays(new Date(), 1);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        List<Place> plist = pDAO.getPlaceList();
        List<InterviewerHours> irhours = irDAO.getInterviewerHours();
        List<Interviewed> iwd = iwdDAO.getInterviewedList();
        List<AppointmentSQL> alist = new ArrayList<AppointmentSQL>();
        Iterator hours = irhours.iterator();
        Iterator place = plist.iterator();
        for(Interviewed i:iwd){
            if((!place.hasNext()) || (!hours.hasNext()) ){
                date = DateUtil.addDays(date, 1);
                sqlDate = new java.sql.Date(date.getTime());
                place = plist.iterator();
                hours = irhours.iterator();
            }
            Place p = (Place)place.next();
            InterviewerHours ih = (InterviewerHours)hours.next();
            alist.add(new AppointmentSQL(sqlDate,p.getPlace_id(),ih.getHours_id(), ih.getInterviewer_id(),i.getItdId()));
        }
        if(alist == null)System.out.println("NO tiene nada");
        for(AppointmentSQL aux:alist){
            System.out.println(aux);
        }
        System.out.println("ok");
        AppointmentDAO aDAO = new AppointmentDAO();
        aDAO.insertAppointment(alist);
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
        return true;
    }
}
