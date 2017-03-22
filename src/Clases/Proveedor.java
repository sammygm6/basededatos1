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
public class Proveedor {
    int id_Proveedor;
    String direccion;
    String telefono;
    String nombre;
    String pais;
    String email;

    public Proveedor() {
    }

    public Proveedor(int id_Proveedor, String direccion, String telefono, String nombre, String pais, String email) {
        this.id_Proveedor = id_Proveedor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.pais = pais;
        this.email = email;
    }

    public int getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(int id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_Proveedor=" + id_Proveedor + ", direccion=" + direccion + ", telefono=" + telefono + ", nombre=" + nombre + ", pais=" + pais + ", email=" + email + '}';
    }
}
