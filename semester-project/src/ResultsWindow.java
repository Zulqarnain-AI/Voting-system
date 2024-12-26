
import java.awt.*;
import javax.swing.*;

class ResultsWindow extends JFrame {
    public ResultsWindow() {
        setTitle("Election Results");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Title Label
        JLabel titleLabel = new JLabel("Election Results", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Prepare data for the results table
        String[] columnNames = { "Candidate Name", "Votes" };
        String[][] data = new String[Registration.candidates.size()][2];
        for (int i = 0; i < Registration.candidates.size(); i++) {
            Candidate candidate = Registration.candidates.get(i);
            data[i][0] = candidate.name;
            data[i][1] = String.valueOf(candidate.voteCount);
        }

        // Results table
        JTable resultsTable = new JTable(data, columnNames);
        resultsTable.setEnabled(false); // Disable editing
        resultsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        resultsTable.setRowHeight(25);
        resultsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        resultsTable.getTableHeader().setBackground(new Color(70, 130, 180));
        resultsTable.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(resultsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
