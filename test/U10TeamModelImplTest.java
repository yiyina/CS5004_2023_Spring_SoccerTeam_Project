import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;
import soccerteam.SoccerTeamModel;
import soccerteam.SoccerTeamModelImpl;

/**
 * This is java unit test class for testing U10TeamModel class.
 */
public class U10TeamModelImplTest {

  private SoccerTeamModel team;
  private Player player1;
  private Player player2;
  private Player player3;
  private Player player4;
  private Player player5;
  private Player player6;
  private Player player7;
  private Player player8;
  private Player player9;
  private Player player10;
  private Player player11;
  private Player player12;
  private Player player13;
  private Player player14;
  private Player player15;
  private Player player16;
  private Player player17;
  private Player player18;
  private Player player19;
  private Player player20;

  /**
   * Initializes the team and player objects to be used in the test cases.
   */
  @Before
  public void setUp() {
    team = new SoccerTeamModelImpl();
    player1 = new Player("Kokomi", "Sangonomiya", LocalDate.of(2017, 2, 22), Position.MIDFIELDER,
        5);
    player2 = new Player("Kazuha", "Kaedehara", LocalDate.of(2018, 10, 29), Position.DEFENDER, 5);
    player3 = new Player("Shogun", "Raiden", LocalDate.of(2015, 6, 26), Position.FORWARD, 5);
    player4 = new Player("Li", "Zhong", LocalDate.of(2014, 12, 31), Position.GOALIE, 5);
    player5 = new Player("Fei", "Yan", LocalDate.of(2018, 7, 28), Position.FORWARD, 4);
    player6 = new Player("Lan", "Ye", LocalDate.of(2016, 4, 20), Position.MIDFIELDER, 5);
    player7 = new Player("Tao", "Hu", LocalDate.of(2018, 7, 16), Position.FORWARD, 5);
    player8 = new Player("Diona", "Di", LocalDate.of(2020, 1, 18), Position.GOALIE, 4);
    player9 = new Player("Sara", "Kujou", LocalDate.of(2015, 7, 14), Position.MIDFIELDER, 4);
    player10 = new Player("Bennet", "Be", LocalDate.of(2020, 2, 29), Position.DEFENDER, 5);
    player11 = new Player("Jean", "Je", LocalDate.of(2016, 3, 14), Position.DEFENDER, 4);
    player12 = new Player("Yun", "Chong", LocalDate.of(2019, 9, 7), Position.GOALIE, 2);
    player13 = new Player("Fischl", "Fi", LocalDate.of(2017, 5, 27), Position.FORWARD, 3);
    player14 = new Player("Layla", "La", LocalDate.of(2016, 12, 19), Position.DEFENDER, 3);
    player15 = new Player("Shinobu", "Kuki", LocalDate.of(2016, 7, 27), Position.GOALIE, 3);
    player16 = new Player("Amber", "Am", LocalDate.of(2017, 8, 10), Position.FORWARD, 1);
    player17 = new Player("Noelle", "No", LocalDate.of(2017, 3, 21), Position.GOALIE, 3);
    player18 = new Player("Faruzan", "Fa", LocalDate.of(2018, 8, 20), Position.MIDFIELDER, 4);
    player19 = new Player("Heizou", "Shikanoin", LocalDate.of(2016, 7, 24), Position.FORWARD, 3);
    player20 = new Player("Mika", "Mi", LocalDate.of(2019, 8, 11), Position.MIDFIELDER, 2);
  }

  /**
   * Tests the addPlayer method.
   */
  @Test
  public void testAddPlayer() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);

    assertEquals(20, team.getTeamSize());
  }

  /**
   * Tests the addPlayer method with a player younger than 10 years old.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddTooYoungPlayer() {
    Player tooYoungPlayer = new Player("Young", "Player", LocalDate.now().minusYears(11),
        Position.MIDFIELDER, 5);
    team.addPlayer(tooYoungPlayer);
  }

  /**
   * Tests the addPlayer method when the team already has 20 players.
   */
  @Test
  public void testAddPlayerWhenAlreadyHasTwentyPlayers() {
    team.addPlayer(new Player("Player0", "A", LocalDate.of(2015, 1, 1), Position.GOALIE, 2));
    for (int i = 1; i < 20; i++) {
      team.addPlayer(
          new Player("Player" + i, "P" + i, LocalDate.of(2015, 1, 1), Position.MIDFIELDER, 5));
    }

    // Add a player with a lower skill level (4)
    Player lowerSkillPlayer = new Player("NewPlayer", "Np", LocalDate.of(2015, 1, 1),
        Position.MIDFIELDER, 4);
    team.addPlayer(lowerSkillPlayer);

    // Check if the team size is still 20 after trying to add a lower skill level player
    assertEquals(20, team.getTeamSize());
  }

  /**
   * Tests the createLineUp method when the team has less than 10 players.
   */
  @Test(expected = IllegalStateException.class)
  public void testCreateLineUpWhenLessThanTenPlayers() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.createLineUp();
  }

  /**
   * Tests the createLineUp method.
   */
  @Test public void testCreateLineUp() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.createLineUp();
    System.out.println(team.printLineupList());
    String expect =
        "This is the line up of the team: \n" + "First Name:Li, Last Name:Zhong, Position: Goalie\n"
            + "First Name:Bennet, Last Name:Be, Position: Defender\n"
            + "First Name:Kazuha, Last Name:Kaedehara, Position: Defender\n"
            + "First Name:Shogun, Last Name:Raiden, Position: Midfielder\n"
            + "First Name:Kokomi, Last Name:Sangonomiya, Position: Midfielder\n"
            + "First Name:Lan, Last Name:Ye, Position: Midfielder\n"
            + "First Name:Tao, Last Name:Hu, Position: Forward\n";
    assertEquals(expect, team.printLineupForTest());
  }

  /**
   * Tests the getTeamSize method when the team has fewer than 10 players.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetTeamSizeWhenDoNotHaveTenPlayers() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.getTeamSize();
  }

  /**
   * Tests the getTeamSize method.
   */
  @Test public void testTeamSize() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    assertEquals(10, team.getTeamSize());
  }

  /**
   * Tests the printPlayerList method when the team has less than 10 players.
   */
  @Test(expected = IllegalStateException.class)
  public void testPrintLessThanTenPlayers() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.printPlayerList();
  }

  /**
   * Tests the printPlayerList method. The printing list should be in alphabetical order
   */
  @Test
  public void testPrintTeamAlphabetical() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    String expectedOutput = "This is the player List for the team: \n"
        + "First Name: Bennet, Last Name: Be, Preferred Position: Defender, Skill Level: 5\n"
        + "First Name: Diona, Last Name: Di, Preferred Position: Goalie, Skill Level: 4\n"
        + "First Name: Tao, Last Name: Hu, Preferred Position: Forward, Skill Level: 5\n"
        + "First Name: Kazuha, Last Name: Kaedehara, Preferred Position: Defender, Skill Level: 5\n"
        + "First Name: Sara, Last Name: Kujou, Preferred Position: Midfielder, Skill Level: 4\n"
        + "First Name: Shogun, Last Name: Raiden, Preferred Position: Forward, Skill Level: 5\n"
        + "First Name: Kokomi, Last Name: Sangonomiya, Preferred Position: Midfielder, "
        + "Skill Level: 5\n"
        + "First Name: Fei, Last Name: Yan, Preferred Position: Forward, Skill Level: 4\n"
        + "First Name: Lan, Last Name: Ye, Preferred Position: Midfielder, Skill Level: 5\n"
        + "First Name: Li, Last Name: Zhong, Preferred Position: Goalie, Skill Level: 5\n";
    assertEquals(expectedOutput, team.printPlayerListForTest());

  }

  /**
   * Tests the printLineUpList method when the line-up has not been created.
   */
  @Test(expected = IllegalStateException.class)
  public void testPrintLineUpListWhenDidNotCreateLineUp() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.printLineupList();
  }

  /**
   * Tests the printLineUpList method. The list should sorted by position (and alphabetically for
   * the same position)
   */
  @Test public void testPrintLineupListSorted() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.createLineUp();
    String expectedOutput =
        "This is the line up of the team: \n" + "First Name:Li, Last Name:Zhong, Position: Goalie\n"
            + "First Name:Bennet, Last Name:Be, Position: Defender\n"
            + "First Name:Kazuha, Last Name:Kaedehara, Position: Defender\n"
            + "First Name:Shogun, Last Name:Raiden, Position: Midfielder\n"
            + "First Name:Kokomi, Last Name:Sangonomiya, Position: Midfielder\n"
            + "First Name:Lan, Last Name:Ye, Position: Midfielder\n"
            + "First Name:Tao, Last Name:Hu, Position: Forward\n";
    assertEquals(expectedOutput, team.printLineupForTest());
  }
}