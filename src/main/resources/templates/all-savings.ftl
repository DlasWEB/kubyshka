<#import "parts/common.ftl" as c>
<@c.head title="Все сбережения">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
    <body>
        <@c.wrapper_class>
            <h6 class="mb-0 text-uppercase">Все сбережения</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table align-middle table-striped">

                            <thead class="table-secondary">
                            <tr>
                                <th>Описание</th>
                                <th>Сумма</th>
                                <th>Валюта</th>
                                <th>Тип сбережения</th>
                                <th>Операции</th>
<#--                                <th>Автор</th>-->
                            </tr>
                            </thead>
                            <tbody>
                            <#list allSavings as a>
                                <tr>
                                    <td>
                                        ${a.saving_name}
                                    </td>
                                    <td>
                                        ${a.amount}
                                    </td>
                                    <td>
                                        ${a.currency_name}
                                    </td>
                                    <td>
                                        ${a.saving_type}
                                    </td>
                                    <td>
                                        <div class="table-actions d-flex align-items-center gap-3 fs-6">
                                            <form class="mb-0" action="savings-edit-${a.id}" method="get">
                                                <button class="btn btn-warning" type="submit">
                                                    <i class="bi bi-pencil-fill"></i>
                                                </button>
                                            </form>
                                            <form class="mb-0" action="savings-delete-${a.id}" method="post">
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
            <h6 class="mb-0 text-uppercase">Добавление сбережения</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <form method="post" class="row g-3">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div class="col-12">
                            <label class="form-label">Описание сбережения</label>

                            <input type="text" name="saving_name"
                                   placeholder="Понятное название (инвестиции в ВТБ или депозит в Сбере и т.п.)"
                                   class="form-control <#if saving_nameError??>is-invalid</#if>"
                            />
                            <#if saving_nameError??>
                                <div class="invalid-feedback">${saving_nameError}</div>
                            </#if>
                        </div>
                        <div class="col-12">
                            <label class="form-label">Сумма сбережения</label>
                            <input type="text" name="amount"
                                   placeholder="Сумма сбережения в виде целого натурального числа в валюте, которую выберете в следующем поле"
                                   class="form-control <#if amountError??>is-invalid</#if>"
                            />
                            <#if amountError??>
                                <div class="invalid-feedback">${amountError}</div>
                            </#if>
                        </div>
                        <div class="col-12">
                            <label class="form-label">Валюта сбережения</label>
                            <select class="form-select" name="currency_name">
                                <#list allCurrencies as ac>
                                    <option value="${ac.name}">${ac.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-12">
                            <label class="form-label">Тип сбережения</label>
                            <select class="form-select" name="saving_type">
                                <#list allTypesOfSavings as at>
                                    <option value="${at.name}">${at.name}</option>
                                </#list>
                            </select>
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