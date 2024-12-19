# Clientes Backend

Este proyecto es una API REST para la gestión de clientes, desarrollada en **Java** con **Spring Boot**.

## Requisitos

- **Java**: Versión 17 o superior.
- **Gradle**: Incluido con el proyecto (se ejecuta con `./gradlew`).
- **H2 Database**: Configuración embebida en el proyecto.

## Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/sebmenca10/clientes-backend.git
   cd clientes-backend

1. Configura tu entorno:

   - Asegúrate de que JAVA_HOME esté configurado correctamente.
   - No es necesario configurar una base de datos.

1. (Opcional) Si necesitas ajustar la base de datos, edita el archivo:

    - src/main/resources/application.properties.

## Ejecución

1. Ejecuta el proyecto con el siguiente comando:
   ```bash
   ./gradlew bootRun