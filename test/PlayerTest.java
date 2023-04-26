import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;

/**
 * This is java unit test class for testing Player class.
 */
public class PlayerTest {

  Player player = new Player("TestF", "TestL", LocalDate.of(2015, 1, 1), Position.GOALIE, 5);

  /**
   * Test create a valid player.
   */
  @Test
  public void testValidPlayer() {
    Player player = new Player("A", "B", LocalDate.of(2017, 1, 1),
        Position.MIDFIELDER, 5);
    assertEquals("A", player.getFirstName());
    assertEquals("B", player.getLastName());
    assertEquals(LocalDate.of(2017, 1, 1), player.getDateOfBirth());
    assertEquals(Position.MIDFIELDER, player.getPreferPosition());
    assertEquals(5, player.getSkillLevel());
  }

  /**
   * Test create an invalid player whose age is less than 10.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer() {
    new Player("A", "B", LocalDate.of(2010, 1, 1),
        Position.MIDFIELDER, 5);
  }

  /**
   * Test getFirstName() method.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("TestF", player.getFirstName());
  }

  /**
   * Test getLastName() method.
   */
  @Test
  void testGetLastName() {
    assertEquals("TestL", player.getLastName());
  }

  /**
   * Test getDateOfBirth() method.
   */
  @Test
  void testGetDateOfBirth() {
    assertEquals(LocalDate.of(2017, 1, 1), player.getDateOfBirth());
  }

  /**
   * Test getPreferPosition() method.
   */
  @Test
  void testGetPreferPosition() {
    assertEquals(Position.GOALIE, player.getPreferPosition());
  }

  /**
   * Test getSkillLevel() method.
   */
  @Test
  void testGetSkillLevel() {
    assertEquals(5, player.getSkillLevel());
  }

}