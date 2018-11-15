<%@ page import="app.domain.Settings" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="app.web.NewsletterServlet" %>
<%@ page import="app.service.SettingsService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="settingsService" class="app.service.SettingsService" scope="application" />
<html>
<body>
Zapisano!
<a href="allnewsletters.jsp">Przejrzyj ustawienia wszystkich</a>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String dateFrom = request.getParameter("dateFrom");
    Date  dateFromD = format.parse ( dateFrom);

    String dateTo = request.getParameter("dateTo");
    Date  dateToD = format.parse ( dateTo);


    Settings settings = new Settings(SettingsService.counter+1,request.getParameter("freq"), dateFromD,dateToD);
    if(request.getParameter("aus")!=null) {settings.setAustralia(true);}
    if(request.getParameter("eur")!=null) {settings.setEurope(true);}
    if(request.getParameter("ind")!=null) {settings.setIndia(true);}
    request.getSession().setAttribute("sett",settings);
    settingsService.addToSettings(settings);

%>
</body>
</html>