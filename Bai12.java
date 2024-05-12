import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Bai12 extends JFrame {
    private JSlider slider;
    private CirclePanel circlePanel;

    public Bai12() {
        setTitle("Circle Slider");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        slider = new JSlider(JSlider.HORIZONTAL, 10, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SliderChangeListener());

        JPanel sliderPanel = new JPanel();
        sliderPanel.add(slider);

        circlePanel = new CirclePanel(100); 
        JPanel circlePanelContainer = new JPanel();
        circlePanelContainer.add(circlePanel);

        setLayout(new BorderLayout());
        add(sliderPanel, BorderLayout.NORTH);
        add(circlePanelContainer, BorderLayout.CENTER);

        setVisible(true);
    }

    private class CirclePanel extends JPanel {
        private int diameter; 

        public CirclePanel(int diameter) {
            this.diameter = diameter;
        }

        public void setDiameter(int diameter) {
            this.diameter = diameter;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g.setColor(Color.BLUE);
            g.fillOval(x, y, diameter, diameter);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    private class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int value = slider.getValue();
            circlePanel.setDiameter(value);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bai12();
            }
        });
    }
}
