<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.dao.BookDao" %>
<%@ page import="com.milo.Library.entity.Book" %>
<%
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String pagesNum = request.getParameter("pages");

    try {
        BookDao bookDao = new BookDao();
        bookDao.insertBook(new Book(title, author, Integer.parseInt(pagesNum)));
        if (bookDao.getX() > 0) {
            response.sendRedirect("/books/showAll");
        } else {
            out.println("Nie udało się dodać książki!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

%>

