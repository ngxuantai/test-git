import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

public class Bai14 extends JPanel implements ActionListener {
    private Timer timer;
    private double t = 0.0;
    private String name = "Xuan Tai";

    public Bai14() {
        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawBezierCurve(g2d);

        FontMetrics metrics = g2d.getFontMetrics();
        int stringWidth = metrics.stringWidth(name);
        int stringHeight = metrics.getHeight();
        int startX = (int) (calculateBezierPoint(t).getX() - stringWidth / 2.0);
        int startY = (int) (calculateBezierPoint(t).getY() - stringHeight / 2.0);
        g2d.drawString(name, startX, startY);

        t += 0.01;
        if (t > 1.0) {
            t = 0.0;
        }
    }

    private void drawBezierCurve(Graphics2D g2d) {
        int x0 = 50, y0 = 250;
        int x1 = 200, y1 = 50;
        int x2 = 350, y2 = 350;
        int x3 = 500, y3 = 250;

        g2d.setColor(Color.RED);
        g2d.fillOval(x0 - 3, y0 - 3, 6, 6);
        g2d.fillOval(x1 - 3, y1 - 3, 6, 6);
        g2d.fillOval(x2 - 3, y2 - 3, 6, 6);
        g2d.fillOval(x3 - 3, y3 - 3, 6, 6);

        g2d.setColor(Color.BLUE);
        CubicCurve2D curve = new CubicCurve2D.Double(x0, y0, x1, y1, x2, y2, x3, y3);
        g2d.draw(curve);
    }

    private Point2D.Double calculateBezierPoint(double t) {
        int x0 = 50, y0 = 250;
        int x1 = 200, y1 = 50;
        int x2 = 350, y2 = 350;
        int x3 = 500, y3 = 250;

        double x = Math.pow(1 - t, 3) * x0 + 3 * t * Math.pow(1 - t, 2) * x1 + 3 * Math.pow(t, 2) * (1 - t) * x2
                + Math.pow(t, 3) * x3;
        double y = Math.pow(1 - t, 3) * y0 + 3 * t * Math.pow(1 - t, 2) * y1 + 3 * Math.pow(t, 2) * (1 - t) * y2
                + Math.pow(t, 3) * y3;
        return new Point2D.Double(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bezier ");
        frame.add(new Bai14());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
