/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class Buffer {   
    
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> text = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String mLine;
            while ((mLine = (String)reader.readLine()) != null) {
                text.add(mLine);
            }
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return text;
    }
}
