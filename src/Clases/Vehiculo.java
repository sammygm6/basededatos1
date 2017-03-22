/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Miguel A. Ardon E
 */
public class Vehiculo {
    int numero_placa;
    String año;
    String marca;
    String tipo_combustible;
    String modelo;
    String color;
    double capa_combustible;
    double kilomet;
    int id_conductor;
    int id_Producto;

    public Vehiculo() {
    }

    public Vehiculo(int numero_placa, String año, String marca, String tipo_combustible, String modelo, String color, double capa_combustible, double kilomet, int id_conductor, int id_Producto) {
        this.numero_placa = numero_placa;
        this.año = año;
        this.marca = marca;
        this.tipo_combustible = tipo_combustible;
        this.modelo = modelo;
        this.color = color;
        this.capa_combustible = capa_combustible;
        this.kilomet = kilomet;
        this.id_conductor = id_conductor;
        this.id_Producto = id_Producto;
    }

    public int getNumero_placa() {
        return numero_placa;
    }

    public void setNumero_placa(int numero_placa) {
        this.numero_placa = numero_placa;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCapa_combustible() {
        return capa_combustible;
    }

    public void setCapa_combustible(double capa_combustible) {
        this.capa_combustible = capa_combustible;
    }

    public double getKilomet() {
        return kilomet;
    }

    public void setKilomet(double kilomet) {
        this.kilomet = kilomet;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "numero_placa=" + numero_placa + ", a\u00f1o=" + año + ", marca=" + marca + ", tipo_combustible=" + tipo_combustible + ", modelo=" + modelo + ", color=" + color + ", capa_combustible=" + capa_combustible + ", kilomet=" + kilomet + ", id_conductor=" + id_conductor + ", id_Producto=" + id_Producto + '}';
    }
    
    
}
