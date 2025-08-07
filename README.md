<div align="center">

# 📚 Booktify

</div>

<p align="center">
  <img src="https://img.shields.io/badge/STATUS-FINALIZADO-brightgreen" alt="Estado del proyecto">
  <img src="https://img.shields.io/badge/LICENSE-MIT-blue" alt="Licencia">
  <img src="https://img.shields.io/github/languages/top/rudygomez404/currency-converter" alt="Lenguaje Principal">
</p>

---
## Descripción del Proyecto
**Booktify** es una aplicación de consola desarrollada con Spring Boot y PostgreSQL que permite gestionar libros de manera eficiente. El objetivo principal del proyecto es demostrar el uso de un backend RESTful con persistencia en base de datos y arquitectura limpia.

---

## 🚀 Características

- Gestión de libros.
- Conexión a base de datos PostgreSQL.
- Configuración flexible mediante application.properties.
- API REST fácil de consumir.

---

## 🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---
## Demostración

```plaintext
📚 BIENVENIDO A BOOKTIFY 📚
1. Buscar libro por título
2. Listar todos los libros
3. Buscar libros por idioma
4. Listar autores
5. Autores vivos en un año
0. Salir
Elige una opción: 3
Idioma (ej: en): en

--------------LIBRO-----------
Titulo: Emma
Autor: Austen, Jane
Idioma: en
Numero de descargas: 96753
-----------------------------------
```
---
## 🔧 Configuración

### 1. Clona el repositorio

```bash
https://github.com/rudy-gomez/Booktify.git
```

### 2. Configura tu base de datos

Crea una base de datos en PostgreSQL con el nombre que prefieras (por defecto: `booktify_db`).

### 3. Configura el archivo `application.properties`

Dirígete a `src/main/resources/application.properties` y reemplaza con tus datos locales:

```properties
# Plantilla de configuración PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/booktify_db
spring.datasource.username=TU_USUARIO_AQUÍ
spring.datasource.password=TU_CONTRASEÑA_AQUÍ
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


---

## 📂 Estructura general del proyecto

```
booktify/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/booktify/
│   │   │       ├── runner/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── BooktifyApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
├── pom.xml
└── README.md
```

## 📄 Licencia

Este proyecto es de código abierto bajo la licencia MIT.

---

## 📬 Contacto

**Autor:** Rudy Gomez Bellido  
**LinkedIn:** [linkedin.com/in/rudy-gomezbellido](https://www.linkedin.com/in/rudy-gomezbellido)
