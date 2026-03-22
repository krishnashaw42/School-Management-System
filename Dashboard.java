import javax.swing.*;
import java.awt.*;

public class Dashboard {

    JFrame frame;

    Dashboard() {

        frame = new JFrame("Student Management System");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top
        JLabel labelTop = new JLabel("Student Management System", SwingConstants.CENTER);
        labelTop.setOpaque(true);
        labelTop.setBackground(new Color(0, 100, 0));
        labelTop.setForeground(Color.WHITE);
        labelTop.setFont(new Font("Arial", Font.BOLD, 20));
        labelTop.setPreferredSize(new Dimension(0, 60));

        // Center
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        centerPanel.setBackground(new Color(255, 253, 208));

        JButton add    = createButton("Add Student", new Color(0, 180, 0));
        JButton view   = createButton("View Students", new Color(0, 120, 220));
        JButton update = createButton("Update Student", new Color(255, 140, 0));
        JButton delete = createButton("Delete Student", new Color(220, 50, 50));

        centerPanel.add(add);
        centerPanel.add(view);
        centerPanel.add(update);
        centerPanel.add(delete);

        // Bottom
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(100, 0, 0));
        bottomPanel.setPreferredSize(new Dimension(0, 60));

        JButton logout = new JButton("Logout");
        logout.setBackground(new Color(100, 0, 0));
        logout.setForeground(Color.WHITE);
        logout.setBorderPainted(false);
        logout.setFocusPainted(false);

        bottomPanel.add(logout, BorderLayout.CENTER);
        // Actions (IMPORTANT)
        logout.addActionListener(e -> {
            frame.dispose();
            new Login_UI(); // go back to login
        });

        add.addActionListener(e -> {
            new AddStudent(); // open new page
        });

        view.addActionListener(e -> new ViewStudents());

        update.addActionListener(e -> new UpdateStudent());

        delete.addActionListener(e -> new DeleteStudent());

        // Add to frame
        frame.add(labelTop, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Button Styling Method
    JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        return btn;
    }
}