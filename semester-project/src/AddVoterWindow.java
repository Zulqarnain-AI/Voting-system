
import java.awt.*;
import javax.swing.*;

class AddVoterWindow extends JFrame {
    public AddVoterWindow() {
        setTitle("Add Voter");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        // Create components
        JLabel titleLabel = new JLabel("Add Voter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(25, 25, 112));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(15);

        JLabel areaLabel = new JLabel("Area:");
        JTextField areaField = new JTextField(15);

        JButton addButton = new JButton("Add");
        JButton backButton = new JButton("Back");

        // Style buttons
        addButton.setBackground(new Color(46, 139, 87));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);

        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        // Add action listeners
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            String area = areaField.getText();
            if (!Registration.addVoter(id, name, area)) {
                JOptionPane.showMessageDialog(this, "Voter ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Voter added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

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

        // Add name label and field
        gbc.gridwidth = 1; // Reset to default
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameField, gbc);

        // Add ID label and field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(idField, gbc);

        // Add area label and field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(areaLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(areaField, gbc);

        // Add buttons
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(addButton, gbc);

        gbc.gridx = 1;
        add(backButton, gbc);

        // Set visibility
        setVisible(true);
    }
}




