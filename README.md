# Soccer Team Management System


## About/Overview

The Soccer Team Management System provides a simple and user-friendly way to add players to soccer team and assign them positions in lineups. By utilizing the MVC design pattern, the application ensures a clean separation of concerns, making it maintainable.

## List of Features
- Add soccer players
- Display team members' name and their random assigned jersey numbers from 1 to 20
- Display lineup members' name and their assigned positions
  - 1 Goalie
  - 2 Defender
  - 3 Midfielder
  - 1 Forward

## How to Run

To run the Soccer Team Management System, follow these steps:

1. Make sure you have Java installed on your computer. 
  - You can download it from the official Java website https://www.java.com/en/.
2. Open a terminal or command prompt.
3. Navigate to the directory containing the JAR file.
  - Alternatively, you can navigate to the directory where you downloaded and stored the JAR file.
4. Run the following command in terminal: java -jar U10Team.jar
  - If you navigate to the directory where you downloaded and stored the U10Team.jar file, double click it.
No additional arguments are required to run the application.

## How to Use the Program

Upon starting the application, you will be presented with a user interface that allows you to add soccer players, display team members and their assigned positions, and display lineup of the soccer team and players' assigned positions.

1. The player added by you will be displayed in the right table in the main window. To add a player, enter the player's following information in related fields:
  - First name: The first name of the player.
  - Last name: The last name of the player.
  - Date of Birth: The date of birth of the player.
  - Preferred Position: Select preferred position of the player from drop down list.
  - Skill Level: Select skill level of the player from drop down list. 
2. To display the team players and their assigned jersey numbers, click the "Show Team Member" button.
3. To display the lineup players and their assigned positions, click the "Show Lineup" button.

*WARNING: The team can only be built when has at least 10 players, and the team size is between 10 to 20. If you enter more than 20 players, the players with lowest skill level will be removed from the team until there is only 20 players.*

## Design/Model Changes

In the initial design, both player and lineup management features were handled through the Soccer team model. To improve the separation of concerns and make the application more visually appealing and maintainable, the MVC design pattern was introduced. This allowed for a clear distinction between data management, user interface, and input handling.

In this Soccer Team Management System, we have implemented the MVC pattern as follows:
- Model: SoccerTeamModel interface and its implementation SoccerTeamModelImpl class represents the soccer team data and provides methods to manage players and lineups.
- View: SoccerTeamView interface and its implementation SoccerTeamViewImpl class define the user interface for adding and displaying team members and lineups.
- Controller: SoccerTeamController interface and its implementation SoccerTeamControllerImpl class handles user input from the view, interacts with the model, and updates the view accordingly.

## Assumptions

This program is built based on the assumption that:
1. Players are uniquely identified by their names. So there are no players with identical names in the system to enable alphabetical sorting by last name.
2. The user input is expected to conform to naming conventions, the given date format. Additionally, the date of birth should not exceed the current date.

## Limitations

1. The current implementation does not support saving and loading data to and from external storage.
2. The user interface is text-based and may not be as intuitive as a graphical user interface.
3. The current implementation may not provide comprehensive error handling, such as handling invalid input or duplicate player names. 

## Citations
[1]"Compile and build applications with IntelliJ IDEA | IntelliJ IDEA," IntelliJ IDEA Help. https://www.jetbrains.com/help/idea/compiling-applications.html#rebuild_project (accessed Apr. 18, 2023).
