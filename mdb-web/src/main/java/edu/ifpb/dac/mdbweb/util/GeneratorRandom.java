/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.util;

import java.util.Random;

/**
 *
 * @author romulo
 */
public class GeneratorRandom {
    
    /**
     * 
     * @param limiteSuperior
     * @return numero entre 0 e limiteSuperior - 1
     */
    public static int generateRandomIntInRange(int limiteSuperior){
        Random gerador = new Random();
        return gerador.nextInt(limiteSuperior);
    }
    
}
