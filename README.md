# SBRS
Swagger API documentation use in a Spring Boot REST project


## Recommended settings

* jdk 14 (can be changed in build.gradle)
* gradle 6.6.1
* port 8099 (can be changed in src/main/dist/conf/application.yml)

** Incase of running the project from IDE src/main/resources/application.yml needed to modified.


### Build && start using gradle

```bash
git clone https://github.com/Shariful-NomaD-Islam/sbrs.git
cd sbrs
gradle clean build
gradle bootRun
```


### Execute

```bash
java -jar build/libs/sbrs-0.0.1-SNAPSHOT.jar
```


### Swagger API Doc walk-through

01. Start the project using gradle/jar file
02. Go to url http://localhost:8099/swagger-ui.html
03. All the controller and model object will be shown on the link with expanding option
04. When Models are expanded there param with information(if provided) will be shown
05. When REST calls are expanded all the request and response param with information(if provided) are shown.
06. Possible exception are also shown in the REST calls
07. Using the "Try it out" and "Execute" button REST call can be made(assuming the application is running).
08. After "Execute" Response/Exception will be shown.
09. Operation 07 and 09 is possible both in Run/Debug mode application start.   

###### Date && Time
* Created time: 03 SEP 2020
* Last updated: 04 SEP 2020

###### NomaD