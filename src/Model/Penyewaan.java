/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Penyewaan {
    private StrategiPenyewaan jenisPenyewaan;
    private Mobil mobil;
    private double totalBiaya;
    
    //Add Constructor Here

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
