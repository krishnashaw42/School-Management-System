import java.awt.*;
import javax.swing.*;

public class Login1 {

    JFrame frame;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel messageLabel;

    Login1() {

        frame = new JFrame("Login Page");
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(255, 253, 208));

        // Components
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        messageLabel = new JLabel("", JLabel.CENTER);

        // Add components
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        panel.add(loginBtn);
        panel.add(new JLabel()); // empty space

        frame.add(panel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        // Button Logic
        loginBtn.addActionListener(e -> login());

        frame.setVisible(true);
    }

    void login() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.equals("admin") && pass.equals("admin1234")) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Login Successful");

            frame.dispose(); // close login
            new Dashboard(); // open next screen
        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Invalid Credentials");
        }
    }

    public static void main(String[] args) {
        new Login1();
    }
}