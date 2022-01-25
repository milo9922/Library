<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <title>O projekcie</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="d-flex flex-column h-100">
<main role="main" class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">O nas</h1>
        <br>
        <p class="lead">Projekt został stworzony w celach edukacyjnych. Ma on za zadanie symulować stronę internetową biblioteki z możliwością rezerwowania książek i ich odbiór poprzez generowanie kodu QR odbioru.
            Zawarte w nim zostały funkcjonalności takie jak rejestracja (z hashowaniem haseł przed zapisem do bazy danych), logowanie, dodawanie nowych książek przez administratora, wypożyczanie ich przez każdego użytkownika oraz zwrot książki.
        Baza danych została stworzona w oparciu o RaspberryPi 4B oraz MySQL, ponieważ zależało mi na zdalnym dostępie bez korzystania z hostingu zewnętrznych firm. Ponieważ nie zajmuję się front-endem do uzyskania przyzwoitego wyglądu strony
        wykorzystałem bootstrapa. Sam projekt działa w oparciu o springboot a poszczególne strony są utworzone w plikach JSP. Dodatkowo do projektu dołączyłem pliki SQL, które wykorzystywałem przy tworzeniu bazy danych.
        Wartą wspomnienia opcją są generowane kody QR, z których każdy zawiera id książki. W przypadku jakichkolwiek uwag/sugestii zapraszam do kontaku poprzez email lub LinkedIn :)</p>
        <br>
        <a class="btn btn-dark" href="http://localhost:8081/books/showAll">Lista książek</a>
    </div>
</main>

<footer class="footer mt-auto py-3">
    <div class="container">
        <span class="text-muted"><a class="btn btn-dark"
                                    href="http://localhost:8081/">Powrót do strony głównej</a></span>
    </div>
</footer>
</body>
</html>