package org.code.bornevia.puzzleB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JFileChooser;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, 
            IOException {
        JFileChooser fileChooser = new JFileChooser();
        int output;
        File file = null;
        int size = 1;
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        output = fileChooser.showOpenDialog(fileChooser);
        
        if (output == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line = br.readLine();
            
            while (line != null) {
                if (isEntry(line)) {
                    size = Integer.valueOf(line);
                }
                line = br.readLine();
            }
        }
        
        if (size % 2 == 0) {
            int max = Integer.valueOf(new String(new char[size]).replace("\0", "9"));
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <= max; i++) {
                MagicNumber mn = new MagicNumber(i, size);
                if (mn.isMagicNumber()) {
                    sb.append(mn.getNumber());
                    sb.append(",");
                }
            }

            String[] result = sb.toString().split(",");
            sb.delete(0, sb.length());
            if (result.length == 1) {
                sb.append(result[0]);
            } else {
                for (int i = 0; i < result.length - 1; i++) {
                    sb.append(result[i]);
                    sb.append(", ");
                }
                sb.append("dan ");
                sb.append(result[result.length - 1]);
            }
            
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setSelectedFile(new File("output.txt"));
            output = fileChooser.showSaveDialog(fileChooser);

            if (output == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            }
            
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file.getAbsoluteFile()), "utf-8"))) {
                writer.write("/*************************** output.txt ****************************/");
                writer.write(System.lineSeparator());
                writer.write("/****************************** Start ******************************/");
                writer.write(System.lineSeparator());
                writer.write(sb.toString());
                writer.write(System.lineSeparator());
                writer.write("/******************************* End *******************************/");
            }
            
            System.out.println(sb.toString());
        } else {
            System.out.println("Invalid input size!!");
        }
    }
    
    private static boolean isEntry(String line) {
        return line.matches("^[0-9]+$");
    }
}