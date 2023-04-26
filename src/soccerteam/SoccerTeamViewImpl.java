package soccerteam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * This class create view for soccer team.
 */
public class SoccerTeamViewImpl implements SoccerTeamView {

  private JFrame mainFrame;
  private JPanel panel;
  private JPanel inputPanel;
  private JPanel playerInfoPanel;
  private JTable playerTable;
  private DefaultTableModel playerTableModel;
  private GridBagConstraints gridConstraint;
  private JLabel firstNameLabel;
  private JLabel lastNameLabel;
  private JLabel dobLabel;
  private JLabel positionLabel;
  private JLabel skillLevelLabel;
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JFormattedTextField dobField;
  private JComboBox<Position> positionComboBox;
  private JComboBox<Integer> skillLevelComboBox;
  private JButton addPlayerButton;
  private JButton createTeamButton;
  private JButton teamButton;
  private JButton lineupButton;
  private JTextArea infoTextArea;
  private JScrollPane infoScrollPane;
  private Position[] positions = Position.values();
  private Integer[] skillLevels = { 1, 2, 3, 4, 5 };

  /**
   * Constructs a SoccerTeamView object with the given title. Initializes the main frame, panels,
   * labels, text fields, combo boxes, buttons, and table
   *
   * @param title the title of the main frame
   */
  public SoccerTeamViewImpl(String title) {
    mainFrame = new JFrame(title);
    mainFrame.setSize(800, 400);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel(new GridBagLayout());
    inputPanel = new JPanel(new GridBagLayout());
    playerInfoPanel = new JPanel(new GridBagLayout());
    gridConstraint = new GridBagConstraints();
    firstNameLabel = new JLabel("First Name:");
    lastNameLabel = new JLabel("Last Name:");
    dobLabel = new JLabel("Date of Birth:");
    positionLabel = new JLabel("Preferred Position:");
    skillLevelLabel = new JLabel("Skill Level:");

    firstNameField = new JTextField(10);
    lastNameField = new JTextField(10);
    dobField = new JFormattedTextField();
    dobField.setPreferredSize(new Dimension(130, dobField.getPreferredSize().height));
    dobField.setForeground(Color.GRAY);
    dobField.setText("yyyymmdd");

    dobField.addFocusListener(new FocusAdapter() {
      @Override public void focusGained(FocusEvent e) {
        dobField.setText("");
        dobField.setForeground(Color.BLACK);
      }

      @Override public void focusLost(FocusEvent e) {
        if (dobField.getText().isEmpty()) {
          dobField.setForeground(Color.GRAY);
          dobField.setText("yyyymmdd");
        }
      }
    });

    positionComboBox = new JComboBox<>(positions);
    skillLevelComboBox = new JComboBox<>(skillLevels);

    addPlayerButton = new JButton("Add Player");

    createTeamButton = new JButton("Create Team");
    createTeamButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Set isCreateTeamClicked to true when you click createTeamButton.
        boolean isCreateTeamClicked = true;

      }
    });

    teamButton = new JButton("Show Team Member");

    lineupButton = new JButton("Show Lineup");

    String[] columnNames = { "Count", "First Name", "Last Name", "DOB", "Prefer Position",
        "Skill Level" };

    playerTableModel = new DefaultTableModel(columnNames, 0);
    playerTable = new JTable(playerTableModel);
    playerTable.setPreferredScrollableViewportSize(new Dimension(450, 200));
    playerTable.setGridColor(Color.BLACK);
    playerTable.setFillsViewportHeight(true);
    playerTable.setShowVerticalLines(false);
    infoScrollPane = new JScrollPane(playerTable);

    gridConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridConstraint.insets = new Insets(5, 5, 5, 5);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 0;
    playerInfoPanel.add(firstNameLabel, gridConstraint);

    gridConstraint.gridx = 1;
    gridConstraint.gridy = 0;
    playerInfoPanel.add(firstNameField, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 1;
    playerInfoPanel.add(lastNameLabel, gridConstraint);

    gridConstraint.gridx = 1;
    gridConstraint.gridy = 1;
    playerInfoPanel.add(lastNameField, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 2;
    playerInfoPanel.add(dobLabel, gridConstraint);

    gridConstraint.gridx = 1;
    gridConstraint.gridy = 2;
    playerInfoPanel.add(dobField, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 3;
    playerInfoPanel.add(positionLabel, gridConstraint);

    gridConstraint.gridx = 1;
    gridConstraint.gridy = 3;
    playerInfoPanel.add(positionComboBox, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 4;
    playerInfoPanel.add(skillLevelLabel, gridConstraint);

    gridConstraint.gridx = 1;
    gridConstraint.gridy = 4;
    playerInfoPanel.add(skillLevelComboBox, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 5;
    gridConstraint.gridwidth = 2;
    playerInfoPanel.add(addPlayerButton, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 7;
    inputPanel.add(createTeamButton, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 8;
    inputPanel.add(teamButton, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 9;
    inputPanel.add(lineupButton, gridConstraint);

    gridConstraint.gridx = 0;
    gridConstraint.gridy = 0;
    gridConstraint.gridheight = 6;
    playerInfoPanel.setBorder(new TitledBorder("Add Player Information"));
    inputPanel.add(playerInfoPanel);
    panel.add(inputPanel, gridConstraint);

    // add empty column to avoid the third column stretch
    gridConstraint.gridx = 1;
    gridConstraint.gridy = 0;
    gridConstraint.gridheight = 9;
    gridConstraint.weightx = 0.0;
    gridConstraint.weighty = 1.0;
    gridConstraint.fill = GridBagConstraints.VERTICAL;
    JPanel emptyPanel = new JPanel();
    panel.add(emptyPanel, gridConstraint);

    // add infoScrollPane to right column
    gridConstraint.gridx = 2;
    gridConstraint.gridy = 0;
    gridConstraint.gridheight = 8;
    gridConstraint.weightx = 1.0;
    gridConstraint.weighty = 1.0;
    gridConstraint.fill = GridBagConstraints.BOTH;
    panel.add(infoScrollPane, gridConstraint);

    mainFrame.add(panel);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);
  }

  @Override public String getFirstNameFieldText() {
    return firstNameField.getText();
  }

  @Override public String getLastNameFieldText() {
    return lastNameField.getText();
  }

  @Override public String getDobFieldText() {
    return dobField.getText();
  }

  @Override public Position getPositionComboBoxSelected() {
    return (Position) positionComboBox.getSelectedItem();
  }

  @Override public int getSkillLevelComboBoxSelected() {
    return (int) skillLevelComboBox.getSelectedItem();
  }

  @Override public LocalDate getLocalDateFromDobString(String dobString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    return LocalDate.parse(getDobFieldText(), formatter);
  }

  @Override public void addPlayerButtonActionListener(ActionListener listener) {
    addPlayerButton.addActionListener(listener);
  }

  @Override public void createTeamButtonActionListener(ActionListener listener) {
    createTeamButton.addActionListener(listener);
  }

  @Override public void showTeamButtonActionListener(ActionListener listener) {
    teamButton.addActionListener(listener);
  }

  @Override public void showLineupButtonActionListener(ActionListener listener) {
    lineupButton.addActionListener(listener);
  }

  @Override public void addPlayerToTable(int index, String firstName, String lastName, String dob,
      String position, int skillLevel) {
    Object[] rowData = { index, firstName, lastName, dob, position, skillLevel };
    playerTableModel.addRow(rowData);
  }

  @Override public Object[][] parsePlayerListToTableData(String playerList, int numColumns) {
    String[] lines = playerList.split("\n");
    Object[][] tableData = new Object[lines.length - 1][numColumns]; // 6 columns now

    for (int i = 1; i < lines.length; i++) {
      String[] columns = lines[i].split(", ");
      tableData[i - 1][0] = i; // Add count as the first column
      tableData[i - 1][1] = getValueAfterColon(columns[0]); // First Name
      tableData[i - 1][2] = getValueAfterColon(columns[1]); // Last Name
      tableData[i - 1][3] = getValueAfterColon(columns[2]); // Jersey Number
      if (numColumns > 4) {
        tableData[i - 1][4] = columns.length > 3 ? getValueAfterColon(columns[3]) : ""; // Position
      }
      if (numColumns > 5) {
        tableData[i - 1][5] =
            columns.length > 4 ? getValueAfterColon(columns[4]) : ""; // Skill Level
      }
    }
    return tableData;
  }

  /**
   * Retrieves the value after the first occurrence of a colon character in the given text.
   *
   * @param text the text to be searched
   * @return the value after the colon character, with leading and trailing whitespace removed
   */
  private String getValueAfterColon(String text) {
    return text.substring(text.indexOf(':') + 1).trim();
  }

  @Override public void showTeamMemberDialog(Object[][] tableData) {
    JDialog teamMemberDialog = new JDialog();
    teamMemberDialog.setTitle("Team Members");
    String[] columnNames = { "Count", "First Name", "Last Name", "Jersey Number" };
    DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
    JTable table = new JTable(tableModel);

    table.setGridColor(Color.BLACK);
    table.setShowVerticalLines(false);
    table.setShowHorizontalLines(true);

    JScrollPane scrollPane = new JScrollPane(table);
    teamMemberDialog.add(scrollPane);

    int rowCount = table.getRowCount();
    int height = Math.min(rowCount * table.getRowHeight() + 50, 400);
    int width = Math.min(table.getPreferredSize().width + 50, 600);
    teamMemberDialog.setSize(width, height);

    teamMemberDialog.setLocationRelativeTo(null);
    teamMemberDialog.setVisible(true);
  }

  @Override public void showLineupDialog(Object[][] tableData) {
    JDialog lineupDialog = new JDialog();
    lineupDialog.setTitle("Team Lineup");
    String[] columnNames = { "Count", "First Name", "Last Name", "Jersey Number", "Position" };
    DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
    JTable table = new JTable(tableModel);

    table.setGridColor(Color.BLACK);
    table.setShowVerticalLines(false);
    table.setShowHorizontalLines(true);

    JScrollPane scrollPane = new JScrollPane(table);
    lineupDialog.add(scrollPane);

    int rowCount = table.getRowCount();
    int height = Math.min(rowCount * table.getRowHeight() + 50, 400);
    int width = Math.min(table.getPreferredSize().width + 50, 600);
    lineupDialog.setSize(width, height);

    lineupDialog.setLocationRelativeTo(null);
    lineupDialog.setVisible(true);
  }

  @Override public void showWarningDialog(String message) {
    JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
  }

  /**
   * Resets the data fields in the GUI to their default values. The first name and last name fields
   * are cleared. The date of birth field is set to "yyyymmdd" and its text color is set to gray.
   * The position combo box is set to "Goalie". The skill level combo box is set to the first item
   * in the list.
   */
  protected void resetDataField() {
    firstNameField.setText("");
    lastNameField.setText("");
    dobField.setForeground(Color.GRAY);
    dobField.setText("yyyymmdd");
    positionComboBox.setSelectedItem(Position.GOALIE);
    skillLevelComboBox.setSelectedIndex(0);
  }
}