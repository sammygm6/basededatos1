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
public class Conductor {
    int id_conductor;
    String direccion;
    String nombre;
    String apellido;
    String localizador;
    double sueldo;
    int edad;
    double viaticos;
    String telefono;
    int id_Producto;

    public Conductor() {
    }

    public Conductor(int id_conductor, String direccion, String nombre,
            String apellido, String localizador, double sueldo, int edad, double viaticos, String telefono, int id_Producto) {
        this.id_conductor = id_conductor;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localizador = localizador;
        this.sueldo = sueldo;
        this.edad = edad;
        this.viaticos = viaticos;
        this.telefono = telefono;
        this.id_Producto = id_Producto;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getViaticos() {
        return viaticos;
    }

    public void setViaticos(double viaticos) {
        this.viaticos = viaticos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    @Override
    public String toString() {
        return "Conductor{" + "id_conductor=" + id_conductor + ", direccion=" + direccion + ", nombre=" + nombre + ", apellido=" + apellido + ", localizador=" + localizador + ", sueldo=" + sueldo + ", edad=" + edad + ", viaticos=" + viaticos + ", telefono=" + telefono + ", id_Producto=" + id_Producto + '}';
    }
}
