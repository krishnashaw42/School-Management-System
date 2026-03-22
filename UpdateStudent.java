import javax.swing.*;
import java.awt.*;

public class UpdateStudent {

    JFrame frame;
    JTextField nameField, rollField, idField, addressField;
    JLabel messageLabel;
    int selectedIndex = -1;

    UpdateStudent() {
        frame = new JFrame("Update Student");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Update Student", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(255, 140, 0));
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setPreferredSize(new Dimension(0, 50));

        // Dropdown to pick student
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(new Color(255, 253, 208));
        JLabel selectLabel = new JLabel("Select Student:");
        JComboBox<String> dropdown = new JComboBox<>();

        for (Student s : StudentsManager.getStudents()) {
            dropdown.addItem(s.rollNo + " - " + s.name);
        }

        topPanel.add(selectLabel);
        topPanel.add(dropdown);

        // Form fields
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formPanel.setBackground(new Color(255, 253, 208));

        nameField    = new JTextField();
        rollField    = new JTextField();
        idField      = new JTextField();
        addressField = new JTextField();
        JButton updateBtn = new JButton("Update Student");
        messageLabel = new JLabel("", JLabel.CENTER);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Roll No:"));
        formPanel.add(rollField);
        formPanel.add(new JLabel("Admission ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(updateBtn);
        formPanel.add(new JLabel());

        // Load selected student into fields
        dropdown.addActionListener(e -> {
            selectedIndex = dropdown.getSelectedIndex();
            if (selectedIndex >= 0) {
                Student s = StudentsManager.getStudents().get(selectedIndex);
                nameField.setText(s.name);
                rollField.setText(String.valueOf(s.rollNo));
                idField.setText(s.admissionId);
                addressField.setText(s.address);
            }
        });

        // Trigger load on open
        if (dropdown.getItemCount() > 0) {
            dropdown.setSelectedIndex(0);
        }

        updateBtn.addActionListener(e -> {
            if (selectedIndex < 0) {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("No student selected!");
                return;
            }
            try {
                String name    = nameField.getText().trim();
                int roll       = Integer.parseInt(rollField.getText().trim());
                String id      = idField.getText().trim();
                String address = addressField.getText().trim();

                if (name.isEmpty() || id.isEmpty() || address.isEmpty()) {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("All fields are required!");
                    return;
                }

                Student s = StudentsManager.getStudents().get(selectedIndex);
                s.name        = name;
                s.rollNo      = roll;
                s.admissionId = id;
                s.address     = address;

                messageLabel.setForeground(new Color(0, 150, 0));
                messageLabel.setText("Student Updated Successfully!");

            } catch (NumberFormatException ex) {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Roll No must be a number!");
            }
        });

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(title, BorderLayout.NORTH);
        northPanel.add(topPanel, BorderLayout.SOUTH);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}