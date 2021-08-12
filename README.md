# API Taxi24

## Librerías
* [Spring Boot](https://spring.io/projects/spring-boot)
* [MongoDB](https://www.mongodb.com)

## Recursos
* [MockMVC](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html)
* [Spring Initializer](https://start.spring.io)
* [Spring Docs](https://spring.io/guides)
* [Postman](https://www.postman.com)

## Modo de uso

Primero se inician los servicios de MongoDB en este caso para MAC con ayuda de brew.

> brew services start mongodb-community@5.0


Desde la carpeta raiz del proyecto se debe cargar la estructura de la base de datos y algunas entradas incluidas para los ejemplos.

```
mongo localhost:27017/taxi24 Models/insertDB.js
```


Para iniciar el servidor se inician los servicios de SpringBoot.

```
./mvnw spring-boot:run

```

### Esta implementación obedece al siguiente esquema:
![alt text](https://github.com/forcesk/API-Taxi24/blob/d6ebc9ccaa22b5e6bee751406e34385da58808bc/img/estructura.png)

### API y EndPoints

#### Conductores
* Obtener la lista de todos los conductores 
> http://localhost:8080/conductores
* Obtener la lista de todos los conductores DISPONIBLES 
> http://localhost:8080/conductores/disponibles
* Obtener la lista de todos los conductores DISPONIBLES en un radio de 3KM a partir de la ubicación de la ubicación del usuario que solicita.
> http://localhost:8080/conductores/near
* Obtener un conductor por ID, donde {id} debe ser alguno de los registrados.
> http://localhost:8080/conductores/{id}
