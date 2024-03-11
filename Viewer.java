
import java.awt.*;
import javax.swing.*;

public class Viewer extends JFrame {
    public Color MyColor = new Color(0x469BD8);
    ImageIcon icon = new ImageIcon("/img/ARM_image1");
    JFrame frame = new JFrame("Peter Ho's Encoding ARM Instructions");

    JButton encode = new JButton("Encode");
    JButton decodeBi = new JButton("Decode Binary");
    JButton decodeHex = new JButton("Decode Hex");

    JPanel panel = new JPanel();

    JLabel label1 = new JLabel("To Assembly Language:", SwingConstants.CENTER);
    JLabel label2 = new JLabel("Binary Instruction", SwingConstants.CENTER);
    JLabel label3 = new JLabel("Hex Instruction", SwingConstants.CENTER);
    JLabel noLabel = new JLabel();

    JTextField arm = new JTextField(); // for arm instruction
    JTextField bi = new JTextField(); // for binary instruction
    JTextField hex = new JTextField(); // for hex instruction

    JTextField feedback = new JTextField("Feedback on Errors");

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Viewer();
    }

    Viewer() {
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 450);
        frame.getContentPane().setBackground(MyColor);

        // set image
        ImageIcon icon = new ImageIcon("img/ARM_image1.jpeg");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        // button
        encode.setFont(encode.getFont().deriveFont(25.0f));
        encode.setForeground(MyColor);

        decodeBi.setFont(decodeBi.getFont().deriveFont(25.0f));
        decodeBi.setForeground(MyColor);

        decodeHex.setFont(decodeHex.getFont().deriveFont(25.0f));
        decodeHex.setForeground(MyColor);

        // textField
        arm.setFont(new Font("MV Boli", Font.PLAIN, 25));
        hex.setFont(new Font("MV Boli", Font.PLAIN, 25));
        bi.setFont(new Font("MV Boli", Font.PLAIN, 20));
        feedback.setFont(new Font("MV Boli", Font.PLAIN, 20));
        feedback.setForeground(Color.red);
        // label
        label1.setFont(new Font("MV Boli", Font.PLAIN, 25));
        label2.setFont(new Font("MV Boli", Font.PLAIN, 25));
        label3.setFont(new Font("MV Boli", Font.PLAIN, 25));
        // set Grid Panel
        noLabel.setVisible(false);
        panel.setBackground(null);
        panel.setLayout(new GridLayout(5, 2));
        panel.add(arm);
        panel.add(encode);
        panel.add(label1);
        panel.add(noLabel);
        panel.add(label2);
        panel.add(label3);
        panel.add(bi);
        panel.add(hex);
        panel.add(decodeBi);
        panel.add(decodeHex);

        frame.add(panel);
        frame.add(new JLabel(icon), BorderLayout.NORTH);
        frame.add(feedback, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}