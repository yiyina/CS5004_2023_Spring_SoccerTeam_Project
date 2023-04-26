package soccerteam;

/**
 * The Main class runs the soccer team program.
 */
public class Main {
  /**
   * The main method creates instances of the model, view, and controller, and opens the GUI.
   *
   * @param args the command-line arguments passed to the program (not used)
   */
  public static void main(String[] args) {
    SoccerTeamModelImpl m = new SoccerTeamModelImpl();
    SoccerTeamViewImpl v = new SoccerTeamViewImpl("U10Team");
    SoccerTeamController c = new SoccerTeamControllerImpl(v, m);
    c.openGui();
  }
}
