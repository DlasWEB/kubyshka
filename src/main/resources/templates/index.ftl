<#import "parts/common.ftl" as c>
<@c.head title="Главная страница">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
    <body>
        <@c.wrapper_class>
            <div class="card bg-transparent shadow-none">
                <div class="card-body">
                    <h6 class="mb-0 text-uppercase">Главная страница</h6>
                    <div class="my-3 border-top"></div>
                    <div class="position-relative" style="z-index: 1;">
                        <div class="row align-items-center">
                            <div class="col-xl-5 col-lg-6">
                                <div>
                                    <h1>Кубышка,</h1>
                                    <h3>посчитай свои кровные</h3>
                                </div>
                            </div>
                            <!--end col-->
                            <div class="col-lg-6 offset-xl-1">
                                <div class="mt-lg-0 mt-5">
                                    <img src="img/05.png" class="card-img">
                                </div>
                            </div>
                        </div>
                        <div class="w-100 border-top"></div>
                        <!--end row-->
                    </div>
                </div>
            </div>
            <div class="card bg-transparent shadow-none">
                <div class="card-body">
                    <div class="row justify-content-center">
                        <div class="col-lg-6">
                            <div class="text-center mb-4">
                                <h3>Как работает приложение?</h3>
                            </div>
                        </div>
                        <!--end col-->
                        <div class="col-lg-10">
                            <div class="timeline-page position-relative py-4">
                                <div class="timeline-item mb-lg-5 pb-5">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="text-center mb-5 mb-lg-0">
                                                <img src="img/02.png" alt="Work" class="img-fluid">
                                            </div>
                                        </div>
                                        <!--end col-->
                                        <div class="col-lg-6">
                                            <div class="works-description-right text-start bg-light mx-lg-3 mx-4">
                                                <h5 class="fs-18">1. Получи доступ!</h5>
                                                <p class="text-muted mb-0">Зарегистрируйся и авторизуйся в приложении.</p>
                                            </div>
                                        </div>
                                        <!--end col-->
                                    </div>
                                    <!--end row-->
                                </div>
                                <!--end timeline-item-->

                                <div class="timeline-item mb-5 pb-5">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="works-description-left text-start bg-light mx-lg-3 mx-4 text-lg-end">
                                                <h5 class="fs-18">2. Заполни информацией!</h5>
                                                <p class="text-muted mb-0">Внеси валюты, в которых у тебя есть накопления, типы сбережений для дополнительной классификации и сами сбережения.
                                                </p>
                                            </div>
                                        </div>
                                        <!--end col-->
                                        <div class="col-lg-6 order-first order-lg-last">
                                            <div class="text-center mb-5 mb-lg-0">
                                                <img src="img/04.png" alt="Work" class="img-fluid">
                                            </div>
                                        </div>
                                        <!--end col-->
                                    </div>
                                    <!--end row-->
                                </div>
                                <!--end timeline-item-->
                                <div class="timeline-item">
                                    <div class="row align-items-start">
                                        <div class="col-lg-6">
                                            <div class="text-center mb-5 mb-lg-0">
                                                <img src="img/06.png" alt="Work" class="img-fluid">
                                            </div>
                                        </div>
                                        <!--end col-->
                                        <div class="col-lg-6">
                                            <div class="works-description-right text-start bg-light mx-lg-3 mx-4">
                                                <h5 class="fs-18">3. Оценивай свой капитал!</h5>
                                                <p class="text-muted mb-0">Посмотри срезы в рублях, по валюте сбережений и по типу сбережений.</p>
                                            </div>
                                        </div>
                                        <!--end col-->
                                    </div>
                                    <!--end row-->
                                </div>
                                <!--end timeline-item-->
                            </div><!-- timeline-page -->
                        </div>
                        <!--end col-->
                    </div>
                    <div class="w-100 border-top"></div>
                </div>
            </div>
            <div class="card bg-transparent shadow-none">
                <div class="card-body">
                    <div class="row row-cols-1 row-cols-lg-3 justify-content-center g-lg-5">
                        <div class="col">
                            <div class="card">
                                <img src="img/01.png" class="card-img-top" alt="...">
                                <div class="card-body text-center">
                                    <h5 class="card-title">Уже с нами?!</h5>
                                    <a href="login" class="btn btn-primary">Авторизовывайся</a>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <img src="img/03.png" class="card-img-top" alt="...">
                                <div class="card-body text-center">
                                    <h5 class="card-title">Еще не с нами?!</h5>
                                    <a href="registration" class="btn btn-success">Регистрируйся</a>
                                </div>
                            </div>
                        </div>
                        <div class="w-100 border-top"></div>
                    </div><!--end row-->
                </div>
            </div>
        </@c.wrapper_class>
        <@c.scripts>

        </@c.scripts>
    </body>
</html>