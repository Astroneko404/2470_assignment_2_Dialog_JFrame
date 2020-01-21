package Message;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Message extends JPanel{
    private static String COLOR_B;
    private static String COLOR_F;
    private static String FONT;
    private static String SHAPE;
    private static String TEXT;

    public void paint(Graphics g){
        if(COLOR_B.equals("blue")){
            g.setColor(Color.blue);
        }
        else if(COLOR_B.equals("red")){
            g.setColor(Color.red);
        }
        if (SHAPE.equals("oval")){
            g.fillOval( 50, 40, 150, 80 );
        }


    }
    public static void main(String[] args){
        JFrame f = new JFrame("Message");
        JPanel main = new JPanel();
        JPanel setting = new JPanel();
        JFrame f2 = new JFrame("Draw");
        GridLayout grid = new GridLayout(7,2);

        JLabel text = new JLabel("Text:");
        JTextField text_field = new JTextField(20);
        JLabel shape = new JLabel("Shape:");
        JTextField shape_field = new JTextField(20);
        JLabel color_back = new JLabel("Color - Background");
        JTextField color_back_field = new JTextField(20);
        JLabel color_front = new JLabel("Color - Front");
        JTextField color_front_field = new JTextField(20);
        JLabel font = new JLabel("Font style:");
        JTextField font_field = new JTextField(20);
        JButton draw = new JButton("Draw");

        draw.addActionListener(actionEvent -> {
            TEXT = text_field.getText();
            SHAPE = shape_field.getText();
            COLOR_B = color_back_field.getText();
            COLOR_F = color_front_field.getText();
            FONT = font_field.getText();

            f2.setSize(300, 160);
            f2.add(new Message());
            f2.setVisible(true);
        });

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        setting.setLayout(grid);
        setting.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        setting.add(text);
        setting.add(text_field);
        setting.add(shape);
        setting.add(shape_field);
        setting.add(color_back);
        setting.add(color_back_field);
        setting.add(color_front);
        setting.add(color_front_field);
        setting.add(font);
        setting.add(font_field);
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
