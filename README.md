## Kubyshka (Кубышка)

<p align="center">
      <img src="https://github.com/DlasWEB/kubyshka/blob/master/src/main/resources/static/img/05.png" alt="Project Logo">
</p>

## Описание

Kubyshka это веб приложения для учета ваших накоплений. Принцип его работы заключается в предоставлении срезов по сбережениям, которые вы занесли в бд под своим пользователем.

## Установка

Для развертывания приложения необходим `docker` и два образа: `kubyshka` и `БД (Mysql или PostreSql)`. Приложение можно развернуть локально или на сервере. 
Для разворачивания приложения нужно выполнить следующие шаги (**инструкция на примере Debian подобных систем**):
1. Качаем образы с:<br/>
    - `mysql сервером` (если у вас его нет) командой: 
        ```shell script
        $ docker pull mysql
        ```
    - `kubyshka` командой: 
        ```shell script
        $ docker pull mrdlas/kubyshka:kubyshka
        ```
2. Проверяем
     ```shell script
     $ docker images
     ``` 
    если все ок, то вы увидите образы `mrdlas/kubyshka` и `mysql` (возможно будут и другие, если они есть у вас на машине)
3. Создаем сеть для контакта между контейнером с БД и контейнером с Kubyshka
     ```shell script
     $ docker network create kubyshka-net
     ```
4. Поднимаем контейнеры с:
    - mysql 
        ```shell script
        $ docker run --restart=unless-stopped -dit --net kubyshka-net -p 3307:3306 --name mysqldb_kubyshka -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=kubyshka_db mysql
        ```
    - kubyshka 
        ```shell script
        $ docker run --restart=unless-stopped -dit -p 9090:8080 --name my-kubyshka --net kubyshka-net -e MYSQL_HOST=mysqldb_kubyshka -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 mrdlas/kubyshka:kubyshka        
        ```
      Название бд, название контейнеров, пароль root пользователя в бд и порты можно ставить свои. Главное чтобы все согласовывалось.
5. Проверяем успешность подключения 
    ```shell script
   $ docker container inspect mysqldb_kubyshka 
    ```
     если все ок, то в разделе Networks вы увидите сеть `kubyshka-net`
    ```shell script
   $ docker container inspect ID_контейнера_с_кубышкой
    ``` 
    узнать ID контейнера можно командой 
   ```shell script
   $ docker ps 
   ```
   если все ок, то в разделе Networks вы увидите сеть `kubyshka-net`.
   
   ### Готово!
   
   В браузере проходим по адресу 'localhost:9090/' и вы уведите рабочее приложение (если устанавливали на сервере, то вместо localhost вбивайте его ip)
   
   <img src="https://github.com/DlasWEB/kubyshka/blob/master/img_for_readme/1.png" alt="Главная страница">
   
   ### Далее:
   1. Регистрируйте пользователя
   2. Логинтесь
   3. Добавляйте валюту в требуемом формате
   4. Добавляйте типы сбережений
   5. Добавляйте сбережения. 
   6. Смотрите срезы.
   
   ### P.S.
   
   Приложение достаточно простое и сырое, т.к. выполнялось как пэт проект, но я только учусь и собираюсь поддерживать и развивать его дальше.
   
   ## Разработчики
   
   - [Денис Ласкин](https://github.com/DlasWEB)
   
   ## Лицензия
   
   Проект **[Kubyshka](https://github.com/DlasWEB/kubyshka)** распространяется под лицензией GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007.
