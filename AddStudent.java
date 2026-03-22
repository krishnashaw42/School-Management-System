import javax.swing.*;
import java.awt.*;

public class AddStudent {

    JFrame frame;
    JTextField nameField, rollField, idField, addressField;
    JLabel messageLabel;

    AddStudent() {

        frame = new JFrame("Add Student");
        frame.setSize(400, 350);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Fields
        nameField = new JTextField();
        rollField = new JTextField();
        idField = new JTextField();
        addressField = new JTextField();

        JButton addBtn = new JButton("Add Student");
        messageLabel = new JLabel("", JLabel.CENTER);

        // Add components
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Roll No:"));
        panel.add(rollField);

        panel.add(new JLabel("Admission ID:"));
        panel.add(idField);

        panel.add(new JLabel("Address:"));
        panel.add(addressField);

        panel.add(addBtn);
        panel.add(new JLabel()); // empty

        frame.add(panel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        // Button logic
        addBtn.addActionListener(e -> addStudent());

        frame.setVisible(true);
    }
    


    void addStudent() {
        try {
            String name = nameField.getText().trim();
            int roll = Integer.parseInt(rollField.getText().trim());
            String id = idField.getText().trim();
            String address = addressField.getText().trim();

            if (name.isEmpty() || id.isEmpty() || address.isEmpty()) {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("All fields are required!");
                return;
            }

            // Create student and store
            Student s = new Student(name, roll, id, address);
            StudentsManager.addStudent(s);

            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Student Added Successfully!");

            // Clear fields
            nameField.setText("");
            rollField.setText("");
            idField.setText("");
            addressField.setText("");

        } catch (NumberFormatException e) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Roll No must be a number!");
        }
    }
}
