/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Mobil implements Serializable {
    private String nama;
    private long harga;
    private Kategori kategori;

    public Mobil(String nama,Kategori kategori , long harga) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
    
    
}
