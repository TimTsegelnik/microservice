# microservices

<br/>
<img src="/img/service-schema-v1.jpg">

<h3>Description: </h2>
<ol>
<li>gateway</li>
<li>audit - service</li>
<li>???????</li>
<li>service - messenger</li>
<li>sensor - listener</li>
<li>sensor</li>
</ol>


<h3>gateway:</h3>
<pre>
    gateway
</pre>
<h3>audit - service:</h3>
<pre>
    listens to Kafka and, depending on a sensorValue, assigns a status and 
    stores it to db.
    Statuses: 
       NORMAL = 0 - 30  
       LOADED = 31 - 60  
       FAILED = 61 - 100 
</pre>
<h3>???????:</h3>
<pre>
    listens to Kafka and when its message contains a sensorValue == 100
    sends a request to the gmail-service.
</pre>
<h3>gmail - messenger:</h3>
<pre>
    sends message to email
</pre>
<h3>sensor - listener:</h3>
<pre>
    requests data from sensor every 1 sec than stores it in db and 
    sends it by kafka to other services.

    Get: sensor-listener/v1/sensors 
        @Param page=int
        @Param size=int
    response: get all sensors storing in db

    Get: sensor-listener/v1/sensors/between
        @Param page=int
        @Param size=int 
        @Param endWith=LocalDateTime
        @Param startWith=LocalDateTime
</pre>
<h3>sensor:</h3>
<pre>
    Get: /sensor/v1/data 
    response: random int 0-100
</pre>
