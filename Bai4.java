import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai4 extends JFrame {
    private JButton leftButton, rightButton, centerButton;
    private JPanel buttonPanel;

    public Bai4() {
        setTitle("Button Alignment");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        leftButton = new JButton("Left");
        rightButton = new JButton("Right");
        centerButton = new JButton("Center");

        leftButton.addActionListener(new ButtonListener());
        rightButton.addActionListener(new ButtonListener());
        centerButton.addActionListener(new ButtonListener());

        buttonPanel.add(leftButton);
        buttonPanel.add(centerButton);
        buttonPanel.add(rightButton);

        add(buttonPanel);

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == leftButton) {
                buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            } else if (e.getSource() == rightButton) {
                buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            } else if (e.getSource() == centerButton) {
                buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            }
            buttonPanel.revalidate();
            buttonPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bai4();
            }
        });
    }
}

