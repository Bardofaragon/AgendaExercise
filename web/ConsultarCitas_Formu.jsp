<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consultar Citas | Agenda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/agenda.css">
        <!-- Agrego JQuery -->
        <script src="./js/jquery-1.12.4.js"></script>
        <!-- Para el Date Picker -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="./js/jquery-ui.js"></script>
        <script>
        $( function() {
          $( "#Dia" ).datepicker();
        } );
        
        function Mostrar(div){
            if(div===r1){
            document.getElementById("Cons_Entrevistador").style.display = "block";
            document.getElementById("Cons_Salon").style.display = "none";
            document.getElementById("Con_Dia").style.display = "none";
            }else if(div===r2){
            document.getElementById("Cons_Entrevistador").style.display = "none";
            document.getElementById("Cons_Salon").style.display = "block";
            document.getElementById("Con_Dia").style.display = "none";
            }else if(div===r3){
            document.getElementById("Cons_Entrevistador").style.display = "none";
            document.getElementById("Cons_Salon").style.display = "none";
            document.getElementById("Con_Dia").style.display = "block";
            }
        }
        
        </script>

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
            <h1>Consultar Citas</h1>
            <p style="text-align: center;">
                               Aquí podrá consultar los datos de las citas de entrevistas filtrando los resultados ya sea por 'Entrevistador', 'Salón' o 'Día' específícos.    
                <br><br>
            </p>
            <form class="form-style1" name="BusquedaCita" action="AgendaTable" method="get">
                <div class="RadioButton"><input type="radio" name='btn_TipoConsulta' onclick="Mostrar(r1)" value="Entrevistador" id="r1" checked><label for="r1" > Entrevistador </label></div>
                <div class="RadioButton"><input type="radio" name='btn_TipoConsulta' onclick="Mostrar(r2)" value="Salon" id="r2"><label for="r2"> Salón </label></div>
                <div class="RadioButton"><input type="radio" name='btn_TipoConsulta' onclick="Mostrar(r3)" value="Dia" id="r3"><label for="r3"> Día </label></div>
                <div class="Formu_Consulta" id="Cons_Entrevistador"> 
                    <h2>Busqueda por 'Entrevistador':</h2>
                    <p>Para consultar las citas de entrevitas asignadas a un Entrevistador, por favor ingrese el 'Número Único de Empleado' asociado al Entrevistador en cuestión: <br><br> </p>
                        <input class="width_70" type="text" name="Par_ConsultaE" id="Par_Consulta" placeholder="Número único de empleado" title="Número único de empleado"/>
                </div>
                <div class="Formu_Consulta" id="Cons_Salon"> 
                    <h2>Busqueda por 'Salón':</h2>
                    <p>Para consultar las citas de entrevitas asignadas a un Salón en particular, por favor ingrese el 'Identificador' que se deseé consultar: <br><br> </p>
                        <input class="width_70" type="text" name="Par_ConsultaS" id="Par_Consulta" placeholder="Salón" title="Salón"/>
                </div>
                <div class="Formu_Consulta" id="Con_Dia" > 
                    <h2>Busqueda por 'Día':</h2>
                    <p>Para consultar las citas de entrevitas asignadas a un Día en particular, por favor seleccione del calendario el 'Día' que se deseé consultar: <br><br> </p>
                    <input class="width_70" type="text" name="Par_ConsultaD" id="Dia" placeholder="dd/mm/yyyy" title="Día"/>
                </div>
                <input type="submit" title="Da clic para hacer la consulta" value="Consultar">
            </form>
            <div class="clear"></div>
        </div>
    </body>
</html>
