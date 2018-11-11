<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("rodo")==null) {
        response.sendRedirect("errorRodo.jsp");
    } else {
        response.sendRedirect("shop.jsp");
    }
%>
</body>
</html>