<%@ page import="com.milo.Library.service.UserService" %>

<%
    if (new UserService().checkIfUserIsLogged(session)) {
        session.setAttribute("isLogged", false);
        session.setAttribute("user", "");
        response.sendRedirect("/");
    } else {
        response.sendRedirect("/");
    }
%>