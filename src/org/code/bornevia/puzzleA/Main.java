package org.code.bornevia.puzzleA;

import java.io.File;
import javax.swing.JFileChooser;

public class Main {
    public static void main(String args[]) {
        JFileChooser fileChooser = new JFileChooser();
        int result;
        File file = null;
        
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        result = fileChooser.showOpenDialog(fileChooser);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        
        CustomersCSV customers = new CustomersCSV(file.getAbsolutePath(), ",");
        StringBuilder sb = new StringBuilder();
        sb.append("/************************** customers_merged.csv ***************************/");
        sb.append(System.lineSeparator());
        sb.append("/****************************** Start ******************************/");
        sb.append(System.lineSeparator());
        sb.append("Name,Email,Facebook,Twitter");
        sb.append(System.lineSeparator());
        sb.append(customers.getCustomers());
        sb.append("/******************************* End *******************************/");
        System.out.println(sb);
    }
}