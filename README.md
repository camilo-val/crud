# Proyecto Spring Boot con Gradle

Este proyecto está desarrollado con Spring Boot, utilizando Java 17 y Gradle como sistema de construcción.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes elementos:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Gradle](https://gradle.org/install/)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

## Configuración de la Base de Datos

1. **Instalar MySQL**: Si no tienes MySQL instalado, sigue las instrucciones en la [página de descarga de MySQL](https://dev.mysql.com/downloads/mysql/).
2. Crear una base de datos con el nombre db_springbot

#Ejecución del proyecto
1. Ejecutar desde la ruta base ./gradlew clean build //Con este comando se genera el archivo jar en la carpeta ./build/libs
2. ./gradlew bootRun

##Otra opción de ejecución es ejecutar en la ruta donde se aloja el .jar del artefacto el siguiente comando:
 java -jar .\crud-0.0.1-SNAPSHOT.jar
