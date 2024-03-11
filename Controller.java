
import java.awt.event.*;

/*
 * Fall 2023 COSC 20203
 * Lab 2: ARM, Binary, and Hex 
 * @author: Rahul Shrestha
 * @credit: Some codes are taken from Dr Sanchez. 
 * @version JDK 18.0.1.1
 */
public class Controller extends Viewer implements ActionListener {
    Module m;

    /**
     * @param args[]
     */
    public static void main(String args[]) {
        new Controller();
    }

    public Controller() {
        m = new Module(this);
        setButtons();
    }

    /**
     * Add action listener for button
     */
    public void setButtons() {
        encode.addActionListener(this);
        decodeBi.addActionListener(this);
        decodeHex.addActionListener(this);
    }

    /**
     * Add action performed for button
     */
    public void actionPerformed(ActionEvent e) {
        String whichWidget = e.getActionCommand();
        System.out.println("calling action perform " + whichWidget + " ");

        if (whichWidget.equals("Encode"))
            m.armToBinaryAndHex(arm.getText());
        if (whichWidget.equals("Decode Binary"))
            m.binaryToArmAndHex(bi.getText());
        if (whichWidget.equals("Decode Hex"))
            m.hexToBinaryAndARM(hex.getText());

    }

}