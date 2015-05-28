/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.code.bornevia.puzzleA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Satriya
 */
public class CustomersCSV {
    private Map<String, Properties> customers = new HashMap<>();
    private final String path, regex;
    
    public CustomersCSV (String path, String regex) {
        this.path = path;
        this.regex = regex;
        this.rebuild(path, regex);
    }
    
    private void rebuild(String path, String regex) {     
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while (line != null) {
                if (this.isEntry(line)) {
                    String[] arr = line.split(regex);
                    String[] entries = new String[4];

                    for (int i = 0; i < entries.length; i++) {
                        entries[i] = i < arr.length ? arr[i] : "";
                    }

                    if (this.customers.isEmpty() || !this.customers.containsKey(entries[0])) {
                        this.updateDict(entries);
                    } else {
                        Properties properties = this.customers.get(entries[0]);
                        entries[1] = properties.getEmail().isEmpty() ? entries[1] : properties.getEmail();
                        entries[2] = properties.getFacebook().isEmpty() ? entries[2] : properties.getFacebook();
                        entries[3] = properties.getTwitter().isEmpty() ? entries[3] : properties.getTwitter();
                        this.updateDict(entries);
                    }
                }
                line = br.readLine();
            }
            
            customers = new TreeMap<>(customers);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomersCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomersCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean isEntry(String line) {
        if (line.contains("*****")) {
            return false;
        } else 
            return !line.contains("Name,");
    }
    
    private void updateDict(String[] entries) {
        this.customers.put(
            entries[0], 
            new Properties.Builder()
                .email(entries[1])
                .facebook(entries[2])
                .twitter(entries[3]).build()
        );
    }
    
    public String getCustomers() {
        StringBuilder sb = new StringBuilder();
                
        for (Map.Entry<String, Properties> e : this.customers.entrySet()) {
            sb.append(e.getKey());
            sb.append(regex);
            Properties p = e.getValue();
            sb.append(p.getEmail());
            sb.append(regex);
            sb.append(p.getFacebook());
            sb.append(regex);
            sb.append(p.getTwitter());
            sb.append(System.lineSeparator());
        }
        
        return sb.toString();
    }
}