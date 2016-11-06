/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Member extends Akun implements Serializable{
    
    private String noMember;
    private ArrayList<Penyewaan> penyewaan;

    public Member(String name, String username, String password, int number) {
        super(name, username, password);
        noMember = "MEM-" + number;
        penyewaan = new ArrayList<>();
    }
    
    public String getNoMember() {
        return noMember;
    }

    public void setNoMember(String noMember) {
        this.noMember = noMember;
    }
    
    public void sewaMobil(Penyewaan penyewaan){
        //TO DO HERE
        this.penyewaan.add(penyewaan);
    }
    
    public Penyewaan getPenyewaan(int i){
        //TO DO HERE
        return penyewaan.get(i);
    }
    
    public ArrayList<Penyewaan> getListPenyewaans(){
        return penyewaan;
    }
}
