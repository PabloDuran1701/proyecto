<%-- 
// EditarDatos.jsp
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez
//
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="box2">
            <h1>Editar Datos Personales</h1>
            <form id="formulario" action="AgregarClienteNuevo" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>

                        <tr>
                            <td>
                                <label for="ID"><strong>ID</strong></label>
                            </td>
                            <td>
                                <input type="text" id="ID" name="ID" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="CLAVE"><strong>CLAVE</strong></label>
                            </td>
                            <td>
                                <input type="password" id="CLAVE" name="CLAVE" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="NOMBRE"><strong>NOMBRE:</strong></label>
                            </td>
                            <td>
                                <input type="text" id="NOMBRE" name="NOMBRE" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="APELLIDO"><strong>APELLIDO</strong></label>
                            </td>
                            <td>
                                <input type="text" id="APELLIDO" name="APELLIDO" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="TELEFONO"><strong>TELEFONO</strong></label>
                            </td>
                            <td>
                                <input type="text" id="TELEFONO" name="TELEFONO" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="DIRECCION"><strong>DIRECCION</strong></label>
                            </td>
                            <td>
                                <input type="text" id="DIRECCION" name="DIRECCION" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="reset">Borrar</button>&nbsp;
                            </td>
                            <td>
                                <button type="submit">Enviar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </section>
    </body>
</html>
