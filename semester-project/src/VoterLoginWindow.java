
import java.awt.*;
import javax.swing.*;

class VoterLoginWindow extends JFrame {
    public VoterLoginWindow() {
        setTitle("Voter Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        // Create components
        JLabel titleLabel = new JLabel("Voter Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(25, 25, 112));

        JLabel idLabel = new JLabel("Voter ID:");
        JTextField idField = new JTextField(15);

        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        // Style buttons
        loginButton.setBackground(new Color(46, 139, 87));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        // Handle login action
        loginButton.addActionListener(e -> {
            String voterId = idField.getText().trim(); // Ensure no leading/trailing spaces
            if (voterId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Voter ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean found = false;
            for (Voter voter : Registration.voters) {
                if (voter.id.equals(voterId)) {
                    found = true;
                    if (voter.hasVoted) {
                        JOptionPane.showMessageDialog(this, "You have already voted.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        new VotingWindow(voterId); // Open the voting window
                    }
                    dispose();
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Invalid Voter ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Back button action
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

        // Add ID label and field
        gbc.gridwidth = 1; // Reset grid width
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(idField, gbc);

        // Add buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        gbc.gridx = 1;
        add(backButton, gbc);

        // Set visibility
        setVisible(true);
    }
}

