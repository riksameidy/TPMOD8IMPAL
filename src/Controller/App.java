/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.FileIO;
import model.Kategori;
import model.Member;
import model.Mobil;
import model.Penyewaan;
import model.Sewa12Jam;
import model.Sewa1Minggu;
import model.Sewa24Jam;
import model.Sewa6Jam;
import model.StrategiPenyewaan;
import View.LoginView;
import View.MenuPenyewaanView;
import View.MenuUtamaView;
import View.RegistrasiView;
import View.RiwayatPenyewaanView;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class App implements ActionListener{
    
    private ArrayList<Member> member;
    private ArrayList<Kategori> kategori;
    private ArrayList<Mobil> listMobil;
    private FileIO database;
    private Member currentMember;
    
    private View view;
    
    public App(){
        
        //to avoid null Pointer
        database = new FileIO();
        //
        loadMember();
        loadKategori();
        loadMobil();
        
        if(member==null){
            member = new ArrayList<>();
        }
        
        if(kategori==null){
            kategori = new ArrayList<>();
        }
        
        if(listMobil==null){
            listMobil = new ArrayList<>();
        }
        
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
                    loginview.showMessage("Login berhasil");
                    loginview.setVisible(false);
                    loginview.dispose();
                    goToMenuUtama();
                }
                else{
                    loginview.showMessage("Username atau Password Salah");
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
            if(e.equals(registrasiView.getBtnRegister())){
                String nama = registrasiView.getTfNama();
                String username = registrasiView.getTfUsername();
                String password = registrasiView.getTfPassword();
                String confirmPassword = registrasiView.getTfConfirmPassword();
                
                if(password.equals(confirmPassword)){
                    createAkun(nama, username, password);
                    registrasiView.showMessage("Registrasi Berhasil");
                    saveMember();
                    registrasiView.setVisible(false);
                    registrasiView.dispose();
                    goToLoginMenu();
                    
                }
                else
                    registrasiView.showMessage("Password mismatch");
            }
            else if(e.equals(registrasiView.getBtnKembali())){
                registrasiView.setVisible(false);
                registrasiView.dispose();
                goToLoginMenu();
            }
            
        }
        
        else if(view instanceof MenuUtamaView){
            MenuUtamaView menuUtamaView = (MenuUtamaView) view;
            if(e.equals(menuUtamaView.getBtnPenyewaan())){
                menuUtamaView.setVisible(false);
                menuUtamaView.dispose();
                goToMenuPenyewaan();
            }
            
            else if(e.equals(menuUtamaView.getBtnLihatRiwayatPenyewaan())){
                menuUtamaView.setVisible(false);
                menuUtamaView.dispose();
                goToRiwayatPenyewaan();
            }
            
            else if(e.equals(menuUtamaView.getBtnLogout())){
                menuUtamaView.setVisible(false);
                menuUtamaView.dispose();
                currentMember = null;
                goToLoginMenu();
                
            }
        }
        
        else if(view instanceof MenuPenyewaanView){
            MenuPenyewaanView menuPenyewaanView = (MenuPenyewaanView) view;
            if(e.equals(menuPenyewaanView.getBtnSewa())){
                
                int selectedRow = menuPenyewaanView.getTableSewa().getSelectedRow();
                if(menuPenyewaanView.getRd6().isSelected()){
                    Penyewaan p = new Penyewaan(new Sewa6Jam(), listMobil.get(selectedRow));
                    currentMember.sewaMobil(p);
                    saveMember();
                }
                
                else if(menuPenyewaanView.getRd12().isSelected()){
                    Penyewaan p = new Penyewaan(new Sewa12Jam(), listMobil.get(selectedRow));
                    currentMember.sewaMobil(p);
                    saveMember();
                }
                else if(menuPenyewaanView.getRd24().isSelected()){
                    Penyewaan p = new Penyewaan(new Sewa24Jam(), listMobil.get(selectedRow));
                    currentMember.sewaMobil(p);
                    saveMember();
                }
                else if(menuPenyewaanView.getRd1week().isSelected()){
                    Penyewaan p = new Penyewaan(new Sewa1Minggu(), listMobil.get(selectedRow));
                    currentMember.sewaMobil(p);
                    saveMember();
                }
                menuPenyewaanView.showMessage("Penyewaan Berhasil");
                menuPenyewaanView.setVisible(false);
                menuPenyewaanView.dispose();
                goToRiwayatPenyewaan();
            }
            else if(e.equals(menuPenyewaanView.getBtnKembali())){
                menuPenyewaanView.setVisible(false);
                menuPenyewaanView.dispose();
                goToMenuUtama();
            }
            
        }
        
        else if(view instanceof RiwayatPenyewaanView){
            RiwayatPenyewaanView riwayatPenyewaanView = (RiwayatPenyewaanView) view;
            if(e.equals(riwayatPenyewaanView.getBtnKembali())){
                riwayatPenyewaanView.setVisible(false);
                riwayatPenyewaanView.dispose();
                goToMenuUtama();
            }
            
        }
    }
    
    public void createAkun(String nama, String username , String password){
        member.add(new Member(nama, username, password, (member.size()+1)));    
    }
    
    public void addKategori(String nama , int jumlahKursi){
        kategori.add(new Kategori(nama, jumlahKursi));
    }
    
    public void addMobil(String nama , long harga , Kategori k){  
        listMobil.add(new Mobil(nama, k, harga));   
    }
    
    public void loadMobil(){  
        listMobil = (ArrayList<Mobil>) database.loadObject("mobil.dat");
    }
    
    public void saveMobil(){
        database.saveObject( listMobil, "mobil.dat"); 
    }
    
    public void loadKategori(){
        kategori = (ArrayList<Kategori>) database.loadObject("kategori.dat");
    }
    
    public void saveKategori(){
       database.saveObject(kategori, "kategori.dat");
    }
    
    public void saveMember(){
        database.saveObject(member, "member.dat");
    }
    
    public void loadMember(){
        member =(ArrayList<Member>) database.loadObject("member.dat");
    }
    
    public boolean validateLogin(String username , String password){
        for(Member m: member){
            if(m.getUsername().equals(username)&& m.getPassword().equals(password)){
                currentMember = m;
                return true;
            }
        }
        return false;
    }
    
    private void goToLoginMenu(){
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        loginView.addListener(this);
        view = loginView;
 
    }
    
    private void goToRegisterMenu(){
        RegistrasiView registrasiView = new RegistrasiView();
        registrasiView.setVisible(true);
        registrasiView.addListener(this);
        view = registrasiView;
    }
    
    private void goToMenuUtama(){
        MenuUtamaView menuUtamaView = new MenuUtamaView();
        menuUtamaView.setVisible(true);
        menuUtamaView.addListener(this);
        view = menuUtamaView;
    }
    
    private void goToMenuPenyewaan(){
        MenuPenyewaanView menuPenyewaanView = new MenuPenyewaanView();
        menuPenyewaanView.initDataTabelSewa(listMobil);
        menuPenyewaanView.setVisible(true);
        menuPenyewaanView.addListener(this);
        view = menuPenyewaanView;
    }
    
    private void goToRiwayatPenyewaan(){
        RiwayatPenyewaanView riwayatPenyewaanView = new RiwayatPenyewaanView();
        riwayatPenyewaanView.initDataTable(currentMember);
        riwayatPenyewaanView.setVisible(true);
        riwayatPenyewaanView.addListener(this);
        view = riwayatPenyewaanView;
    }

    
}
