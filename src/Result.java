import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {

    private JTextArea textArea;
    private JScrollPane jScrollPane1;

    public Result(String planText) {
        setTitle("Your Diet Plan");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create text area with the plan
        textArea = new JTextArea(planText);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));

        // Put it inside scroll pane
        jScrollPane1 = new JScrollPane(textArea);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Title label at top
        JLabel titleLabel = new JLabel("  Your Personalized Diet Plan", JLabel.LEFT);
        titleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        titleLabel.setBackground(new Color(255, 153, 255));
        titleLabel.setOpaque(true);
        titleLabel.setPreferredSize(new Dimension(700, 45));

        // Add to frame
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(jScrollPane1, BorderLayout.CENTER);

        setVisible(true);
    }
}