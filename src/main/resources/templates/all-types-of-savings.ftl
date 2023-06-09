<#import "parts/common.ftl" as c>
<@c.head title="Все типы сбережений">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
    <body>
        <@c.wrapper_class>
            <h6 class="mb-0 text-uppercase">Все типы сбережений</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table align-middle table-striped">
                            <thead class="table-secondary">
                            <tr>
                                <th>Тип сбережения</th>
                                <th>Операции</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list allTypesOfSavings as a>
                                <tr>
                                    <td>
                                        ${a.name}
                                    </td>
                                    <td>
                                        <div class="table-actions d-flex align-items-center gap-3 fs-6">
                                            <form class="mb-0" action="type-of-saving-edit-${a.id}" method="get">
                                                <button class="btn btn-warning" type="submit">
                                                    <i class="bi bi-pencil-fill"></i>
                                                </button>
                                            </form>
                                            <form class="mb-0" action="type-of-saving-delete-${a.id}" method="post">
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
            <h6 class="mb-0 text-uppercase">Добавление типа сбережения</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <form method="post" class="row g-3">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <div class="col-12">
                            <label class="form-label">Тип сбережения</label>
                            <input type="text" name="name"
                                   placeholder="Введите название типа сбережения (Наличка, Депозит, Инвестиции и т.п.)"
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