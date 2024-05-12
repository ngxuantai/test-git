import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;

public class Bai10 extends JFrame {
    private JTextField textField;
    private Highlighter highlighter;

    public Bai10() {
        setTitle("B10");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Bai10.this, "This is a simple menu demo", "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);

        JMenu formatMenu = new JMenu("Format");
        JMenu colorSubMenu = new JMenu("Color");
        JMenuItem redColorItem = new JMenuItem("Red");
        redColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyColor(Color.RED);
            }
        });
        JMenuItem greenColorItem = new JMenuItem("Green");
        greenColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyColor(Color.GREEN);
            }
        });
        JMenuItem blueColorItem = new JMenuItem("Blue");
        blueColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyColor(Color.BLUE);
            }
        });
        colorSubMenu.add(redColorItem);
        colorSubMenu.add(greenColorItem);
        colorSubMenu.add(blueColorItem);

        JMenu fontSubMenu = new JMenu("Font");
        ButtonGroup fontGroup = new ButtonGroup();
        JRadioButtonMenuItem font1Item = new JRadioButtonMenuItem("Font 1");
        font1Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JRadioButtonMenuItem font2Item = new JRadioButtonMenuItem("Font 2");
        font2Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JRadioButtonMenuItem font3Item = new JRadioButtonMenuItem("Font 3");
        font3Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        fontGroup.add(font1Item);
        fontGroup.add(font2Item);
        fontGroup.add(font3Item);

        JCheckBoxMenuItem boldItem = new JCheckBoxMenuItem("Bold");
        boldItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyStyle(Font.BOLD);
            }

        });
        JCheckBoxMenuItem italicItem = new JCheckBoxMenuItem("Italic");
        italicItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyStyle(Font.ITALIC);
            }
        });

        fontSubMenu.add(font1Item);
        fontSubMenu.add(font2Item);
        fontSubMenu.add(font3Item);
        fontSubMenu.addSeparator();
        fontSubMenu.add(boldItem);
        fontSubMenu.add(italicItem);

        formatMenu.add(colorSubMenu);
        formatMenu.add(fontSubMenu);

        menuBar.add(fileMenu);
        menuBar.add(formatMenu);

        setJMenuBar(menuBar);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        getContentPane().add(textField, BorderLayout.NORTH);

        highlighter = new DefaultHighlighter();
        textField.setHighlighter(highlighter);
    }

    private void applyColor(Color color) {
        int start = textField.getSelectionStart();
        int end = textField.getSelectionEnd();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(color);
        try {
            highlighter.addHighlight(start, end, painter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void applyStyle(int style) {
        int start = textField.getSelectionStart();
        int end = textField.getSelectionEnd();
        Font currentFont = textField.getFont();
        Font newFont = new Font(currentFont.getFontName(), style, currentFont.getSize());
        textField.setFont(newFont);
        textField.setSelectionStart(start);
        textField.setSelectionEnd(end);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Bai10 demo = new Bai10();
                demo.setVisible(true);
            }
        });
    }
}
