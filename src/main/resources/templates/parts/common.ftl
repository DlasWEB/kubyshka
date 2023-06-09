<#include "security.ftl">
<#macro head title>
    <head xmlns="http://www.w3.org/1999/html">
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="icon" href="img/favicon-32x32.png" type="image/png" />
            <!--plugins-->
            <link href="css/simplebar.css" rel="stylesheet" />
            <link href="css/perfect-scrollbar.css" rel="stylesheet" />
            <link href="css/metisMenu.min.css" rel="stylesheet" />
            <!-- Bootstrap CSS -->
            <link href="css/bootstrap.min.css" rel="stylesheet" />
            <link href="css/bootstrap-extended.css" rel="stylesheet" />
            <link href="css/style.css" rel="stylesheet" />
            <link href="css/icons.css" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
            <#nested>
            <title>${title}</title>
        </head>
</#macro>

<#macro wrapper_class>
    <!--start wrapper-->
    <div class="wrapper">
        <!--start top header-->
        <header class="top-header">
            <nav class="navbar navbar-expand gap-3">
                <div class="mobile-toggle-icon fs-3">
                    <i class="bi bi-list"></i>
                </div>
                <div class="top-navbar-right ms-auto">
                    <ul class="navbar-nav align-items-center">
                        <li class="nav-item dropdown dropdown-large">
                            <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                                <div class="projects">
                                    <i class="bi bi-grid-3x3-gap-fill"></i>
                                </div>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end">
                                <div class="p-2 border-bottom m-2">
                                    <h5 class="h5 mb-0">
                                        <#if user??>${name}<#else>Авторизуйся или регистрируйся</#if>
                                    </h5>
                                </div>
                                <div class="row row-cols-3 gx-2">
                                    <#if user??>
                                        <div class="col">
                                            <form action="/logout" method="post">
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                    <div class="apps p-2 radius-10 text-center">
                                                        <button type="submit" class="apps-icon-box mb-1 text-white bg-gradient-voilet">
                                                            <i class="bi bi-arrow-up-right-circle"></i>
                                                        </button>
                                                        <p class="mb-0 apps-name">Выйти</p>
                                                    </div>
                                            </form>
                                        </div>
                                    <#else>
                                        <div class="col">
                                            <a href="/login">
                                                <div class="apps p-2 radius-10 text-center">
                                                    <div class="apps-icon-box mb-1 text-white bg-gradient-danger">
                                                        <i class="bi bi-arrow-down-circle"></i>
                                                    </div>
                                                    <p class="mb-0 apps-name">Авторизация</p>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="col">
                                            <a href="/registration">
                                                <div class="apps p-2 radius-10 text-center">
                                                    <div class="apps-icon-box mb-1 text-white bg-gradient-warning">
                                                        <i class="bi bi-arrow-down-right-circle"></i>
                                                    </div>
                                                    <p class="mb-0 apps-name">Регистрация</p>
                                                </div>
                                            </a>
                                        </div>
                                    </#if>
                                </div><!--end row-->
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!--end top header-->

        <!--start sidebar -->
        <aside class="sidebar-wrapper" data-simplebar="true">
            <div class="sidebar-header">
                <div>
                    <img src="img/logo-icon.png" class="logo-icon" alt="logo icon">
                </div>
                <div>
                    <h4 class="logo-text">Кубышка</h4>
                </div>
                <div class="toggle-icon ms-auto"> <i class="bi bi-list"></i>
                </div>
            </div>
            <!--navigation-->
            <ul class="metismenu" id="menu">
                <#if user??>
                    <li>
                        <a href="/">
                            <div class="parent-icon"><i class="bi bi-house-fill"></i>
                            </div>
                            <div class="menu-title">Главная</div>
                        </a>
                    </li>
                    <li class="menu-label">Срезы:</li>
                    <li>
                        <a href="savings-rub">
                            <div class="parent-icon"><i class="bi bi-piggy-bank-fill"></i>
                            </div>
                            <div class="menu-title">В рублях</div>
                        </a>
                    </li>
                    <li>
                        <a href="savings-group-by-currency">
                            <div class="parent-icon"><i class="bi bi-cash-stack"></i>
                            </div>
                            <div class="menu-title">По валюте</div>
                        </a>
                    </li>
                    <li>
                        <a href="savings-group-by-type-of-saving">
                            <div class="parent-icon"><i class="bi bi-basket"></i>
                            </div>
                            <div class="menu-title">По типам</div>
                        </a>
                    </li>
                    <li class="menu-label">Управление:</li>
                    <li>
                        <a href="currencies">
                            <div class="parent-icon"><i class="bi bi-currency-exchange"></i>
                            </div>
                            <div class="menu-title">Валютами</div>
                        </a>
                    </li>
                    <li>
                        <a href="types-of-savings">
                            <div class="parent-icon"><i class="bi bi-wallet2"></i>
                            </div>
                            <div class="menu-title">Типами сбережений</div>
                        </a>
                    </li>
                    <li>
                        <a href="savings">
                            <div class="parent-icon"><i class="bi bi-inboxes"></i>
                            </div>
                            <div class="menu-title">Сбережениями</div>
                        </a>
                    </li>
                <#else>
                    <li>
                        <a href="/">
                            <div class="parent-icon"><i class="bi bi-house-fill"></i>
                            </div>
                            <div class="menu-title">Главная</div>
                        </a>
                    </li>
                </#if>
            </ul>
            <!--end navigation-->
        </aside>
        <!--end sidebar -->

        <!--start content-->
        <main class="page-content">
            <#nested>
        </main>
        <!--end page main-->
        <!--start overlay-->
        <div class="overlay nav-toggle-icon"></div>
        <!--end overlay-->
        <!--Start Back To Top Button-->
        <a href="javaScript:;" class="back-to-top"><i class='bx bxs-up-arrow-alt'></i></a>
        <!--End Back To Top Button-->
    </div>
    <!--end wrapper-->
</#macro>

<#macro scripts>
    <!-- Bootstrap bundle JS -->
    <script src="js/bootstrap.bundle.min.js"></script>
    <!--plugins-->
    <script src="js/jquery.min.js"></script>
    <script src="js/simplebar.min.js"></script>
    <script src="js/metisMenu.min.js"></script>
    <script src="js/perfect-scrollbar.js"></script>
    <script src="js/pace.min.js"></script>
    <#nested>
    <!--app-->
    <script src="js/app.js"></script>

</#macro>



