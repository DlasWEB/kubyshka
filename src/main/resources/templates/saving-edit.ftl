<#import "parts/common.ftl" as c>
<@c.head title="Изменение сбережения">

</@c.head>
<!DOCTYPE html>
<html lang="ru">
<body>
<@c.wrapper_class>
    <h6 class="mb-0 text-uppercase">Именение сбережения</h6>
    <hr/>
    <div class="card">
        <div class="card-body">
            <#list saving as s>
                <form method="post" class="row g-3">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="col-12">
                        <label class="form-label">Описание сбережения</label>
                        <input type="text"
                               name="saving_name"
                               value="${s.saving_name}"
                               placeholder="Понятное название (инвестиции в ВТБ или депозит в Сбере и т.п.)"
                               class="form-control" />
                    </div>
                    <div class="col-12">
                        <label class="form-label">Сумма сбережения (целое положительное число без пробелов)</label>
                        <input type="text"
                               name="amount"
                               value="${s.amount?c}"
                               placeholder="Сумма сбережения в виде целого натурального числа без пробелов в валюте,
                                        которую выберете в следующем поле"
                               class="form-control" />
                    </div>
                    <div class="col-12">
                        <label class="form-label">Валюта сбережения</label>
                        <select class="form-select" name="currency_name">
                            <option value="${s.currency_name}">${s.currency_name}</option>
                            <#list allCurrencies as ac>
                                <#if ac.name != s.currency_name>
                                <option value="${ac.name}">${ac.name}</option>
                                </#if>
                            </#list>
                        </select>
                    </div>
                    <div class="col-12">
                        <label class="form-label">Тип сбережения</label>
                        <select class="form-select" name="saving_type">
                            <option value="${s.saving_type}">${s.saving_type}</option>
                            <#list allTypesOfSavings as at>
                                 <#if at.name != s.saving_type>
                                <option value="${at.name}">${at.name}</option>
                                 </#if>
                            </#list>
                        </select>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-success">Изменить</button>
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