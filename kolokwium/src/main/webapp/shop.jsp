<%@ page import="app.service.ParrotService" %>
<%@ page import="app.service.ShopService" %>
<%@ page import="app.domain.Parrot" %>
<%@ page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="parrotService" class="app.service.ParrotService" scope="application" />
<jsp:useBean id="basket" class="app.service.ShopService" scope="session" />
<%
    if(session.getAttribute("rodo")==null) {
        response.sendRedirect("errorRodo.jsp");
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aplikacja</title>
</head>
<body>
<h1>Witaj w sklepie!</h1>
<h3>Produkty</h3>
    <%
        for(Map.Entry<Integer, Parrot> entry : parrotService.getMap().entrySet()) {
    %>
        <form action="addToBasket.jsp" method="post">
        <p><%out.println(entry.getValue());%>
        <input type="hidden" name="id" value="<%out.print(entry.getKey());%>">
        <input type="submit" value="Dodaj do koszyka"></p></form>
    <%
    }
%>
<h3>Koszyk</h3>
<%
    if (basket!=null)
    for(Parrot p : basket.getBasket()){ %><p><%out.println(p);}%></p><%
%>

</body>
</html>