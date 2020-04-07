<%@ page import="com.milo.Library.repository.UserDao" %>

<%
    UserDao userDao = new UserDao();
    String uname = request.getParameter("username");
    String pass = request.getParameter("password");

    if (userDao.checkLoginAndPassword(uname, pass)) {
        session.setAttribute("loginError", false);
        session.setAttribute("isLogged", true);
        session.setAttribute("user", uname);
        response.sendRedirect("/");
    } else {
        session.setAttribute("loginError", true);
        session.setAttribute("isLogged", false);
        response.sendRedirect("/user/signin");
    }
%>