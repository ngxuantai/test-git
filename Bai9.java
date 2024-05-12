import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai9 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Field Style Change");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(20);

        JRadioButton normalRadioButton = new JRadioButton("Thường");
        JRadioButton boldRadioButton = new JRadioButton("Bôi đậm");
        JRadioButton italicRadioButton = new JRadioButton("In nghiêng");
        JRadioButton boldItalicRadioButton = new JRadioButton("Bôi đậm và in nghiêng");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(normalRadioButton);
        buttonGroup.add(boldRadioButton);
        buttonGroup.add(italicRadioButton);
        buttonGroup.add(boldItalicRadioButton);

        ActionListener radioButtonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton radioButton = (JRadioButton) e.getSource();
                if (radioButton == normalRadioButton) {
                    textField.setFont(new Font("Arial", Font.PLAIN, 12));
                } else if (radioButton == boldRadioButton) {
                    textField.setFont(new Font("Arial", Font.BOLD, 12));
                } else if (radioButton == italicRadioButton) {
                    textField.setFont(new Font("Arial", Font.ITALIC, 12));
                } else if (radioButton == boldItalicRadioButton) {
                    textField.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
                }
            }
        };

        normalRadioButton.addActionListener(radioButtonAction);
        boldRadioButton.addActionListener(radioButtonAction);
        italicRadioButton.addActionListener(radioButtonAction);
        boldItalicRadioButton.addActionListener(radioButtonAction);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        panel.add(textField);
        panel.add(normalRadioButton);
        panel.add(boldRadioButton);
        panel.add(italicRadioButton);
        panel.add(boldItalicRadioButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
