# my-target-retail

This application was generated using Spring Initializer, you can find documentation and help at [https://docs.spring.io/initializr/docs/current/reference/html/].

This is a "microservice" application intended to be part of a microservice architecture, please refer to the [Doing microservices with SpringBoot][] page of the documentation for more information.

This microservice (my-target-retail) reads necessary config from the config server. Config Server is running at [http://localhost:8888]

This microservice (my-target-retail) is running on port 8500. This can be reconfigured in the default-app-config git repo which is specific to environment.

## Development

To start your application in the dev profile, run:

```
./mvnw
```

For further instructions on how to develop with Spring Boot, have a look at [Using SpringBoot in development][].

## Building for production

### Packaging as jar

To build the final jar and optimize the my-target-retail application for production, run:

```
./mvnw -Pprod clean verify
```

To ensure everything worked, run:

```
java -jar target/*.jar
```


### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

```
./mvnw -Pprod,war clean verify
```

## Testing

To launch your application's tests, run:

```
./mvnw verify
```

For more information, refer to the [Running tests page][].

[Doing microservices with SpringBoot]: https://spring.io/microservices/
[Using SpringBoot in development]: https://spring.io/projects/spring-boot