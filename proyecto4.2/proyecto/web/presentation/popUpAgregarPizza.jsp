<%-- 
// CrudMenu.jsp
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez
//
--%>


<%@page import="MODEL.Producto"%>
<%@page import="MODEL.Pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../presentation/Head.jsp"%>
        <script src="../js/scripts.js" type="text/javascript"></script>
        <script type="text/javascript">
            inicializarDatos(<%= new Pizza().listaPizzasJSON()%>);
        </script>
    </head>
    <%@include file="../presentation/Menu.jsp"%>
    <body onload="init();">
        <div class="jumbotron big-banner mb-0 jumbotron-fluid" style="height: 100%; padding-top: 150px;">
            <div class="" style="height: available; position: relative; margin-top: 20px;  margin-left: 15%; margin-right: 15%; margin-bottom: 100px; "> 
                <table class="table table-bordered table-striped mb-1 table-light" id="example"style="">
                    <thead>
                        <tr style="">
                            <th scope="col">Tipo</th>
                            <th scope="col">tipo</th>
                            <th scope="col">tamaño</th>
                            <th scope="col">precio</th>
                            <th scope="col">Agregar</th>
                        </tr>
                    </thead>
                    <tbody id="cuerpo">
                    </tbody>
                </table>
            </div>
        </div>
    </body>

</html>
