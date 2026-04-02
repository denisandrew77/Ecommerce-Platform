# E-Commerce Backend Platform (In Development)

This repository contains the backend of an e-commerce platform currently **under development** using **Java Spring Boot** and a **microservices architecture**. 

In this architecture, each core feature is implemented as a **separate backend service**:
- **Product Service** – manages product catalog and inventory
- **User Service** – handles user accounts and authentication
- **Order Service** – processes orders
- **Payment Service** – processes transactions

An **API Gateway** serves as the single entry point, routing requests to the appropriate service. Each service is independent, can be developed and deployed separately, and communicates with others over RESTful APIs. The backend and databases are **containerized using Docker** for easy deployment and scalability.

This project is ongoing and demonstrates **modular backend design, RESTful API development, database management, and containerization**.
