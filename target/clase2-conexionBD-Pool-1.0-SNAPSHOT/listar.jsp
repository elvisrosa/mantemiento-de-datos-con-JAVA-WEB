<%-- 
    Document   : listar
    Created on : 7/10/2022, 02:38:00 PM
    Author     : elvis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de profesores</h1>
        <table border="1">
            <tr>
                <td>Nombre</td>
                <td>Docente</td>
                <td>Semestre</td>
                <td>Cantidad</td>
                <td>Acción</td>
            </tr>

            <c:forEach var="pro" items="${lista}">        
                <tr>
                    <td><a href="controlador?opcion=editar&nombrepk=<c:out value="${pro.nombre}"></c:out>"><c:out value="${pro.nombre}"></c:out></a></td>
                    <td><c:out value="${pro.docente}"></c:out></td>
                    <td><c:out value="${pro.semestre}"></c:out></td>
                    <td><c:out value="${pro.cantidad}"></c:out></td>
                    <td><a href="controlador?opcion=eliminar&nombrepk=<c:out value="${pro.nombre}"></c:out>">Eliminar</a></td>

                    </tr>
            </c:forEach>
        </table>
    </body>
</html>
