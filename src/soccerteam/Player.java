package soccerteam;

import static java.time.LocalDate.now;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class represents a soccer player, with first name, last name, date of birth, preferred
 * position, position, skill level, and jersey number.
 */
public class Player {
  private final String firstName;
  private final String lastName;
  private final LocalDate dateOfBirth;
  private Position preferPosition;
  private Position position;
  private int skillLevel;
  private int jerseyNumber;

  /**
   * Constructs a new player with the given first name, last name, date of birth, preferred
   * position, and skill level.
   *
   * @param firstName      the first name of the player.
   * @param lastName       the last name of the player.
   * @param dateOfBirth    the date of birth of the player.
   * @param preferPosition the preferred position of the player.
   * @param skillLevel     the skill level of the player.
   * @throws IllegalArgumentException if the player's age is greater than 10.
   */
  public Player(String firstName, String lastName, LocalDate dateOfBirth, Position preferPosition,
      int skillLevel) throws IllegalArgumentException {
    if (Period.between(dateOfBirth, now()).getYears() > 10) {
      throw new IllegalArgumentException("Players must be younger than 10 years old.");
    }
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("The skill level must be between 1 and 5.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.preferPosition = preferPosition;
    this.skillLevel = skillLevel;
  }

  /**
   * Returns the first name of the player.
   *
   * @return the first name of the player.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the player.
   *
   * @return the last name of the player.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the Date of Birth of the player.
   *
   * @return the Date of Birth of the player.
   */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Returns the prefered position of the player.
   *
   * @return the prefered position of the player.
   */
  public Position getPreferPosition() {
    return preferPosition;
  }

  /**
   * Returns the skill level of the player.
   *
   * @return the skill level of the player.
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Sets the jersey number of the player.
   *
   * @param randNum the random number assigned to the player's jersey.
   */
  protected void setJerseyNumber(int randNum) {
    this.jerseyNumber = randNum;
  }

  /**
   * Returns the jersey number of the player.
   *
   * @return the jersey number of the player.
   */
  protected int getJerseyNumber() {
    return this.jerseyNumber;
  }

  /**
   * Sets the position of the player.
   *
   * @param role the role of the player.
   */
  protected void setPosition(Position role) {
    this.position = role;
  }

  /**
   * Returns the position of the player.
   *
   * @return the position of the player.
   */
  protected Position getPosition() {
    return this.position;
  }

}
