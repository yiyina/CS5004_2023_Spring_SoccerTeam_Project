package soccerteam;

import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * The SoccerTeamView interface defines the methods for displaying the soccer team GUI.
 */
public interface SoccerTeamView {
  /**
   * Get the text content of the first name field.
   *
   * @return the text content of the first name field
   */
  String getFirstNameFieldText();

  /**
   * Get the text content of the last name field.
   *
   * @return the text content of the last name field
   */
  String getLastNameFieldText();

  /**
   * Get the text content of the date of birth field.
   *
   * @return the text content of the date of birth field
   */
  String getDobFieldText();

  /**
   * Get the selected position from the position combo box.
   *
   * @return the selected position from the position combo box
   */
  Position getPositionComboBoxSelected();

  /**
   * Get the selected skill level from the skill level combo box.
   *
   * @return the selected skill level from the skill level combo box
   */
  int getSkillLevelComboBoxSelected();

  /**
   * Parses a date of birth string and returns a LocalDate object.
   *
   * @param dobString the date of birth string to be parsed
   * @return LocalDate object obtained by parsing the dobString
   */
  LocalDate getLocalDateFromDobString(String dobString);

  /**
   * Adds an ActionListener to the "Add Player" button.
   *
   * @param listener the ActionListener to be added
   */
  void addPlayerButtonActionListener(ActionListener listener);

  /**
   * Adds an ActionListener to the "Create Team" button.
   *
   * @param listener the ActionListener to be added
   */
  void createTeamButtonActionListener(ActionListener listener);

  /**
   * Adds an ActionListener to the "Show Team" button.
   *
   * @param listener the ActionListener to be added
   */
  void showTeamButtonActionListener(ActionListener listener);

  /**
   * Adds an ActionListener to the "Show Lineup" button.
   *
   * @param listener the ActionListener to be added
   */
  void showLineupButtonActionListener(ActionListener listener);

  /**
   * Adds a new player to the table with the given data.
   *
   * @param index the index of the new player in the table
   * @param firstName the first name of the new player
   * @param lastName the last name of the new player
   * @param dob the date of birth of the new player
   * @param position position the position of the new player
   * @param skillLevel skillLevel the skill level of the new player
   */
  void addPlayerToTable(int index, String firstName, String lastName, String dob,
      String position, int skillLevel);

  /**
   * Parses a player list string and returns a two-dimensional array of table data.
   *
   * @param playerList the player list string to be parsed
   * @param numColumns the number of columns in the table
   * @return a two-dimensional array of table data obtained by parsing the playerList
   */
  Object[][] parsePlayerListToTableData(String playerList, int numColumns);

  /**
   * Shows a dialog containing team member data in a table.
   *
   * @param tableData tableData the data to be displayed in the table
   */
  void showTeamMemberDialog(Object[][] tableData);

  /**
   * Shows a dialog containing the lineup data in a table.
   *
   * @param tableData the data to be displayed in the table
   */
  void showLineupDialog(Object[][] tableData);

  /**
   * Shows a warning dialog with the given message.
   *
   * @param message the message to be displayed in the warning dialog
   */
  void showWarningDialog(String message);
}
