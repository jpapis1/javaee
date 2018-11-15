<%@ page import="app.domain.Settings" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="settingsService" class="app.service.SettingsService" scope="application" />
<jsp:useBean id="sett" class="app.domain.Settings" scope="session" />

<html>
<body>
Moje ustawienia:
<%
        out.print("<p>" + sett + "</p>");
%>
Wszystkich ustawienia:
<%

    for(Settings settings : settingsService.getSettings()) {
        %>
<form action="deleteNews.jsp" method="post">
        <input type="hidden" name="id" value="<%settings.getId();%>">
        <input type="submit" value="Usun z settings"></form>
        <%

        out.print("<p>" + settings + "</p>");
    }
%>
</body>
</html>