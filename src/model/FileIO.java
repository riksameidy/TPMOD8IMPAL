/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class FileIO {
    
    public void saveObject(Object o, String filename){
        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(f);
            obj.writeObject(o);
            obj.flush();
            obj.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public Object loadObject(String filename){
        try {
            FileInputStream f = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(f);
            Object b = obj.readObject();
            obj.close();
            return b;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
}
