/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Sammy
 */
public class traileta {
    int numero_placa;
    int tmMax;//toneladas metricas maxima

    public traileta() {
    }

    public traileta(int numero_placa, int tmMax) {
        this.numero_placa = numero_placa;
        this.tmMax = tmMax;
    }

    public int getNumero_placa() {
        return numero_placa;
    }

    public void setNumero_placa(int numero_placa) {
        this.numero_placa = numero_placa;
    }

    public int getTmMax() {
        return tmMax;
    }

    public void setTmMax(int tmMax) {
        this.tmMax = tmMax;
    }
    
}
