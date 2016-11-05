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
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class App {
    private ArrayList<Member> member;
    private ArrayList<Kategori> kategori;
    private ArrayList<Mobil> listMobil;
    private FileIO database;
    
    public App(){
        
        //to avoid null Pointer
        member = new ArrayList<>();
        kategori = new ArrayList<>();
        listMobil = new ArrayList<>();
        //
              
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
    
}
