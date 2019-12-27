## 'Hello World' Application with Spring Boot Microservice  Stack

This is very simple microservice application designed to illustrate  the basic concept of Microservice Architecture and to provide a starting point for future development of any business application. 

#### Business Requirements

Since it is a  simple 'Hello World' application, it should produce a 'Hello *World*'  messages in JSON format. The  second  part of the message should  be replaceable and configurable based on a  value in the property file. So if the property file is updated and the word '*World* ' is replaced with '*Java*', the service should start producing 'Hello *Java*' message.

#### Solution

The business logic is located in two Microservices:

| Microservice Name  | Location            | Description                                                  |
| ------------------ | ------------------- | ------------------------------------------------------------ |
| getname-service    | /getname_service    | Provides the second part of the 'Hello *World*' message from `/config_dir/getname-service.properties` file. |
| helloworld-service | /helloworld_service | Main service                                                 |
|                    |                     |                                                              |

getname-service  - provides the second part of the messages

This implementation is based on open-source Spring Boot v2.2.2 and Netflix frameworks. 

This code developed  to illustrate  the basic concept of Microservice Architecture and to provide an ability to play and 