import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai7 extends JFrame implements ActionListener {
    private JPanel colorPanel;
    private JRadioButton redButton, greenButton, blueButton;

    public Bai7() {
        setTitle("Change color");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        redButton = new JRadioButton("Red");
        greenButton = new JRadioButton("Green");
        blueButton = new JRadioButton("Blue");

        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);

        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(greenButton);
        group.add(blueButton);

        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);

        add(buttonPanel, BorderLayout.WEST);
        add(colorPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            colorPanel.setBackground(Color.RED);
        } else if (e.getSource() == greenButton) {
            colorPanel.setBackground(Color.GREEN);
        } else if (e.getSource() == blueButton) {
            colorPanel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bai7().setVisible(true);
            }
        });
    }
}
