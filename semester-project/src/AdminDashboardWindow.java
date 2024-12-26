

import java.awt.*;
import javax.swing.*;

class AdminDashboardWindow extends JFrame {
    public AdminDashboardWindow() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        // Create components
        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(25, 25, 112));

        JButton addVoterButton = new JButton("Add Voter");
        JButton addCandidateButton = new JButton("Add Candidate");
        JButton backButton = new JButton("Back");

        // Style buttons
        addVoterButton.setBackground(new Color(70, 130, 180));
        addVoterButton.setForeground(Color.WHITE);
        addVoterButton.setFocusPainted(false);

        addCandidateButton.setBackground(new Color(46, 139, 87));
        addCandidateButton.setForeground(Color.WHITE);
        addCandidateButton.setFocusPainted(false);

        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        // Add action listeners
        addVoterButton.addActionListener(e -> new AddVoterWindow());
        addCandidateButton.addActionListener(e -> new AddCandidateWindow());
        backButton.addActionListener(e -> dispose());

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add title label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across 2 columns
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        // Add buttons
        gbc.gridwidth = 1; // Reset to default
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(addVoterButton, gbc);

        gbc.gridy = 2;
        add(addCandidateButton, gbc);

        gbc.gridy = 3;
        add(backButton, gbc);

        // Set visibility
        setVisible(true);
    }
}



