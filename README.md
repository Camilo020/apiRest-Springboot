# API de Autenticación

Esta es una API REST construida con Java y Spring Boot que se autentica contra la API externa de DummyJSON y registra los inicios de sesión exitosos en una base de datos PostgreSQL.

## Instrucciones de Ejecución 

1.  **Prerrequisitos**:
    * Java 21 o superior. 
    * Maven.
    * PostgreSQL instalado y corriendo.

2.  **Configuración**:
    * Clona este repositorio: `git clone <URL_DE_TU_REPO>`
    * Crea una base de datos en PostgreSQL llamada `auth_db`.
    * Actualiza las credenciales de la base de datos en el archivo `src/main/resources/application.properties`.

3.  **Ejecución**:
    * Navega a la raíz del proyecto y ejecuta: `mvn spring-boot:run`
    * La aplicación se iniciará en `http://localhost:8080`.

## Usuario de Prueba 

Puedes usar cualquier usuario de la lista de `https://dummyjson.com/users`. Por ejemplo:
* **Usuario**: `emilys`
* **Contraseña**: `emilyspass`

## Ejemplo de Login con cURL

```bash
curl --request POST \
  --url http://localhost:8080/api/auth/login \
  --header 'Content-Type: application/json' \
  --data '{
    "username": "emilys",
    "password": "emilyspass"
  }'
