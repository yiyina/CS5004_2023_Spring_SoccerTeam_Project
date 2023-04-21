# Soccer Team Management System


## About/Overview

The Soccer Team Management System provides a simple and user-friendly way to add players to soccer team and assign them positions in lineups. By utilizing the MVC design pattern, the application ensures a clean separation of concerns, making it maintainable.

## List of Features
- Add soccer players.
- Display team members and their random assigned jersey numbers from 1 to 20.
- Display lineup members and their assigned positions.
  - 1 Goalie
  - 2 Defender
  - 3 Midfielder
  - 1 Forward

## How to Run

To run the Soccer Team Management System, follow these steps:

1. Make sure you have Java installed on your computer. 
  - You can download it from the official Java website https://www.java.com/en/.
2. Download the "U10Team.zip" in this github repository.
3. You can navigate to the directory where you downloaded and stored the ZIP file, then double click it to unzip it.
4. When you open the unzipped directory of "U10Team", double click to open it and navigate into the "res/" directory.
5. In the "res/" directory, you will find the "U10Team.jar" file inside of it.
6. Double click on the "U10Team.jar" file to run it on your computer.
7. The main window will show up and you can start to manage the team (See *"How to Use the Program"* part below).

## How to Use the Program

Upon starting the application, you will be presented with a user interface that allows you to add soccer players, display team members and their assigned positions, and display lineup of the soccer team and players' assigned positions.

1. The player added by you will be displayed in the right table area in the main window. To add a player, enter the player's following information in related fields:
  - First name: The first name of the player. 
    - Following name convention
  - Last name: The last name of the player.
    - Following name convention
  - Date of Birth: The date of birth of the player.
    - player cannot be added if age is greater than 10
    - Input formate should be *"yyyymmdd"*
  - Preferred Position: Select preferred position of the player from drop down list.
  - Skill Level: Select skill level of the player from drop down list. 
2. To display the team players and their assigned jersey numbers, click the *"Show Team Member"* button.
  - If the number of players smaller than 10, cannot create team, thus click the button will not show the team members.
  - If the number of inputs exceeds 20 players, the exceeding part will replace the 20 players with the lowest skill levels to ensure that the team size does not exceed 20. 
4. To display the lineup players and their assigned positions, click the *"Show Lineup"* button.

*WARNING: The team can only be built when it has at least 10 players, and the team size is between 10 to 20 (included). If you enter more than 20 players, the players with lowest skill level will be removed from the team until there is only 20 players.*

## Design/Model Changes

In the initial design, there is no user interface. Only has one driver class to run the program which is inconvinent and not maintainable.
At this time, the MVC design pattern was introduced. This allowed for a clear distinction between data management, user interface, and input handling.

In this Soccer Team Management System, we have implemented the MVC pattern as follows:
- Model: SoccerTeamModel interface and its implementation SoccerTeamModelImpl class represents the soccer team data and provides methods to manage players and lineups.
- View: SoccerTeamView interface and its implementation SoccerTeamViewImpl class define the user interface for adding and displaying team members and lineups.
- Controller: SoccerTeamController interface and its implementation SoccerTeamControllerImpl class handles user input from the view, interacts with the model, and updates the view accordingly.

## Assumptions

This program is built based on the assumption that:
1. Players are uniquely identified by their names. So there are no players with identical names in the system to enable alphabetical sorting by last name.
2. The user input fields "First Name" and "Last Name" are expected to conform to naming conventions. 
3. The user input field "Date of Birth" is expected to be the given date format "yyyymmdd". Additionally, the date of birth should not exceed the current date.

## Limitations

1. The current implementation does not support saving and loading data to and from external storage.
2. The user interface is text-based and may not be as intuitive as a graphical user interface.
3. The current implementation may not provide comprehensive error handling, such as handling invalid input or duplicate player names. 

## Citations
[1]"Compile and build applications with IntelliJ IDEA | IntelliJ IDEA," IntelliJ IDEA Help. https://www.jetbrains.com/help/idea/compiling-applications.html#rebuild_project (accessed Apr. 18, 2023).
