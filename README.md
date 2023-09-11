# FrontEnd Code Snippets

## Description

The FrontCode platform is a dedicated space for FrontEnd enthusiasts to exhibit their coding prowess. It offers a user-friendly interface for members to upload and showcase their unique FrontEnd projects. This project emphasizes seamless interaction and engagement within the community, allowing users to appreciate and subscribe to their favorite creators. It's a collaborative hub for like-minded individuals to connect, form teams, and elevate their creations together. The platform also serves as a personal portfolio, giving users the opportunity to display their skills and projects for others to explore and appreciate. The FrontCode platform is dedicated to fostering creativity and growth within the FrontEnd development community:

- **User Service**: Responsible for user management.
- **Auth Service**: Handles user authorization.
- **Eureka Service**: Provides a namespace for all services.
- **Api Gateway Service**: Routes requests to the appropriate service.
- **Code Service**: Responsible for code management.
- **Notification Service**: Responsible for notifications.


## Requirements

- Java 17
- Gradle
- Kafka

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

Start Code Service
```bash
cd Code-Service
gradle bootRun
```

Start Notification Service
```bash
cd Notification-Service
gradle bootRun
```

Start Kafka
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
