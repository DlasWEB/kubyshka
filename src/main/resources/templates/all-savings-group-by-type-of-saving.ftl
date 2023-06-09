<#import "parts/common.ftl" as c>
<@c.head title="Все сбережения с группировкой по типу сбережения">
    <link href="css/dataTables.bootstrap5.min.css" rel="stylesheet" />
</@c.head>
<!DOCTYPE html>
<html lang="ru">
    <body>
        <@c.wrapper_class>
            <h6 class="mb-0 text-uppercase">Все сбережения с группировкой по типу сбережения</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <table id="example2" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Тип сбережения</th>
                                <th>Сумма, руб.</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list collectSavingGroupByTypeOfSavingContainerList as key, value>
                                <tr>
                                    <td>
                                        ${key.typeOfSaving}
                                    </td>
                                    <td>
                                        ${value}
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <h6 class="mb-0 text-uppercase">Распределение всех сбережений по типам, рубль</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <div id="chart9"></div>
                </div>
            </div>
        </@c.wrapper_class>
        <@c.scripts>
            <script src="js/jquery.dataTables.min.js"></script>
            <script src="js/dataTables.bootstrap5.min.js"></script>
            <script src="js/table-datatable.js"></script>
            <script src="js/apexcharts.min.js"></script>
            <script type="text/javascript">
                // chart 9
                var options = {
                    series:
                        [
                        <#list collectSavingGroupByTypeOfSavingContainerList?values as v>
                            ${v?c},
                        </#list>
                ],
                labels:
                    [
                    <#list collectSavingGroupByTypeOfSavingContainerList?keys as k>
                        "${k.typeOfSaving}",
                    </#list>
                ],
                chart: {
                    foreColor: '#9ba7b2',
                        height: 380,
                        type: 'donut',
                },
                plotOptions: {
                    pie: {
                        donut: {
                            labels: {
                                show: true,
                                    total: {
                                    label: 'Итого:',
                                        showAlways: true,
                                        show: true
                                }
                            }
                        }
                    }
                },
                colors: ["#FF6E40", "#FFA940", "#3D9AD1", "#36D986",
                    "#FF3D00", "#FF8C00", "#0969A2", "#00B358"],
                    responsive: [{
                    breakpoint: 480,
                    options: {
                        chart: {
                            height: 320
                        },
                        legend: {
                            position: 'bottom'
                        }
                    }
                }]
                };
                var chart = new ApexCharts(document.querySelector("#chart9"), options);
                chart.render();
            </script>
        </@c.scripts>
    </body>
</html>