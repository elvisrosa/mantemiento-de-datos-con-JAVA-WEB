<%-- 
    Document   : registrar
    Created on : 6/10/2022, 04:02:08 PM
    Author     : elvis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vista para el registro!</h1>

        <form action="controlador " method="post">
            <input type="hidden" name="opcion" value="guardar">
            <table>
                <tr>
                    <td>Nombre: </td> 
                    <td><input type="text"  name="nombre"/></td>
                </tr>   
                <tr>
                    <td>Docente </td> 
                    <td><input type="text"  name="docente"/></td>
                </tr>   
                <tr>
                    <td>Semestre </td> 
                    <td><input type="text"  name="semestre"/></td>
                </tr>   
                <tr>
                    <td>Cantidad </td> 
                    <td><input type="text" name="cantidad"/></td>
                </tr>   
            </table>

            <input type="submit" value="Registrar">
        </form>




    </body>
</html>
