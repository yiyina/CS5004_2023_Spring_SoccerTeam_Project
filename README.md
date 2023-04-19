# Soccer Team Management System

This repository contains a Java-based Soccer Team Management System that utilizes the Model-View-Conrtoller(MVC) design pattern. The purpose of this application is to help users manage soccer team members and their lineups.

# MVC Design Pattern

The Model-View-Controller(MVC) design pattern is a useful architechtural pattern for designing applications with a clear seperation of concerns. It is particularly beneficial when you want to separate the data management logic from the user interface and input handling.
The pattern is composed of three main components:
Model: Represents the data and business logic of the application.
View: Represents the user interface and visualization of the data.
Controller: Handles user input and communicates between the Model and View.

Using the MVC pattern is a good idea when you need to create applications that are maintainable.

## Example

In this Soccer Team Management System, we have implemented the MVC pattern as follows:

Model: SoccerTeamModel interface and its implementation SoccerTeamModelImpl class represents the soccer team data and provides methods to manage players and lineups.
View: SoccerTeamView interface and its implementation SoccerTeamViewImpl class define the user interface for adding and displaying team members and lineups.
Controller: SoccerTeamController interface and its implementation SoccerTeamControllerImpl class handles user input from the view, interacts with the model, and updates the view accordingly.

## Code Structure and Running the Application

This repository contains well-structured code with clear separation between classes and packages. Each class has a specific responsibility and follows the Single Responsibility Principle.

To run the application, simply execute the SoccerTeamApp class, which contains the main method. This class initializes the Model, View, and Controller, and sets up the necessary connections between them.

## UML Diagram

A UML class diagram for the code is provided in the repository. This diagram illustrates the relationships between the classes and their respective methods and attributes, making it easier to understand the overall structure of the application.

## Code Style and Documentation

The code in this repository follows the style principles learned in class, with consistent indentation, clear naming conventions, and proper use of access modifiers. Javadoc-style comments are available for all classes, methods, and attributes, providing clear explanations of their purpose and functionality. This ensures that the code is maintainable and easy to understand for other developers who may work on the project.

## Citations
[1]"Compile and build applications with IntelliJ IDEA | IntelliJ IDEA," IntelliJ IDEA Help. https://www.jetbrains.com/help/idea/compiling-applications.html#rebuild_project (accessed Apr. 18, 2023).
