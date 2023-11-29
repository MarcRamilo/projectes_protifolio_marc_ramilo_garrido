/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Marc
 */
public class Restaurant {
    
    int numRestaurant;
    String nomRestaurant;
    int quantitatProducte;

    public Restaurant(int numRestaurant, String nomRestaurant) {
        this.numRestaurant = numRestaurant;
        this.nomRestaurant = nomRestaurant;
    }

    public int getNumRestaurant() {
        return numRestaurant;
    }

    public void setNumRestaurant(int numRestaurant) {
        this.numRestaurant = numRestaurant;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public int getQuantitatProducte() {
        return quantitatProducte;
    }

    public void setQuantitatProducte(int quantitatProducte) {
        this.quantitatProducte = quantitatProducte;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "numRestaurant=" + numRestaurant + ", nomRestaurant=" + nomRestaurant + '}';
    }

    public String toName() {
        return getNomRestaurant();
    }
    
  
    
}
