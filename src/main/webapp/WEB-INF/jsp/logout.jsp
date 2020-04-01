<%
    session.setAttribute("isLogged", false);
    session.setAttribute("user", "");
    response.sendRedirect("/");
%>