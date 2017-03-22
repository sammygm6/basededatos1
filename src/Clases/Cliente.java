/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Miguel A. Ardon E
 */
public class Cliente {
    int cliente;
    String  telefono; 
    String direccion;
    String nombre;
    Date fecha_iniContrato;
    String nombre_Empresa;

    public Cliente() {
    }

    public Cliente(int cliente, String telefono, String direccion, String nombre, Date fecha_iniContrato, String nombre_Empresa) {
        this.cliente = cliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.fecha_iniContrato = fecha_iniContrato;
        this.nombre_Empresa = nombre_Empresa;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_iniContrato() {
        return fecha_iniContrato;
    }

    public void setFecha_iniContrato(Date fecha_iniContrato) {
        this.fecha_iniContrato = fecha_iniContrato;
    }

    public String getNombre_Empresa() {
        return nombre_Empresa;
    }

    public void setNombre_Empresa(String nombre_Empresa) {
        this.nombre_Empresa = nombre_Empresa;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente=" + cliente + ", telefono=" + telefono + ", direccion=" + direccion + ", nombre=" + nombre + ", fecha_iniContrato=" + fecha_iniContrato + ", nombre_Empresa=" + nombre_Empresa + '}';
    }
}
