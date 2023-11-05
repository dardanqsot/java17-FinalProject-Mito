# java17-FinalProject-Mito
# Proyecto Spring Boot Ejemplo

Este proyecto es un entregable de fin curso "JAVA 17 Backend, Mitocode".
Existen 3 controladores: Student, Course y Enrollment, cada uno con sus Endpoints, siendo dos servicios principales solicitados en el entregable de Trabajo Final.

El proyecto incluye un archivo **_import.sql_** para llenar con data inicial y consumir sin problema alguno los métodos solicitados.

El proyecto tiene un propertie  **_spring.jpa.hibernate.ddl-auto=create-dropl_** paracrear y eliminar los objetos de BD con susregistros, esto en BD postgresql, para objetivos de prueba.

## Servicio 1: Listar estudiantes ordenados de forma descendente por edad usando programación funcional
Este servicio te permite obtener lista de estudiantes ordenados de forma descendente en base a su edad

### Ruta de Consumo
GET:  localhost:8080/student/sortedByAgeDesc

Respuesta esperada:
```json
[
    {
        "idStudent": 2,
        "firstName": "Darwin",
        "lastName": "Quispe Soto",
        "dni": "87654321",
        "age": 29
    },
    {
        "idStudent": 3,
        "firstName": "Daniel",
        "lastName": "Diaz Diaz",
        "dni": "12345670",
        "age": 25
    },
    {
        "idStudent": 1,
        "firstName": "Pepito",
        "lastName": "Perez Perez",
        "dni": "12345678",
        "age": 19
    }
]
```


## Servicio 2: Mostrar la relación de cursos matriculados y sus estudiantes correspondientes
Este servicio permite visualizar alumnos por curso en formato map:

### Ruta de Consumo
GET:  localhost:8080/enrollment/courses/enrollments

Respuesta esperada:
```json
{
    "JAVA FULLSTACK": [
        "Darwin Quispe Soto",
        "Daniel Diaz Diaz"
    ],
    "SPRING WEBFLUX": [
        "Pepito Perez Perez",
        "Daniel Diaz Diaz"
    ],
    "JAVA 17": [
        "Darwin Quispe Soto"
    ],
    "MICROSERVICIOS": [
        "Darwin Quispe Soto"
    ]
}
```

## Ejecución del Proyecto

1. Clona el repositorio o descarga los archivos.

2. Abre una terminal en el directorio raíz del proyecto.

3. Ejecuta el siguiente comando para compilar y ejecutar la aplicación:

mvn spring-boot:run
