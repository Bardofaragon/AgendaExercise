<%-- 
    Document   : index
    Created on : 8/03/2017, 09:51:57 PM
    Author     : Recko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int BD_Vacio = 1;%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio | Agenda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/agenda.css">
    </head>
    <body>
        <h1 class="Tit_Principal">Agenda</h1>
        <div class="Cuerpo">
            <img src="images/Agenda.png" width="30" alt="agenda" class="left icon">
            <p style="text-align: center;" class="left introduccion">
                Aplicación web que permite generar citas de entrevistas, así como la busqueda de las mismas filtrada por parametros.   
            </p>
            <img src="images/Agenda.png" class="left icon" width="30" alt="agenda">
            <div class="clear"></div>
            <hr>
            <p style="text-align: center;">¡Bienvenido! ¿Qué deseas hacer?... <br><br></p>
            <div class="Div_GeneraCitas"> 
                <h1>Generar Citas</h1>
                <p>Para generar citas nuevas, por favor haga clic en el siguiente botón: <br><br> </p>
                <form class="form-style1" action="MakeAgendaServlet" method="get">
                    <input type="submit" value="Generar" title="Generar"/>
                </form>
            </div>
            <div class="Div_ConsultarCitas"> 
                <h1>Consultar Citas</h1>

                <%
                    if (BD_Vacio == 0) {
                %>
                <p>
                    Si deseas consultar las citas de entrevistas generados en el sistema, favor de hacer clic en el siguiente botón:
                    <br><br><span class="red">Lo sentimos no encontramos citas en nuestra BD. </span><br><br>
                    <button disabled="true" value="Consultar">Consultar</button>
                </p>

                <%
                } else {
                %>
                <p>
                    Si deseas consultar las citas de entrevistas generados en el sistema, favor de hacer clic en el siguiente botón:
                </p>
                <form class="form-style1" action="ConsultarCitas_Formu.jsp">
                    <input name="btn_Consultar" id="ConsultarCitas" type="submit" value="Consultar" title="Consultar"/>
                </form>
                <%
                    }
                %>
            </div>
            <div class="clear"></div>
        </div>
    </body>
</html>
