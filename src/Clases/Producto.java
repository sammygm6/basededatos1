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
public class Producto {
    int id_Produto;
    double cantidad;
    String nombre;
    double precio;

    public Producto() {
    }

    public Producto(int id_Produto, double cantidad, String nombre, double precio) {
        this.id_Produto = id_Produto;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_Produto=" + id_Produto + ", cantidad=" + cantidad + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
}
