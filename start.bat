@echo off

echo Limpiando y empaquetando el proyecto con Maven...
mvnw clean package -DskipTests

echo Deteniendo y eliminando los contenedores existentes de Docker...
docker stop spring_app postgres_db
docker rm spring_app postgres_db

echo Construyendo las imágenes de Docker...
docker-compose build

echo Iniciando los contenedores nuevamente...
docker-compose up -d

echo Proceso completado.
pause
