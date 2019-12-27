## 'Hello World' Application with Spring Boot Microservice  Stack

This is very simple microservice application designed to illustrate  the basic concept of Microservice Architecture and to provide a starting point for future development of any business application. 

#### Business Requirements

Since it is a  simple 'Hello World' application, it should produce a 'Hello *World*'  messages in JSON format. The  second  part of the message should  be replaceable and configurable based on a  value in the property file. So if the property file is updated and the word '*World* ' is replaced with '*Java*', the service should start producing 'Hello *Java*' message.

#### Solution

!['Hello World' microservices](D:\Projects\IntelliJ\microservices-hello-world\hello-world-microservices2.png)



The business logic is located in two Microservices:

| Microservice Name  | Location            | Description                                                  |
| ------------------ | ------------------- | ------------------------------------------------------------ |
| HelloWorld service | /helloworld_service | The main service. It receives client requests,  calls GetName service  to get the second part of the greeting message,  builds the whole message and returns it to the client in JSON format.<br />Note:  A Circuit Breaker is used in the  GetName call. |
| GetName service    | /getname_service    | Provides the second part of the 'Hello *World*' message from `/config_dir/getname-service.properties` file. |

This implementation is based on open-source Spring Boot v2.2.2 and Spring Cloud Netflix frameworks. 

