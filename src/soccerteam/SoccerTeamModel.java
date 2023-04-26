package soccerteam;

/**
 * The interface for SoccerTeamModelImpl class.
 */
public interface SoccerTeamModel {
  /**
   * Adds a player to the team.
   *
   * @param member the player to be added to the team
   */
  void addPlayer(Player member) throws IllegalArgumentException;

  /**
   * Creates a lineup of players for a match.
   *
   * @throws IllegalStateException if number of players less than 10
   */
  void createLineUp() throws IllegalStateException;

  /**
   * Returns the current size of the team.
   *
   * @return the number of players in the team
   * @throws IllegalStateException if number of players less than 10
   */
  int getTeamSize() throws IllegalStateException;

  /**
   * Returns the list of players in the team.
   *
   * @return the string of all players
   * @throws IllegalStateException if number of players less than 10
   */
  String printPlayerList() throws IllegalStateException;

  /**
   * Returns the list of players in the team.
   *
   * @return the string of all players without Jersey number
   * @throws IllegalStateException if number of players less than 10
   */
  String printPlayerListForTest() throws IllegalStateException;

  /**
   * Returns the lineup of players for a match.
   *
   * @return the string of the staring lineup
   * @throws IllegalStateException if the size of LineUp is less than 7
   */
  String printLineupList() throws IllegalStateException;

  /**
   * Returns the lineup of players for unit test exclude jersey number.
   *
   * @return the string of the staring lineup without Jersey Number
   * @throws IllegalStateException if the size of LineUp is less than 7
   */
  String printLineupForTest() throws IllegalStateException;
}
