<#import "parts/common.ftl" as c>
<@c.head title="Все валюты">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
    <body>
        <@c.wrapper_class>
            <h6 class="mb-0 text-uppercase">Все валюты</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table align-middle table-striped">
                            <thead class="table-secondary">
                            <tr>
                                <th>Валюта</th>
                                <th>Операции</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list allCurrencies as a>
                                <tr>
                                    <td>
                                        ${a.name}
                                    </td>
                                    <td>
                                        <div class="table-actions d-flex align-items-center gap-3 fs-6">
                                            <form class="mb-0" action="currencies-edit-${a.id}" method="get">
                                                <button class="btn btn-warning" type="submit">
                                                    <i class="bi bi-pencil-fill"></i>
                                                </button>
                                            </form>
                                            <form class="mb-0" action="currencies-delete-${a.id}" method="post">
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                <button class="btn btn-danger" type="submit">
                                                    <i class="bi bi-trash-fill"></i>
                                                </button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <h6 class="mb-0 text-uppercase">Добавление валюты</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <form method="post" class="row g-3">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <div class="col-12">
                            <label class="form-label">Валюта сбережения (<a href="https://www.cbr.ru/currency_base/daily/">актуальный список с сайта ЦБ РФ</a>)</label>
                            <input type="text" name="name"
                                   placeholder="Введите обозначение валюты в формате ISO 4217 (RUB, EUR, USD и т.п.)"
                                   class="form-control <#if nameError??>is-invalid</#if>" />
                            <#if nameError??>
                                <div class="invalid-feedback">${nameError}</div>
                            </#if>
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-success">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </@c.wrapper_class>
        <@c.scripts>

        </@c.scripts>
    </body>
</html>