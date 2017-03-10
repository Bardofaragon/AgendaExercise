<!DOCTYPE html>
<html>
    <head>
        <title>Entrevistas | Agenda</title>
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
           
            <H1>Entrevistas Agendadas...</H1>
            <p class="p_info">
                Se han encontrado los siguientes resultados: 
            </p>
            <div class="Entrevista">
                <div class="Entrev_Text">
                    <br><span class="subTitulo">Día: </span>
                    <br><span class="subTitulo">Horario: </span> 
                    <br><span class="subTitulo">Nombre Entrevistador: </span> 
                    <br><span class="subTitulo">Nombre Entrevistado:  </span> 
                    <br><span class="subTitulo">Salón:  </span> 
                </div>
            </div>    
            <div class="Entrevista">
                <div class="Entrev_Text">
                    <br><span class="subTitulo">Horario: </span> 
                    <br><span class="subTitulo">Entrevistador: </span> 
                    <br><span class="subTitulo">Entrevistado: </span> 
                    <br><span class="subTitulo">Agenda: </span> 
                    <br><span class="subTitulo">Lugar: </span> 
                </div>
            </div>    
            <hr>
            <div class="clear"></div>
            
             <H1>Consultar Entrevistas...</H1>
            <p>Para visualizar las entrevistas agendadas que tiene un entrevistador en particular, favor de ingresar el número de empleado asignado a este.</p>
            <div class="formulario">
                <form class="form-style1" action="#" method="get">
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
            
        </div>
    </body>
</html>
