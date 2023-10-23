Demo from: https://spring.io/guides/gs/spring-boot/#scratch

```To run application```
./mvnw spring-boot:run

```To view actuator```
http://localhost:8080/actuator/health
http://localhost:8080/actuator

```To check application health via cURL```
$ curl localhost:8080/actuator/health
{"status":"UP"}

```To invoke application shut-down```
$ curl -X POST localhost:8080/actuator/shutdown
{"timestamp":1401820343710,"error":"Not Found","status":404,"message":"","path":"/actuator/shutdown"}