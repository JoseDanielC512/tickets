# Aplicación de Tickets para DVP

Este proyecto es una aplicación que permite gestionar las operaciones básicas de un CRUD para tickets

## Requisitos previos

- [Docker](https://www.docker.com/) instalado en tu máquina.
- [Docker Compose](https://docs.docker.com/compose/) instalado.
- [Maven](https://maven.apache.org/) instalado.

## Configuración de ejecución en local

Ejecuta los siguientes comandos en la raíz del proyecto en orden descendente para configurar y ejecutar la aplicación en tu entorno local:

### 1. Crear una red de Docker
```bash
docker network create mynetwork
```

### 2. Crear y ejecutar un contenedor para la base de datos PostgreSQL
```bash
docker run --name postgres_db \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  -e POSTGRES_DB=ticketsdb \
  -p 5432:5432 \
  -v db_data:/var/lib/postgresql/data \
  --network mynetwork \
  -d postgres:15
```

### 3. Compilar la aplicación
Compilar el proyecto y generar el archivo `.jar`:
```bash
mvn clean package -DskipTests
```

### 4. Detener y eliminar contenedores existentes
```bash
docker stop spring_app postgres_db
docker rm spring_app postgres_db
```

### 5. Construir los contenedores con Docker Compose
```bash
docker-compose build
```

### 6. Iniciar la aplicación
```bash
docker-compose up -d
```

### 7. Acceder a la aplicación
Abre tu navegador y accede a la URL:
```
http://localhost:8080
```

## Notas adicionales

- La base de datos PostgreSQL utiliza `admin` como usuario y contraseña.
- La base de datos `ticketsdb` se crea automáticamente al iniciar el contenedor PostgreSQL.
- Puedes detener la aplicación en cualquier momento con:
  ```bash
  docker-compose down
  ```
## Interacción con la API de Tickets
A continuación, se describen las operaciones básicas que puedes realizar con la API de tickets:
1. Agregar un ticket (POST)
   URL: http://localhost:8080/api/tickets
   Método: POST
    ```bash
   {
   "usuario": "Ticket nuevo"
   }
    ```

2. Solicitar un ticket por ID (GET)
   URL: http://localhost:8080/tickets/{id}
   Método: GET
    ```bash
   http://localhost:8080/api/tickets/1
   ```

3. Editar un ticket por ID (PUT)
   URL: http://localhost:8080/tickets/{id}
   Método: PUT
    ```bash
   http://localhost:8080/api/tickets/1
   ```
   ```bash
   {
   "usuario": "Ticket de prueba editado",
   "status": "CLOSED"
   }
   ```
   
4. Listar todos los tickets (GET)
   Método: GET
   Descripción: Obtiene una lista de tickets con paginación. Puedes ajustar los parámetros de la página (page), tamaño de página (size) y orden de los resultados (sort).
    ```bash
   http://localhost:8080/api/tickets?page=0&size=10&sort=fechaCreacion,desc
   ```

## Interacción con la API de GitHub
Se puede probar el siguiente endpoint para obtener información de un usuario de GitHub.

1. Obtener información de un usuario de GitHub (GET)
    ```bash
   http://localhost:8080/api/github/user/{username}
   ```
   Descripción: Este endpoint permite obtener información de un usuario de GitHub mediante su nombre de usuario. Asegúrate de reemplazar {username} por el nombre de usuario de GitHub deseado.
   Ejemplo: 
    ```bash
    http://localhost:8080/api/github/users?q=JoseDanielC512
   ```