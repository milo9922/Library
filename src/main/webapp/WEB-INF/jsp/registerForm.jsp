<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>Rejestracja</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">
        <h2>Zarejestruj się</h2>
    </div>
    <br><br>

    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Zarejestruj się</h4>
        <form action="register" method="POST">
            <div class="row">
                <div class="text-align: center col-md-6 mb-3">
                    <label>Nazwa użytkownika</label>
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="Nazwa użytkownika" maxlength="30"
                           required>
                </div>
                <div class="col-md-6 mb-3">
                    <label>Adres email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Adres email"
                           maxlength="30"
                           required>
                </div>
                <div class="col-md-6 mb-3">
                    <label>Hasło</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Hasło"
                           required>
                    <div class="invalid-feedback">
                        Nieprawidłowe dane!
                    </div>
                </div>
            </div>

            <br><br>
            <div class="button">
                <button type="submit" class="btn btn-secondary">Zarejestruj się</button>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Powrót</a>
            </div>
        </form>

    </div>
</div>

<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017-2019 Biblioteka</p>
    <ul class="list-inline">
        <li class="list-inline-item"><a href="#">Privacy</a></li>
        <li class="list-inline-item"><a href="#">Terms</a></li>
        <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
</footer>

</body>
</html>

