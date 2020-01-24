package Message;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Message extends JPanel{
    private static String COLOR_B;
    private static String COLOR_F;
    private static String FONT;
    private static String FONT_SIZE;
    private static String HEIGHT;
    private static String SHAPE;
    private static String TEXT;
    private static String WIDTH;

    private static String[] COLOR_LIST = {
            "Black", "Blue", "Cyan", "Dark gray",
            "Gray", "Green", "Light gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow"
    };
    private static String[] FONT_LIST = {
            "Regular", "Bold", "Italic", "Bold Italic"
    };
    private static String[] SHAPE_LIST = {
            "Oval", "Rectangle", "Round Rectangle"
    };

    Boolean font_err = false;
    Boolean height_err = false;
    Boolean text_err = false;
    Boolean width_err = false;

    String error_message = "Error:\n";

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public void paint(Graphics g){
        // No error checking for COLOR_B, COLOR_F, FONT, and SHAPE

        /* Draw background part
           Including:
           - COLOR_B
           - WIDTH & HEIGHT
           - SHAPE
        */
        switch (COLOR_B) {
            case "black":
                g.setColor(Color.black);
                break;
            case "blue":
                g.setColor(Color.blue);
                break;
            case "cyan":
                g.setColor(Color.cyan);
                break;
            case "dark gray":
                g.setColor(Color.darkGray);
                break;
            case "gray":
                g.setColor(Color.gray);
                break;
            case "green":
                g.setColor(Color.green);
                break;
            case "light gray":
                g.setColor(Color.lightGray);
                break;
            case "magenta":
                g.setColor(Color.magenta);
                break;
            case "orange":
                g.setColor(Color.orange);
                break;
            case "pink":
                g.setColor(Color.pink);
                break;
            case "red":
                g.setColor(Color.red);
                break;
            case "white":
                g.setColor(Color.white);
                break;
            case "yellow":
                g.setColor(Color.yellow);
                break;
        }

        if (!isInteger(WIDTH)) { width_err = true; }
        if (!isInteger(HEIGHT)) { height_err = true; }

        if (!width_err && !height_err) {
            switch (SHAPE) {
                case "oval":
                    g.fillOval(
                            (500 - Integer.parseInt(WIDTH)) / 2,
                            (300 - Integer.parseInt(HEIGHT)) / 2,
                            Integer.parseInt(WIDTH),
                            Integer.parseInt(HEIGHT)
                    );
                    break;
                case "rectangle":
                    g.fillRect(
                            (500 - Integer.parseInt(WIDTH)) / 2,
                            (300 - Integer.parseInt(HEIGHT)) / 2,
                            Integer.parseInt(WIDTH),
                            Integer.parseInt(HEIGHT)
                    );
                    break;
                case "round rectangle":
                    g.fillRoundRect(
                            (500 - Integer.parseInt(WIDTH)) / 2,
                            (300 - Integer.parseInt(HEIGHT)) / 2,
                            Integer.parseInt(WIDTH),
                            Integer.parseInt(HEIGHT),
                            30,
                            30
                    );
                    break;
            }
        }

        /* Draw text part
           Including:
        */
    }

    public static void main(String[] args){
        JFrame f = new JFrame("Message");
        JPanel main = new JPanel();
        JPanel setting = new JPanel();
        JFrame f2 = new JFrame("Draw");
        GridLayout grid = new GridLayout(10,2);

        JLabel color_back = new JLabel("Color - Background:");
        JComboBox color_back_field = new JComboBox(COLOR_LIST);
        color_back_field.setEditable(false);
        JLabel color_front = new JLabel("Color - Front:");
        JComboBox color_front_field = new JComboBox(COLOR_LIST);
        color_front_field.setEditable(false);
        JLabel font = new JLabel("Font style:");
        JComboBox font_field = new JComboBox(FONT_LIST);
        font_field.setEditable(false);
        JLabel shape = new JLabel("Shape:");
        JComboBox shape_field = new JComboBox(SHAPE_LIST);
        shape_field.setEditable(false);

        JLabel font_size = new JLabel("Font size:");
        JTextField font_size_field = new JTextField(20);
        JLabel height = new JLabel("Height:");
        JTextField height_field = new JTextField(20);
        JLabel text = new JLabel("Text:");
        JTextField text_field = new JTextField(20);
        JLabel width = new JLabel("Width:");
        JTextField width_field = new JTextField(20);

        JButton draw = new JButton("Draw");
        draw.setSize(20,20);

        draw.addActionListener(actionEvent -> {
            COLOR_B = color_back_field.getSelectedItem().toString().toLowerCase();
            COLOR_F = color_front_field.getSelectedItem().toString().toLowerCase();
            FONT = font_field.getSelectedItem().toString().toLowerCase();
            FONT_SIZE = font_size_field.getText();
            HEIGHT = height_field.getText();
            SHAPE = shape_field.getSelectedItem().toString().toLowerCase();
            TEXT = text_field.getText();
            WIDTH = width_field.getText();

            f2.setSize(500, 300);
            f2.add(new Message());
            f2.setVisible(true);
        });

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        setting.setLayout(grid);
        setting.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setting.add(color_back);
        setting.add(color_back_field);
        setting.add(shape);
        setting.add(shape_field);
        setting.add(width);
        setting.add(width_field);
        setting.add(height);
        setting.add(height_field);

        setting.add(color_front);
        setting.add(color_front_field);
        setting.add(font);
        setting.add(font_field);
        setting.add(font_size);
        setting.add(font_size_field);

        setting.add(text);
        setting.add(text_field);

        setting.add(new JLabel(" "));
        setting.add(new JLabel(" "));
        setting.add(new JLabel(" "));
        setting.add(draw);

        main.add(setting);

        f.setSize(500, 300);
        f.add(main);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
