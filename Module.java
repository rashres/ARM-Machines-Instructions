
public class Module {
    Controller c;
    int r0, r0Int;
    int r1, r1Int;
    int r2, r2Int;
    String[] split;
    int biN1 = 0;
    int biN2 = 0;
    int biN3 = 0;
    int biN4 = 0;
    int biN5 = 0;
    int biN6 = 0;
    int biN7 = 0;
    int biN8 = 0;
    String biResult;
    int number1, number2, number3, number4, number5, number6, number7, number8;
    String bi1 = "";
    String bi2 = "";
    String bi3 = "";
    String bi4 = "";
    String bi5 = "";
    String bi6 = "";
    String bi7 = "";
    String bi8 = "";

    public Module(Controller fromC) {
        c = fromC;

    }

    /**
     * Convert ARM to binary and hex number
     * <p>
     * Convert ARM to binary number and then convert
     * binary number to hex number
     * <p>
     * 
     * @param arm ARM instruction
     */
    public void armToBinaryAndHex(String arm) {
        // arm to binary
        c.feedback.setText("Feedback on Errors");
        c.bi.setText("");
        c.hex.setText("");

        arm = arm.replaceAll(" ", "");

        biResult = "1110000";
        try {
            if (arm.substring(0, 3).equalsIgnoreCase("AND"))
                biResult += "0000";
            else if (arm.substring(0, 3).equalsIgnoreCase("EOR"))
                biResult += "0001";
            else if (arm.substring(0, 3).equalsIgnoreCase("SUB"))
                biResult += "0010";
            else if (arm.substring(0, 3).equalsIgnoreCase("RSB"))
                biResult += "0011";
            else if (arm.substring(0, 3).equalsIgnoreCase("ADD"))
                biResult += "0100";
            else if (arm.substring(0, 3).equalsIgnoreCase("ADC"))
                biResult += "0101";
            else if (arm.substring(0, 3).equalsIgnoreCase("SBC"))
                biResult += "0110";
            else if (arm.substring(0, 3).equalsIgnoreCase("RSC"))
                biResult += "0111";
            else if (arm.substring(0, 3).equalsIgnoreCase("TST"))
                biResult += "1000";
            else if (arm.substring(0, 3).equalsIgnoreCase("TEQ"))
                biResult += "1001";
            else if (arm.substring(0, 3).equalsIgnoreCase("CMP"))
                biResult += "1010";
            else if (arm.substring(0, 3).equalsIgnoreCase("CMN"))
                biResult += "1011";
            else if (arm.substring(0, 3).equalsIgnoreCase("ORR"))
                biResult += "1100";
            else if (arm.substring(0, 3).equalsIgnoreCase("MOV"))
                biResult += "1101";
            else if (arm.substring(0, 3).equalsIgnoreCase("BIC"))
                biResult += "1110";
            else if (arm.substring(0, 3).equalsIgnoreCase("MVN"))
                biResult += "1111";
        } catch (Exception e) {
            c.feedback.setText("Inappropriate ARM, please try again.");

        }

        biResult += "0";

        String r1 = "";
        String r0 = "";
        String r2 = "";
        try {
            split = arm.split(",");
            r1Int = Integer.parseInt(split[1].substring(1));
            r0Int = Integer.parseInt(split[0].substring(4));
            r2Int = Integer.parseInt(split[2].substring(1));
            if (r0Int > 15 || r0Int < 0) {
                c.feedback.setText("Inappropriate ARM, please try again.");
            }
            if (r1Int > 15 || r1Int < 0) {
                c.feedback.setText("Inappropriate ARM, please try again.");
            }
            if (r2Int > 15 || r2Int < 0) {
                c.feedback.setText("Inappropriate ARM, please try again.");
            }
            for (int i = 0; i < 4; ++i) {
                r1 = (r1Int & 1) + r1;
                r0 = (r0Int & 1) + r0;
                r2 = (r2Int & 1) + r2;
                r1Int = (short) (r1Int >> 1);
                r2Int = (short) (r2Int >> 1);
                r0Int = (short) (r0Int >> 1);
            }
        } catch (Exception e) {
            c.feedback.setText("Inappropriate ARM, please try again.");

        }

        biResult = biResult + r1 + r0 + "00000000" + r2;

        if (biResult.length() != 32) {
            c.feedback.setText("Inappropriate ARM, please try again.");

        }

        // binary to hex

        // binary to integer
        try {
            number1 = Integer.parseInt(biResult.substring(0, 4), 2); // first 4 binary digit to integer
            number2 = Integer.parseInt(biResult.substring(4, 8), 2); // second 4 binary digit to integer
            number3 = Integer.parseInt(biResult.substring(8, 12), 2);
            number4 = Integer.parseInt(biResult.substring(12, 16), 2);
            number5 = Integer.parseInt(biResult.substring(16, 20), 2);
            number6 = Integer.parseInt(biResult.substring(20, 24), 2);
            number7 = Integer.parseInt(biResult.substring(24, 28), 2);
            number8 = Integer.parseInt(biResult.substring(28, 32), 2);
        } catch (Exception e) {
            c.feedback.setText("Inappropriate ARM, please try again.");

        }

        // integer to hex
        String hex = "";
        hex = Integer.toHexString(number1) + Integer.toHexString(number2) + Integer.toHexString(number3)
                + Integer.toHexString(number4) +
                Integer.toHexString(number5) + Integer.toHexString(number6) + Integer.toHexString(number7)
                + Integer.toHexString(number8);

        // setText()
        if (c.feedback.getText().equals("Feedback on Errors")) {
            c.bi.setText(biResult);
            c.hex.setText(hex.toUpperCase());
        }

    }

    /**
     * Convert binary number to ARM and hex number.
     * <p>
     * For the conversion of binary to hex number,
     * convert binary to integer first then to hex number.
     * <p>
     * 
     * @param binary binary number
     */
    public void binaryToArmAndHex(String binary) {
        // binary to ARM
        c.feedback.setText("Feedback on Errors");
        c.arm.setText("");
        c.hex.setText("");
        binary = binary.replaceAll(" ", "");
        if (binary.length() != 32) {
            c.feedback.setText("Inappropriate binary number, please try again.");
        }

        String arm = "";
        try {
            if (binary.substring(7, 11).equals("0000"))
                arm += "AND ";
            else if (binary.substring(7, 11).equals("0001"))
                arm += "EOR ";
            else if (binary.substring(7, 11).equals("0010"))
                arm += "SUB ";
            else if (binary.substring(7, 11).equals("0011"))
                arm += "RSB ";
            else if (binary.substring(7, 11).equals("0100"))
                arm += "ADD ";
            else if (binary.substring(7, 11).equals("0101"))
                arm += "ADC ";
            else if (binary.substring(7, 11).equals("0110"))
                arm += "SBC ";
            else if (binary.substring(7, 11).equals("0111"))
                arm += "RSC ";
            else if (binary.substring(7, 11).equals("1000"))
                arm += "TST ";
            else if (binary.substring(7, 11).equals("1001"))
                arm += "TEQ ";
            else if (binary.substring(7, 11).equals("1010"))
                arm += "CMP ";
            else if (binary.substring(7, 11).equals("1011"))
                arm += "CMN ";
            else if (binary.substring(7, 11).equals("1100"))
                arm += "ORR ";
            else if (binary.substring(7, 11).equals("1101"))
                arm += "MOV ";
            else if (binary.substring(7, 11).equals("1110"))
                arm += "BIC ";
            else if (binary.substring(7, 11).equals("1111"))
                arm += "MVN ";
        } catch (Exception e) {
            c.feedback.setText("Inappropriate binary number, please try again.");
        }

        try {
            r0 = Integer.parseInt(binary.substring(16, 20), 2);
            r1 = Integer.parseInt(binary.substring(12, 16), 2);
            r2 = Integer.parseInt(binary.substring(28, 32), 2);
            // System.out.println(" testing binary " + binary);
        } catch (Exception e) {
            System.out.println("Inappropriate binary number, please try again.");
        }
        arm = arm + "r" + r0 + "," + "r" + r1 + "," + "r" + r2;

        // binary to Hex
        // binary to integer
        try {
            number1 = Integer.parseInt(binary.substring(0, 4), 2); // first 4 binary digit to integer
            number2 = Integer.parseInt(binary.substring(4, 8), 2); // second 4 binary digit to integer
            number3 = Integer.parseInt(binary.substring(8, 12), 2);
            number4 = Integer.parseInt(binary.substring(12, 16), 2);
            number5 = Integer.parseInt(binary.substring(16, 20), 2);
            number6 = Integer.parseInt(binary.substring(20, 24), 2);
            number7 = Integer.parseInt(binary.substring(24, 28), 2);
            number8 = Integer.parseInt(binary.substring(28, 32), 2);
        } catch (Exception e) {
            c.feedback.setText("Inappropriate binary number, please try again.");
        }

        // integer to hex
        String hex = "";
        hex = Integer.toHexString(number1) + Integer.toHexString(number2) + Integer.toHexString(number3)
                + Integer.toHexString(number4) +
                Integer.toHexString(number5) + Integer.toHexString(number6) + Integer.toHexString(number7)
                + Integer.toHexString(number8);
        if (c.feedback.getText().equals("Errors Feedback")) {
            c.arm.setText(arm);
            c.hex.setText(hex.toUpperCase());

        }

    }

    /**
     * Convert hex number to ARM and binary number.
     * <p>
     * For the conversion of hex to binary,
     * convert hex to integer first then to binary
     * <p>
     * 
     * @param binary binary number
     */
    public void hexToBinaryAndARM(String hexString) {
        // hex to binary
        c.feedback.setText("Feedback on Errors");
        c.bi.setText("");
        c.arm.setText("");
        bi1 = "";
        bi2 = "";
        bi3 = "";
        bi4 = "";
        bi5 = "";
        bi6 = "";
        bi7 = "";
        bi8 = "";
        biN1 = 0;
        biN2 = 0;
        biN3 = 0;
        biN4 = 0;
        biN5 = 0;
        biN6 = 0;
        biN7 = 0;
        biN8 = 0;
        hexString = hexString.replaceAll(" ", "");
        if (hexString.length() != 8) {
            c.feedback.setText("Inappropriate hex number, please try again.");
        }
        // hex to int

        try {
            biN1 = Integer.parseInt(hexString.substring(0, 1), 16);
            biN2 = Integer.parseInt(hexString.substring(1, 2), 16);
            biN3 = Integer.parseInt(hexString.substring(2, 3), 16);
            biN4 = Integer.parseInt(hexString.substring(3, 4), 16);
            biN5 = Integer.parseInt(hexString.substring(4, 5), 16);
            biN6 = Integer.parseInt(hexString.substring(5, 6), 16);
            biN7 = Integer.parseInt(hexString.substring(6, 7), 16);
            biN8 = Integer.parseInt(hexString.substring(7, 8), 16);

        } catch (Exception e) {
            c.feedback.setText("Inappropriate hex number, please try again.");

        }
        // int to binary
        try {

            for (int i = 0; i < 4; ++i) {
                bi1 = (biN1 & 1) + bi1;
                bi2 = (biN2 & 1) + bi2;
                bi3 = (biN3 & 1) + bi3;
                bi4 = (biN4 & 1) + bi4;
                bi5 = (biN5 & 1) + bi5;
                bi6 = (biN6 & 1) + bi6;
                bi7 = (biN7 & 1) + bi7;
                bi8 = (biN8 & 1) + bi8;

                biN1 = (short) (biN1 >> 1);
                biN2 = (short) (biN2 >> 1);
                biN3 = (short) (biN3 >> 1);
                biN4 = (short) (biN4 >> 1);
                biN5 = (short) (biN5 >> 1);
                biN6 = (short) (biN6 >> 1);
                biN7 = (short) (biN7 >> 1);
                biN8 = (short) (biN8 >> 1);

            }
        } catch (Exception e) {
            c.feedback.setText("Inappropriate hex number, please try again.");
        }

        String binary = "";
        binary = bi1 + bi2 + bi3 + bi4 + bi5 + bi6 + bi7 + bi8;
        if (binary.length() != 32) {
            c.feedback.setText("Inappropriate hex number, please try again.");
        }

        // binary to ARM

        String arm = "";

        if (binary.substring(7, 11).equals("0000"))
            arm += "AND ";
        else if (binary.substring(7, 11).equals("0001"))
            arm += "EOR ";
        else if (binary.substring(7, 11).equals("0010"))
            arm += "SUB ";
        else if (binary.substring(7, 11).equals("0011"))
            arm += "RSB ";
        else if (binary.substring(7, 11).equals("0100"))
            arm += "ADD ";
        else if (binary.substring(7, 11).equals("0101"))
            arm += "ADC ";
        else if (binary.substring(7, 11).equals("0110"))
            arm += "SBC ";
        else if (binary.substring(7, 11).equals("0111"))
            arm += "RSC ";
        else if (binary.substring(7, 11).equals("1000"))
            arm += "TST ";
        else if (binary.substring(7, 11).equals("1001"))
            arm += "TEQ ";
        else if (binary.substring(7, 11).equals("1010"))
            arm += "CMP ";
        else if (binary.substring(7, 11).equals("1011"))
            arm += "CMN ";
        else if (binary.substring(7, 11).equals("1100"))
            arm += "ORR ";
        else if (binary.substring(7, 11).equals("1101"))
            arm += "MOV ";
        else if (binary.substring(7, 11).equals("1110"))
            arm += "BIC ";
        else if (binary.substring(7, 11).equals("1111"))
            arm += "MVN ";

        try {
            r0 = Integer.parseInt(binary.substring(16, 20), 2);
            r1 = Integer.parseInt(binary.substring(12, 16), 2);
            r2 = Integer.parseInt(binary.substring(28, 32), 2);
            // System.out.println(" testing binary " + binary);
        } catch (Exception e) {
            c.feedback.setText("Inappropriate hex number, please try again.");
        }
        arm = arm + "r" + r0 + "," + "r" + r1 + "," + "r" + r2;

        if (c.feedback.getText().equals("Errors Feedback")) {
            c.arm.setText(arm);
            c.bi.setText(binary);

        }

    }
}