<%@ page import="app.domain.Parrot" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:useBean id="parrotService" class="app.service.ParrotService" scope="application" />
<jsp:useBean id="basket" class="app.service.ShopService" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodano do koszyka</title>
</head>
<body>

<%
    basket.addToBasket(parrotService.getParrot(Integer.valueOf(request.getParameter("id"))));
    parrotService.removeParrot(Integer.valueOf(request.getParameter("id")));
%>

<p>Dodano do koszyka</p>
<p><%parrotService.getParrot(Integer.valueOf(request.getParameter("id")));%> </p>
<p>
    <a href="shop.jsp">Wróć do sklepu</a>
</p>
</body>
</html>