import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Bai8 extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JButton chooseButton;

    public Bai8() {
        setTitle("Image Chooser");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(400, 400));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        chooseButton = new JButton("Chon hinh anh");
        chooseButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(chooseButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hinh anh", "jpg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String imagePath = selectedFile.getAbsolutePath();

            ImageIcon icon = new ImageIcon(imagePath);
            imageLabel.setIcon(icon);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bai8();
            }
        });
    }
}

