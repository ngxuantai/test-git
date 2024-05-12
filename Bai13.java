import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Bai13 extends JFrame {
    private JPanel drawingPanel;
    private JPanel controlPanel;
    private JButton colorChooserButton;
    private JButton brushChooserButton;
    private JButton penChooserButton;
    private JButton clearButton;

    private Color chosenColor = Color.BLACK;
    private BasicStroke chosenStroke = new BasicStroke(1.0f);
    private Color fillColor = null; // Màu để fill hình đã chọn

    private enum Tool {
        PEN, LINE, CIRCLE, RECTANGLE, ELLIPSE, POLYGON
    }

    private Tool currentTool = Tool.LINE;

    private Point startPoint;
    private Point endPoint;

    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null; // Hình được chọn

    public Bai13() {
        setTitle("Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(chosenColor);
                g2d.setStroke(chosenStroke);

                for (Shape shape : shapes) {
                    if (shape == selectedShape && fillColor != null) { // Kiểm tra xem hình có được chọn hay không
                        g2d.setColor(fillColor);
                        g2d.fill(shape); // Fill hình đã chọn
                    } else {
                        g2d.setColor(chosenColor);
                        g2d.draw(shape);
                    }
                }

                switch (currentTool) {
                    case PEN:
                        break;
                    case LINE:
                        if (startPoint != null && endPoint != null) {
                            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                        }
                        break;
                    case CIRCLE:
                        if (startPoint != null && endPoint != null) {
                            int width = Math.abs(endPoint.x - startPoint.x);
                            int height = Math.abs(endPoint.y - startPoint.y);
                            int x = Math.min(startPoint.x, endPoint.x);
                            int y = Math.min(startPoint.y, endPoint.y);
                            g2d.drawOval(x, y, width, height);
                        }
                        break;
                    case RECTANGLE:
                        if (startPoint != null && endPoint != null) {
                            int width = Math.abs(endPoint.x - startPoint.x);
                            int height = Math.abs(endPoint.y - startPoint.y);
                            int x = Math.min(startPoint.x, endPoint.x);
                            int y = Math.min(startPoint.y, endPoint.y);
                            g2d.drawRect(x, y, width, height);
                        }
                        break;
                    case ELLIPSE:
                        if (startPoint != null && endPoint != null) {
                            int width = Math.abs(endPoint.x - startPoint.x);
                            int height = Math.abs(endPoint.y - startPoint.y);
                            int x = Math.min(startPoint.x, endPoint.x);
                            int y = Math.min(startPoint.y, endPoint.y);
                            g2d.drawOval(x, y, width, height);
                        }
                        break;
                    case POLYGON:
                        // Implement drawing polygon
                        break;
                }
            }
        };
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentTool == Tool.PEN) {
                    ((Graphics2D) drawingPanel.getGraphics()).setStroke(chosenStroke);
                    ((Graphics2D) drawingPanel.getGraphics()).setColor(chosenColor);
                    ((Graphics2D) drawingPanel.getGraphics()).drawLine(e.getX(), e.getY(), e.getX(), e.getY());
                } else {
                    startPoint = e.getPoint();
                    
                    // Xác định xem hình nào được chọn (nếu có)
                    for (Shape shape : shapes) {
                        if (shape.contains(startPoint)) {
                            selectedShape = shape;
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentTool != Tool.PEN) {
                    endPoint = e.getPoint();
                    Shape shape = createShape(startPoint, endPoint, currentTool);
                    shapes.add(shape);
                    drawingPanel.repaint();
                }
            }
        });
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentTool == Tool.PEN) {
                    ((Graphics2D) drawingPanel.getGraphics()).setStroke(chosenStroke);
                    ((Graphics2D) drawingPanel.getGraphics()).setColor(chosenColor);
                    ((Graphics2D) drawingPanel.getGraphics()).drawLine(e.getX(), e.getY(), e.getX(), e.getY());
                }
            }
        });

        controlPanel = new JPanel();
        colorChooserButton = new JButton("Chọn màu");
        brushChooserButton = new JButton("Chọn kích thước bút vẽ");
        penChooserButton = new JButton("Chọn hình vẽ");
        clearButton = new JButton("Xóa");

        controlPanel.add(colorChooserButton);
        controlPanel.add(brushChooserButton);
        controlPanel.add(penChooserButton);
        controlPanel.add(clearButton);

        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosenColor = JColorChooser.showDialog(null, "Chọn màu", chosenColor);
            }
        });

        brushChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chọn kích thước bút vẽ
                String[] options = {"1px", "3px", "5px"};
                String selectedOption = (String) JOptionPane.showInputDialog(null, "Chọn kích thước bút:", "Chọn kích thước bút vẽ", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (selectedOption != null) {
                    float size = Float.parseFloat(selectedOption.substring(0, selectedOption.indexOf("px")));
                    chosenStroke = new BasicStroke(size);
                }
            }
        });

        penChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chọn công cụ vẽ
                String[] options = {"Đường thẳng", "Hình tròn", "Hình chữ nhật"};
                String selectedOption = (String) JOptionPane.showInputDialog(null, "Chọn hình vẽ:", "Chọn hình vẽ", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (selectedOption != null) {
                    switch (selectedOption) {
                        case "Bút":
                            currentTool = Tool.PEN;
                            break;
                        case "Đường thẳng":
                            currentTool = Tool.LINE;
                            break;
                        case "Hình tròn":
                            currentTool = Tool.CIRCLE;
                            break;
                        case "Hình chữ nhật":
                            currentTool = Tool.RECTANGLE;
                            break;
                        case "Hình oval":
                            currentTool = Tool.ELLIPSE;
                            break;
                        case "Hình đa giác":
                            currentTool = Tool.POLYGON;
                            break;
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                drawingPanel.repaint();
            }
        });

        setLayout(new BorderLayout());
        add(drawingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
    }

    private Shape createShape(Point start, Point end, Tool tool) {
        switch (tool) {
            case LINE:
                return new Line2D.Float(start, end);
            case CIRCLE:
                int width = Math.abs(end.x - start.x);
                int height = Math.abs(end.y - start.y);
                int x = Math.min(start.x, end.x);
                int y = Math.min(start.y, end.y);
                return new Ellipse2D.Float(x, y, width, height);
            case RECTANGLE:
                width = Math.abs(end.x - start.x);
                height = Math.abs(end.y - start.y);
                x = Math.min(start.x, end.x);
                y = Math.min(start.y, end.y);
                return new Rectangle2D.Float(x, y, width, height);
            case ELLIPSE:
                width = Math.abs(end.x - start.x);
                height = Math.abs(end.y - start.y);
                x = Math.min(start.x, end.x);
                y = Math.min(start.y, end.y);
                return new Ellipse2D.Float(x, y, width, height);
            // Implement drawing polygon
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bai13().setVisible(true);
            }
        });
    }
}
