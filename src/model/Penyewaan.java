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
public class Penyewaan implements Serializable{
    private StrategiPenyewaan jenisPenyewaan;
    private Mobil mobil;
    private double totalBiaya;
    
    //Add Constructor Here

    public Penyewaan(StrategiPenyewaan jenisPenyewaan, Mobil mobil) {
        this.jenisPenyewaan = jenisPenyewaan;
        this.mobil = mobil;
        totalBiaya = jenisPenyewaan.kalkulasiBiaya(mobil.getHarga());
    }
    

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }
    
    
    
}
