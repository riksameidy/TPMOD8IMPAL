/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Member extends Akun{
    
    private int noMember;
    private ArrayList<Penyewaan> penyewaan;

    public Member(String name, String username, String password, int number) {
        super(name, username, password);
        noMember = number;
    }
    
    public int getNoMember() {
        return noMember;
    }

    public void setNoMember(int noMember) {
        this.noMember = noMember;
    }
    
    public void sewaMobil(Penyewaan penyewaan){
        //TO DO HERE
    }
    
    public Penyewaan getPenyewaan(){
        //TO DO HERE
    }
}
