# SOLID Principles Examples

This folder contains practical examples demonstrating each of the 5 SOLID principles in Java.

## Folder Structure

- **01-SRP**: Single Responsibility Principle
- **02-OCP**: Open/Closed Principle  
- **03-LSP**: Liskov Substitution Principle
- **04-ISP**: Interface Segregation Principle
- **05-DIP**: Dependency Inversion Principle

## SOLID Principles Overview

### 1. Single Responsibility Principle (SRP)
**"A class should have only one reason to change"**
- Each class should have only one responsibility
- Separates concerns into different classes
- Makes code more maintainable and testable

### 2. Open/Closed Principle (OCP)
**"Software entities should be open for extension but closed for modification"**
- Classes should be open for extension (inheritance)
- Classes should be closed for modification
- Use abstractions and polymorphism

### 3. Liskov Substitution Principle (LSP)
**"Objects of a superclass should be replaceable with objects of its subclasses"**
- Subclasses should be substitutable for their base classes
- Maintains behavioral compatibility
- Prevents unexpected behavior when substituting objects

### 4. Interface Segregation Principle (ISP)
**"Clients should not be forced to depend on interfaces they don't use"**
- Create focused, specific interfaces
- Avoid fat interfaces with many methods
- Prefer composition over inheritance

### 5. Dependency Inversion Principle (DIP)
**"High-level modules should not depend on low-level modules. Both should depend on abstractions"**
- Depend on abstractions, not concretions
- Use dependency injection
- Invert the dependency direction

## How to Run Examples

Each folder contains a Java file with a complete example. To run:

```bash
# Navigate to specific principle folder
cd 01-SRP

# Compile and run
javac SRPExample.java
java SRPExample
```

## Benefits of Following SOLID Principles

- **Maintainability**: Easier to modify and extend code
- **Testability**: Better unit testing capabilities
- **Flexibility**: More adaptable to changing requirements
- **Reusability**: Components can be reused in different contexts
- **Readability**: Cleaner, more understandable code structure
