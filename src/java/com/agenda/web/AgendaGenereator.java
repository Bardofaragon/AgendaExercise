/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.web;

import com.agenda.model.Appointment;
import com.agenda.dao.AppointmentDAO;
import com.agenda.model.DateUtil;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Baradofaragon
 */
public class AgendaGenereator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            try{
            String type = request.getParameter("btn_TipoConsulta");
            AppointmentDAO agenda = new AppointmentDAO();
            List<Appointment> result = null;
            if(type.equals("Entrevistador")){
                String filter = request.getParameter("Par_ConsultaE");
                result = agenda.getAppointmentsByIr(filter);
            }
            else if(type.equals("Dia")){
                String filter = request.getParameter("Par_ConsultaD");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                filter = URLDecoder.decode(filter,"UTF-8");
                try{
                    Date date = formatter.parse(filter);
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    result = agenda.getAppointmentsByDay(sqlDate+"");
                    System.out.println(sqlDate + "");
                }
                catch(ParseException e){e.printStackTrace();}
                //result = agenda.getAppointments();
               
            }
            else if(type.equals("Salon")){
                String filter = request.getParameter("Par_ConsultaS");
                result = agenda.getAppointmentsByPlace(filter);
            }
            request.setAttribute("agenda",result);
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request,response);
        }catch(SQLException sqlE){
        }catch(ParseException parseE){}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
