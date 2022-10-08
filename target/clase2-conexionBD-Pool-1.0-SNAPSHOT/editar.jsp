<%-- 
    Document   : editar
    Created on : 7/10/2022, 03:47:03 PM
    Author     : elvis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Formulario para editar un profesor</h3>
        <form action="controlador " method="post">
            <input type="hidden" name="opcion" value="eeditar">
            <c:set var="prof" value="${profesor}" ></c:set>
            <input type="hidden" name="nombreId" value="${prof.nombre}">
            <table border="1">
                   
                <tr>
                    <td>Docente </td> 
                    <td><input type="text"  name="docente" value="${prof.docente}"/></td>
                </tr>   
                <tr>
                    <td>Semestre </td> 
                    <td><input type="text"  name="semestre" value="${prof.semestre}"/></td>
                </tr>   
                <tr>
                    <td>Cantidad </td> 
                    <td><input type="text" name="cantidad" value="${prof.cantidad}"/></td>
                </tr>   
            </table>

            <input type="submit" value="Actualizar">
        </form>
    </body>
</html>
