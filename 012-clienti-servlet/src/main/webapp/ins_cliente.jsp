<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Crea Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <ul class="w3-navbar w3-light-grey w3-border">
            <li><a  href="index.html"><i class="fa fa-home"></i></a></li>
            <li><a  href="elenco_clienti.jsp"><i class="fa fa-search"></i></a></li>
            <li><a class="w3-green" href="#"><i class="fa fa-id-card"></i></a></li>
        </ul>
        <div class="w3-container w3-green">
            <h2>Dati del Cliente</h2>
        </div>
        <form method="POST" action="cliente"  class="w3-container">
            <input type="text" placeholder="ragione sociale" name="rag_soc" class="w3-input"/>
            <br/>
            <input type="text" placeholder="indirizzo" name="ind" class="w3-input"/>
            <br/>
            <input type="submit" value="Invia" class="w3-btn w3-white w3-border w3-border-green w3-round-xlarge" />
        </form>
        <footer class="w3-container w3-green">
            <h5>powered by tss2017</h5>
        </footer>
    </body>
</html>
