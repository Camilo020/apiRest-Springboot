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

¿Cómo se guarda el registro de login? 

Cuando un usuario realiza una petición POST a /api/auth/login con credenciales válidas:

El AuthController recibe la petición.

Llama al AuthService.

El AuthService utiliza un DummyJsonClient (Feign) para enviar las credenciales a https://dummyjson.com/auth/login.

Si la respuesta de DummyJSON es exitosa y devuelve tokens, el AuthService crea una nueva entidad LoginLog.

Esta entidad se puebla con el nombre de usuario, la fecha y hora actuales, y los tokens recibidos.

Finalmente, se utiliza 

LoginLogRepository para guardar esta entidad como una nueva fila en la tabla login_log de la base de datos PostgreSQL. 
