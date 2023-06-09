<#import "parts/common.ftl" as c>
<@c.head title="Изменение валюты">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
<body>
<@c.wrapper_class>
    <h6 class="mb-0 text-uppercase">Именение валюты</h6>
    <hr/>
    <div class="card">
        <div class="card-body">
            <#list currency as c>
                <form method="post" class="row g-3">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="col-12">
                        <label class="form-label">Валюта сбережения</label>
                        <input type="text"
                               value="${c.name}"
                               name="name"
                               placeholder="Введите обозначение валюты в формате ISO 4217 (RUB, EUR, USD и т.п.)"
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