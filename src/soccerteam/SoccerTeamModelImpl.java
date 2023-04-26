package soccerteam;

import static java.time.LocalDate.now;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Implementation of the SoccerTeamModel interface. This class manages the players in a soccer team,
 * including adding and removing players, generating a lineup, and printing the player and lineup
 * information.
 */
public class SoccerTeamModelImpl implements SoccerTeamModel {
  private Map<String, Player> teamPlayers;
  private List<Integer> jerseyNumbers;
  private List<Player> lineup;
  private int teamSize;

  /**
   * Constructs a new SoccerTeam object, initializing the team's data structures and setting the
   * initial team size to zero. The TreeMap for team players is configured to use a case-insensitive
   * comparator for ordering the keys (player last names). Add 1 to 20 to the JerseyNumbers list.
   */
  public SoccerTeamModelImpl() {
    // compares String objects(Key) in a case-insensitive manner
    teamPlayers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    jerseyNumbers = new ArrayList<>();
    lineup = new ArrayList<>();
    teamSize = 0;
    for (int i = 1; i <= 20; i++) {
      jerseyNumbers.add(i);
    }
  }

  /**
   * Assigns a jersey number to a player.
   *
   * @param member the player to receive a jersey number
   */
  private void assignJerseyNumber(Player member) {
    int randomIndex = new Random().nextInt(jerseyNumbers.size());
    int randomJerseyNumber = jerseyNumbers.get(randomIndex);
    jerseyNumbers.remove(randomIndex);
    member.setJerseyNumber(randomJerseyNumber);
  }

  /**
   * Removes a player from the team based on the lowest skill level. If two players has same skill
   * level, remove the first with lastname in alphabetical order If new player has lower skill level
   * than the player with lowest skill level in the list do not replace the original player with
   * lowest skill level
   */
  private boolean removeLowestSkillPlayer(Player member) {
    // get the lowest skill level player and remove him from the teamPlayers
    // (sort by skill level and alphabetical order and remove the last one).
    Player lowestSkillPlayer = teamPlayers.values().stream()
        .min(Comparator.comparing(Player::getSkillLevel).thenComparing(Player::getLastName))
        .orElse(null);
    if (lowestSkillPlayer != null) {
      if (lowestSkillPlayer.getSkillLevel() <= member.getSkillLevel()) {
        jerseyNumbers.add(lowestSkillPlayer.getJerseyNumber());
        teamPlayers.remove(lowestSkillPlayer.getLastName());
        teamSize--;
        return true;
      }
    }
    return false;
  }

  @Override public void addPlayer(Player member) {
    if (teamSize >= 20) {
      if (removeLowestSkillPlayer(member)) {
        assignJerseyNumber(member);
        teamPlayers.put(member.getLastName(), member);
        teamSize++;
        return;
      }
    }
    assignJerseyNumber(member);
    teamPlayers.put(member.getLastName(), member);
    teamSize++;
  }

  @Override public void createLineUp() throws IllegalStateException {
    if (teamPlayers.size() < 10) {
      throw new IllegalStateException("Do not have enough players to create a Lineup.");
    }
    // sort players in descending order of SkillLevel, and their preferred positions.
    List<Player> sortPlayer = new ArrayList<>(teamPlayers.values());
    sortPlayer.sort(Comparator.comparing(Player::getSkillLevel).reversed()
        .thenComparing(Player::getPreferPosition));

    // set maximum number for each position
    EnumMap<Position, Integer> maxEachPosition = new EnumMap<>(Position.class);
    maxEachPosition.put(Position.GOALIE, 1);
    maxEachPosition.put(Position.DEFENDER, 2);
    maxEachPosition.put(Position.MIDFIELDER, 3);
    maxEachPosition.put(Position.FORWARD, 1);

    int i = 0;
    while (lineup.size() < 7 && i < sortPlayer.size()) {
      Player member = sortPlayer.get(i);
      Position preferPosition = member.getPreferPosition();
      // check if still has slot left in preferred position
      if (maxEachPosition.get(preferPosition) > 0) {
        member.setPosition(preferPosition);
        lineup.add(member);
        // number of slot in that position minus 1
        maxEachPosition.put(preferPosition, maxEachPosition.get(preferPosition) - 1);
      } else {
        // cannot find available preferred position
        // put all available position in an array
        List<Position> emptyPosition = new ArrayList<>();
        for (Position positions : maxEachPosition.keySet()) {
          if (maxEachPosition.get(positions) > 0) {
            emptyPosition.add(positions);
          }
        }
        if (!emptyPosition.isEmpty()) {
          // randomly assign position to player
          int randomIndex = new Random().nextInt(emptyPosition.size());
          Position randomPosition = emptyPosition.get(randomIndex);
          member.setPosition(randomPosition);
          maxEachPosition.put(randomPosition, maxEachPosition.get(randomPosition) - 1);
          lineup.add(member);
        }
      }
      i++;
    }
  }

  @Override public int getTeamSize() throws IllegalStateException {
    if (teamSize < 10) {
      throw new IllegalStateException("Do not have enough players to form a team.");
    }
    return teamSize;
  }

  @Override public String printPlayerList() throws IllegalStateException {
    StringBuilder sb = new StringBuilder();
    if (teamSize < 10) {
      throw new IllegalStateException("Does not have enough players to form a team.");
    }
    sb.append("This is the player List for the team: \n");
    for (Player member : teamPlayers.values()) {
      sb.append(
          String.format("First Name: %s, Last Name: %s, Jersey number: %d\n", member.getFirstName(),
              member.getLastName(), member.getJerseyNumber()));
    }
    return sb.toString();
  }

  @Override public String printPlayerListForTest() throws IllegalStateException {
    StringBuilder sb = new StringBuilder();
    if (teamSize < 10) {
      throw new IllegalStateException("Does not have enough players to form a team.");
    }
    sb.append("This is the player List for the team: \n");
    for (Player member : teamPlayers.values()) {
      sb.append(
          String.format("First Name: %s, Last Name: %s, Preferred Position: %s, Skill Level: %d\n", member.getFirstName(),
              member.getLastName(), member.getPreferPosition(), member.getSkillLevel()));
    }
    return sb.toString();
  }

  @Override public String printLineupList() throws IllegalStateException {
    StringBuilder sb = new StringBuilder();
    sb.append("This is the line up of the team: \n");
    if (lineup.size() < 7) {
      throw new IllegalStateException("You didn't create a line up.");
    }
    lineup.sort(Comparator.comparing(Player::getPosition).thenComparing(Player::getLastName));
    for (Player member : lineup) {
      sb.append(String.format("First Name:%s, Last Name:%s, Jersey Number: %d, Position: %s\n",
          member.getFirstName(), member.getLastName(), member.getJerseyNumber(),
          member.getPosition()));
    }
    return sb.toString();
  }

  @Override public String printLineupForTest() throws IllegalStateException {
    StringBuilder sb = new StringBuilder();
    sb.append("This is the line up of the team: \n");
    if (lineup.size() < 7) {
      throw new IllegalStateException("You didn't create a line up.");
    }
    lineup.sort(Comparator.comparing(Player::getPosition).thenComparing(Player::getLastName));
    for (Player member : lineup) {
      sb.append(String.format("First Name:%s, Last Name:%s, Position: %s\n",
          member.getFirstName(), member.getLastName(), member.getPosition()));
    }
    return sb.toString();
  }
}
