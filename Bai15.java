import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Bai15 extends JPanel {
    private ImageIcon fireIcon;
    private int numberOfFires = 1;

    public Bai15() {
        fireIcon = new ImageIcon(getClass().getResource("Sprite.png"));
        setPreferredSize(new Dimension(600, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Random random = new Random();
        for (int i = 0; i < numberOfFires; i++) {
            int x = random.nextInt(getWidth() - fireIcon.getIconWidth());
            int y = random.nextInt(getHeight() - fireIcon.getIconHeight());
            fireIcon.paintIcon(this, g, x, y);
        }
    }

    public void setNumberOfFires(int numberOfFires) {
        this.numberOfFires = numberOfFires;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fire Animation");
            Bai15 fireAnimation = new Bai15();
            frame.add(fireAnimation, BorderLayout.CENTER);
            
            JPanel controlPanel = new JPanel();
            JLabel label = new JLabel("Number of Fires:");
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
            spinner.addChangeListener(e -> {
                int value = (int) spinner.getValue();
                fireAnimation.setNumberOfFires(value);
            });
            controlPanel.add(label);
            controlPanel.add(spinner);
            
            frame.add(controlPanel, BorderLayout.SOUTH);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
