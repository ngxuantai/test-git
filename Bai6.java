import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai6 extends JFrame {
    private JList<String> bookList;
    private JButton submitButton;

    public Bai6() {
        setTitle("Chọn thể loại sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        String[] bookGenres = {"Văn học", "Khoa học", "Lịch sử", "Công nghệ", "Thể thao", "Văn hóa"};
        bookList = new JList<>(bookGenres);
        bookList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(bookList);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGenres = "Thể loại sách bạn đã chọn:\n";
                for (String genre : bookList.getSelectedValuesList()) {
                    selectedGenres += genre + "\n";
                }
                JOptionPane.showMessageDialog(Bai6.this, selectedGenres);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai6();
    }
}
