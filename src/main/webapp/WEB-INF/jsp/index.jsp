<%@ page import="com.milo.Library.repository.UserDao" %>
<%@ page import="com.milo.Library.service.UserService" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Biblioteka</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        .title-center {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
                <a href="${pageContext.request.contextPath}/"><img src="png/book.png" alt="strona główna" width="72"
                                                                   height="54"></a>
            </div>
            <div class="col-4 align-content-center title-center">
                <h3 style="color: #b7b7b7">Biblioteka</h3>
            </div>


            <div class="col-4 d-flex justify-content-end align-items-center">
                <%
                    UserService userService = new UserService();
                    UserDao userDao = new UserDao();
                    if (userService.isUserLogged(session)) {
                        if (userDao.getIsUserAdmin(userDao.getUserIdByName((String) session.getAttribute("user")))) {
                %>
                <h6 class="font-italic">Witaj, [ADMIN]<%=session.getAttribute("user")%>! <br><a
                        style="color: #343a40; font-size: 14px" href="${pageContext.request.contextPath}/user/Logout">Wyloguj
                    się</a></h6>
                <br>

                <%
                } else {
                %>
                <h6 class="font-italic">Witaj, <%=session.getAttribute("user")%>! <br><a
                        style="color: #343a40; font-size: 14px" href="${pageContext.request.contextPath}/user/Logout">Wyloguj
                    się</a></h6>
                <br>
                <%
                    }
                } else {
                %>
                <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/user/signin">Logowanie</a>
                <a class="btn btn-sm btn-outline-secondary" style="margin-left: 4px"
                   href="${pageContext.request.contextPath}/user/signup">Rejestracja</a>
                <%
                    }
                %>
            </div>
        </div>
    </header>

    <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex justify-content-between">
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/about">O nas</a>
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/books/showAll">Spis książek</a>
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/contact">Kontakt</a>
            <%
                if (userService.isUserLogged(session)) {
            %>
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/books/available">Wypożycz</a>
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/books/borrowed">Wypożyczone</a>
            <%
                if (userDao.getIsUserAdmin(userDao.getUserIdByName((String) session.getAttribute("user")))) {
            %>
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/books/add">Dodaj</a>
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/user/showAll">Spis użytkowników</a>
            <%
                    }
                }
            %>
        </nav>
    </div>

    <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark">
        <div class="col-md-6 px-0">
            <h1 class="display-4 font-italic">Nowości</h1>
            <p class="lead my-3">Ostatnio dodane książki</p>
            <p class="lead mb-0"><a href="${pageContext.request.contextPath}/books/latest"
                                    class="text-white font-weight-bold">Sprawdź...</a></p>
        </div>
    </div>

    <div class="row mb-2">
        <div class="col-md-6">
            <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <h3 class="mb-0">Brak interesującego Cię tytułu?</h3>
                    <br>
                    <p class="card-text mb-auto">Skontaktuj się z nami, a my postaramy się uzupełnić naszą ofertę
                        jak najszybciej!</p>
                    <a href="${pageContext.request.contextPath}/contact" class="stretched-link">Sprawdź...</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg"
                         preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
                         aria-label="Placeholder: Thumbnail"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"/>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em"></text>
                    </svg>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-success"></strong>
                    <h3 class="mb-0">TOP 5</h3>
                    <br>
                    <p class="mb-auto">Najchętniej wypożyczane przez naszych użytkowników</p>
                    <a href="${pageContext.request.contextPath}/books/top" class="stretched-link">Sprawdź...</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg"
                         preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
                         aria-label="Placeholder: Thumbnail"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"/>
                    </svg>
                </div>
            </div>
        </div>
    </div>
</div>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <h3 class="pb-4 mb-4 font-italic border-bottom">
                Polecamy!
            </h3>

            <div class="blog-post">
                <h2 class="blog-post-title">Przełęcz Diatłowa</h2>
                <p class="blog-post-meta">Autor: <a href="https://pl.wikipedia.org/wiki/Anna_Matwiejewa">Anna
                    Matwiejewa</a></p>
                <h3>Wciągająca opowieść inspirowana tragicznymi wydarzeniami na Uralu sprzed ponad sześćdziesięciu lat,
                    które do dzisiaj rozpalają wyobraźnię łowców zagadek.</h3>
                <br>
                <p>Czy rosyjskiej pisarce uda się rozwiązać jedną z największych tajemnic XX wieku?</p>
                <p> W styczniu 1959 roku grupa studentów i absolwentów Politechniki Uralskiej w Swierdłowsku (dzisiejszy
                    Jekaterynburg) pod przywództwem Igora Diatłowa wyruszyła na północny Ural z zamiarem zdobycia
                    szczytów Otorten i Ojka-Czakur. Wieczorem pierwszego lutego uczestnicy wyprawy rozbili obóz na
                    zboczu góry Chołatczachl, aby przeczekać pogarszającą się pogodę. To, co wydarzyło się później
                    pozostaje zagadką do dziś – wszyscy ponieśli śmierć w tajemniczych okolicznościach. W trakcie
                    prowadzonego śledztwa powstało wiele hipotez dotyczących dramatu, który wydarzył się na Przełęczy
                    Diatłowa.</p>
                <p>Kiedy kilkadziesiąt lat później młoda pisarka przypadkowo trafia na informację o tragedii
                    „diatłowców”, jej życie zaczyna się w dziwny sposób splatać z wydarzeniami z 1959 roku. Anna próbuje
                    dociec prawdy.</p>
                <br>
                <hr>
            </div>

        </div>

        <aside class="col-md-4 blog-sidebar">

            <div class="p-4">
                <h4 class="font-italic">Znajdziesz nas na</h4>
                <br>
                <ol class="list-unstyled">
                    <li><a href="https://github.com/">GitHub</a></li>
                    <li><a href="https://twitter.com/">Twitter</a></li>
                    <li><a href="https://www.facebook.com/">Facebook</a></li>
                </ol>
            </div>
        </aside>

    </div>

</main>

</body>
</html>