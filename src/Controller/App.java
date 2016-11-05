/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileIO;
import Model.Kategori;
import Model.Member;
import Model.Mobil;
import Model.StrategiPenyewaan;
import View.LoginView;
import View.RegistrasiView;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class App implements ActionListener{
    
    private ArrayList<Member> member;
    private ArrayList<Kategori> kategori;
    private ArrayList<Mobil> listMobil;
    private FileIO database;
    
    private View view;
    
    public App(){
        
        //to avoid null Pointer
        member = new ArrayList<>();
        kategori = new ArrayList<>();
        listMobil = new ArrayList<>();
        //
        goToLoginMenu();         
    }
    
    @Override
    public void actionPerformed(ActionEvent en) {
        Object e = en.getSource();
        if(view instanceof LoginView){
            LoginView loginview = (LoginView) view;
            if(e.equals(loginview.getBtnLogin())){
                String username = loginview.getTfUsername();
                String password = loginview.getTfPassword();
                if(validateLogin(username, password)){
                    loginview.setVisible(false);
                    loginview.dispose();
                    goToMenuUtama();
                }
                else{
                    JOptionPane.showMessageDialog(loginview, "Username atau Password salah");
                }
            }
            else if(e.equals(loginview.getBtnRegister())){
                loginview.setVisible(false);
                loginview.dispose();
                goToRegisterMenu();
            }
        }
        
        else if(view instanceof RegistrasiView){
            RegistrasiView registrasiView = (RegistrasiView) view;
        }
    }
    
    public void createAkun(String nama, String username , String password){
        //TO DO HERE
        member.add(new Member(nama, username, password, (member.size()+1)));    
    }
    
    public void addKategori(String nama , int jumlahKursi){
        //TO DO HERE
        kategori.add(new Kategori(nama, jumlahKursi));
    }
    
    public void addMobil(String nama , long harga , Kategori k){
        //TO DO HERE
        listMobil.add(new Mobil(nama, harga, k));
        
    }
    
    public void loadMobil(){
        //TO DO HERE
    }
    
    public void saveMobil(){
        //TO DO HERE
    }
    
    public void loadKategori(){
        //TO DO HERE
    }
    
    public void saveKategori(){
        //TO DO HERE
    }
    
    public boolean validateLogin(String username , String password){
        for(Member m: member){
            if(m.getUsername().equals(username)&& m.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    
    public void goToLoginMenu(){
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        loginView.addListener(this);
        view = loginView;
 
    }
    
    public void goToRegisterMenu(){
        RegistrasiView registrasiView = new RegistrasiView();
        registrasiView.setVisible(true);
        //registrasiView.addListener(this);
        view = registrasiView;
    }
    
    public void goToMenuUtama(){
        
    }

    
}
