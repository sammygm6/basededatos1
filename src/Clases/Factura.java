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
public class Factura {
    int rtn;
    int numero;
    double tm;
    String fecha;
    double subtotal;
    double total;
    int id_Cliente;

    public Factura() {
    }

    public Factura(int rtn, int numero, double tm, String fecha, double subtotal, double total, int id_Cliente) {
        this.rtn = rtn;
        this.numero = numero;
        this.tm = tm;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.id_Cliente = id_Cliente;
    }

    public int getRtn() {
        return rtn;
    }

    public void setRtn(int rtn) {
        this.rtn = rtn;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTm() {
        return tm;
    }

    public void setTm(double tm) {
        this.tm = tm;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    
    @Override
    public String toString() {
        return "Factura{" + "rtn=" + rtn + ", numero=" + numero + ", tm=" + tm + ", fecha=" + fecha + ", subtotal=" + subtotal + ", total=" + total + ", id_Cliente=" + id_Cliente + '}';
    }
    
}
