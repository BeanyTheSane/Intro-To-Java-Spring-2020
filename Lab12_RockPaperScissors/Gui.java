import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Gui extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JLabel lblAppTitle = new JLabel("Rock, Paper, Scissors, SHOOT!");
    public JLabel lblUser = new JLabel("User");
    public JLabel lblComputer = new JLabel("Computer");
    public JLabel lblUserScoreTitle = new JLabel("User Score");
    public JLabel lblCompScoreTitle = new JLabel("Computer Score");
    public JLabel lblUserScore = new JLabel("0");
    public JLabel lblCompScore = new JLabel("0");
    public JLabel lblUserChoice = new JLabel("");
    public JLabel lblCompChoice = new JLabel("");
    public JLabel lblResults = new JLabel("");
    public JLabel lblError = new JLabel("");
    public JButton btnShoot = new JButton("Shoot!");
    public JButton btnTests= new JButton("Run Tests");
    public JRadioButton rdbRock = new JRadioButton("Rock");
    public JRadioButton rdbPaper = new JRadioButton("Paper");
    public JRadioButton rdbScissors = new JRadioButton("Scissors");
    public JRadioButton rdbRandom = new JRadioButton("Random", true);
    public JTextArea testResults = new JTextArea("Test Results:\n", 12, 20);
    public JScrollPane scrollableTestResults = new JScrollPane(testResults, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    Gui() {
        //set up the frame
        this.setTitle("Lab 12 - Adam Knitter");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setSize(700,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        try {
            BufferedImage rightRock = ImageIO.read(new File("images/rightRock.png"));
            BufferedImage rightPaper = ImageIO.read(new File("images/rightPaper.png"));
            BufferedImage rightScissors = ImageIO.read(new File("images/rightScissors.png"));
            BufferedImage leftRock = ImageIO.read(new File("images/leftRock.png"));
            BufferedImage leftPaper = ImageIO.read(new File("images/leftPaper.png"));
            BufferedImage leftScissors = ImageIO.read(new File("images/leftScissors.png"));
            BufferedImage emptyChoice = ImageIO.read(new File("images/emptyChoice.png"));
            BufferedImage resultsBanner = ImageIO.read(new File("images/resultsBanner.png"));
            BufferedImage winnerBanner = ImageIO.read(new File("images/winnerBanner.png"));
            BufferedImage loserBanner = ImageIO.read(new File("images/loserBanner.png"));
            BufferedImage drawBanner = ImageIO.read(new File("images/drawBanner.png"));
            lblUserChoice.setIcon(new ImageIcon(emptyChoice));
            lblCompChoice.setIcon(new ImageIcon(emptyChoice));
            lblResults.setIcon(new ImageIcon(resultsBanner));
        } catch (IOException e) {
            lblError.setText(e.getLocalizedMessage());
        } 

        //set up header panel
        JPanel HeaderPanel = new JPanel();
        HeaderPanel.add(lblAppTitle);
        HeaderPanel.setFont(new Font("Verdana", Font.BOLD, 18));

        //set up User choice selection panel
        JPanel userChoiceSelectionPanel = new JPanel();
        ButtonGroup userChoices = new ButtonGroup();
        userChoices.add(rdbRock);
        userChoices.add(rdbPaper);
        userChoices.add(rdbScissors);
        userChoices.add(rdbRandom);
        userChoiceSelectionPanel.setLayout(new BoxLayout(userChoiceSelectionPanel,BoxLayout.Y_AXIS));
        userChoiceSelectionPanel.add(rdbRock);
        userChoiceSelectionPanel.add(rdbPaper);
        userChoiceSelectionPanel.add(rdbScissors);
        userChoiceSelectionPanel.add(rdbRandom);
        userChoiceSelectionPanel.add(btnShoot);

        //set up User Choice Display Panel
        JPanel userChoiceDisplayPanel = new JPanel(new GridBagLayout());
        GridBagConstraints userTitleConstraints = new GridBagConstraints();
        GridBagConstraints userImgBoxConstraints = new GridBagConstraints();
        userTitleConstraints.gridx = 0;
        userTitleConstraints.gridy = 0;
        userImgBoxConstraints.gridx = 0;
        userImgBoxConstraints.gridy = 1;
        userChoiceDisplayPanel.add(lblUser, userTitleConstraints);
        userChoiceDisplayPanel.add(lblUserChoice, userImgBoxConstraints);

        //set up Computer Choice Display Panel
        JPanel compChoiceDisplayPanel = new JPanel(new GridBagLayout());
        GridBagConstraints compTitleConstraints = new GridBagConstraints();
        GridBagConstraints compImgBoxConstraints = new GridBagConstraints();
        compTitleConstraints.gridx = 0;
        compTitleConstraints.gridy = 0;
        compImgBoxConstraints.gridx = 0;
        compImgBoxConstraints.gridy = 1;
        compChoiceDisplayPanel.add(lblComputer, compTitleConstraints);
        compChoiceDisplayPanel.add(lblCompChoice, compImgBoxConstraints);

        //set up User Score panel
        JPanel userScorePanel = new JPanel(new GridBagLayout());
        JPanel userScoreTitlePanel = new JPanel();
        JPanel userScoreValuePanel = new JPanel();
        GridBagConstraints userScoreTitleConstraints = new GridBagConstraints();
        GridBagConstraints userScoreValueConstraints = new GridBagConstraints();
        userScoreTitleConstraints.gridx = 0;
        userScoreTitleConstraints.gridy = 0;
        userScoreValueConstraints.gridx = 0;
        userScoreValueConstraints.gridy = 1;
        userScoreTitlePanel.add(lblUserScoreTitle);
        userScoreValuePanel.add(lblUserScore);
        userScorePanel.add(userScoreTitlePanel, userScoreTitleConstraints);
        userScorePanel.add(userScoreValuePanel, userScoreValueConstraints);

        //set up Computer Score panel
        JPanel compScorePanel = new JPanel(new GridBagLayout());
        JPanel compScoreTitlePanel = new JPanel();
        JPanel compScoreValuePanel = new JPanel();
        GridBagConstraints compScoreTitleConstraints = new GridBagConstraints();
        GridBagConstraints compScoreValueConstraints = new GridBagConstraints();
        compScoreTitleConstraints.gridx = 0;
        compScoreTitleConstraints.gridy = 0;
        compScoreValueConstraints.gridx = 0;
        compScoreValueConstraints.gridy = 1;
        compScoreTitlePanel.add(lblCompScoreTitle);
        compScoreValuePanel.add(lblCompScore);
        compScorePanel.add(compScoreTitlePanel, compScoreTitleConstraints);
        compScorePanel.add(compScoreValuePanel, compScoreValueConstraints);

        //set up Results panel
        JPanel resultsPanel = new JPanel();
        resultsPanel.add(lblResults);

        //build body panel
        JPanel bodyPanel = new JPanel(); 
        bodyPanel.setLayout(new BoxLayout(bodyPanel,BoxLayout.X_AXIS));
        bodyPanel.add(userChoiceSelectionPanel, BorderLayout.WEST);
        bodyPanel.add(userChoiceDisplayPanel, BorderLayout.CENTER);
        bodyPanel.add(compChoiceDisplayPanel, BorderLayout.EAST);

        //build Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel,BoxLayout.X_AXIS));
        footerPanel.add(userScorePanel);
        footerPanel.add(resultsPanel);
        footerPanel.add(compScorePanel);
        footerPanel.add(btnTests);

        //add panels to the frame
        this.add(HeaderPanel, BorderLayout.NORTH);
        this.add(bodyPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

}