# Prueba Técnica 

1) Descargar el proyecto.
2) Abrir una terminal ya sea en el editor o de su preferencia y posicionarse en la carpeta "src/main/resources/data"
3) DEscargar la imagen de postgres:latest // docker pull postgres:latest
4) Ejecutar el siguiente comando docker-compose up ![docker-compose-up.png](src/main/resources/img/docker-compose-up.png)
5) Abrir la colección de postman 
    - ejecutar el request "save-employee"
    - ejecutar los siguientes request en el orden deseado
6) Se adjunta evidencia del correcto funcionamiento
![inserts.png](src/main/resources/img/inserts.png)
![getall.png](src/main/resources/img/getall.png)
![patch.png](src/main/resources/img/patch.png)
![validarCambioPatch.png](src/main/resources/img/validarCambioPatch.png)
![delete.png](src/main/resources/img/delete.png)
![validarDelete.png](src/main/resources/img/validarDelete.png)

### Coverage
Se utilizó Jacoco 
![cobertura.png](src/main/resources/img/cobertura.png)


### Swagger
Colocar en el buscador http://localhost:8080/employees/swagger-ui/index.html#/employees-controller/getOrderById
Para poder ver el contrato
![swagger.png](src/main/resources/img/swagger.png)