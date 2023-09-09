# FrontEnd Code Snippets

## Description

This project provides ready-to-use code snippets for building a FrontEnd application. It includes four services:

- **User Service**: Responsible for user management.
- **Auth Service**: Handles user authorization.
- **Eureka Service**: Provides a namespace for all services.
- **Api Gateway Service**: Routes requests to the appropriate service.

## Requirements

- Java 17
- Gradle

## Installation

1. Clone the repository:

```bash
git clone https://github.com/your_project.git
```
.
    Navigate to the project directory:

```bash
cd FrontCode
gradle build
```
Running the Services
```bash
Start Eureka Service:

cd Eureka-Service
gradle bootRun
```
Start User Service:

```bash
cd User-Service
gradle bootRun
```
Start Auth Service:
```bash
cd Auth-Service
gradle bootRun
```
Start Api Gateway Service:
```bash
cd Api-Gateway-Service
gradle bootRun
```