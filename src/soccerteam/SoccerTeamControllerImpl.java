package soccerteam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * The controller class for the soccer team application. This class is responsible for handling user
 * interactions and updating the model and view accordingly.
 */
public class SoccerTeamControllerImpl implements SoccerTeamController {
  // Instance variables
  private final SoccerTeamViewImpl view;
  private final SoccerTeamModelImpl model;

  private boolean teamCreated = false;
  private int playerCount = 0;

  /**
   * Creates a new instance of the controller with the given view and model.
   *
   * @param v the view component of the MVC pattern
   * @param m the model component of the MVC pattern
   */
  public SoccerTeamControllerImpl(SoccerTeamViewImpl v, SoccerTeamModelImpl m) {
    this.view = v;
    this.model = m;
  }

  /**
   * Determines if a given date is within the past 10 years.
   *
   * @param date the date to be checked
   * @return true if the date is within the past 10 years, false otherwise.
   */
  private static boolean isDateValid(LocalDate date) {
    return Period.between(date, LocalDate.now()).getYears() <= 10;
  }

  /**
   * Adds a new player to the model and updates the view.
   */
  private void addPlayer() {
    String firstName = view.getFirstNameFieldText();
    String lastName = view.getLastNameFieldText();
    String dobString = view.getDobFieldText();
    // check if date of birth is empty
    if ("yyyymmdd".equals(dobString)) {
      view.showWarningDialog("The date of birth can not be empty!");
      return;
    }
    // check if age smaller than 10
    LocalDate dob = view.getLocalDateFromDobString(dobString);
    if (!isDateValid(dob)) {
      view.showWarningDialog("Player must be under 10 years old.");
      view.resetDataField();
      return;
    }

    Position position = view.getPositionComboBoxSelected();
    int skillLevel = view.getSkillLevelComboBoxSelected();
    Player player = new Player(firstName, lastName, dob, position, skillLevel);
    model.addPlayer(player);
    view.resetDataField();
    String formattedDob = dob.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    playerCount++;
    view.addPlayerToTable(playerCount, firstName, lastName, formattedDob, position.toString(),
        skillLevel);
  }

  private void createTeam() {
    if (playerCount >= 10) {
      teamCreated = true;
      view.showWarningDialog("U10 Team Created!");
    } else {
      view.showWarningDialog("Can not create team: a team should have at least 10 players.");
    }
  }

  /**
   * Displays the list of team members in the view.
   */
  private void showTeamMember() {
    if (!teamCreated) {
      view.showWarningDialog("You have not created a team yet.");
      return;
    } else if (playerCount < 10) {
      view.showWarningDialog("Can not create team: a team should have at least 10 players.");
      return;
    }
    try {
      String output = model.printPlayerList();
      Object[][] tableData = view.parsePlayerListToTableData(output, 4);
      view.showTeamMemberDialog(tableData);
    } catch (IllegalStateException e) {
      view.showWarningDialog(e.getMessage());
    }
  }

  /**
   * Displays the lineup of players in the view.
   */
  private void showLineup() {
    try {
      model.createLineUp();
      String output = model.printLineupList();
      Object[][] tableData = view.parsePlayerListToTableData(output, 5);
      view.showLineupDialog(tableData);
    } catch (IllegalStateException e) {
      view.showWarningDialog(e.getMessage());
    }
  }

  @Override public void openGui() {
    this.view.addPlayerButtonActionListener(e -> addPlayer());
    this.view.createTeamButtonActionListener(e -> createTeam());
    this.view.showTeamButtonActionListener(e -> showTeamMember());
    this.view.showLineupButtonActionListener(e -> showLineup());
  }
}
