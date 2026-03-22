import javax.swing.*;
import java.awt.*;

public class ViewStudents {

    JFrame frame;

    ViewStudents() {
        frame = new JFrame("View Students");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        String[] columns = {"Name", "Roll No", "Admission ID", "Address"};
        String[][] data = new String[StudentsManager.getStudents().size()][4];

        for (int i = 0; i < StudentsManager.getStudents().size(); i++) {
            Student s = StudentsManager.getStudents().get(i);
            data[i][0] = s.name;
            data[i][1] = String.valueOf(s.rollNo);
            data[i][2] = s.admissionId;
            data[i][3] = s.address;
        }

        JTable table = new JTable(data, columns);
        table.setRowHeight(25);
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);

        JLabel title = new JLabel("All Students", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(0, 100, 0));
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setPreferredSize(new Dimension(0, 50));

        frame.add(title, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}