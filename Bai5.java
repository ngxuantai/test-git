import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Hide/Show");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Tạo các nút
        JButton leftButton = new JButton("Trái");
        JButton rightButton = new JButton("Phải");
        JButton topButton = new JButton("Trên");
        JButton bottomButton = new JButton("Dưới");
        JButton centerButton = new JButton("Giữa");

        // Tạo panel và đặt layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Thêm các nút vào panel
        panel.add(leftButton, BorderLayout.WEST);
        panel.add(rightButton, BorderLayout.EAST);
        panel.add(topButton, BorderLayout.NORTH);
        panel.add(bottomButton, BorderLayout.SOUTH);
        panel.add(centerButton, BorderLayout.CENTER);

        // Xử lý sự kiện khi nút được nhấn
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                button.setVisible(false); // Ẩn nút được nhấn
                showOtherButtons(panel, button); // Hiển thị các nút khác
            }
        };

        // Gán xử lý sự kiện cho các nút
        leftButton.addActionListener(buttonAction);
        rightButton.addActionListener(buttonAction);
        topButton.addActionListener(buttonAction);
        bottomButton.addActionListener(buttonAction);
        centerButton.addActionListener(buttonAction);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Hiển thị các nút khác khi một nút được nhấn
    private static void showOtherButtons(JPanel panel, JButton hiddenButton) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton && component != hiddenButton) {
                component.setVisible(true);
            }
        }
    }
}
