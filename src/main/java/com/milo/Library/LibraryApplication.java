package com.milo.Library;

import com.milo.Library.servlet.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

//Due to raspberry pi crash project may not work now. I should fix it by the end of this month. Sorry for this inconvenience.
@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    //addBook servlet registration
    @Bean
    public ServletRegistrationBean addBookServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new AddBook(), "/books/AddBook");
        return bean;
    }

    @Bean
    public ServletRegistrationBean removeBookServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new RemoveBook(), "/books/remove");
        return bean;
    }

    //borrowBook servlet registration
    @Bean
    public ServletRegistrationBean borrowBookServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new BorrowBook(), "/books/borrow");
        return bean;
    }

    //returnBook servlet registration
    @Bean
    public ServletRegistrationBean returnServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new ReturnBook(), "/books/return");
        return bean;
    }

    //register servlet registration
    @Bean
    public ServletRegistrationBean registerServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new Register(), "/user/Register");
        return bean;
    }

    //login servlet registration
    @Bean
    public ServletRegistrationBean loginServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new Login(), "/user/Login");
        return bean;
    }

    //logout servlet registration
    @Bean
    public ServletRegistrationBean logoutServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new Logout(), "/user/Logout");
        return bean;
    }

}
