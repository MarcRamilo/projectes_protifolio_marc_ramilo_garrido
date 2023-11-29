/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Usuari;

/**
 *
 * @author Marc
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        daoTest test = new daoTest();
        
        List<Usuari> persones = new ArrayList<Usuari>();
        
        persones = test.selectAll();
        
        persones.toString();
        for (int i = 0; i < persones.size(); i++) {
            System.out.println(persones.get(i).toString());
            
        }
        
    }
    
}
