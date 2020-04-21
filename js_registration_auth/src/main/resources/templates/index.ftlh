<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
</head>
<body>
<!-- Splash screen -->
<section id="page-splash" class="page-splash">
    <div class="d-flex justify-content-center">
        <div class="mx-3">
            <form id="registration-form">
                <h3>Регистрация</h3>
                <input type="email" name="email" class="form-control mb-1" placeholder="Email">
                <input type="text" name="name" class="form-control mb-1" placeholder="Полное имя">
                <input type="text" name="login" class="form-control mb-1" placeholder="Логин">
                <input type="password" name="password" class="form-control mb-1" placeholder="Пароль">
                <button class="btn btn-outline-primary btn-block">Зарегистрироваться</button>
            </form>
        </div>
        <div class="mx-3">
            <form id="login-form">
                <h3>Вход</h3>
                <input type="text" name="username" class="form-control mb-1" placeholder="Логин">
                <input type="password" name="password" class="form-control mb-1" placeholder="Пароль">
                <button type="submit" class="btn btn-outline-primary btn-block">Войти</button>
            </form>
        </div>
    </div>

</section>
</body>
</html>

<script src="js/script.js"></script>
<script src="js/login.js"></script>