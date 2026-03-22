import javax.swing.*;
import java.awt.*;

public class DeleteStudent {

    JFrame frame;
    JLabel messageLabel;

    DeleteStudent() {
        frame = new JFrame("Delete Student");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Delete Student", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(220, 50, 50));
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setPreferredSize(new Dimension(0, 50));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 40));
        panel.setBackground(new Color(255, 253, 208));

        JLabel selectLabel = new JLabel("Select Student:");
        JComboBox<String> dropdown = new JComboBox<>();

        for (Student s : StudentsManager.getStudents()) {
            dropdown.addItem(s.rollNo + " - " + s.name);
        }

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(220, 50, 50));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFocusPainted(false);

        messageLabel = new JLabel("", JLabel.CENTER);

        panel.add(selectLabel);
        panel.add(dropdown);
        panel.add(deleteBtn);

        deleteBtn.addActionListener(e -> {
            int index = dropdown.getSelectedIndex();
            if (index < 0 || StudentsManager.getStudents().isEmpty()) {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("No student to delete!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to delete this student?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                StudentsManager.deleteStudent(index);
                dropdown.removeItemAt(index);
                messageLabel.setForeground(new Color(0, 150, 0));
                messageLabel.setText("Student Deleted Successfully!");
            }
        });

        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}