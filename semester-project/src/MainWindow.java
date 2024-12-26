

import java.awt.*;
import javax.swing.*;

class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Voting System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        // Create the title label
        JLabel title = new JLabel("Welcome to the Voting System");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(new Color(25, 25, 112));

        // Create buttons
        JButton adminLogin = new JButton("Admin ");
        JButton voterLogin = new JButton("Voter ");
        JButton viewResults = new JButton("View Results");


        // Customize buttons
        adminLogin.setBackground(new Color(70, 130, 180));
        adminLogin.setForeground(Color.WHITE);
        voterLogin.setBackground(new Color(46, 139, 87));
        voterLogin.setForeground(Color.WHITE);
        viewResults.setBackground(new Color(255, 165, 0));
        viewResults.setForeground(Color.WHITE);


        // Add action listeners
        adminLogin.addActionListener(e -> new AdminLoginWindow());
        voterLogin.addActionListener(e -> new VoterLoginWindow());
        viewResults.addActionListener(e -> new ResultsWindow());

        // Arrange components using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

        // Add title to the top
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Center the title
        gbc.anchor = GridBagConstraints.CENTER;
        add(title, gbc);

        // Add buttons below the title
        gbc.gridy = 1;
        add(adminLogin, gbc);

        gbc.gridy = 2;
        add(voterLogin, gbc);

        gbc.gridy = 3;
        add(viewResults, gbc);

        // Set visibility
        setVisible(true);
    }
}
