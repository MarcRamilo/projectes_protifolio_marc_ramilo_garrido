/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Marc
 */
public class adresa {

    String num;
    String carrer;
    String ciutat;

    public adresa(String num, String carrer, String ciutat) {
        this.num = num;
        this.carrer = carrer;
        this.ciutat = ciutat;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    @Override
    public String toString() {
        return "adresa{" + "num=" + num + ", carrer=" + carrer + ", ciutat=" + ciutat + '}';
    }

}
