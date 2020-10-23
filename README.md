# Test 

## Description

Imagine that you are involved in the development of a large file storage system. Special feature here is storing photos and images. We need to provide our users with the possibility to search stored images based on attribute fields.

## Before start
Change properties in [application.properties](src/main/resources/application.properties).
Add your DB driver to [pom.xml](pom.xml).
In this case we are using MySQL DB.

Make sure you set a right credentials for DB connection, API key, period(in ms) and url fir 3rd party API.


```properties
server.port=2121

spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://localhost:3306/TEST
spring.datasource.username=pavel
spring.datasource.password=pavel

#3rd party API url
url=http://interview.agileengine.com:80
#period for update data in 'cache' in ms.
period=60000
#credential for providing token
key.value=23567b218376f79d9415
#period for refreshing token in ms.
key.live=600000
```

## Start
* Open your browser and enter in search field `http://localhost:2121/`.
* At this application you are able to find: 
  * all images via using `/images` route. p.s this method supports pagination.
  * get more details about the specific image by id `/images/1s2o3m4e5i6d`.
  * search some specific images with already known information about them `/search/1s2o3m4e5i6d`. p.s. you can choose any property.
    

## Read more about libraries
[Spring Data](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface).

[Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/).
