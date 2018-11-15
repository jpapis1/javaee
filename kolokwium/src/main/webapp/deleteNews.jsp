<%@ page import="app.domain.Settings" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="settingsService" class="app.service.SettingsService" scope="application" />
<jsp:useBean id="sett" class="app.domain.Settings" scope="session" />

<html>
<body>
Moje ustawienia:
<%
    settingsService.deleteSetting(id);
    out.print("<p>" + "USUNIĘTO" + "</p>");
%>
</body>
</html>