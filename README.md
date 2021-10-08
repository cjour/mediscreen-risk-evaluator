
# Mediscreen-risk-evaluator

REST API allowing to determine patient risk for diabetis.

## Technical : 
1. JAVA : 11
2. Spring boot : v2.5.5
3. Docker-compose : v1.29.2
4. Maven : v3.6.3

## Deployment :
Make sure that Docker and Maven are installed on your system. <br />

run the CLI command : ``$ ./mvnw package && java -jar target/mediscreen-risk-evaluator.jar`` <br />

run the CLI command : ``$ docker-compose up --build -d``<br />

### Code coverage (JaCoCo report)
![Screenshot 2021-10-07 at 10-25-22 risk-evaluator](https://user-images.githubusercontent.com/61873476/136354348-53c2b2ce-8ff5-43b3-918d-1b35ebf4850b.png)
