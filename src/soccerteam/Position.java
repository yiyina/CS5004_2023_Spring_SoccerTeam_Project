package soccerteam;

/**
 * The `Position` enum represents the different positions.
 * It has four different values: `GOALIE`, `DEFENDER`, `MIDFIELDER`, and `FORWARD`.
 */
public enum Position {
  GOALIE("Goalie"),
  DEFENDER("Defender"),
  MIDFIELDER("Midfielder"),
  FORWARD("Forward");

  private final String name;

  /**
   * Constructs a Position object with the given name.
   *
   * @param name the name of the position
   */
  private Position(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}