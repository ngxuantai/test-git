import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Bai3 extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JTextArea textArea1, textArea2;
    private JButton transferButton;

    public Bai3() {
        setTitle("Transfer text");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("Text Area 1");
        textArea1 = new JTextArea(5, 20);
        textArea1.setBackground(Color.WHITE);
        label2 = new JLabel("Text Area 2");
        textArea2 = new JTextArea(5, 20);
        textArea2.setBackground(Color.LIGHT_GRAY);
        textArea2.setEditable(false); 
        transferButton = new JButton("Transfer");
        transferButton.addActionListener(this);

        JPanel textAreaPanel1 = new JPanel();
        textAreaPanel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        textAreaPanel1.setLayout(new GridLayout(2, 1));
        textAreaPanel1.add(label1);
        textAreaPanel1.add(textArea1);

        JPanel textAreaPanel2 = new JPanel();
        textAreaPanel2.setBorder(new EmptyBorder(10, 10, 10, 10));
        textAreaPanel2.setLayout(new GridLayout(2, 1));
        textAreaPanel2.add(label2);
        textAreaPanel2.add(textArea2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(transferButton);

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(textAreaPanel1);
        getContentPane().add(textAreaPanel2);
        getContentPane().add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transferButton) {
            String selectedText = textArea1.getText();
            textArea2.setText(selectedText);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bai3().setVisible(true);
            }
        });
    }
}
