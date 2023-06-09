<#import "parts/common.ftl" as c>
<@c.head title="Изменение типа сбережения">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
<body>
<@c.wrapper_class>
    <h6 class="mb-0 text-uppercase">Именение типа сбережения</h6>
    <hr/>
    <div class="card">
        <div class="card-body">
            <#list typeOfSaving as t>
                <form method="post" class="row g-3">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="col-12">
                        <label class="form-label">Тип сбережения</label>
                        <input type="text"
                               value="${t.name}"
                               name="name"
                               placeholder="Введите название типа сбережения (Наличка, Депозит, Инвестиции и т.п.)"
                               class="form-control" />
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-success">Обновить</button>
                    </div>
                </form>
            </#list>
        </div>
    </div>
</@c.wrapper_class>
<@c.scripts>

</@c.scripts>
</body>
</html>