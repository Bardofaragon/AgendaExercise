<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.agenda.model.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Entrevistas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/agenda.css">
    </head>
    <body>
        <h1 class="Tit_Principal">Agenda</h1>
        <div class="Cuerpo">
            <img src="images/Agenda.png" width="30" alt="agenda" class="left icon">
            <p style="text-align: center;" class="left introduccion">Sistema de monitoreo para una agenda de entrevistas a aspirantes, realizadas por el personal dentro de nuestras instalaciones. </p>
            <img src="images/Agenda.png" class="left icon" width="30" alt="agenda">
            <div class="clear"></div>
            <hr>
            
            <H1>Entrevistas Agendadas...</H1>
            <p class="p_info">En este apartado se visualizan las entrevistas agendadas. Para buscar las de algún entrevistador en particular, ir al apartado de arriba "<span class="red">Consultar entrevistas</span>".</p>
            <%
                List<Appointment> agendas = (List<Appointment>) request.getAttribute("agenda");
                for (Appointment cita : agendas) {
            %>
            <div class="Entrevista">
                <div class="Entrev_Text">
                    <br><span class="subTitulo">Horario: </span><%out.print(cita.getStart_hour() +"-"+ cita.getEnd_hour());%>
                    <br><span class="subTitulo">Entrevistador: </span><%out.print(cita.getInterviewer_name());%>
                    <br><span class="subTitulo">Entrevistado: </span><%out.print(cita.getInterviewed_name());%>
                    <br><span class="subTitulo">Agenda: </span><%out.print(cita.getAgenda());%>
                    <br><span class="subTitulo">Salón: </span><%out.print(cita.getPlace());%>
                </div>
            </div>    
            <%
                }
            %>
            <hr>
            <H1>Consultar Entrevistas...</H1>
            <p>Para visualizar las entrevistas agendadas que tiene un entrevistador en particular, favor de ingresar el número de empleado asignado a este.</p>
            <div class="formulario">
                <form class="form-style1" action="AgendaTable" method="get">
                    <table class="form_table">
                        <tr>
                            <td><label for="interviewer_name">Entrevistador (Número de Empleado): </label></td>
                        </tr>
                        <tr>
                            <td>
                                <input class="width_90" type="text" name="interviewer_name" id="interviewer_name" placeholder="Número de empleado" title="Número de empleado"/>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <input type="submit" title="Da clic para agendar entrevista" value="Consultar">
                </form>
            </div>
            <hr>
            <div class="clear"></div>
        </div>
    </body>
</html>
