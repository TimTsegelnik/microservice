# microservices

<br/>
<img src="/img/service-schema-v1.jpg">
<h2>Системная архитектура:</h2>
<table>
<tr>
<th>Компонент</th>
<th>Платформа</th>
<th>Функция</th>
</tr>
<tr>
<td>Gateway</td>
<td>Spring-Boot</td>
<td>
    <ul>
        <li>генерация документации</li>
        <li>валидация запросов</li>
        <li>передача запроса на получение всех данных сенсора</li>
        <li>передача запроса на получение данных сенсора в течение указанного времени</li>
        <li>передача запроса на полученние кол-ва ошибок и отправленных в связи с ними оповещений</li>
        <li>передача запроса на получение всех данных со статусом маркировки</li>
    </ul>
</td>
</tr>
<tr>
<td>Sensor-Listener</td>
<td>Spring-Boot</td>
<td>
    <ul>
        <li>получение данных от Sensor</li>
        <li>валидация полученных данных</li>
        <li>сохранение полученных данных в базу данных</li>
        <li>передача полученных данных с помощью Kafka</li>
    </ul>
</td>
</tr>
<tr>
<td>Sensor</td>
<td>Spring-Boot</td>
<td>
    <ul>
        <li>имитация работы датчика</li>
        <li>передача данных по каждому запросу</li>
    </ul>
</td>
</tr>
<tr>
<td>Alert-Service</td>
<td>Spring-Boot</td>
<td>
    <ul>
        <li>получение данных из Kafka</li>
        <li>сканирование полученных данных на наличие высоких показателей</li>
        <li>сохранение данных с высокими показателями в базу данных</li>
        <li>отправление оповещения в Messenger</li>
        <li>выдача полученных данных по запросу</li>
    </ul>
</td>
</tr>
<tr>
<td>Messenger</td>
<td>Spring-Boot</td>
<td>
    <ul>
        <li>получение оповещения от Alert-service</li>
        <li>отправка оповещения на определенные адреса</li>
    </ul>
</td>
</tr>
<tr>
<td>Audit</td>
<td>Spring-Boot</td>
<td>
    <ul>
        <li>получение данных из Kafka</li>
        <li>обработка полученых данных, присвоение соответсвующей маркировки</li>
        <li>сохранение обработанных данных в базе данных</li>
        <li>выдача сохраненных данных по запросу</li>
    </ul>
</td>
</tr>
</table>

[//]: # (///////////////////////////////////////////////////////)
<h2>Агрегаты:</h2>
<h3>Sensor - Listener BD (PostgresQL) </h3>
<h4>Table: SENSOR_METRICS </h4>
<table>
<tr>
    <th>Поле</th>
    <th>Описание</th>
    <th>Тип</th>
    <th>Обязательность</th>
</tr>
<tr>
    <td>id</td>
    <td>Идентефикатор</td>
    <td></td>
    <td>Да</td>
</tr>
<tr>
    <td>sensor_id</td>
    <td>Название</td>
    <td>Строка</td>
    <td>Да</td>
</tr>
<tr>
    <td>sensor_data</td>
    <td>Данные измерения</td>
    <td>Число</td>
    <td>Да</td>
</tr>
<tr>
    <td>timestamp</td>
    <td>Дата измерения</td>
    <td>Время</td>
    <td>Да</td>
</tr>
</table>

<h3>Alert - Service BD (PostgresQL) </h3>
<h4>Table: SENSOR </h4>
<table>
<tr>
    <th>Поле</th>
    <th>Описание</th>
    <th>Тип</th>
    <th>Обязательность</th>
</tr>
<tr>
    <td>id</td>
    <td>Идентефикатор</td>
    <td></td>
    <td>Да</td>
</tr>
<tr>
    <td>sensor_name</td>
    <td>Название</td>
    <td>Строка</td>
    <td>Да</td>
</tr>
<tr>
    <td>sensor_data</td>
    <td>Данные измерения</td>
    <td>Число</td>
    <td>Да</td>
</tr>
<tr>
    <td>timestamp</td>
    <td>Дата измерения</td>
    <td>Время</td>
    <td>Да</td>
</tr>
<tr>
    <td>status</td>
    <td>Маркер состояния</td>
    <td>Строка</td>
    <td>Да</td>
</tr>
</table>

<h3>Alert - Service BD (PostgresQL) </h3>
<h4>Table: SENSOR</h4>
<table>
<tr>
    <th>Поле</th>
    <th>Описание</th>
    <th>Тип</th>
    <th>Обязательность</th>
</tr>
<tr>
    <td>id</td>
    <td>Идентефикатор</td>
    <td></td>
    <td>Да</td>
</tr>
<tr>
    <td>sensor_id</td>
    <td>Название</td>
    <td>Строка</td>
    <td>Да</td>
</tr>
<tr>
    <td>sensor_data</td>
    <td>Данные измерения</td>
    <td>Число</td>
    <td>Да</td>
</tr>
<tr>
    <td>timestamp</td>
    <td>Дата измерения</td>
    <td>Время</td>
    <td>Да</td>
</tr>
</table>


