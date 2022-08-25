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
    Gateway accepts a request and validates it, then distributes it to internal services.
</pre>
<h3>Audit - service:</h3>
<pre>
    Audit listens to the Kafka and, depending on a sensorValue assigns one of statuses:  
       NORMAL = 0 - 30  
       LOADED = 31 - 60  
       FAILED = 61 - 100
    Then it stores data in the postgres bd, which one's using partition data by statuses.
</pre>
<h3>???????:</h3>
<pre>
    Listens to Kafka, if its message contains a sensorValue that equals 100,
    stores data in bd and sends a request to the messenger.
</pre>
<h3>Messenger:</h3>
<pre>
    Messenger just merely sends message to a certain email
</pre>
<h3>Sensor - listener:</h3>
<pre>
    Every one second Sensor-listener requests data from sensor than stores it in the Postgres db and 
    sends it by kafka to other services.
</pre>
<h3>Sensor:</h3>
<pre>
    For each request Sensor creates random sensorValue in a range between 0 and 100.  
</pre>
