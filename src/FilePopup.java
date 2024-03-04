import javax.swing.*;
public class FilePopup {
    static public String popup() {

        JTextField fileNameField = new JTextField();


        Object[] message = {
                "Enter program file name (ex. tri):", fileNameField
        };


        int option = JOptionPane.showConfirmDialog(null, message, "File Name Input", JOptionPane.OK_CANCEL_OPTION);


        if (option == JOptionPane.OK_OPTION) {

            return fileNameField.getText();
        }
        return "";
    }

}
