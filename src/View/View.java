/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public interface View {
    public void showMessage(String message);
    public void addListener(ActionListener l);
}
