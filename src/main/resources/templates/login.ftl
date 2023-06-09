<!doctype html>
<html lang="ru">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/favicon-32x32.png" type="image/png" />
    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/bootstrap-extended.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    <link href="css/icons.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <title>Авторизация</title>
</head>

<body class="bg-surface">

<!--start wrapper-->
<div class="wrapper">

    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-white rounded-0 border-bottom">
            <div class="container">
                <h4 class="mt-2 logo-text">Кубышка</h4>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <div class="d-flex ms-3 gap-3">
                        <a href="/login" class="btn btn-primary btn-sm px-4 radius-30">Авторизация</a>
                        <a href="/registration" class="btn btn-white btn-sm px-4 radius-30">Регистрация</a>
                    </div>
                </div>
            </div>
        </nav>
    </header>

    <!--start content-->
    <main class="authentication-content">
        <div class="container">
            <div class="mt-4">
                <div class="card rounded-0 overflow-hidden shadow-none border mb-5 mb-lg-0">
                    <div class="row g-0">
                        <div class="col-12 order-1 col-xl-8 d-flex align-items-center justify-content-center border-end">
                            <img src="img/auth-img-7.png" class="img-fluid" alt="">
                        </div>
                        <div class="col-12 col-xl-4 order-xl-2">
                            <div class="card-body p-4 p-sm-5">
                                <h5 class="card-title">Авторизация</h5>
                                <form action="/login" method="post" class="form-body">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="row g-3">
                                        <div class="col-12">
                                            <label for="inputName" class="form-label">Логин</label>
                                            <div class="ms-auto position-relative">
                                                <input type="text" class="form-control radius-30 <#if loginError??>is-invalid</#if>" name="username" placeholder="Логин">
                                                <#if loginError??>
                                                    <div class="invalid-feedback">${loginError}</div>
                                                </#if>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputChoosePassword" class="form-label">Пароль</label>
                                            <div class="ms-auto position-relative">
                                                <input type="password" class="form-control radius-30 <#if loginError??>is-invalid</#if>" name="password" placeholder="Пароль">
                                                <#if loginError??>
                                                    <div class="invalid-feedback">${loginError}</div>
                                                </#if>
                                            </div>
                                        </div>

                                        <div class="col-12">
                                            <div class="d-grid">
                                                <input type="submit" class="btn btn-primary radius-30" value="Погнали" name="submit">
                                            </div>
                                        </div>
                                        <div class="col-12 text-center">
                                            <p class="mb-0">Еще не с нами? <a href="registration">Регистрируйся</a></p>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!--end page main-->

    <footer class="bg-white border-top p-3 text-center fixed-bottom">
        <p class="mb-0">© 2023. Все путем!</p>
    </footer>

</div>
<!--end wrapper-->


<!-- Bootstrap bundle JS -->
<script src="js/bootstrap.bundle.min.js"></script>

<!--plugins-->
<script src="js/jquery.min.js"></script>
<script src="js/pace.min.js"></script>


</body>

</html>