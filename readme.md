
Simple Restful API Webservice Using Java

## How to use

- Download this project
- Download and unzip Apache Tomcat EE Plus
- Open Eclipse and open this project
- Right click on the project and run as -> run on server
- Choose Apache Tomcat 9.0 and set the folder
- Open command prompt
- Go to the project folder

- Test following url using curl command
    - curl -X GET "http://localhost:8080/simple-restful-java/score"
    - curl -X POST "http://localhost:8080/simple-restful-java/score/wins"
	- curl -X POST "http://localhost:8080/simple-restful-java/score/losses"
	- curl -X POST "http://localhost:8080/simple-restful-java/score/ties"
	- curl -X PUT "http://localhost:8080/simple-restful-java/score?wins=1&losses=2&ties=3"

