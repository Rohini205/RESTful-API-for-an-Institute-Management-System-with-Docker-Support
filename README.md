# Institute Management System API

This project implements a RESTful API for managing institutes within an Institute Management System. The API allows for institute registration, modification, and retrieval of institute information. Additionally, Docker support is provided for easy deployment.


## Technology Stack

* Java
* Spring Boot
* MySQL 
* Docker
## Features

* Institute Registration: Register new institutes with details such as name, location, contact information, and additional details.

* Institute Modification: Modify existing institute information based on the institute's ID, including fields like name, location, and contact information.

* Institute Information Retrieval: Retrieve information about a specific institute based on its ID.
* Docker Support: Dockerize the application for easy deployment and scalability.

* Security Measures: Implement input validation and use HTTPS for secure communication.

* Testing: Write unit tests for critical components using JUnit and include integration tests for the API endpoints.

* Documentation: Provide clear and concise documentation for setting up, running, and deploying the project, including details on API endpoints, request/response formats, and Docker deployment.
## Getting Started

Follow these steps to set up and run the project:

1. Clone the repository:

        git clone https://github.com/your-username/institute-management-system.git

2. Navigate to the project directory:
    
       cd institute-management-system

3. Build the Docker image:

        docker build -t institute-management-system .

4. Run the Docker container:

        docker run -p 8080:8080 institute-management-system

5. Access the API at http://localhost:8080/institutes/Registration
## Docker Solution

    version: '3.8'
    services:
        app:
        image:  rohinitibile/institutesystem:1.0.0
        ports:
            - 8080:8080
    
        environment:
            SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/   localspringbootdb?autoReconncet=true&SSL=false
            SPRING_DATASOURCE_USERNAME: admin
            SPRING_DATASOURCE_PASSWORD: root@123
      
    depends_on:
     - db
    db:
        image: mysql:8.0.20
        environment:
            DATABASE_HOST: docker-mysql
            DATABASE_PORT: 3306
            MYSQL_ROOT_PASSWORD: root
            MYSQL_DATABASE: localspringdb
            MYSQL_USER: admin
            MYSQL_PASSWORD: root@123
## MySQL Database Integration:

* Use of Spring Data JPA and Hibernate to map entities to MySQL database tables.
* Repository class for performing CRUD operations on the database.

        package com.institutemanagement.intituteRepo;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import com.institutemanagement.model.Institute;

        @Repository
        public interface InsituteRepository extends JpaRepository<Institute, Long> {
	
        }
    
## database settings in the application.properties file:

    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/sms?autoreconnect=true&SSL=false
    spring.datasource.username=root
    spring.datasource.password=root@123
 
    #JPA
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.     dialect.MySQL5Dialect

## API Endpoints

* POST /institutes/Registeration: Register a new institute.
* PUT /institutes/{id}: Modify institute information.
* Patch /institutes/{id}: Modify institute information.
* GET /api/institutes/{id}: Retrieve information about an institute.
* DELETE /employees/delete/{id}: Delete employee by ID.
## Request/Response Formats

* Institute Registration Request Body:
## Institute Registration
Endpoint: POST /institutes/registeration

Request body:

        {
            "name": "Institute Name",
            "location": "Institute Location",
            "contact": "Contact Information",
            "details": "Additional Details"
        }

## Testing

* Unit tests: JUnit for critical components.
* Integration tests: Test API endpoints.
## Security

* Input validation and handling edge cases.
* HTTPS for secure communication.
## Docker Deployment

Follow the Docker commands mentioned above to build and run the Docker image for easy deployment.
## Conclusion

This project provides a robust RESTful API for managing institutes within an Institute Management System, with Docker support for seamless deployment.






## Contact

For any questions or support, please contact rohinitibile25@gmail.com.
