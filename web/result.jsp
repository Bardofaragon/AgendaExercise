<%-- 
    Document   : result
    Created on : Mar 2, 2017, 12:45:39 AM
    Author     : Baradofaragon
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.agenda.model.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table">
            <thead>
                <tr>
                    <th>Agenda</th>
                    <th>Lugar</th>
                    <th>Horario</th>
                    <th>Entrevistador</th>
                    <th>Entrevistado</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Appointment> agendas = (List<Appointment>)request.getAttribute("agenda");
                    for(Appointment cita : agendas){
                        out.println("<tr>");
                        out.println("<td>" + cita.getAgenda() + "</td>");
                        out.println("<td>" + cita.getStart_hour() + "</td>");
                        out.println("<td>" + cita.getEnd_hour() + "</td>");
                        out.println("<td>" + cita.getInterviewer_name() + "</td>");
                        out.println("<td>" + cita.getInterviewed_name() + "</td>");
                        out.println("<tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
