import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai2 extends JFrame implements KeyListener {
    private JLabel keyLabel;

    public Bai2() {

        super("B2");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        keyLabel = new JLabel("Press a key");
        keyLabel.setHorizontalAlignment(JLabel.CENTER);
        keyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(keyLabel, BorderLayout.CENTER);

        addKeyListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();

        keyLabel.setText("Key pressed: " + keyChar + " (KeyCode: " + keyCode + ")");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
