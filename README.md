# WebProj - Servlet Demo

This repository contains a web application project built using Java Servlets. The project demonstrates basic functionality for user registration and login, as well as the use of ServletConfig and ServletContext for handling configuration parameters.

## Project Overview

### 1. **ServletConfigDemo**

- **Description**: This servlet demonstrates how to retrieve configuration parameters from the `web.xml` file using `ServletConfig`.
- **Key Concepts**:
    - `ServletConfig` for retrieving servlet-specific configuration parameters.
    - Initialization of configuration parameters like `username` and `password` from `web.xml`.

### 2. **ServletContextDemo**

- **Description**: This servlet demonstrates how to retrieve application-wide context parameters using `ServletContext`.
- **Key Concepts**:
    - `ServletContext` for retrieving context-wide configuration parameters.
    - Application-wide initialization parameters like eg:`goldrate` are retrieved.

### 3. **Registration and Login Features**

- **Description**: This part of the project implements a basic user registration and login system.
- **Features**:
    - **Registration**: Users can register by providing their first name, middle name, last name, username, phone, email, and password.
    - **Login**: Users can log in by entering their username and password.
    - **Database**: A PostgreSQL database is used to store user credentials.

---

## Key Features

- **ServletConfig**: Allows you to access initialization parameters specific to the servlet.
- **ServletContext**: Provides access to parameters that are shared across all servlets in the application.
- **PostgreSQL Database**: User credentials (username, email, password) are stored securely in a PostgreSQL database.
- **Registration and Login**: Basic authentication system for user registration and login.

---

## How to Run the Project

### 1. **Set up the Environment**

- Ensure you have **Apache Tomcat** installed and configured in your environment.
- Set up a **PostgreSQL** database with the necessary tables and columns to store user credentials.
- Ensure Java and Maven are properly installed and configured.

### 2. **Configure `web.xml`**

- In your `WEB-INF/web.xml`, ensure you have the correct servlet mappings and context parameters.

### 3. **Database Setup**

- Create the `OWNER` table in your PostgreSQL database:
    
    sql
    
    Copy code
    
    `CREATE TABLE OWNER (     fname VARCHAR(100),     mname VARCHAR(100),     lname VARCHAR(100),     username VARCHAR(100) PRIMARY KEY,     phone VARCHAR(15),     email VARCHAR(100),     password VARCHAR(100) );`
    

### 4. **Run the Application**

- Deploy the project to Apache Tomcat.
- Access the project via your browser at `http://localhost:8080/WebProj`.

---

## Directory Structure

WebProj/
│
├── src/main/java
│   ├── RegisterServlet.java
│   ├── LoginServlet.java
│   ├── ServletConfigDemo.java
│   └── ServletContextDemo.java
│
├── src/main/webapp
│   ├── META-INF
│   ├── WEB-INF
	│   ├── web.xml
	│   └── lib/
	│       └── postgresql-<version>.jar
│
└── login.jsp
└── register.jsp


## Future Enhancements

- **Password Encryption**: Implement password hashing for better security.
- **Error Handling**: Add custom error pages and improve exception handling.
- **User Sessions**: Implement session management for logged-in users.