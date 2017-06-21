<%-- 
    Document   : elenco_clienti
    Created on : 13-feb-2017, 12.24.45
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elenco Clienti</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
    </head>
    <body>
        <ul class="w3-navbar w3-light-grey w3-border">
            <li><a  href="index.html"><i class="fa fa-home"></i></a></li>
            <li><a class="w3-green" href="#"><i class="fa fa-search"></i></a></li>
            <li><a href="ins_cliente.html"><i class="fa fa-id-card"></i></a></li>
        </ul>
        <p>Logged User : <c:out value="${sessionData.loggedUser}" /></p>
        <table class="w3-table w3-striped" >
            <th>ID</th>
            <th>RAGIONE SOCIALE</th>
            <th>INDIRIZZO</th>
            <c:forEach items="${clientiSrv.findAll()}" var="cli">
                <tr>
                    <td><c:out value="${cli.id}"/></td>
                    <td><c:out value="${cli.ragioneSociale}"/></td>
                    <td><c:out value="${cli.indirizzo}"/></td>
                </tr>
            </c:forEach>
        </table>
        <footer class="w3-container w3-green">
            <h5>powered by tss2017</h5>
        </footer>
    </body>
</html>
