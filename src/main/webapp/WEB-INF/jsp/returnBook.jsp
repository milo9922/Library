<%@ page import="com.milo.Library.repository.BookDao" %>
<%@ page import="com.milo.Library.service.UserService" %>


<%
    if (!new UserService().checkIfUserIsLogged(session)) {
        response.sendRedirect("http://localhost:8080/user/signin");
    } else {
        new BookDao().returnBook(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/books/borrowed");
    }
%>