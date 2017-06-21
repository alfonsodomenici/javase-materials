<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul class="w3-navbar w3-light-grey w3-border">
    <li><a class="w3-green" href="#"><i class="fa fa-home"></i></a></li>
    <li><a href="elenco_clienti.jsp"><i class="fa fa-search"></i></a></li>
    <c:if test="${not empty sessionData.loggedUser}" >
        <li><a href="ins_cliente.jsp"><i class="fa fa-id-card"></i></a></li>
    </c:if>
    <c:if test="${empty sessionData.loggedUser}" >
        <li><a href="login.jsp"><i class="fa fa-user"></i></a></li>
    </c:if>
    
</ul>
