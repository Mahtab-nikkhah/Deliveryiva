# Deliveryiva

An object-oriented food ordering and delivery management desktop application built with **Java 19**, **JavaFX (FXML & CSS)**, and **Maven**, structured using the **MVC (Model–View–Controller)** architecture.

Developed as the course project for **Object-Oriented Programming (Spring 2023)** at Sharif University of Technology.

## Key Features
- **Role-Based Access Control:** Polymorphic user hierarchy (`ParentUser`) supporting **Admin** (restaurant owners), **User** (customers), and **Delivery** (couriers).
- **JavaFX Graphical User Interface:** Interactive FXML screens (`HelloApplication.fxml`, `RegisterMenu.fxml`, `LoginMenu.fxml`), custom CSS styling, hover states, and native alert dialogs for real-time validation.
- **Authentication & Recovery:** Role-based registration, login, regex-enforced password strength validation, and security-question password recovery.
- **Restaurant & Order Management:** Menu item CRUD operations, active-order deletion protection, time-bounded food discounts, order history tracking, and customer rating/comment response workflows.
- **Graph Primitives:** Object-oriented city map representation (`Graph`, `Node`, `Edge`) designed for location and routing integration.

## Tech Stack
- **Language:** Java 19 (Java Modules)
- **GUI Framework:** JavaFX 19 (`javafx-controls`, `javafx-fxml`), CSS
- **Build Tool:** Apache Maven
- **Architecture:** MVC (Model–View–Controller)

## Project Structure
```text
src/main/
├── java/
│   ├── module-info.java
│   └── com/example/phase2/
│       ├── HelloApplication.java    # JavaFX entry point
│       ├── Main.java                # Console entry point
│       ├── controller/              # MVC controllers & JavaFX event handlers
│       ├── model/                   # OOP domain models, DataBase & Graph classes
│       └── view/                    # Menu views & scene loaders
└── resources/com/example/phase2/
    ├── HelloApplication.fxml / .css
    ├── RegisterMenu.fxml / .css
    ├── LoginMenu.fxml
    └── icon.png
```

## Running the Application
Ensure **JDK 19+** and **Maven** are installed, then run:
```bash
mvn clean javafx:run
```
Or using the included Maven Wrapper:
```bash
./mvnw clean javafx:run
```
