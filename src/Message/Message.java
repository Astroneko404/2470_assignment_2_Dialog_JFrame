package Message;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.*;

public class Message extends JPanel{
    static String COLOR_B;
    static String COLOR_F;
    static String FONT;
    static String FONT_SIZE;
    static String HEIGHT;
    static String SHAPE;
    static String TEXT;
    static String WIDTH;

    String[] COLOR_LIST = {
            "black", "blue", "cyan", "dark gray",
            "gray", "green", "light gray", "magenta",
            "orange", "pink", "red", "white", "yellow"
    };
    String[] FONT_LIST = {
            "regular", "bold", "italic", "bold italic"
    };
    String[] SHAPE_LIST = {
            "oval", "rectangle", "round rectangle"
    };

    public static boolean isInteger(String s) {
        try { Integer.parseInt(s); }
        catch(NumberFormatException | NullPointerException e) { return false; }
        return true;
    }

    public void paint(Graphics g){
        boolean err = false;
        boolean width_err = false;
        boolean height_err = false;

        String error_message = "Error:\n";

        if (!Arrays.asList(COLOR_LIST).contains(COLOR_B)) {
            err = true;
            error_message += " - COLOR_BACKGROUND should be Java preset color:\n " +
                    "\tblue, cyan, dark gray, gray, green, light gray, \n" +
                    "\tmagenta, orange, pink, red, white, yellow\n";
        };
        if (!Arrays.asList(SHAPE_LIST).contains(SHAPE)) {
            err = true;
            error_message += " - SHAPE should be oval, rectangle, or round rectangle\n";
        }

        if (!isInteger(WIDTH) || Integer.parseInt(WIDTH) <= 0 || Integer.parseInt(WIDTH) > 500) {
            err = true;
            width_err = true;
            error_message += " - WIDTH should be an integer in range (0, 500]\n";
        }
        if (!isInteger(HEIGHT) || Integer.parseInt(HEIGHT) <= 0 || Integer.parseInt(HEIGHT) > 300) {
            err = true;
            height_err = true;
            error_message += " - HEIGHT should be an integer in range (0, 300]\n";
        }

        if (!Arrays.asList(COLOR_LIST).contains(COLOR_F)) {
            err = true;
            error_message += " - COLOR_FRONT should be Java preset color:\n " +
                    "\tblue, cyan, dark gray, gray, green, light gray, \n" +
                    "\tmagenta, orange, pink, red, white, yellow\n";
        };
        if (!isInteger(FONT_SIZE) || Integer.parseInt(FONT_SIZE) < 0) {
            err = true;
            error_message += " - FONT SIZE should be an integer larger than 0\n";
        }
        if (TEXT.isEmpty()) {
            err = true;
            error_message += " - TEXT cannot be empty\n";
        }
        if (!width_err && !height_err) {
            if (!Arrays.asList(FONT_LIST).contains(FONT)) {
                err = true;
                error_message += "FONT should be regular, bold, italic, or bold italic\n";
            }
            else {
                switch (FONT) {
                    case "regular":
                        g.setFont(new Font("Serif", Font.PLAIN, Integer.parseInt(FONT_SIZE)));
                    case "bold":
                        g.setFont(new Font("Serif", Font.BOLD, Integer.parseInt(FONT_SIZE)));
                    case "italic":
                        g.setFont(new Font("Serif", Font.ITALIC, Integer.parseInt(FONT_SIZE)));
                    case "bold italic":
                        g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, Integer.parseInt(FONT_SIZE)));
                }
                FontMetrics fm = g.getFontMetrics();
                int str_width = fm.stringWidth(TEXT);
                int str_height = fm.getHeight() - fm.getAscent() - fm.getDescent();

                if (str_width > Integer.parseInt(WIDTH) || str_height > Integer.parseInt(HEIGHT)) {
                    err = true;
                    error_message += " - TEXT cannot be draw in the message box\n";
                }
            }
        }
        if (err) {
            g.setFont(new Font("Serif", Font.PLAIN, 16));
            FontMetrics fm = g.getFontMetrics();
            int y = 20;
            for (String line : error_message.split("\n")) {
                g.drawString(line, 15, y);
                y += fm.getHeight();
            }
        }
        else {
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
                case "round Rectangle":
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

            switch (COLOR_F) {
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
                default:
                    err = true;
                    error_message += " - COLOR_FRONT should be Java preset color:\n " +
                            "\tblue, cyan, dark gray, gray, green, light gray, \n" +
                            "\tmagenta, orange, pink, red, white, yellow\n";
            }
            switch (FONT) {
                case "regular":
                    g.setFont(new Font("Serif", Font.PLAIN, Integer.parseInt(FONT_SIZE)));
                case "bold":
                    g.setFont(new Font("Serif", Font.BOLD, Integer.parseInt(FONT_SIZE)));
                case "italic":
                    g.setFont(new Font("Serif", Font.ITALIC, Integer.parseInt(FONT_SIZE)));
                case "bold italic":
                    g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, Integer.parseInt(FONT_SIZE)));
            }

            FontMetrics fm = g.getFontMetrics();
            int str_width = fm.stringWidth(TEXT);
            int str_height = fm.getHeight() - fm.getAscent() - fm.getDescent();
            g.drawString(TEXT, (500 - str_width) / 2, (300 - str_height) / 2);
        }
    }

    public static void main(String[] args){
        COLOR_B = JOptionPane.showInputDialog("Please input background color: ").toLowerCase();
        SHAPE = JOptionPane.showInputDialog("Please input shape: ").toLowerCase();
        WIDTH = JOptionPane.showInputDialog("Please input weight (int 1 - 500): ");
        HEIGHT = JOptionPane.showInputDialog("Please input height (int 1 - 300): ");

        COLOR_F = JOptionPane.showInputDialog("Please input front part color: ").toLowerCase();
        FONT = JOptionPane.showInputDialog("Please input font style: ").toLowerCase();
        FONT_SIZE = JOptionPane.showInputDialog("Please input font size: ");

        TEXT = JOptionPane.showInputDialog("Please input text message: ");

        JFrame f = new JFrame();

        f.setSize(500, 300);
        f.add(new Message());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
