# Gestión Ágil de Proyectos con Scrum, Trello y GitHub

## 📜 Descripción del Proyecto
Proyecto académico para la asignatura de Metodologías Agiles, DevOps y Desarrollo Full-Stack con Intelligencia Artificial. Se trata de una aplicación de consola desarrollada en Java que permite a un usuario gestionar su colección personal de videojuegos.

La aplicación utiliza JDBC para conectarse a una base de datos MySQL (o similar), permitiendo la persistencia de los datos.


## ✨ Características (Funcionalidades)

El menú principal de la aplicación ofrece las siguientes opciones:

* **1. Añadir un nuevo juego:** Solicita al usuario los datos (título, género, plataforma, año, valoración) y los inserta en la base de datos.
* **2. Eliminar un juego:** Permite borrar un juego de la base de datos.
* **3. Buscar juegos:** Permite filtrar la colección por título, plataforma o género.
* **4. Mostrar todos los juegos:** Obtiene y muestra la lista completa de videojuegos de la base de datos.
* **5. Mostrar los juegos mejor valorados:** Ejecuta una consulta SQL para mostrar un número determinado de juegos ordenados por su valoración.
* **6. Salir:** Finaliza la aplicación.

## 💻 Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 11 o superior)
* **Base de Datos:** MySQL (aunque adaptable a cualquier BBDD SQL como PostgreSQL o MariaDB)
* **Conectividad:** JDBC (Java Database Connectivity)
* **Driver BBDD:** [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

## 🚀 Instalación y Ejecución

Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local.

### 1. Prerrequisitos

* Tener instalado [Java JDK](https://www.oracle.com/java/technologies/downloads/) (versión 11 o superior).
* Tener un servidor de [MySQL](https://dev.mysql.com/downloads/mysql/) instalado y en ejecución.
* Descargar el **conector JDBC de MySQL** (archivo `.jar`).

### 2. Configuración de la Base de Datos

Antes de ejecutar la aplicación, necesitas crear la base de datos y la tabla correspondiente.

1.  Abre tu cliente de MySQL (Workbench, DBeaver, o la terminal).
2.  Ejecuta el siguiente Script SQL:

   ```
-- Script para crear la base de datos y la tabla para la actividad de gestión de videojuegos.
-- Se recomienda eliminar la base de datos si ya existe para empezar desde cero.
DROP DATABASE IF EXISTS videojuegos_db;
-- Crear la base de datos con el conjunto de caracteres adecuado
CREATE DATABASE videojuegos_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- Usar la base de datos recién creada
USE videojuegos_db;
-- Crear la tabla 'videojuegos'
CREATE TABLE videojuegos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    genero VARCHAR(100),
    plataforma VARCHAR(100),
    anio INT,
    valoracion INT CHECK (valoracion >= 1 AND valoracion <= 10)
);
-- Ejemplo de inserción de datos (opcional, para que los alumnos prueben)
INSERT INTO videojuegos (titulo, genero, plataforma, anio, valoracion) VALUES
('The Witcher 3: Wild Hunt', 'RPG', 'PC', 2015, 10),
('Red Dead Redemption 2', 'Aventura', 'PS4', 2018, 10),
('Celeste', 'Plataformas', 'Nintendo Switch', 2018, 9);
-- Mensaje para el usuario al ejecutar el script desde un cliente SQL
SELECT 'Base de datos videojuegos_db y tabla videojuegos creadas correctamente.' AS 'Estado';
  ```

### 3. Configuración del Proyecto

1.  Clona o descarga este repositorio.
2.  **Importante:** Edita el archivo `ConexionDB.java` con tus credenciales de la base de datos:
    ```java
    // Dentro de ConexionDB.java (ejemplo)
    private static final String URL = "jdbc:mysql://localhost:3306/gestor_videojuegos";
    private static final String USER = "tu_usuario_mysql"; // ej: root
    private static final String PASSWORD = "tu_contraseña_mysql"; // ej: 1234
    ```
3.  Asegúrate de que el archivo `.jar` del conector de MySQL esté en el *classpath* de tu proyecto (si usas un IDE como IntelliJ o Eclipse, añádelo como librería).

## 📂 Estructura del Proyecto

El código fuente se divide en las siguientes clases:

* `App.java`: Clase principal. Contiene el `main` y el menú de la consola. Captura la entrada del usuario y llama al gestor.
* `GestorVideojuegos.java`: Se encarga de preparar y ejecutar las consultas SQL contra la base de datos.
* `Videojuego.java`: Representa la estructura de un videojuego con sus getters y constructores.
* `ConexionDB.java`: Clase de utilidad que gestiona el establecimiento de la conexión JDBC.

## 🗂️ Gestión del Proyecto (Trello)

Para cumplir con la planificación y seguimiento de este proyecto se usan metodologías ágiles, utilizando un tablero de Trello para la definición y seguimiento de las tareas.

➡️ **Enlace al Tablero de Trello:** https://trello.com/b/25Q0hEQ0/gestion-agil-de-proyectos-con-scrum-trello-y-github

## ✒️ Autores

* Pablo Martin López
* Maria Trinidad Landero Contreras
* Alberto Carmona Oller
* Antonio Rodríguez Oliveira


## 📝 Notas Adicionales

Para este proyecto, se tomó la decisión de gestionar la dependencia del driver MySQL Connector/J (el archivo .jar), de forma manual. Se descargó y se enlazó al classpath del proyecto, tal como se describe en la sección de "Instalación y Ejecución".

Esta experiencia sirvió para poner en valor la comodidad y eficiencia de Maven, que automatiza por completo este proceso, simplificando enormemente la configuración.
