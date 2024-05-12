import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Bai11 extends JPanel {
    private final int NUM_STARS = 20;
    private final int STAR_RADIUS = 50;
    private final int CIRCLE_RADIUS = 150;
    private final int ANGLE_INCREMENT = 360 / NUM_STARS;

    public Bai11() {
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (int i = 0; i < NUM_STARS; i++) {
            double angle = Math.toRadians(i * ANGLE_INCREMENT);
            int x = (int) (centerX + Math.cos(angle) * CIRCLE_RADIUS);
            int y = (int) (centerY + Math.sin(angle) * CIRCLE_RADIUS);

            Color starColor = generateRandomColor();
            g2d.setColor(starColor);

            drawStar(g2d, x, y);
        }
    }

    private void drawStar(Graphics2D g2d, int x, int y) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(i * 36);
            int radius = (i % 2 == 0) ? STAR_RADIUS : STAR_RADIUS / 2;
            xPoints[i] = (int) (x + radius * Math.cos(angle));
            yPoints[i] = (int) (y + radius * Math.sin(angle));
        }

        g2d.fillPolygon(xPoints, yPoints, 10);
    }

    private static Color generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Star circle");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Bai11());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
