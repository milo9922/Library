<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.milo.Library.entity.Book" %>
<%@ page import="com.milo.Library.repository.BookDao" %>
<%@ page import="com.milo.Library.service.UserService" %>


<%
    if (!new UserService().isUserLogged(session)) {
        response.sendRedirect("http://localhost:8080/user/signin");
    }
%>

<!doctype html>
<html lang="en">
<style>
    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<head>
    <meta charset="utf-8">
    <title>Kod odbioru</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="py-4">

<div class="container">
    <%
        Book currentBook = new BookDao().getSingleBookById(Integer.parseInt(request.getParameter("id")));
    %>
    <h2 style="text-align: center"><%=currentBook.getTitle()%>
    </h2>
    <br>
    <h3 style="text-align: center"><%=currentBook.getAuthor()%>
    </h3>
    <%new BookDao().createBorrowQrCodePngFileById(Integer.parseInt(request.getParameter("id")));%>
    <br><br>
    <img class="center" src="${pageContext.request.contextPath}/png/borrowQrCode.png" width="250" height="250"
         alt="Nie znaleziono kodu Qr">
    <br><br>
    <div align="center">
        <a href="${pageContext.request.contextPath}/" class="btn-secondary">Powrót</a>
    </div>
</div>
</body>
</html>