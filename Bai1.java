import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bai1 {
    public static void main(String[] args) {
        // Yêu cầu người dùng nhập tên
        String name = JOptionPane.showInputDialog("Nhập tên của bạn:");

        // Tạo một frame (cửa sổ)
        JFrame frame = new JFrame("Chào mừng");

        // Tạo một label để hiển thị thông điệp chào mừng
        JLabel label = new JLabel("Xin chào " + name + "!");

        // Thêm label vào panel
        JPanel panel = new JPanel();
        panel.add(label);

        // Thêm panel vào frame
        frame.add(panel);

        // Cài đặt kích thước của frame
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
