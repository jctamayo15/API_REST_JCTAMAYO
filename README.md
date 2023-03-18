# Kruger-Challenge

# Tecnología utilizada
  - Java 11
  - IDE Sprint Tool Suite Versión: 4.18.0.RELEASE
  - Spring Boot Version 2.7.9
  - UI Swagger 1.6.4
  -Datos de la api
    - Nombre: service-empleado
    - Puerto: 8001
    - Url documentación OpenApi: http://localhost:8001/apiRestEmpleado/swagger-ui/index.html#/ (Se podra visualizar al ejecutar el microservicio)
    - Metodos: Get, Post, Put, Delete
    - Se utiliza el servidor tomcat embebido
  - Base de DatosPostgreSql 15.2
    - User: postgres
    - Password: admin
    - Nombre de la base de datos: db_empleados_cloud

# Patrón de Diseño	
DAO -> Uso de interfaces entre la aplicación y el almacenamiento de datos.
MVC -> Separación y Representación de los Datos, Manejo de errores, Escalabilidad, etc

# Consideraciones para la ejecución
   - Descargar el fuente de la rama master (git pull)
   - Importar el proyecto en el IDE
   - Click derecho sobre el proyecto y seleccionar Run ass -> Spring Boot App
   - Se podra encontrar los endpoints y ejemplos del request en la url http://localhost:8001/swagger-ui.html
   - Se deberan crear los empleados, ya que no contiene registros inicialmente.
   - Si detiene el microservicio, se eliminara toda la informacion en la base de datos db_empleados_cloud
