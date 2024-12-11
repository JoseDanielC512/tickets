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

