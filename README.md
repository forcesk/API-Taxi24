# API Taxi24 :taxi:

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
> [Estructura de la base de datos](https://github.com/forcesk/API-Taxi24/blob/9733585a87b16e427808a1e312cc337d89b44535/Models/insertDB.js)
```
mongo localhost:27017/taxi24 Models/insertDB.js
```


Para iniciar el servidor se inician los servicios de SpringBoot.

```
./mvnw spring-boot:run
```

## Esta implementación obedece al siguiente esquema:
> ![alt text](https://github.com/forcesk/API-Taxi24/blob/d6ebc9ccaa22b5e6bee751406e34385da58808bc/img/estructura.png)

## API y EndPoints

### Conductores :oncoming_automobile:
* Obtener la lista de todos los conductores 
> http://localhost:8080/conductores
* Obtener la lista de todos los conductores DISPONIBLES 
> http://localhost:8080/conductores/disponibles
* Obtener la lista de todos los conductores DISPONIBLES en un radio de 3KM a partir de la ubicación de la ubicación del usuario que solicita.
> http://localhost:8080/conductores/near
* Obtener un conductor por ID, donde {id} debe ser alguno de los registrados.
> http://localhost:8080/conductores/{id}


### Viajes :oncoming_taxi:
* Crear una nueva solicitud de viaje asignando un conductor al solicitante, donde idPasajero es un id de algun pasajero registrado.
> http://localhost:8080/viajes/nuevo/{idPasajero}
* Completar un viaje activo, donde idViaje es el id de algun viaje activo registrado. Se agrega una factura nueva.
> http://localhost:8080/viajes/end/{idViaje}
* Obtener la lista de todos los viajes ACTIVOS.
> http://localhost:8080/viajes

### Pasajeros :walking: 
* Obtener la lista de todos los pasajeros 
> http://localhost:8080/pasajeros
* Obtener un pasajero por ID, donde {id} debe ser alguno de los registrados.
> http://localhost:8080/pasajeros/{id}
* Obtener los 3 conductores más cercarnos al punto de partida del usuario que lo solicita, donde {usuarioId} es el id del usuario que lo solicita.
> http://localhost:8080/pasajeros/near/{usuarioId}
 
### Facturas :page_with_curl:
* Obtener la lista de todas las facturas registradas.
> http://localhost:8080/facturas
* Las facturas nuevas son agregadas cuando se finaliza un viaje activo.


## Pruebas :construction_worker:

* Para ejecutar todas las pruebas en Intellij 
> ![alt text](https://github.com/forcesk/API-Taxi24/blob/8ecf4e81579f6c583c5d03a97b7f8e23623778bc/img/test1.png)
* La salida de las pruebas es la siguiente
> ![alt text](https://github.com/forcesk/API-Taxi24/blob/7b3a41920f1c8cc10d2763259544173e8a279168/img/test2.png)


