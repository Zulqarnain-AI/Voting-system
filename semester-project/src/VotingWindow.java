
import java.awt.*;
import javax.swing.*;

class VotingWindow extends JFrame {
    public VotingWindow(String voterId) {
        setTitle("Voting");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        // Handle no candidates scenario
        if (Registration.candidates.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No candidates available for voting.", "Information", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }

        // Create components
        JLabel titleLabel = new JLabel("Cast Your Vote");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(25, 25, 112));

        JLabel candidateLabel = new JLabel("Select a Candidate:");
        JComboBox<String> candidateDropdown = new JComboBox<>();
        for (Candidate candidate : Registration.candidates) {
            candidateDropdown.addItem(candidate.name);
        }

        JButton voteButton = new JButton("Vote");
        JButton backButton = new JButton("Back");

        // Style buttons
        voteButton.setBackground(new Color(46, 139, 87));
        voteButton.setForeground(Color.WHITE);
        voteButton.setFocusPainted(false);

        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        // Vote button action
        voteButton.addActionListener(e -> {
            String selectedCandidate = (String) candidateDropdown.getSelectedItem();
            for (Candidate candidate : Registration.candidates) {
                if (candidate.name.equals(selectedCandidate)) {
                    candidate.voteCount++;
                    for (Voter voter : Registration.voters) {
                        if (voter.id.equals(voterId)) {
                            voter.hasVoted = true;
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Vote cast successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    return;
                }
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

        // Add candidate label and dropdown
        gbc.gridwidth = 1; // Reset grid width
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(candidateLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(candidateDropdown, gbc);

        // Add buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(voteButton, gbc);

        gbc.gridx = 1;
        add(backButton, gbc);

        // Set visibility
        setVisible(true);
    }
}


