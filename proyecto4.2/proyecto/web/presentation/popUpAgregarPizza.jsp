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


<%@page import="MODEL.Pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../presentation/Head.jsp"%>
        <script src="../js/scriptAgregarpizza.js" type="text/javascript"></script>
        <script type="text/javascript">
            inicializarDatos(<%= new Pizza().listaPizzasJSON()%>);
        </script>
    </head>
    <%@include file="../presentation/Menu.jsp"%>
    <body onload="init();">
        <div class="" style="height: available; position: relative; margin-top: 20px;  margin-left: 40px; margin-right: 40px; margin-bottom: 100px; "> 
            <table class="table table-bordered table-striped mb-1 " id="example"style="">
                <thead>
                    <tr style="">
                        <th scope="col">nombre</th>
                        <th scope="col">tamaño</th>
                        <th scope="col">precio</th>
                    </tr>
                </thead>
                <tbody id="cuerpo">
                </tbody>
            </table>
        </div>
    </body>

</html>
