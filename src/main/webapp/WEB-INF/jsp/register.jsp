<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.entity.User" %>
<%@ page import="com.milo.Library.repository.UserDao" %>
<%@ page import="com.milo.Library.service.UserService" %>
<%

    try {
        if (!new UserService().checkIfUserIsLogged(session)) {
            UserDao userDao = new UserDao();
            User user = new User(request.getParameter("username"), request.getParameter("email"), request.getParameter("password"));

            if (userDao.checkIfUserIsNew(user)) {
                userDao.registerUser(user);
                if (userDao.getX() > 0) {
                    response.sendRedirect("/user/signin");
                } else {
                    response.sendRedirect("http://localhost:8080/user/register/fail");
                }
            } else {
                response.sendRedirect("http://localhost:8080/user/register/fail");
            }
        }
    } catch
    (Exception e) {
        e.printStackTrace();
    }
%>