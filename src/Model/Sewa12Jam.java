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
public class Sewa12Jam implements StrategiPenyewaan{

    @Override
    public double kalkulasiBiaya(long biaya) {
        return 0.90 * biaya;
    }
    
}
