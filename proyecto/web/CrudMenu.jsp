<%-- 
    Document   : CrudMenu
    Created on : 19/06/2020, 08:19:02 PM
    Author     : Lenovo
--%>

<%@page import="MODEL.Pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/scripts.js" type="text/javascript"></script>
         <script type="text/javascript">
            inicializarDatos(<%= new Pizza().listaPizzasJSON()%>);
        </script>
    </head>

    <body onload="init();">
        <table id="menu1" class="menu1" style="border: 1px solid">

            <tr class="pizza" style="border: 1px solid">
                <td colspan="3">Menu de Pizza</td>
            </tr>
            <tr class="Productos" style="border: 1px solid">
                <td colspan="3"></td>
            </tr>
            <tr class="Productos" style="border: 1px solid">
                <td>1</td>
                <td>2<td>
                <td>3</td>
            </tr>

        </table>
        <table id="menu2" class="menu2" style="border: 1px solid">
            <tbody>
                <tr class="pizza" style="border: 1px solid">
                    <td colspan="3">Productos adicionales</td>
                </tr>
                <tr class="Productos" style="border: 1px solid">
                    <td colspan="3"></td>
                </tr>
                <tr class="Productos" style="border: 1px solid">
                    <td>1</td>
                    <td>2<td>
                    <td>3</td>
                </tr>
            </tbody>
        </table>
    </body>

</html>
