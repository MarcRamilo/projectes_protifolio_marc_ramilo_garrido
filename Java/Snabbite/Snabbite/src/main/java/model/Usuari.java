/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Marc
 */
public class Usuari {
     String nom,cognom,telefon,contrasenya;
     int id;
     adresa adresa;

    public Usuari(String nom, String cognom, String telefon, String contrasenya, int id, adresa adresa) {
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
        this.contrasenya = contrasenya;
        this.id = id;
        this.adresa = adresa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Usuari{" + "nom=" + nom + ", cognom=" + cognom + ", telefon=" + telefon + ", contrasenya=" + contrasenya + ", id=" + id + ", adresa=" + adresa + '}';
    }
     
     

    

}
