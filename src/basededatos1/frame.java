/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos1;

import BaseDatos.Conn;
import Clases.Cliente;
import Clases.Conductor;
import Clases.Factura;
import Clases.Producto;
import Clases.Proveedor;
import Clases.Vehiculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy
 */
public class frame extends javax.swing.JFrame {

    /**
     * Creates new form frame
     */
    public frame() {
        initComponents();
        this.setTitle("Transporte Carmen");
        //tomar los valores de la tabla proveedor
        Conn cn = new Conn();// Obtiene la conexion
        ResultSet rs = null;
        Statement stmt = null;
        int i = 0;
        /*Fin declaracion de variables*/
        try {
            /*Crear la conexion a la base de datos */
            cn.mkConnRe();
            if (cn == null) {
                JOptionPane.showMessageDialog(rootPane, "Error de Conexion a la Base de Datos ");
            } else {
                stmt = cn.conn.createStatement();
                rs = stmt.executeQuery("select idProveedor, direccion, telefono, nombre, pais, email \n"
                        + "FROM transportecarmen.proveedor c \n"
                        + ";");
                /*Carga los datos de la base de datos a las propiedades de la clase*/
                while (rs.next()) {
                    Proveedor p = new Proveedor(Integer.parseInt(rs.getString("idProveedor")),
                            rs.getString("direccion"), rs.getString("telefono"), rs.getString("nombre"),
                            rs.getString("pais"), rs.getString("email"));
                    proveedores.add(p);
                    i++;
                }
                if (i == 0) {
                    //JOptionPane.showMessageDialog(rootPane, "Error la consulta no devolvio registros");
                } else {
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex + "1");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (cn.conn != null) {
                    cn.conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e + "2");
            }
        }
        //toma los valores de la tabla de prodcto
        cn = new Conn();// Obtiene la conexion
        rs = null;
        stmt = null;
        i = 0;
        /*Fin declaracion de variables*/
        try {
            /*Crear la conexion a la base de datos */
            cn.mkConnRe();
            if (cn == null) {
                JOptionPane.showMessageDialog(rootPane, "Error de Conexion a la Base de Datos ");
            } else {
                stmt = cn.conn.createStatement();
                rs = stmt.executeQuery("select idProducto, cantidad, nombre, precio, Proveedor_idProveedor \n"
                        + "FROM transportecarmen.producto c \n"
                        + ";");
                /*Carga los datos de la base de datos a las propiedades de la clase*/
                while (rs.next()) {
                    Producto pro = new Producto(Integer.parseInt(rs.getString("idProducto")),
                            Double.parseDouble(rs.getString("cantidad")), rs.getString("nombre"),
                            Double.parseDouble(rs.getString("precio")),
                            Integer.parseInt(rs.getString("Proveedor_idProveedor")));
                    productos.add(pro);
                    i++;
                }
                if (i == 0) {
                    //JOptionPane.showMessageDialog(rootPane, "Error la consulta no devolvio registros");
                } else {
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex + "1");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (cn.conn != null) {
                    cn.conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e + "2");
            }
        }

        //toma los valores de la tabla de cliente
        cn = new Conn();// Obtiene la conexion
        rs = null;
        stmt = null;
        i = 0;
        /*Fin declaracion de variables*/
        try {
            /*Crear la conexion a la base de datos */
            cn.mkConnRe();
            if (cn == null) {
                JOptionPane.showMessageDialog(rootPane, "Error de Conexion a la Base de Datos ");
            } else {
                stmt = cn.conn.createStatement();
                rs = stmt.executeQuery("select idCliente, telefono, direccion, nombrecontacto, fechainiciocontrato, nombreempresa \n"
                        + "FROM transportecarmen.cliente c \n"
                        + ";");
                /*Carga los datos de la base de datos a las propiedades de la clase*/
                while (rs.next()) {
                    Cliente cli = new Cliente(rs.getInt("idCliente"),
                            rs.getString("telefono"),
                            rs.getString("direccion"),
                            rs.getString("nombrecontacto"),
                            rs.getDate("fechainiciocontrato"),
                            rs.getString("nombreempresa"));
                    clientes.add(cli);
                    i++;
                }
                if (i == 0) {
                    //JOptionPane.showMessageDialog(rootPane, "Error la consulta no devolvio registros");
                } else {
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex + "1");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (cn.conn != null) {
                    cn.conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e + "2");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_Proveedor = new javax.swing.JDialog();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jp_proveedor_editar = new javax.swing.JPanel();
        jl_proveedor_editar_id = new javax.swing.JLabel();
        tf_editar_proveedor_id = new javax.swing.JTextField();
        jl_proveedor_editar_nombre = new javax.swing.JLabel();
        jl_proveedor_editar_direccion = new javax.swing.JLabel();
        jl_proveedor_editar_pais = new javax.swing.JLabel();
        jl_proveedor_editar_telefono = new javax.swing.JLabel();
        jl_proveedor_editar_correo = new javax.swing.JLabel();
        tf_editar_proveedor_correo = new javax.swing.JTextField();
        tf_editar_proveedor_pais = new javax.swing.JTextField();
        tf_editar_proveedor_direccion = new javax.swing.JTextField();
        tf_editar_proveedor_nombre = new javax.swing.JTextField();
        tf_editar_proveedor_telefono = new javax.swing.JFormattedTextField();
        jButton7 = new javax.swing.JButton();
        cb_editar_proveedor = new javax.swing.JComboBox<>();
<<<<<<< HEAD
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_proveedores = new javax.swing.JTable();
        jLabel167 = new javax.swing.JLabel();
=======
        jl_proveedor_editar_proveedor = new javax.swing.JLabel();
        jl_proveedor_editar_fondo = new javax.swing.JLabel();
        jp_proveedor_ver = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_proveedores = new javax.swing.JTable();
        jl_proveedor_ver_seleccionar = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_borrar_proveedor = new javax.swing.JComboBox<>();
        jButton24 = new javax.swing.JButton();
        jl_proveedor_ver_fondo = new javax.swing.JLabel();
        jp_proveedor_nuevo = new javax.swing.JPanel();
        jl_proveedor_nuevo_id = new javax.swing.JLabel();
        jl_proveedor_nuevo_nombre = new javax.swing.JLabel();
        jl_proveedor_nuevo_direccion = new javax.swing.JLabel();
        jl_proveedor_nuevo_pais = new javax.swing.JLabel();
        jl_proveedor_nuevo_telefono = new javax.swing.JLabel();
        jl_proveedor_nuevo_correo = new javax.swing.JLabel();
        tf_nuevo_proveedor_id = new javax.swing.JTextField();
        tf_nuevo_proveedor_nombre = new javax.swing.JTextField();
        tf_nuevo_proveedor_direccion = new javax.swing.JTextField();
        tf_nuevo_proveedor_pais = new javax.swing.JTextField();
        tf_nuevo_proveedor_correo = new javax.swing.JTextField();
        tf_nuevo_proveedor_telefono = new javax.swing.JFormattedTextField();
        jButton9 = new javax.swing.JButton();
        jl_proveedor_nuevo_fondo = new javax.swing.JLabel();
        jl_proveedor_subtitulo = new javax.swing.JLabel();
        jl_proveedor_titulo = new javax.swing.JLabel();
        jl_proveedor_imagen_fondo = new javax.swing.JLabel();
        jd_Producto = new javax.swing.JDialog();
        jTabbedPane17 = new javax.swing.JTabbedPane();
        jp_producto_editar = new javax.swing.JPanel();
        jl_producto_editar_id = new javax.swing.JLabel();
        tf_editar_Producto_id = new javax.swing.JTextField();
<<<<<<< HEAD
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
=======
        jl_producto_editar_nombre = new javax.swing.JLabel();
        jl_producto_editar_precio = new javax.swing.JLabel();
        jl_producto_editar_proveedor = new javax.swing.JLabel();
        jl_producto_editar_Tcantidad = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_editar_Producto_proveedor = new javax.swing.JComboBox<>();
        tf_editar_Producto_nombre = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        cb_editar_Producto = new javax.swing.JComboBox<>();
        Sp_editar_Producto_Tcantidad = new javax.swing.JSpinner();
        Sp_editar_Producto_precio = new javax.swing.JSpinner();
        jl_producto_editar_seleccionar = new javax.swing.JLabel();
        jl_producto_editar_fondo = new javax.swing.JLabel();
        jp_producto_ver = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();
<<<<<<< HEAD
        jLabel166 = new javax.swing.JLabel();
=======
        jl_producto_ver_seleccionar = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_borrar_producto = new javax.swing.JComboBox<>();
        jButton22 = new javax.swing.JButton();
        jl_producto_ver_fondo = new javax.swing.JLabel();
        jp_producto_nuevo = new javax.swing.JPanel();
        jl_producto_nuevo_id = new javax.swing.JLabel();
        jl_producto_nuevo_nombre = new javax.swing.JLabel();
        tf_nuevo_producto_id = new javax.swing.JTextField();
        tf_nuevo_producto_nombre = new javax.swing.JTextField();
<<<<<<< HEAD
        jLabel184 = new javax.swing.JLabel();
=======
        jl_producto_nuevo_proveedor = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_nuevo_Producto_proveedor = new javax.swing.JComboBox<>();
        jButton23 = new javax.swing.JButton();
        jl_producto_nuevo_precio = new javax.swing.JLabel();
        Sp_nuevo_producto_precio = new javax.swing.JSpinner();
        jl_producto_nuevo_Tcantidad = new javax.swing.JLabel();
        Sp_nuevo_producto_Tcantidad = new javax.swing.JSpinner();
        jl_producto_nuevo_fondo = new javax.swing.JLabel();
        jl_producto_subtitulo = new javax.swing.JLabel();
        jl_producto_titulo = new javax.swing.JLabel();
        jl_producto_imagen_fondo = new javax.swing.JLabel();
        jd_Cliente = new javax.swing.JDialog();
        jTabbedPane18 = new javax.swing.JTabbedPane();
        jp_cliente_editar = new javax.swing.JPanel();
        jl_cliente_editar_id = new javax.swing.JLabel();
        tf_editar_Cliente_id = new javax.swing.JTextField();
        jl_cliente_editar_empresa = new javax.swing.JLabel();
        jl_cliente_editar_fecaInicio = new javax.swing.JLabel();
        jl_cliente_editar_direccion = new javax.swing.JLabel();
        tf_editar_Cliente_direccion = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
<<<<<<< HEAD
        tf_editar_Cliente = new javax.swing.JComboBox<>();
=======
        cb_editar_Cliente = new javax.swing.JComboBox<>();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        Sp_editar_Cliente_fecaInicio = new javax.swing.JSpinner();
        jl_cliente_editar_seleccionar = new javax.swing.JLabel();
        tf_editar_Cliente_empresa = new javax.swing.JTextField();
        tf_editar_Cliente_nombreContacto = new javax.swing.JTextField();
        tf_editar_cliente_telefono = new javax.swing.JFormattedTextField();
        jl_cliente_editar_nombre_de = new javax.swing.JLabel();
        jl_cliente_editar_contacto = new javax.swing.JLabel();
        jl_cliente_editar_telefono = new javax.swing.JLabel();
        jl_cliente_editar_fondo = new javax.swing.JLabel();
        jp_cliente_ver = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_cliente = new javax.swing.JTable();
<<<<<<< HEAD
        jLabel181 = new javax.swing.JLabel();
=======
        jl_cliente_ver_seleccionar = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_borrar_cliente = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        jl_cliente_ver_fondo = new javax.swing.JLabel();
        jp_cliente_nuevo = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jl_cliente_nuevo_id = new javax.swing.JLabel();
        tf_nuevo_Cliente_id = new javax.swing.JTextField();
        jl_cliente_nuevo_telefono = new javax.swing.JLabel();
        jl_cliente_nuevo_empresa = new javax.swing.JLabel();
        jl_cliente_nuevo_fechaInicio = new javax.swing.JLabel();
        jl_cliente_nuevo_direccion = new javax.swing.JLabel();
        tf_nuevo_Cliente_direccion = new javax.swing.JTextField();
        Sp_nuevo_Cliente_fechaInicio = new javax.swing.JSpinner();
        tf_nuevo_Cliente_empresa = new javax.swing.JTextField();
        tf_nuevo_cliente_telefono = new javax.swing.JFormattedTextField();
        jl_cliente_nuevo_nombre_de = new javax.swing.JLabel();
        jl_cliente_nuevo_contacto = new javax.swing.JLabel();
        tf_nuevo_Cliente_nombreContacto = new javax.swing.JTextField();
        jl_cliente_nuevo_fondo = new javax.swing.JLabel();
        jl_cliente_subtitulo = new javax.swing.JLabel();
        jl_cliente_titulo = new javax.swing.JLabel();
        jl_cliente_fondo = new javax.swing.JLabel();
        jd_Vehiculo = new javax.swing.JDialog();
        jTabbedPane19 = new javax.swing.JTabbedPane();
        jp_vehiculo_editar = new javax.swing.JPanel();
        jp_vehiculo_editar_placa = new javax.swing.JLabel();
        tf_editar_vehiculo_placa = new javax.swing.JTextField();
        jp_vehiculo_editar_kilometraje = new javax.swing.JLabel();
        jp_vehiculo_editar_marca = new javax.swing.JLabel();
        jp_vehiculo_editar_anio = new javax.swing.JLabel();
        tf_editar_vehiculo_modelo = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        cb_editar_vehiculo = new javax.swing.JComboBox<>();
        Sp_editar_vehiculo_tm = new javax.swing.JSpinner();
        jLabel205 = new javax.swing.JLabel();
        tf_editar_vehiculo_marca = new javax.swing.JTextField();
        jp_vehiculo_editar_tipoCombu = new javax.swing.JLabel();
        jp_vehiculo_editar_modelo = new javax.swing.JLabel();
        jp_vehiculo_editar_capaCombus = new javax.swing.JLabel();
        jp_vehiculo_editar_color = new javax.swing.JLabel();
        Sp_editar_vehiculo_año = new javax.swing.JSpinner();
        cb_editar_vehiculo_tipoCombu = new javax.swing.JComboBox<>();
        Sp_editar_vehiculo_color = new javax.swing.JTextField();
        jp_vehiculo_editar_localizador = new javax.swing.JLabel();
        tf_editar_vehiculo_localizador = new javax.swing.JTextField();
        Sp_editar_vehiculo_kilometraje = new javax.swing.JSpinner();
        jp_vehiculo_editar_traileta = new javax.swing.JLabel();
        jp_vehiculo_editar_tm = new javax.swing.JLabel();
        Sp_editar_vehiculo_capaCombus = new javax.swing.JSpinner();
        jp_vehiculo_editar_fondo = new javax.swing.JLabel();
        jp_vehiculo_ver = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_vehivculo = new javax.swing.JTable();
<<<<<<< HEAD
        jLabel210 = new javax.swing.JLabel();
=======
        jp_vehiculo_ver_seleccionar_vehiculo = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_borrar_vehiculo = new javax.swing.JComboBox<>();
        jButton29 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_traileta = new javax.swing.JTable();
<<<<<<< HEAD
        jLabel227 = new javax.swing.JLabel();
=======
        jp_vehiculo_ver_seleccionar_traileta = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_borrar_traileta = new javax.swing.JComboBox<>();
        jButton35 = new javax.swing.JButton();
        jp_vehiculo_ver_fondo = new javax.swing.JLabel();
        jp_vehiculo_editar_nuevo = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jp_vehiculo_nuevo_placa = new javax.swing.JLabel();
        tf_nuevo_vehiculo_placa = new javax.swing.JTextField();
        jp_vehiculo_nuevo_kilometraje = new javax.swing.JLabel();
        jp_vehiculo_nuevo_marca = new javax.swing.JLabel();
        jp_vehiculo_nuevo_modelo = new javax.swing.JLabel();
        jp_vehiculo_nuevo_anio = new javax.swing.JLabel();
        jp_vehiculo_nuevo_color = new javax.swing.JLabel();
        tf_nuevo_vehiculo_color = new javax.swing.JTextField();
        Sp_nuevo_vehiculo_año = new javax.swing.JSpinner();
        tf_nuevo_vehiculo_modelo = new javax.swing.JTextField();
        tf_nuevo_vehiculo_marca = new javax.swing.JTextField();
        jp_vehiculo_nuevo_tm = new javax.swing.JLabel();
        jp_vehiculo_nuevo_traileta = new javax.swing.JLabel();
        jp_vehiculo_nuevo_localizador = new javax.swing.JLabel();
        jp_vehiculo_nuevo_tipoCombu = new javax.swing.JLabel();
        jp_vehiculo_nuevo_capaCombu = new javax.swing.JLabel();
        Sp_nuevo_vehiculo_capaCombu = new javax.swing.JSpinner();
        cb_nuevo_vehiculo_tipoCombu = new javax.swing.JComboBox<>();
        tf_nuevo_vehiculo_localizador = new javax.swing.JTextField();
        Sp_nuevo_vehiculo_kilometra = new javax.swing.JSpinner();
        Sp_nuevo_vehiculo_tm = new javax.swing.JSpinner();
        jp_vehiculo_nuevo_fondo = new javax.swing.JLabel();
        jp_vehiculo_subtitulo = new javax.swing.JLabel();
        jp_vehiculo_titulo = new javax.swing.JLabel();
        jp_vehiculo_fondo = new javax.swing.JLabel();
        jd_Conductor = new javax.swing.JDialog();
        jTabbedPane20 = new javax.swing.JTabbedPane();
        jp_conductor_editar = new javax.swing.JPanel();
        jl_conductor_editar_id = new javax.swing.JLabel();
        tf_editar_conductor_id = new javax.swing.JTextField();
        jl_conductor_editar_nombres = new javax.swing.JLabel();
        jl_conductor_editar_apellidos = new javax.swing.JLabel();
        jl_conductor_editar_direccion = new javax.swing.JLabel();
        tf_editar_conductor_direccion = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
<<<<<<< HEAD
        cb_editar_conductor_id = new javax.swing.JComboBox<>();
=======
        cb_editar_conductor = new javax.swing.JComboBox<>();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        Sp_editar_conductor_viaticos = new javax.swing.JSpinner();
        jl_conductor_editar_seleccionar = new javax.swing.JLabel();
        tf_editar_conductor_nombre = new javax.swing.JTextField();
        tf_editar_conductor_apellido = new javax.swing.JTextField();
        tf_editar_conductor_telefono = new javax.swing.JTextField();
        jl_conductor_editar_telefono = new javax.swing.JLabel();
        jl_conductor_editar_edad = new javax.swing.JLabel();
        jl_conductor_editar_vitalicio = new javax.swing.JLabel();
        jl_conductor_editar_salario = new javax.swing.JLabel();
        Sp_editar_conductor_edad = new javax.swing.JSpinner();
        Sp_editar_conductor_salario = new javax.swing.JSpinner();
        jl_conductor_editar_fondo = new javax.swing.JLabel();
        jp_conductor_ver = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_conductor = new javax.swing.JTable();
<<<<<<< HEAD
        jLabel235 = new javax.swing.JLabel();
=======
        jl_conductor_ver_conductor = new javax.swing.JLabel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        cb_borrar_conductor = new javax.swing.JComboBox<>();
        jButton32 = new javax.swing.JButton();
        jl_conductor_ver_fondo = new javax.swing.JLabel();
        jp_conductor_nuevo = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jl_conductor_nuevo_id = new javax.swing.JLabel();
        jl_conductor_nuevo_nombres = new javax.swing.JLabel();
        jl_conductor_nuevo_apellidos = new javax.swing.JLabel();
        jl_conductor_nuevo_edad = new javax.swing.JLabel();
        jl_conductor_nuevo_direccion = new javax.swing.JLabel();
        tf_nuevo_conductor_direccion = new javax.swing.JTextField();
        Sp_nuevo_conductor_edad = new javax.swing.JSpinner();
        tf_nuevo_conductor_apellido = new javax.swing.JTextField();
        tf_nuevo_conductor_nombre = new javax.swing.JTextField();
        tf_nuevo_conductor_id = new javax.swing.JTextField();
        jl_conductor_nuevo_salario = new javax.swing.JLabel();
        jl_conductor_nuevo_viaticos = new javax.swing.JLabel();
        jl_conductor_nuevo_telefono = new javax.swing.JLabel();
        tf_nuevo_conductor_telefono = new javax.swing.JTextField();
        Sp_nuevo_conductor_viaticos = new javax.swing.JSpinner();
        Sp_nuevo_conductor_salario = new javax.swing.JSpinner();
        jl_conductor_nuevo_fondo = new javax.swing.JLabel();
        jl_conductor_subtitulo = new javax.swing.JLabel();
        jl_conductor_titulo = new javax.swing.JLabel();
        jl_conductor_fondo = new javax.swing.JLabel();
        jd_Factura = new javax.swing.JDialog();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jp_factura_editar = new javax.swing.JPanel();
        jl_factura_editar_numero = new javax.swing.JLabel();
        tf_editar_factura_numero = new javax.swing.JTextField();
        jl_factura_editar_tm = new javax.swing.JLabel();
        jl_factura_editar_fecha = new javax.swing.JLabel();
        jl_factura_editar_subtotal = new javax.swing.JLabel();
        jl_factura_editar_total = new javax.swing.JLabel();
        jl_factura_editar_id_cliente = new javax.swing.JLabel();
        tf_editar_factura_id_cliente = new javax.swing.JTextField();
        tf_editar_factura_total = new javax.swing.JTextField();
        tf_editar_factura_tm = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jl_factura_editar_rtn = new javax.swing.JLabel();
        tf_editar_factura_rtn = new javax.swing.JTextField();
        Sp_editar_factura_fechaInicio = new javax.swing.JSpinner();
        tf_editar_factura_subtotal = new javax.swing.JTextField();
        jl_factura_editar_fondo = new javax.swing.JLabel();
        jp_factura_ver = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_facturas = new javax.swing.JTable();
        jl_factura_ver_seleccionar = new javax.swing.JLabel();
        cb_borrar_factura = new javax.swing.JComboBox<>();
        jButton34 = new javax.swing.JButton();
        jl_factura_ver_fondo = new javax.swing.JLabel();
        jp_factura_nuevo = new javax.swing.JPanel();
        jl_factura_nuevo_rtn = new javax.swing.JLabel();
        jl_factura_nuevo_numero = new javax.swing.JLabel();
        jl_factura_nuevo_tm = new javax.swing.JLabel();
        jl_factura_nuevo_fecha = new javax.swing.JLabel();
        jl_factura_nuevo_subtotal = new javax.swing.JLabel();
        jl_factura_nuevo_total = new javax.swing.JLabel();
        tf_nuevo_factura_rtn = new javax.swing.JTextField();
        tf_nuevo_factura_numero = new javax.swing.JTextField();
        tf_nuevo_factura_subtotal = new javax.swing.JTextField();
        tf_nuevo_factura_id_cliente = new javax.swing.JTextField();
        tf_nuevo_factura_total = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jl_factura_nuevo_id_cliente = new javax.swing.JLabel();
        tf_nuevo_factura_tm = new javax.swing.JTextField();
        Sp_nuevo_factura_fechaInicio = new javax.swing.JSpinner();
        jl_factura_nuevo_fondo = new javax.swing.JLabel();
        jl_factura_subtitulo = new javax.swing.JLabel();
        jl_factura_titulo = new javax.swing.JLabel();
        jl_factura_imagen_fondo = new javax.swing.JLabel();
        jl_subrayado = new javax.swing.JLabel();
        jl_titulo = new javax.swing.JLabel();
        jl_CONDUCTOR = new javax.swing.JLabel();
        jl_PRODUCTO = new javax.swing.JLabel();
        jl_FACTURA = new javax.swing.JLabel();
        jl_VEHICULO = new javax.swing.JLabel();
        jl_CLIENTE = new javax.swing.JLabel();
        jl_PROVEEDOR = new javax.swing.JLabel();
        jl_opciones = new javax.swing.JLabel();
        jl_imagen = new javax.swing.JLabel();

        jd_Proveedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane3.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane3.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jp_proveedor_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_proveedor_editar_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_id.setText("ID");
        jp_proveedor_editar.add(jl_proveedor_editar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 102, -1, -1));

        tf_editar_proveedor_id.setEditable(false);
        tf_editar_proveedor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_editar.add(tf_editar_proveedor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 97, 227, -1));

        jl_proveedor_editar_nombre.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_nombre.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_nombre.setText("Nombre");
        jp_proveedor_editar.add(jl_proveedor_editar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 156, -1, -1));

        jl_proveedor_editar_direccion.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_direccion.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_direccion.setText("Direccion");
        jp_proveedor_editar.add(jl_proveedor_editar_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 210, -1, -1));

        jl_proveedor_editar_pais.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_pais.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_pais.setText("Pais");
        jp_proveedor_editar.add(jl_proveedor_editar_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 264, -1, -1));

        jl_proveedor_editar_telefono.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_telefono.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_telefono.setText("Telefono");
        jp_proveedor_editar.add(jl_proveedor_editar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 318, -1, -1));

        jl_proveedor_editar_correo.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_correo.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_correo.setText("Correo electronico");
        jp_proveedor_editar.add(jl_proveedor_editar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 372, -1, -1));

        tf_editar_proveedor_correo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_editar.add(tf_editar_proveedor_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 367, 227, -1));

        tf_editar_proveedor_pais.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_editar.add(tf_editar_proveedor_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 259, 227, -1));

        tf_editar_proveedor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_editar.add(tf_editar_proveedor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 205, 227, -1));

        tf_editar_proveedor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_editar.add(tf_editar_proveedor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 151, 227, -1));

        try {
            tf_editar_proveedor_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_editar_proveedor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_editar.add(tf_editar_proveedor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 310, 230, 40));

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton7.setForeground(new java.awt.Color(153, 153, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton7.setText("Editar");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jp_proveedor_editar.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 241, 76));

        cb_editar_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_editar_proveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_editar_proveedorItemStateChanged(evt);
            }
        });
        cb_editar_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_editar_proveedorActionPerformed(evt);
            }
        });
        jp_proveedor_editar.add(cb_editar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        jl_proveedor_editar_proveedor.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_editar_proveedor.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_editar_proveedor.setText("Seleccione Proveedor");
        jp_proveedor_editar.add(jl_proveedor_editar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        jl_proveedor_editar_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_proveedor_editar.add(jl_proveedor_editar_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane3.addTab("E d i t a r          ", jp_proveedor_editar);

        jp_proveedor_ver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_proveedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla_proveedores.setForeground(new java.awt.Color(0, 0, 102));
        tabla_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DIRECCION", "PAIS", "TELEFONO", "CORREO ELECTRONICO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_proveedores);

        jp_proveedor_ver.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1130, 360));

        jl_proveedor_ver_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_ver_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_ver_seleccionar.setText("Seleccione Proveedor");
        jp_proveedor_ver.add(jl_proveedor_ver_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_ver.add(cb_borrar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

        jButton24.setBackground(new java.awt.Color(204, 204, 204));
        jButton24.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton24.setForeground(new java.awt.Color(0, 102, 102));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton24.setText("Borrar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jp_proveedor_ver.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jl_proveedor_ver_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jp_proveedor_ver.add(jl_proveedor_ver_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane3.addTab("        V e r / B o r r a r     ", jp_proveedor_ver);

        jp_proveedor_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_proveedor_nuevo_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_nuevo_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_nuevo_id.setText("ID");
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 34, -1, -1));

        jl_proveedor_nuevo_nombre.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_nuevo_nombre.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_nuevo_nombre.setText("Nombre");
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 93, -1, -1));

        jl_proveedor_nuevo_direccion.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_nuevo_direccion.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_nuevo_direccion.setText("Direccion");
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 147, -1, -1));

        jl_proveedor_nuevo_pais.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_nuevo_pais.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_nuevo_pais.setText("Pais");
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 201, -1, -1));

        jl_proveedor_nuevo_telefono.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_nuevo_telefono.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_nuevo_telefono.setText("Telefono");
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 255, -1, -1));

        jl_proveedor_nuevo_correo.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_proveedor_nuevo_correo.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_nuevo_correo.setText("Correo electronico");
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 309, -1, -1));

        tf_nuevo_proveedor_id.setEditable(false);
        tf_nuevo_proveedor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_nuevo.add(tf_nuevo_proveedor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 29, 186, -1));

        tf_nuevo_proveedor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_nuevo.add(tf_nuevo_proveedor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 88, 186, -1));

        tf_nuevo_proveedor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_nuevo.add(tf_nuevo_proveedor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 142, 186, -1));

        tf_nuevo_proveedor_pais.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_nuevo.add(tf_nuevo_proveedor_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 196, 186, -1));

        tf_nuevo_proveedor_correo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_nuevo.add(tf_nuevo_proveedor_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 304, 186, -1));

        try {
            tf_nuevo_proveedor_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_nuevo_proveedor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_proveedor_nuevo.add(tf_nuevo_proveedor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 190, 40));

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 153, 153));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton9.setText("Crear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jp_proveedor_nuevo.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        jl_proveedor_nuevo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_proveedor_nuevo.add(jl_proveedor_nuevo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane3.addTab("N u e v o          ", jp_proveedor_nuevo);

        jd_Proveedor.getContentPane().add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jl_proveedor_subtitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jl_proveedor_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        jl_proveedor_subtitulo.setText("Transportes   Carmen");
        jd_Proveedor.getContentPane().add(jl_proveedor_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jl_proveedor_titulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jl_proveedor_titulo.setForeground(new java.awt.Color(204, 204, 0));
        jl_proveedor_titulo.setText("PROVEEDOR");
        jd_Proveedor.getContentPane().add(jl_proveedor_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 860, 140));

        jl_proveedor_imagen_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Proveedor.getContentPane().add(jl_proveedor_imagen_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Producto.setMinimumSize(new java.awt.Dimension(1219, 801));
        jd_Producto.setSize(new java.awt.Dimension(1219, 801));
        jd_Producto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane17.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane17.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane17.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jTabbedPane17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane17MouseClicked(evt);
            }
        });

        jp_producto_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_producto_editar_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_editar_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_editar_id.setText("ID");
        jp_producto_editar.add(jl_producto_editar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 102, -1, -1));

        tf_editar_Producto_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_editar.add(tf_editar_Producto_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 97, 227, -1));

        jl_producto_editar_nombre.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_editar_nombre.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_editar_nombre.setText("Nombre");
        jp_producto_editar.add(jl_producto_editar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 156, -1, -1));

        jl_producto_editar_precio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_editar_precio.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_editar_precio.setText("Precio");
        jp_producto_editar.add(jl_producto_editar_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 210, -1, -1));

        jl_producto_editar_proveedor.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_editar_proveedor.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_editar_proveedor.setText("Proveedor");
        jp_producto_editar.add(jl_producto_editar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jl_producto_editar_Tcantidad.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_editar_Tcantidad.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_editar_Tcantidad.setText("Cantidad Total");
        jp_producto_editar.add(jl_producto_editar_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 264, -1, -1));

        cb_editar_Producto_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_editar.add(cb_editar_Producto_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 227, -1));

        tf_editar_Producto_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_editar.add(tf_editar_Producto_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 151, 227, -1));

        jButton21.setBackground(new java.awt.Color(204, 204, 204));
        jButton21.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton21.setForeground(new java.awt.Color(153, 153, 0));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton21.setText("Editar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jp_producto_editar.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 241, 76));

        cb_editar_Producto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_editar_Producto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_editar_ProductoItemStateChanged(evt);
            }
        });
        cb_editar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_editar_ProductoActionPerformed(evt);
            }
        });
        jp_producto_editar.add(cb_editar_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_Producto_Tcantidad.setModel(new javax.swing.SpinnerNumberModel());
        jp_producto_editar.add(Sp_editar_Producto_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 220, -1));

        Sp_editar_Producto_precio.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));
<<<<<<< HEAD
        jPanel24.add(Sp_editar_Producto_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 220, -1));
=======
        jp_producto_editar.add(Sp_editar_Producto_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 220, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jl_producto_editar_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_editar_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_editar_seleccionar.setText("Seleccione Producto");
        jp_producto_editar.add(jl_producto_editar_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        jl_producto_editar_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_producto_editar.add(jl_producto_editar_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane17.addTab("E d i t a r        ", jp_producto_editar);

        jp_producto_ver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Producto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_Producto.setForeground(new java.awt.Color(0, 0, 102));
        jTable_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "PRECIO", "CANTIDAD TOTAL", "ID PROVEEDOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Producto.getTableHeader().setResizingAllowed(false);
        jTable_Producto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_Producto);

        jp_producto_ver.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 1130, 350));

        jl_producto_ver_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_ver_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_ver_seleccionar.setText("Seleccione Producto");
        jp_producto_ver.add(jl_producto_ver_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_producto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_ver.add(cb_borrar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

        jButton22.setBackground(new java.awt.Color(204, 204, 204));
        jButton22.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton22.setForeground(new java.awt.Color(0, 102, 102));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton22.setText("Borrar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jp_producto_ver.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jl_producto_ver_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jp_producto_ver.add(jl_producto_ver_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane17.addTab("        V e r / B o r r a r     ", jp_producto_ver);

        jp_producto_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_producto_nuevo_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_nuevo_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_nuevo_id.setText("ID");
        jp_producto_nuevo.add(jl_producto_nuevo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jl_producto_nuevo_nombre.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_nuevo_nombre.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_nuevo_nombre.setText("Nombre");
        jp_producto_nuevo.add(jl_producto_nuevo_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        tf_nuevo_producto_id.setEditable(false);
        tf_nuevo_producto_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_nuevo.add(tf_nuevo_producto_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 220, -1));

        tf_nuevo_producto_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_nuevo.add(tf_nuevo_producto_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 220, -1));

        jl_producto_nuevo_proveedor.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_nuevo_proveedor.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_nuevo_proveedor.setText("Proveedor");
        jp_producto_nuevo.add(jl_producto_nuevo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        cb_nuevo_Producto_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_producto_nuevo.add(cb_nuevo_Producto_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 310, 230, -1));

        jButton23.setBackground(new java.awt.Color(204, 204, 204));
        jButton23.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton23.setForeground(new java.awt.Color(0, 153, 153));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton23.setText("Crear");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jp_producto_nuevo.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        jl_producto_nuevo_precio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_nuevo_precio.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_nuevo_precio.setText("Precio");
        jp_producto_nuevo.add(jl_producto_nuevo_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        Sp_nuevo_producto_precio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
<<<<<<< HEAD
        jPanel27.add(Sp_nuevo_producto_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 220, -1));
=======
        jp_producto_nuevo.add(Sp_nuevo_producto_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 220, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jl_producto_nuevo_Tcantidad.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_producto_nuevo_Tcantidad.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_nuevo_Tcantidad.setText("Cantidad Total");
        jp_producto_nuevo.add(jl_producto_nuevo_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        Sp_nuevo_producto_Tcantidad.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
<<<<<<< HEAD
        jPanel27.add(Sp_nuevo_producto_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 220, -1));
=======
        jp_producto_nuevo.add(Sp_nuevo_producto_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 220, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jl_producto_nuevo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_producto_nuevo.add(jl_producto_nuevo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane17.addTab("N u e v o            ", jp_producto_nuevo);

        jd_Producto.getContentPane().add(jTabbedPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jl_producto_subtitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jl_producto_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        jl_producto_subtitulo.setText("Transportes   Carmen");
        jd_Producto.getContentPane().add(jl_producto_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jl_producto_titulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jl_producto_titulo.setForeground(new java.awt.Color(204, 0, 0));
        jl_producto_titulo.setText("PRODUCTO");
        jd_Producto.getContentPane().add(jl_producto_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 670, 140));

        jl_producto_imagen_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Producto.getContentPane().add(jl_producto_imagen_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Cliente.setMinimumSize(new java.awt.Dimension(1219, 801));
        jd_Cliente.setSize(new java.awt.Dimension(1219, 801));
        jd_Cliente.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane18.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane18.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane18.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jTabbedPane18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane18MouseClicked(evt);
            }
        });

        jp_cliente_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_cliente_editar_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_id.setText("ID:");
        jp_cliente_editar.add(jl_cliente_editar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 130, 40, -1));

        tf_editar_Cliente_id.setEditable(false);
        tf_editar_Cliente_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_editar.add(tf_editar_Cliente_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 120, 250, -1));

        jl_cliente_editar_empresa.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_empresa.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_empresa.setText("Nombre de Empresa:");
        jp_cliente_editar.add(jl_cliente_editar_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jl_cliente_editar_fecaInicio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_fecaInicio.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_fecaInicio.setText("Fecha Inicio de Contrato:");
        jp_cliente_editar.add(jl_cliente_editar_fecaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 240, 300, -1));

        jl_cliente_editar_direccion.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_direccion.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_direccion.setText("Direccion:");
        jp_cliente_editar.add(jl_cliente_editar_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        tf_editar_Cliente_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_editar.add(tf_editar_Cliente_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 720, -1));

        jButton25.setBackground(new java.awt.Color(204, 204, 204));
        jButton25.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton25.setForeground(new java.awt.Color(153, 153, 0));
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton25.setText("Editar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jp_cliente_editar.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 241, 76));

        cb_editar_Cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_editar_Cliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_editar_ClienteItemStateChanged(evt);
            }
        });
        cb_editar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_editar_ClienteActionPerformed(evt);
            }
        });
        jp_cliente_editar.add(cb_editar_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_Cliente_fecaInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_Cliente_fecaInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        jp_cliente_editar.add(Sp_editar_Cliente_fecaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 250, -1));

        jl_cliente_editar_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_seleccionar.setText("Seleccione Cliente");
        jp_cliente_editar.add(jl_cliente_editar_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        tf_editar_Cliente_empresa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_editar.add(tf_editar_Cliente_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 180, 250, -1));

        tf_editar_Cliente_nombreContacto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_editar.add(tf_editar_Cliente_nombreContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 250, -1));

        try {
            tf_editar_cliente_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_editar_cliente_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_editar.add(tf_editar_cliente_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 230, 40));

        jl_cliente_editar_nombre_de.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_nombre_de.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_nombre_de.setText("Nombre de ");
        jp_cliente_editar.add(jl_cliente_editar_nombre_de, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 150, -1));

        jl_cliente_editar_contacto.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_contacto.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_contacto.setText("Contacto:");
        jp_cliente_editar.add(jl_cliente_editar_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 130, 40));

        jl_cliente_editar_telefono.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_editar_telefono.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_editar_telefono.setText("Telefono:");
        jp_cliente_editar.add(jl_cliente_editar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 130, 40));

        jl_cliente_editar_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_cliente_editar.add(jl_cliente_editar_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane18.addTab("E d i t a r        ", jp_cliente_editar);

        jp_cliente_ver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_cliente.setForeground(new java.awt.Color(0, 0, 102));
        jTable_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE EMPRESA", "FECHA INICIO CONTRATO", "DIRECCION", "TELEFONO", "NOMBRE DE CONTACTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_cliente);
        if (jTable_cliente.getColumnModel().getColumnCount() > 0) {
            jTable_cliente.getColumnModel().getColumn(2).setHeaderValue("");
            jTable_cliente.getColumnModel().getColumn(3).setHeaderValue("Modelo");
        }

        jp_cliente_ver.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 1130, 350));

        jl_cliente_ver_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_ver_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_ver_seleccionar.setText("Seleccione Cliente:");
        jp_cliente_ver.add(jl_cliente_ver_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_ver.add(cb_borrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

        jButton26.setBackground(new java.awt.Color(204, 204, 204));
        jButton26.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton26.setForeground(new java.awt.Color(0, 102, 102));
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton26.setText("Borrar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jp_cliente_ver.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jl_cliente_ver_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jp_cliente_ver.add(jl_cliente_ver_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1210, 520));

        jTabbedPane18.addTab("        V e r / B o r r a r     ", jp_cliente_ver);

        jp_cliente_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton27.setBackground(new java.awt.Color(204, 204, 204));
        jButton27.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton27.setForeground(new java.awt.Color(0, 153, 153));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton27.setText("Crear");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jp_cliente_nuevo.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        jl_cliente_nuevo_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_id.setText("ID:");
        jp_cliente_nuevo.add(jl_cliente_nuevo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 130, 40, -1));

        tf_nuevo_Cliente_id.setEditable(false);
        tf_nuevo_Cliente_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_nuevo.add(tf_nuevo_Cliente_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 120, 250, -1));

        jl_cliente_nuevo_telefono.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_telefono.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_telefono.setText("Telefono:");
        jp_cliente_nuevo.add(jl_cliente_nuevo_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 130, 40));

        jl_cliente_nuevo_empresa.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_empresa.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_empresa.setText("Nombre de Empresa:");
        jp_cliente_nuevo.add(jl_cliente_nuevo_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jl_cliente_nuevo_fechaInicio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_fechaInicio.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_fechaInicio.setText("Fecha Inicio de Contrato:");
        jp_cliente_nuevo.add(jl_cliente_nuevo_fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 240, 300, -1));

        jl_cliente_nuevo_direccion.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_direccion.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_direccion.setText("Direccion:");
        jp_cliente_nuevo.add(jl_cliente_nuevo_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        tf_nuevo_Cliente_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_nuevo.add(tf_nuevo_Cliente_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 720, -1));

        Sp_nuevo_Cliente_fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_Cliente_fechaInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        jp_cliente_nuevo.add(Sp_nuevo_Cliente_fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 250, -1));

        tf_nuevo_Cliente_empresa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_nuevo.add(tf_nuevo_Cliente_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 180, 250, -1));

        try {
            tf_nuevo_cliente_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_nuevo_cliente_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_nuevo.add(tf_nuevo_cliente_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 230, 40));

        jl_cliente_nuevo_nombre_de.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_nombre_de.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_nombre_de.setText("Nombre de ");
        jp_cliente_nuevo.add(jl_cliente_nuevo_nombre_de, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 150, -1));

        jl_cliente_nuevo_contacto.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_cliente_nuevo_contacto.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_nuevo_contacto.setText("Contacto:");
        jp_cliente_nuevo.add(jl_cliente_nuevo_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 130, 40));

        tf_nuevo_Cliente_nombreContacto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_cliente_nuevo.add(tf_nuevo_Cliente_nombreContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 250, -1));

        jl_cliente_nuevo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_cliente_nuevo.add(jl_cliente_nuevo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane18.addTab("N u e v o            ", jp_cliente_nuevo);

        jd_Cliente.getContentPane().add(jTabbedPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jl_cliente_subtitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jl_cliente_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        jl_cliente_subtitulo.setText("Transportes   Carmen");
        jd_Cliente.getContentPane().add(jl_cliente_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jl_cliente_titulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jl_cliente_titulo.setForeground(new java.awt.Color(255, 204, 0));
        jl_cliente_titulo.setText("CLIENTE");
        jd_Cliente.getContentPane().add(jl_cliente_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 490, 140));

        jl_cliente_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Cliente.getContentPane().add(jl_cliente_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Vehiculo.setMinimumSize(new java.awt.Dimension(1213, 851));
        jd_Vehiculo.setResizable(false);
        jd_Vehiculo.setSize(new java.awt.Dimension(1213, 851));
        jd_Vehiculo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane19.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane19.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane19.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N

        jp_vehiculo_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_vehiculo_editar_placa.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_placa.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_placa.setText("Numero de Placa:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 210, -1));

        tf_editar_vehiculo_placa.setEditable(false);
        tf_editar_vehiculo_placa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar.add(tf_editar_vehiculo_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        jp_vehiculo_editar_kilometraje.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_kilometraje.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_kilometraje.setText("Kilometraje:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jp_vehiculo_editar_marca.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_marca.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_marca.setText("Marca:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, -1));

        jp_vehiculo_editar_anio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_anio.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_anio.setText("Año:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 130, -1));

        tf_editar_vehiculo_modelo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar.add(tf_editar_vehiculo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));

        jButton28.setBackground(new java.awt.Color(204, 204, 204));
        jButton28.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton28.setForeground(new java.awt.Color(153, 153, 0));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton28.setText("Editar");
        jp_vehiculo_editar.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 241, 76));

        cb_editar_vehiculo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar.add(cb_editar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_vehiculo_tm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_tm.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
<<<<<<< HEAD
        jPanel30.add(Sp_editar_vehiculo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 150, -1));
=======
        jp_vehiculo_editar.add(Sp_editar_vehiculo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 150, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jLabel205.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(204, 204, 204));
        jLabel205.setText("Seleccione Vehiculo:");
        jp_vehiculo_editar.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        tf_editar_vehiculo_marca.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar.add(tf_editar_vehiculo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, -1));

        jp_vehiculo_editar_tipoCombu.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_tipoCombu.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_tipoCombu.setText("Tipo Combustible:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 210, 40));

        jp_vehiculo_editar_modelo.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_modelo.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_modelo.setText("Modelo:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        jp_vehiculo_editar_capaCombus.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_capaCombus.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_capaCombus.setText("Capacidad de Combustible:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_capaCombus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 310, -1));

        jp_vehiculo_editar_color.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_color.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_color.setText("Color:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 140, -1));

        Sp_editar_vehiculo_año.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_año.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, null, 1));
<<<<<<< HEAD
        jPanel30.add(Sp_editar_vehiculo_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 250, -1));

        cb_editar_vehiculo_tipoCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_editar_vehiculo_tipoCombu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Regular" }));
        jPanel30.add(cb_editar_vehiculo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 170, 150, -1));
=======
        jp_vehiculo_editar.add(Sp_editar_vehiculo_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 250, -1));

        cb_editar_vehiculo_tipoCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_editar_vehiculo_tipoCombu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Regular" }));
        jp_vehiculo_editar.add(cb_editar_vehiculo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 170, 150, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        Sp_editar_vehiculo_color.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar.add(Sp_editar_vehiculo_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 250, -1));

        jp_vehiculo_editar_localizador.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_localizador.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_localizador.setText("Localizador:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 140, -1));

        tf_editar_vehiculo_localizador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar.add(tf_editar_vehiculo_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 260, -1));

        Sp_editar_vehiculo_kilometraje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_kilometraje.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
<<<<<<< HEAD
        jPanel30.add(Sp_editar_vehiculo_kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));
=======
        jp_vehiculo_editar.add(Sp_editar_vehiculo_kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jp_vehiculo_editar_traileta.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jp_vehiculo_editar_traileta.setForeground(new java.awt.Color(204, 0, 0));
        jp_vehiculo_editar_traileta.setText("TRAILETA");
        jp_vehiculo_editar.add(jp_vehiculo_editar_traileta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 210, -1));

        jp_vehiculo_editar_tm.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_editar_tm.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_editar_tm.setText("Toneladas Metricas:");
        jp_vehiculo_editar.add(jp_vehiculo_editar_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 250, -1));

        Sp_editar_vehiculo_capaCombus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_capaCombus.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
<<<<<<< HEAD
        jPanel30.add(Sp_editar_vehiculo_capaCombus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 100, -1));
=======
        jp_vehiculo_editar.add(Sp_editar_vehiculo_capaCombus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 100, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jp_vehiculo_editar_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_vehiculo_editar.add(jp_vehiculo_editar_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 590));

        jTabbedPane19.addTab("E d i t a r        ", jp_vehiculo_editar);

        jp_vehiculo_ver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_vehivculo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable_vehivculo.setForeground(new java.awt.Color(0, 0, 102));
        jTable_vehivculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Placa", "Kilometraje", "Marca", "Modelo", "Año", "Color", "Capacidad Combustible", "Tipo Combustible", "Localizador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable_vehivculo);
        if (jTable_vehivculo.getColumnModel().getColumnCount() > 0) {
            jTable_vehivculo.getColumnModel().getColumn(2).setHeaderValue("");
            jTable_vehivculo.getColumnModel().getColumn(3).setHeaderValue("Modelo");
            jTable_vehivculo.getColumnModel().getColumn(4).setHeaderValue("Año");
            jTable_vehivculo.getColumnModel().getColumn(5).setHeaderValue("Color");
            jTable_vehivculo.getColumnModel().getColumn(6).setHeaderValue("Capacidad Combustible");
            jTable_vehivculo.getColumnModel().getColumn(7).setHeaderValue("Tipo Combustible");
            jTable_vehivculo.getColumnModel().getColumn(8).setHeaderValue("Localizador");
        }

        jp_vehiculo_ver.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1130, 230));

        jp_vehiculo_ver_seleccionar_vehiculo.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_ver_seleccionar_vehiculo.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_ver_seleccionar_vehiculo.setText("Seleccione Vehiculo:");
        jp_vehiculo_ver.add(jp_vehiculo_ver_seleccionar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        cb_borrar_vehiculo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_ver.add(cb_borrar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 370, -1));

        jButton29.setBackground(new java.awt.Color(204, 204, 204));
        jButton29.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton29.setForeground(new java.awt.Color(0, 102, 102));
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton29.setText("Borrar");
        jp_vehiculo_ver.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 241, 76));

        jTable_traileta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable_traileta.setForeground(new java.awt.Color(0, 0, 102));
        jTable_traileta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Placa", "Toneladas metricas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable_traileta);

        jp_vehiculo_ver.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 530, 120));

        jp_vehiculo_ver_seleccionar_traileta.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_ver_seleccionar_traileta.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_ver_seleccionar_traileta.setText("Seleccione Traileta:");
        jp_vehiculo_ver.add(jp_vehiculo_ver_seleccionar_traileta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        cb_borrar_traileta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_ver.add(cb_borrar_traileta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 370, -1));

        jButton35.setBackground(new java.awt.Color(204, 204, 204));
        jButton35.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton35.setForeground(new java.awt.Color(0, 102, 102));
        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton35.setText("Borrar");
        jp_vehiculo_ver.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 241, 76));

        jp_vehiculo_ver_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jp_vehiculo_ver.add(jp_vehiculo_ver_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 580));

        jTabbedPane19.addTab("        V e r / B o r r a r     ", jp_vehiculo_ver);

        jp_vehiculo_editar_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton30.setBackground(new java.awt.Color(204, 204, 204));
        jButton30.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton30.setForeground(new java.awt.Color(0, 153, 153));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton30.setText("Crear");
        jp_vehiculo_editar_nuevo.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        jp_vehiculo_nuevo_placa.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_placa.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_placa.setText("Numero de Placa:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 210, -1));

        tf_nuevo_vehiculo_placa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar_nuevo.add(tf_nuevo_vehiculo_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 250, -1));

        jp_vehiculo_nuevo_kilometraje.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_kilometraje.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_kilometraje.setText("Kilometraje:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 250, -1));

        jp_vehiculo_nuevo_marca.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_marca.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_marca.setText("Marca:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 300, -1));

        jp_vehiculo_nuevo_modelo.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_modelo.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_modelo.setText("Modelo:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, -1));

        jp_vehiculo_nuevo_anio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_anio.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_anio.setText("Año:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        jp_vehiculo_nuevo_color.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_color.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_color.setText("Color:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 140, -1));

        tf_nuevo_vehiculo_color.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar_nuevo.add(tf_nuevo_vehiculo_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 250, -1));

        Sp_nuevo_vehiculo_año.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_año.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, null, 1));
<<<<<<< HEAD
        jPanel32.add(Sp_nuevo_vehiculo_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));
=======
        jp_vehiculo_editar_nuevo.add(Sp_nuevo_vehiculo_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        tf_nuevo_vehiculo_modelo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar_nuevo.add(tf_nuevo_vehiculo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, -1));

        tf_nuevo_vehiculo_marca.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar_nuevo.add(tf_nuevo_vehiculo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));

        jp_vehiculo_nuevo_tm.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_tm.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_tm.setText("Toneladas Metricas:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 290, -1));

        jp_vehiculo_nuevo_traileta.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_traileta.setForeground(new java.awt.Color(204, 0, 0));
        jp_vehiculo_nuevo_traileta.setText("TRAILETA");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_traileta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 210, -1));

        jp_vehiculo_nuevo_localizador.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_localizador.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_localizador.setText("Localizador:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 140, -1));

        jp_vehiculo_nuevo_tipoCombu.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_tipoCombu.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_tipoCombu.setText("Tipo Combustible:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 210, 40));

        jp_vehiculo_nuevo_capaCombu.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jp_vehiculo_nuevo_capaCombu.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_nuevo_capaCombu.setText("Capacidad de Combustible:");
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_capaCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 310, -1));

        Sp_nuevo_vehiculo_capaCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_capaCombu.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
<<<<<<< HEAD
        jPanel32.add(Sp_nuevo_vehiculo_capaCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 100, -1));

        cb_nuevo_vehiculo_tipoCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_nuevo_vehiculo_tipoCombu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Regular" }));
        jPanel32.add(cb_nuevo_vehiculo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 150, -1));
=======
        jp_vehiculo_editar_nuevo.add(Sp_nuevo_vehiculo_capaCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 100, -1));

        cb_nuevo_vehiculo_tipoCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_nuevo_vehiculo_tipoCombu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Regular" }));
        jp_vehiculo_editar_nuevo.add(cb_nuevo_vehiculo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 150, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        tf_nuevo_vehiculo_localizador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_vehiculo_editar_nuevo.add(tf_nuevo_vehiculo_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 260, -1));

        Sp_nuevo_vehiculo_kilometra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_kilometra.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
<<<<<<< HEAD
        jPanel32.add(Sp_nuevo_vehiculo_kilometra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        Sp_nuevo_vehiculo_tm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_tm.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jPanel32.add(Sp_nuevo_vehiculo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, 150, -1));
=======
        jp_vehiculo_editar_nuevo.add(Sp_nuevo_vehiculo_kilometra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        Sp_nuevo_vehiculo_tm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_tm.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jp_vehiculo_editar_nuevo.add(Sp_nuevo_vehiculo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, 150, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jp_vehiculo_nuevo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_vehiculo_editar_nuevo.add(jp_vehiculo_nuevo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 580));

        jTabbedPane19.addTab("N u e v o            ", jp_vehiculo_editar_nuevo);

        jd_Vehiculo.getContentPane().add(jTabbedPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 650));

        jp_vehiculo_subtitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jp_vehiculo_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        jp_vehiculo_subtitulo.setText("Transportes   Carmen");
        jd_Vehiculo.getContentPane().add(jp_vehiculo_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jp_vehiculo_titulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jp_vehiculo_titulo.setForeground(new java.awt.Color(153, 255, 204));
        jp_vehiculo_titulo.setText("VEHICULO");
        jd_Vehiculo.getContentPane().add(jp_vehiculo_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 610, 140));

        jp_vehiculo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Vehiculo.getContentPane().add(jp_vehiculo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Conductor.setMinimumSize(new java.awt.Dimension(1219, 801));
        jd_Conductor.setResizable(false);
        jd_Conductor.setSize(new java.awt.Dimension(1219, 801));
        jd_Conductor.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jd_ConductorWindowOpened(evt);
            }
        });
        jd_Conductor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane20.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane20.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane20.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N

        jp_conductor_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_conductor_editar_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_id.setText("ID:");
        jp_conductor_editar.add(jl_conductor_editar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 40, -1));

        tf_editar_conductor_id.setEditable(false);
        tf_editar_conductor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_editar.add(tf_editar_conductor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        jl_conductor_editar_nombres.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_nombres.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_nombres.setText("Nombres:");
        jp_conductor_editar.add(jl_conductor_editar_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jl_conductor_editar_apellidos.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_apellidos.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_apellidos.setText("Apellidos:");
        jp_conductor_editar.add(jl_conductor_editar_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, -1));

        jl_conductor_editar_direccion.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_direccion.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_direccion.setText("Direccion:");
        jp_conductor_editar.add(jl_conductor_editar_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 130, -1));

        tf_editar_conductor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_editar.add(tf_editar_conductor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 720, -1));

        jButton31.setBackground(new java.awt.Color(204, 204, 204));
        jButton31.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton31.setForeground(new java.awt.Color(153, 153, 0));
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton31.setText("Editar");
<<<<<<< HEAD
        jButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton31MouseClicked(evt);
            }
        });
        jPanel33.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 241, 76));

        cb_editar_conductor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_editar_conductor_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_editar_conductor_idItemStateChanged(evt);
            }
        });
        jPanel33.add(cb_editar_conductor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_conductor_viaticos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_viaticos.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jPanel33.add(Sp_editar_conductor_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 250, -1));

        jLabel216.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(204, 204, 204));
        jLabel216.setText("Seleccione Conductor");
        jPanel33.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));
=======
        jp_conductor_editar.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 241, 76));

        cb_editar_conductor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_editar.add(cb_editar_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_conductor_viaticos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_viaticos.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jp_conductor_editar.add(Sp_editar_conductor_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 250, -1));

        jl_conductor_editar_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_seleccionar.setText("Seleccione conductor:");
        jp_conductor_editar.add(jl_conductor_editar_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        tf_editar_conductor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_editar.add(tf_editar_conductor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));

        tf_editar_conductor_apellido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_editar.add(tf_editar_conductor_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, -1));

        tf_editar_conductor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_editar.add(tf_editar_conductor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 250, -1));

        jl_conductor_editar_telefono.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_telefono.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_telefono.setText("Telefono:");
        jp_conductor_editar.add(jl_conductor_editar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 40));

        jl_conductor_editar_edad.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_edad.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_edad.setText("Edad:");
        jp_conductor_editar.add(jl_conductor_editar_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        jl_conductor_editar_vitalicio.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_vitalicio.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_vitalicio.setText("Viaticos:");
        jp_conductor_editar.add(jl_conductor_editar_vitalicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 140, -1));

        jl_conductor_editar_salario.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_editar_salario.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_editar_salario.setText("Salario:");
        jp_conductor_editar.add(jl_conductor_editar_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 140, -1));

        Sp_editar_conductor_edad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_edad.setModel(new javax.swing.SpinnerNumberModel(15, 15, null, 1));
<<<<<<< HEAD
        jPanel33.add(Sp_editar_conductor_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));

        Sp_editar_conductor_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_salario.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jPanel33.add(Sp_editar_conductor_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 250, -1));
=======
        jp_conductor_editar.add(Sp_editar_conductor_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));

        Sp_editar_conductor_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_salario.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jp_conductor_editar.add(Sp_editar_conductor_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 250, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jl_conductor_editar_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_conductor_editar.add(jl_conductor_editar_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane20.addTab("E d i t a r        ", jp_conductor_editar);

        jp_conductor_ver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_conductor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable_conductor.setForeground(new java.awt.Color(0, 0, 102));
        jTable_conductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Edad", "Direccion", "Salario", "Viaticos", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_conductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_conductorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_conductor);
        if (jTable_conductor.getColumnModel().getColumnCount() > 0) {
            jTable_conductor.getColumnModel().getColumn(2).setHeaderValue("");
            jTable_conductor.getColumnModel().getColumn(3).setHeaderValue("Modelo");
            jTable_conductor.getColumnModel().getColumn(4).setHeaderValue("Año");
            jTable_conductor.getColumnModel().getColumn(5).setHeaderValue("Color");
            jTable_conductor.getColumnModel().getColumn(6).setHeaderValue("Capacidad Combustible");
            jTable_conductor.getColumnModel().getColumn(7).setHeaderValue("Tipo Combustible");
        }

        jp_conductor_ver.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 1130, 350));

<<<<<<< HEAD
        jLabel235.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(204, 204, 204));
        jLabel235.setText("Seleccione Conductor:");
        jPanel34.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_conductor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_borrar_conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_borrar_conductorActionPerformed(evt);
            }
        });
        jPanel34.add(cb_borrar_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));
=======
        jl_conductor_ver_conductor.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_ver_conductor.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_ver_conductor.setText("Seleccione Conductor:");
        jp_conductor_ver.add(jl_conductor_ver_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_conductor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_ver.add(cb_borrar_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jButton32.setBackground(new java.awt.Color(204, 204, 204));
        jButton32.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton32.setForeground(new java.awt.Color(0, 102, 102));
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton32.setText("Borrar");
<<<<<<< HEAD
        jButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton32MouseClicked(evt);
            }
        });
        jPanel34.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));
=======
        jp_conductor_ver.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jl_conductor_ver_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jp_conductor_ver.add(jl_conductor_ver_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane20.addTab("        V e r / B o r r a r     ", jp_conductor_ver);

        jp_conductor_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton33.setBackground(new java.awt.Color(204, 204, 204));
        jButton33.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton33.setForeground(new java.awt.Color(0, 153, 153));
        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton33.setText("Crear");
        jp_conductor_nuevo.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        jl_conductor_nuevo_id.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_id.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_id.setText("ID:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, -1));

        jl_conductor_nuevo_nombres.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_nombres.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_nombres.setText("Nombres:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 250, -1));

        jl_conductor_nuevo_apellidos.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_apellidos.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_apellidos.setText("Apellidos:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 300, -1));

        jl_conductor_nuevo_edad.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_edad.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_edad.setText("Edad:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, -1));

        jl_conductor_nuevo_direccion.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_direccion.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_direccion.setText("Direccion:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 130, -1));

        tf_nuevo_conductor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_nuevo.add(tf_nuevo_conductor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 720, -1));

        Sp_nuevo_conductor_edad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_edad.setModel(new javax.swing.SpinnerNumberModel(15, 15, null, 1));
<<<<<<< HEAD
        jPanel35.add(Sp_nuevo_conductor_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 250, -1));
=======
        jp_conductor_nuevo.add(Sp_nuevo_conductor_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 250, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        tf_nuevo_conductor_apellido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_nuevo.add(tf_nuevo_conductor_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 250, -1));

        tf_nuevo_conductor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_nuevo.add(tf_nuevo_conductor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 250, -1));

        tf_nuevo_conductor_id.setEditable(false);
        tf_nuevo_conductor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_nuevo.add(tf_nuevo_conductor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 250, -1));

        jl_conductor_nuevo_salario.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_salario.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_salario.setText("Salario:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 140, -1));

        jl_conductor_nuevo_viaticos.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_viaticos.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_viaticos.setText("Viaticos:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 140, -1));

        jl_conductor_nuevo_telefono.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_conductor_nuevo_telefono.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_nuevo_telefono.setText("Telefono:");
        jp_conductor_nuevo.add(jl_conductor_nuevo_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 130, 40));

        tf_nuevo_conductor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_conductor_nuevo.add(tf_nuevo_conductor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, 250, -1));

        Sp_nuevo_conductor_viaticos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_viaticos.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
<<<<<<< HEAD
        jPanel35.add(Sp_nuevo_conductor_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 250, -1));

        Sp_nuevo_conductor_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_salario.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jPanel35.add(Sp_nuevo_conductor_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 250, -1));
=======
        jp_conductor_nuevo.add(Sp_nuevo_conductor_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 250, -1));

        Sp_nuevo_conductor_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_salario.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jp_conductor_nuevo.add(Sp_nuevo_conductor_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 250, -1));
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

        jl_conductor_nuevo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_conductor_nuevo.add(jl_conductor_nuevo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane20.addTab("N u e v o            ", jp_conductor_nuevo);

        jd_Conductor.getContentPane().add(jTabbedPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jl_conductor_subtitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jl_conductor_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        jl_conductor_subtitulo.setText("Transportes   Carmen");
        jd_Conductor.getContentPane().add(jl_conductor_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jl_conductor_titulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jl_conductor_titulo.setForeground(new java.awt.Color(153, 0, 255));
        jl_conductor_titulo.setText("CONDUCTOR");
        jd_Conductor.getContentPane().add(jl_conductor_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 790, 140));

        jl_conductor_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Conductor.getContentPane().add(jl_conductor_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Factura.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane4.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane4.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane4.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

        jp_factura_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_factura_editar_numero.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_numero.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_numero.setText("Numero");
        jp_factura_editar.add(jl_factura_editar_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 102, -1, -1));

        tf_editar_factura_numero.setEditable(false);
        tf_editar_factura_numero.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_editar.add(tf_editar_factura_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 97, 227, -1));

        jl_factura_editar_tm.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_tm.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_tm.setText("Toneladas metricas");
        jp_factura_editar.add(jl_factura_editar_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 156, -1, -1));

        jl_factura_editar_fecha.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_fecha.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_fecha.setText("Fecha");
        jp_factura_editar.add(jl_factura_editar_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 210, -1, -1));

        jl_factura_editar_subtotal.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_subtotal.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_subtotal.setText("Subtotal");
        jp_factura_editar.add(jl_factura_editar_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 264, -1, -1));

        jl_factura_editar_total.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_total.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_total.setText("Total");
        jp_factura_editar.add(jl_factura_editar_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 318, -1, -1));

        jl_factura_editar_id_cliente.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_id_cliente.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_id_cliente.setText("ID. cliente");
        jp_factura_editar.add(jl_factura_editar_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 372, -1, -1));

        tf_editar_factura_id_cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_editar.add(tf_editar_factura_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 367, 227, -1));

        tf_editar_factura_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_editar.add(tf_editar_factura_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 227, -1));

        tf_editar_factura_tm.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_editar.add(tf_editar_factura_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 151, 227, -1));

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton8.setForeground(new java.awt.Color(153, 153, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton8.setText("Editar");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jp_factura_editar.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 241, 76));

        jl_factura_editar_rtn.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_editar_rtn.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_editar_rtn.setText("Rtn");
        jp_factura_editar.add(jl_factura_editar_rtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));
        jp_factura_editar.add(tf_editar_factura_rtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 220, 30));

        Sp_editar_factura_fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_factura_fechaInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        jp_factura_editar.add(Sp_editar_factura_fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 250, -1));

        tf_editar_factura_subtotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_editar.add(tf_editar_factura_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 259, 227, -1));

        jl_factura_editar_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_factura_editar.add(jl_factura_editar_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane4.addTab("E d i t a r          ", jp_factura_editar);

        jp_factura_ver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_facturas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla_facturas.setForeground(new java.awt.Color(0, 0, 102));
        tabla_facturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RTB", "Numero", "Toneladas Metricas", "Fecha", "Subtotal", "Total", "ID Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tabla_facturas);

        jp_factura_ver.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1130, 360));

        jl_factura_ver_seleccionar.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_ver_seleccionar.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_ver_seleccionar.setText("Seleccione Factura");
        jp_factura_ver.add(jl_factura_ver_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_factura.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_ver.add(cb_borrar_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

        jButton34.setBackground(new java.awt.Color(204, 204, 204));
        jButton34.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton34.setForeground(new java.awt.Color(0, 102, 102));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton34.setText("Borrar");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jp_factura_ver.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jl_factura_ver_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jp_factura_ver.add(jl_factura_ver_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane4.addTab("        V e r / B o r r a r     ", jp_factura_ver);

        jp_factura_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_factura_nuevo_rtn.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_rtn.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_rtn.setText("RTN");
        jp_factura_nuevo.add(jl_factura_nuevo_rtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 34, -1, -1));

        jl_factura_nuevo_numero.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_numero.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_numero.setText("Numero");
        jp_factura_nuevo.add(jl_factura_nuevo_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 93, -1, -1));

        jl_factura_nuevo_tm.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_tm.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_tm.setText("Toneladas metricas");
        jp_factura_nuevo.add(jl_factura_nuevo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 147, -1, -1));

        jl_factura_nuevo_fecha.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_fecha.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_fecha.setText("Fecha");
        jp_factura_nuevo.add(jl_factura_nuevo_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        jl_factura_nuevo_subtotal.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_subtotal.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_subtotal.setText("Subtotal");
        jp_factura_nuevo.add(jl_factura_nuevo_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 255, -1, -1));

        jl_factura_nuevo_total.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_total.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_total.setText("Total");
        jp_factura_nuevo.add(jl_factura_nuevo_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 309, -1, -1));

        tf_nuevo_factura_rtn.setEditable(false);
        tf_nuevo_factura_rtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_nuevo.add(tf_nuevo_factura_rtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 29, 186, -1));

        tf_nuevo_factura_numero.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_nuevo.add(tf_nuevo_factura_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 88, 186, -1));

        tf_nuevo_factura_subtotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_nuevo.add(tf_nuevo_factura_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 186, -1));

        tf_nuevo_factura_id_cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_nuevo.add(tf_nuevo_factura_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 186, -1));

        tf_nuevo_factura_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_nuevo.add(tf_nuevo_factura_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 304, 186, -1));

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 153, 153));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton10.setText("Crear");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jp_factura_nuevo.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, -1, -1));

        jl_factura_nuevo_id_cliente.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jl_factura_nuevo_id_cliente.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_nuevo_id_cliente.setText("ID. Cliente");
        jp_factura_nuevo.add(jl_factura_nuevo_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        tf_nuevo_factura_tm.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jp_factura_nuevo.add(tf_nuevo_factura_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 142, 186, -1));

        Sp_nuevo_factura_fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_factura_fechaInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        jp_factura_nuevo.add(Sp_nuevo_factura_fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 250, -1));

        jl_factura_nuevo_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jp_factura_nuevo.add(jl_factura_nuevo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane4.addTab("N u e v o          ", jp_factura_nuevo);

        jd_Factura.getContentPane().add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jl_factura_subtitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jl_factura_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        jl_factura_subtitulo.setText("Transportes   Carmen");
        jd_Factura.getContentPane().add(jl_factura_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jl_factura_titulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jl_factura_titulo.setForeground(new java.awt.Color(0, 102, 204));
        jl_factura_titulo.setText("Factura");
        jd_Factura.getContentPane().add(jl_factura_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 860, 140));

        jl_factura_imagen_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Factura.getContentPane().add(jl_factura_imagen_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_subrayado.setFont(new java.awt.Font("Pristina", 0, 100)); // NOI18N
        jl_subrayado.setForeground(new java.awt.Color(245, 237, 237));
        jl_subrayado.setText("________________");

        jl_titulo.setFont(new java.awt.Font("Pristina", 1, 100)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(245, 237, 237));
        jl_titulo.setText("Transportes   Carmen");

        jl_CONDUCTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/929-64.png"))); // NOI18N
        jl_CONDUCTOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_CONDUCTORMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_CONDUCTORMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_CONDUCTORMouseExited(evt);
            }
        });

        jl_PRODUCTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Noun_Project_20Icon_10px_grid-17-64.png"))); // NOI18N
        jl_PRODUCTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_PRODUCTOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_PRODUCTOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_PRODUCTOMouseExited(evt);
            }
        });

        jl_FACTURA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill-rule-paper-document-64.png"))); // NOI18N
        jl_FACTURA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_FACTURAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_FACTURAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_FACTURAMouseExited(evt);
            }
        });

        jl_VEHICULO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/truck_1-64.png"))); // NOI18N
        jl_VEHICULO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_VEHICULOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_VEHICULOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_VEHICULOMouseExited(evt);
            }
        });

        jl_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/handshake3-64.png"))); // NOI18N
        jl_CLIENTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_CLIENTEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_CLIENTEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_CLIENTEMouseExited(evt);
            }
        });

        jl_PROVEEDOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gold-64.png"))); // NOI18N
        jl_PROVEEDOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_PROVEEDORMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_PROVEEDORMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_PROVEEDORMouseExited(evt);
            }
        });

        jl_opciones.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N

        jl_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/43950_miscellaneous_empty_road.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(560, 560, 560)
                            .addComponent(jl_VEHICULO, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(150, 150, 150)
                            .addComponent(jl_PRODUCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(740, 740, 740)
                            .addComponent(jl_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(700, 700, 700)
                            .addComponent(jl_CONDUCTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1120, 1120, 1120)
                            .addComponent(jl_FACTURA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(980, 980, 980)
                            .addComponent(jl_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(420, 420, 420)
                            .addComponent(jl_PROVEEDOR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(420, 420, 420)
                            .addComponent(jl_subrayado, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(390, 390, 390)
                            .addComponent(jl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(500, 500, 500)
                            .addComponent(jl_VEHICULO, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(500, 500, 500)
                            .addComponent(jl_PRODUCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(650, 650, 650)
                            .addComponent(jl_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(500, 500, 500)
                            .addComponent(jl_CONDUCTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(500, 500, 500)
                            .addComponent(jl_FACTURA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(500, 500, 500)
                            .addComponent(jl_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(500, 500, 500)
                            .addComponent(jl_PROVEEDOR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(310, 310, 310)
                            .addComponent(jl_subrayado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(jl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jl_CONDUCTORMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CONDUCTORMouseEntered
        jl_CONDUCTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/929-128.png"))); // NOI18N
        jl_opciones.setText("CONDUCTOR");
    }//GEN-LAST:event_jl_CONDUCTORMouseEntered

    private void jl_CONDUCTORMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CONDUCTORMouseExited
        jl_CONDUCTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/929-64.png"))); // NOI18N
        jl_opciones.setText("");
    }//GEN-LAST:event_jl_CONDUCTORMouseExited

    private void jl_PRODUCTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PRODUCTOMouseClicked
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < productos.size(); i++) {
            modelo.addElement(productos.get(i).getNombre());
        }
        DefaultTableModel tmodel = (DefaultTableModel) jTable_Producto.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < productos.size(); i++) {
            tmodel.addRow(new Object[]{productos.get(i).getId_Produto(),
                productos.get(i).getNombre(),
                productos.get(i).getPrecio(),
                productos.get(i).getCantidad(),
                productos.get(i).getIdProveedor()});
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < proveedores.size(); i++) {
            model.addElement(proveedores.get(i).getNombre());
        }
        cb_nuevo_Producto_proveedor.setModel(model);
        cb_editar_Producto_proveedor.setModel(model);
        jTable_Producto.setModel(tmodel);
        cb_borrar_producto.setModel(modelo);
        cb_editar_Producto.setModel(modelo);
        jd_Producto.setTitle("Producto");
        jd_Producto.setModal(true);
        jd_Producto.pack();
        jd_Producto.setVisible(true);
    }//GEN-LAST:event_jl_PRODUCTOMouseClicked

    private void jl_PRODUCTOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PRODUCTOMouseEntered
        jl_PRODUCTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Noun_Project_20Icon_10px_grid-17-128.png"))); // NOI18N
        jl_opciones.setText("PRODUCTO");
    }//GEN-LAST:event_jl_PRODUCTOMouseEntered

    private void jl_PRODUCTOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PRODUCTOMouseExited
        jl_PRODUCTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Noun_Project_20Icon_10px_grid-17-64.png"))); // NOI18N
        jl_opciones.setText("");
    }//GEN-LAST:event_jl_PRODUCTOMouseExited

    private void jl_FACTURAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_FACTURAMouseEntered
        jl_FACTURA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill-rule-paper-document-128.png"))); // NOI18N
        jl_opciones.setText("FACTURA");
    }//GEN-LAST:event_jl_FACTURAMouseEntered

    private void jl_FACTURAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_FACTURAMouseExited
        jl_FACTURA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill-rule-paper-document-64.png"))); // NOI18N
        jl_opciones.setText("");
    }//GEN-LAST:event_jl_FACTURAMouseExited

    private void jl_VEHICULOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_VEHICULOMouseEntered
        jl_VEHICULO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/truck_1-128.png"))); // NOI18N
        jl_opciones.setText("VEHICULO");
    }//GEN-LAST:event_jl_VEHICULOMouseEntered

    private void jl_VEHICULOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_VEHICULOMouseExited
        jl_VEHICULO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/truck_1-64.png"))); // NOI18N
        jl_opciones.setText("");
    }//GEN-LAST:event_jl_VEHICULOMouseExited

    private void jl_CLIENTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CLIENTEMouseEntered
        jl_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/handshake3-128.png"))); // NOI18N
        jl_opciones.setText("CLIENTE");
    }//GEN-LAST:event_jl_CLIENTEMouseEntered

    private void jl_CLIENTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CLIENTEMouseExited
        jl_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/handshake3-64.png"))); // NOI18N
        jl_opciones.setText("");
    }//GEN-LAST:event_jl_CLIENTEMouseExited

    private void jl_PROVEEDORMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PROVEEDORMouseEntered
        jl_PROVEEDOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gold-128.png"))); // NOI18N
        jl_opciones.setText("PROVEEDOR");
    }//GEN-LAST:event_jl_PROVEEDORMouseEntered

    private void jl_PROVEEDORMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PROVEEDORMouseExited
        jl_PROVEEDOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gold-64.png")));
        jl_opciones.setText("");
    }//GEN-LAST:event_jl_PROVEEDORMouseExited

    private void jl_CONDUCTORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CONDUCTORMouseClicked
        jd_Conductor.setTitle("Conductor");
        jd_Conductor.pack();
        jd_Conductor.setModal(true);
        jd_Conductor.setVisible(true);
    }//GEN-LAST:event_jl_CONDUCTORMouseClicked

    private void jl_FACTURAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_FACTURAMouseClicked
        //jd_Factura.setModal(true);
        //jd_Factura.setVisible(true);
    }//GEN-LAST:event_jl_FACTURAMouseClicked

    private void jl_VEHICULOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_VEHICULOMouseClicked
        jd_Vehiculo.setTitle("Vehiculo");
        jd_Vehiculo.pack();
        jd_Vehiculo.setModal(true);
        jd_Vehiculo.setVisible(true);
    }//GEN-LAST:event_jl_VEHICULOMouseClicked

    private void jl_CLIENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CLIENTEMouseClicked
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < clientes.size(); i++) {
            modelo.addElement(clientes.get(i).getNombre_Empresa());
        }
        DefaultTableModel tmodel = (DefaultTableModel) jTable_cliente.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < clientes.size(); i++) {
            tmodel.addRow(new Object[]{clientes.get(i).getCliente(),
                clientes.get(i).getNombre_Empresa(),
                clientes.get(i).getFecha_iniContrato(),
                clientes.get(i).getDireccion(),
                clientes.get(i).getTelefono(),
                clientes.get(i).getNombre()});
        }
        jTable_cliente.setModel(tmodel);
        cb_borrar_cliente.setModel(modelo);
        cb_editar_Cliente.setModel(modelo);
        jd_Cliente.setTitle("Cliente");
        jd_Cliente.pack();
        jd_Cliente.setModal(true);
        jd_Cliente.setVisible(true);
    }//GEN-LAST:event_jl_CLIENTEMouseClicked

    private void jl_PROVEEDORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PROVEEDORMouseClicked
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < proveedores.size(); i++) {
            modelo.addElement(proveedores.get(i).getNombre());
        }
        DefaultTableModel tmodel = (DefaultTableModel) tabla_proveedores.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < proveedores.size(); i++) {
            tmodel.addRow(new Object[]{Integer.toString(proveedores.get(i).getId_Proveedor()),
                proveedores.get(i).getNombre(),
                proveedores.get(i).getDireccion(),
                proveedores.get(i).getPais(),
                proveedores.get(i).getTelefono(),
                proveedores.get(i).getEmail()});
        }
        tabla_proveedores.setModel(tmodel);
        cb_borrar_proveedor.setModel(modelo);
        cb_editar_proveedor.setModel(modelo);
        jd_Proveedor.setTitle("Proveedor");
        jd_Proveedor.pack();
        jd_Proveedor.setModal(true);
        jd_Proveedor.setVisible(true);
    }//GEN-LAST:event_jl_PROVEEDORMouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "UPDATE proveedor SET direccion=?, telefono=?, nombre=? ,pais=? ,email=? "
                    + "WHERE idProveedor=" + id_Proveedor;
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, tf_editar_proveedor_direccion.getText());
            pst.setString(2, tf_editar_proveedor_telefono.getText());
            pst.setString(3, tf_editar_proveedor_nombre.getText());
            pst.setString(4, tf_editar_proveedor_pais.getText());
            pst.setString(5, tf_editar_proveedor_correo.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Proveedor Actualizado con exito!");
                for (int i = 0; i < proveedores.size(); i++) {
                    if (proveedores.get(i).getId_Proveedor() == id_Proveedor) {
                        proveedores.get(i).setId_Proveedor(Integer.parseInt(tf_editar_proveedor_id.getText()));
                        proveedores.get(i).setDireccion(tf_editar_proveedor_direccion.getText());
                        proveedores.get(i).setTelefono(tf_editar_proveedor_telefono.getText());
                        proveedores.get(i).setNombre(tf_editar_proveedor_nombre.getText());
                        proveedores.get(i).setPais(tf_editar_proveedor_pais.getText());
                        proveedores.get(i).setEmail(tf_editar_proveedor_correo.getText());
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < proveedores.size(); i++) {
            modelo.addElement(proveedores.get(i).getNombre());
        }
        cb_borrar_proveedor.setModel(modelo);
        cb_editar_proveedor.setModel(modelo);
    }//GEN-LAST:event_jButton7MouseClicked

    private void cb_editar_proveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_editar_proveedorItemStateChanged
        // TODO add your handling code here:
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getNombre().equals(cb_editar_proveedor.getSelectedItem().toString())) {
                id_Proveedor = proveedores.get(i).getId_Proveedor();
                tf_editar_proveedor_id.setText(Integer.toString(proveedores.get(i).getId_Proveedor()));
                tf_editar_proveedor_nombre.setText(proveedores.get(i).getNombre());
                tf_editar_proveedor_direccion.setText(proveedores.get(i).getDireccion());
                tf_editar_proveedor_pais.setText(proveedores.get(i).getPais());
                tf_editar_proveedor_telefono.setText(proveedores.get(i).getTelefono());
                tf_editar_proveedor_correo.setText(proveedores.get(i).getEmail());
            }
        }

    }//GEN-LAST:event_cb_editar_proveedorItemStateChanged

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        // TODO add your handling code here:
        if (jTabbedPane3.getSelectedIndex() == 1) {
            DefaultTableModel tmodel = (DefaultTableModel) tabla_proveedores.getModel();
            int fila = tmodel.getRowCount();
            for (int i = 1; i <= fila; i++) {
                tmodel.removeRow(0);
            }
            for (int i = 0; i < proveedores.size(); i++) {
                tmodel.addRow(new Object[]{Integer.toString(proveedores.get(i).getId_Proveedor()),
                    proveedores.get(i).getNombre(),
                    proveedores.get(i).getDireccion(),
                    proveedores.get(i).getPais(),
                    proveedores.get(i).getTelefono(),
                    proveedores.get(i).getEmail()});
            }
            tabla_proveedores.setModel(tmodel);
        } else if (jTabbedPane3.getSelectedIndex() == 2) {
            tf_nuevo_proveedor_id.setText(Integer.toString(proveedores.get(proveedores.size() - 1).getId_Proveedor() + 1));
        }
    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getNombre().equals(cb_borrar_proveedor.getSelectedItem())) {
                id_Proveedor = proveedores.get(i).getId_Proveedor();
            }
        }
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "DELETE FROM proveedor "
                    + "WHERE idProveedor=?";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, id_Proveedor);
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Proveedor Eliminado con exito!");
                for (int i = 0; i < proveedores.size(); i++) {
                    if (proveedores.get(i).getId_Proveedor() == id_Proveedor) {
                        proveedores.remove(i);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < proveedores.size(); i++) {
            modelo.addElement(proveedores.get(i).getNombre());
        }
        cb_borrar_proveedor.setModel(modelo);
        cb_editar_proveedor.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) tabla_proveedores.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < proveedores.size(); i++) {
            tmodel.addRow(new Object[]{Integer.toString(proveedores.get(i).getId_Proveedor()),
                proveedores.get(i).getNombre(),
                proveedores.get(i).getDireccion(),
                proveedores.get(i).getPais(),
                proveedores.get(i).getTelefono(),
                proveedores.get(i).getEmail()});
        }
        tabla_proveedores.setModel(tmodel);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void cb_editar_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_editar_proveedorActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getNombre().equals(cb_editar_proveedor.getSelectedItem().toString())) {
                id_Proveedor = proveedores.get(i).getId_Proveedor();
                tf_editar_proveedor_id.setText(Integer.toString(proveedores.get(i).getId_Proveedor()));
                tf_editar_proveedor_nombre.setText(proveedores.get(i).getNombre());
                tf_editar_proveedor_direccion.setText(proveedores.get(i).getDireccion());
                tf_editar_proveedor_pais.setText(proveedores.get(i).getPais());
                tf_editar_proveedor_telefono.setText(proveedores.get(i).getTelefono());
                tf_editar_proveedor_correo.setText(proveedores.get(i).getEmail());
            }
        }
    }//GEN-LAST:event_cb_editar_proveedorActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "INSERT INTO proveedor (idProveedor, direccion, telefono, nombre, pais, email)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tf_nuevo_proveedor_id.getText()));
            pst.setString(2, tf_nuevo_proveedor_direccion.getText());
            pst.setString(3, tf_nuevo_proveedor_telefono.getText());
            pst.setString(4, tf_nuevo_proveedor_nombre.getText());
            pst.setString(5, tf_nuevo_proveedor_pais.getText());
            pst.setString(6, tf_nuevo_proveedor_correo.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Proveedor Creadoo con exito!");
                Proveedor p = new Proveedor(Integer.parseInt(tf_nuevo_proveedor_id.getText()),
                        tf_nuevo_proveedor_direccion.getText(),
                        tf_nuevo_proveedor_telefono.getText(),
                        tf_nuevo_proveedor_nombre.getText(),
                        tf_nuevo_proveedor_pais.getText(),
                        tf_nuevo_proveedor_correo.getText());
                proveedores.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < proveedores.size(); i++) {
            modelo.addElement(proveedores.get(i).getNombre());
        }
        cb_borrar_proveedor.setModel(modelo);
        cb_editar_proveedor.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) tabla_proveedores.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < proveedores.size(); i++) {
            tmodel.addRow(new Object[]{Integer.toString(proveedores.get(i).getId_Proveedor()),
                proveedores.get(i).getNombre(),
                proveedores.get(i).getDireccion(),
                proveedores.get(i).getPais(),
                proveedores.get(i).getTelefono(),
                proveedores.get(i).getEmail()});
        }
        tabla_proveedores.setModel(tmodel);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void cb_editar_ProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_editar_ProductoItemStateChanged
        // TODO add your handling code here:
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(cb_editar_Producto.getSelectedItem().toString())) {
                id_Producto = productos.get(i).getId_Produto();
                tf_editar_Producto_id.setText(Integer.toString(productos.get(i).getId_Produto()));
                tf_editar_Producto_nombre.setText(productos.get(i).getNombre());
                Sp_editar_Producto_precio.setValue(productos.get(i).getPrecio());
                Sp_editar_Producto_Tcantidad.setValue(productos.get(i).getCantidad());
                for (int j = 0; j < proveedores.size(); j++) {
                    if (proveedores.get(j).getId_Proveedor() == productos.get(i).getIdProveedor()) {
                        cb_editar_Producto_proveedor.setSelectedItem(proveedores.get(j).getNombre());
                    }
                }
            }
        }
    }//GEN-LAST:event_cb_editar_ProductoItemStateChanged

    private void cb_editar_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_editar_ProductoActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(cb_editar_Producto.getSelectedItem().toString())) {
                id_Producto = productos.get(i).getId_Produto();
                tf_editar_Producto_id.setText(Integer.toString(productos.get(i).getId_Produto()));
                tf_editar_Producto_nombre.setText(productos.get(i).getNombre());
                Sp_editar_Producto_precio.setValue(productos.get(i).getPrecio());
                Sp_editar_Producto_Tcantidad.setValue(productos.get(i).getCantidad());
                for (int j = 0; j < proveedores.size(); j++) {
                    if (proveedores.get(j).getId_Proveedor() == productos.get(i).getIdProveedor()) {
                        cb_editar_Producto_proveedor.setSelectedItem(proveedores.get(j).getNombre());
                    }
                }
            }
        }
    }//GEN-LAST:event_cb_editar_ProductoActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        int Proveedor_idProveedor = 0;
        for (int i = 0; i < proveedores.size(); i++) {
            if (cb_editar_Producto_proveedor.getSelectedItem().equals(proveedores.get(i).getNombre())) {
                Proveedor_idProveedor = proveedores.get(i).getId_Proveedor();
            }
        }
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "UPDATE producto SET cantidad=?, nombre=? ,precio=? ,Proveedor_idProveedor=? "
                    + "WHERE idProducto=" + id_Producto;
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, Sp_editar_Producto_Tcantidad.getValue().toString());
            pst.setString(2, tf_editar_Producto_nombre.getText());
            pst.setString(3, Sp_editar_Producto_precio.getValue().toString());
            pst.setString(4, Integer.toString(Proveedor_idProveedor));
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Producto Actualizado con exito!");
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getId_Produto() == id_Producto) {
                        productos.get(i).setId_Produto(id_Producto);
                        productos.get(i).setCantidad(Double.parseDouble(Sp_editar_Producto_Tcantidad.getValue().toString()));
                        productos.get(i).setNombre(tf_editar_Producto_nombre.getText());
                        productos.get(i).setPrecio(Double.parseDouble(Sp_editar_Producto_precio.getValue().toString()));
                        productos.get(i).setIdProveedor(Proveedor_idProveedor);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < productos.size(); i++) {
            modelo.addElement(productos.get(i).getNombre());
        }
        cb_borrar_producto.setModel(modelo);
        cb_editar_Producto.setModel(modelo);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTabbedPane17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane17MouseClicked
        // TODO add your handling code here:
        if (jTabbedPane17.getSelectedIndex() == 1) {
            DefaultTableModel tmodel = (DefaultTableModel) jTable_Producto.getModel();
            int fila = tmodel.getRowCount();
            for (int i = 1; i <= fila; i++) {
                tmodel.removeRow(0);
            }
            for (int i = 0; i < productos.size(); i++) {
                tmodel.addRow(new Object[]{productos.get(i).getId_Produto(),
                    productos.get(i).getNombre(),
                    productos.get(i).getPrecio(),
                    productos.get(i).getCantidad(),
                    productos.get(i).getIdProveedor()});
            }
            jTable_Producto.setModel(tmodel);
        } else if (jTabbedPane17.getSelectedIndex() == 2) {
            tf_nuevo_producto_id.setText(Integer.toString(productos.get(productos.size() - 1).getId_Produto() + 1));

        }
    }//GEN-LAST:event_jTabbedPane17MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(cb_borrar_producto.getSelectedItem())) {
                id_Producto = productos.get(i).getId_Produto();
            }
        }
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "DELETE FROM producto "
                    + "WHERE idProducto=?";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, id_Producto);
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Producto Eliminado con exito!");
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getId_Produto() == id_Producto) {
                        productos.remove(i);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < productos.size(); i++) {
            modelo.addElement(productos.get(i).getNombre());
        }
        cb_borrar_producto.setModel(modelo);
        cb_editar_Producto.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) jTable_Producto.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < productos.size(); i++) {
            tmodel.addRow(new Object[]{productos.get(i).getId_Produto(),
                productos.get(i).getNombre(),
                productos.get(i).getPrecio(),
                productos.get(i).getCantidad(),
                productos.get(i).getIdProveedor()});
        }
        jTable_Producto.setModel(tmodel);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        int idNuevoProveedor = 0;
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getNombre().equals(cb_nuevo_Producto_proveedor.getSelectedItem().toString())) {
                idNuevoProveedor = proveedores.get(i).getId_Proveedor();
            }
        }
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "INSERT INTO producto (idProducto, cantidad, nombre, precio, Proveedor_idProveedor)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tf_nuevo_producto_id.getText()));
            pst.setDouble(2, Double.parseDouble(Sp_nuevo_producto_Tcantidad.getValue().toString()));
            pst.setString(3, tf_nuevo_producto_nombre.getText());
            pst.setDouble(4, Double.parseDouble(Sp_nuevo_producto_precio.getValue().toString()));
            pst.setInt(5, idNuevoProveedor);
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Producto Creadoo con exito!");
                Producto pro = new Producto(Integer.parseInt(tf_nuevo_producto_id.getText()),
                        Double.parseDouble(Sp_nuevo_producto_Tcantidad.getValue().toString()),
                        tf_nuevo_producto_nombre.getText(),
                        Double.parseDouble(Sp_nuevo_producto_precio.getValue().toString()),
                        idNuevoProveedor);
                productos.add(pro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");

        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < productos.size(); i++) {
            modelo.addElement(productos.get(i).getNombre());
        }
        cb_borrar_producto.setModel(modelo);
        cb_editar_Producto.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) jTable_Producto.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < productos.size(); i++) {
            tmodel.addRow(new Object[]{productos.get(i).getId_Produto(),
                productos.get(i).getNombre(),
                productos.get(i).getPrecio(),
                productos.get(i).getCantidad(),
                productos.get(i).getIdProveedor()});
        }
        jTable_Producto.setModel(tmodel);
    }//GEN-LAST:event_jButton23ActionPerformed

<<<<<<< HEAD
    private void cb_editar_conductor_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_editar_conductor_idItemStateChanged
        // evento para actualizar el combo box de conductor
        this.cb_editar_conductor_id.removeAllItems();
        for (int i = 0; i < this.conductores.size(); i++) {
            this.cb_editar_conductor_id.addItem(Integer.toString(this.conductores.get(i).getId_conductor()));
        }
        //codigo para escribir los datos en la ventana del id seleccionado del conductor
        int id_conductor_seleccionado = Integer.parseInt(this.cb_editar_conductor_id.getSelectedItem().toString());
        for (int i = 0; i < this.conductores.size(); i++) {
            if (id_conductor_seleccionado == this.conductores.get(i).getId_conductor()) {
                this.tf_editar_conductor_id.setText(Integer.toString(this.conductores.get(i).getId_conductor()));
                this.tf_editar_conductor_direccion.setText(this.conductores.get(i).getDireccion());
                this.tf_editar_conductor_nombre.setText(this.conductores.get(i).getNombre());
                this.tf_editar_conductor_apellido.setText(this.conductores.get(i).getApellido());
                this.Sp_nuevo_conductor_salario.setValue(this.conductores.get(i).getSueldo());
                this.Sp_nuevo_conductor_edad.setValue(this.conductores.get(i).getEdad());
                this.Sp_nuevo_conductor_viaticos.setValue(this.conductores.get(i).getViaticos());
                break;
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontro ningun conductor");
        
    }//GEN-LAST:event_cb_editar_conductor_idItemStateChanged

    private void jd_ConductorWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jd_ConductorWindowOpened
        // evento para actualizar el combo box cuando habre la ventana
        this.cb_editar_conductor_id.removeAllItems();
        for (int i = 0; i < this.conductores.size(); i++) {
            this.cb_editar_conductor_id.addItem(Integer.toString(this.conductores.get(i).getId_conductor()));
        }
    }//GEN-LAST:event_jd_ConductorWindowOpened

    private void jButton31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton31MouseClicked
        // evento para editar un conductor
        //public Conductor(int id_conductor, String direccion, String nombre,
            //String apellido, String localizador, double sueldo, int edad, double viaticos, String telefono, int id_Producto)
        int id_conductor = Integer.parseInt(this.tf_editar_conductor_id.getText());
        String direccion = this.tf_editar_conductor_direccion.getText();
        String nombre = this.tf_editar_conductor_nombre.getText();
        String apellido = this.tf_editar_conductor_apellido.getText();
        double sueldo = (double)this.Sp_editar_conductor_salario.getValue();
        int edad = (int)this.Sp_editar_conductor_edad.getValue();
        double viaticos = (double)this.Sp_editar_conductor_viaticos.getValue();
        String telefono = this.tf_editar_conductor_telefono.getText();
        this.tf_editar_conductor_id.setText("");
        this.tf_editar_conductor_direccion.setText("");
        this.tf_editar_conductor_nombre.setText("");
        this.tf_editar_conductor_apellido.setText("");
        this.Sp_editar_conductor_salario.setValue(0);
        this.Sp_editar_conductor_edad.setValue(0);
        this.Sp_editar_conductor_viaticos.setValue(0);
        this.tf_editar_conductor_telefono.setText("");
    }//GEN-LAST:event_jButton31MouseClicked

    private void jTable_conductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_conductorMouseClicked
        // evento para actualizar la tabla de conductores
        DefaultTableModel tmodel = (DefaultTableModel) this.jTable_conductor.getModel();
=======
    private void cb_editar_ClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_editar_ClienteItemStateChanged
        // TODO add your handling code here:
        for (int i = 0; i < clientes.size(); i++) {
            if (cb_editar_Cliente.getSelectedItem().equals(clientes.get(i).getNombre_Empresa())) {
                id_Cliente = clientes.get(i).getCliente();
                tf_editar_Cliente_id.setText(Integer.toString(clientes.get(i).getCliente()));
                tf_editar_Cliente_empresa.setText(clientes.get(i).getNombre_Empresa());
                SpinnerDateModel model = (SpinnerDateModel)Sp_editar_Cliente_fecaInicio.getModel();
                model.setValue(clientes.get(i).getFecha_iniContrato());
                Sp_editar_Cliente_fecaInicio.setValue(model.getDate());
                tf_editar_Cliente_direccion.setText(clientes.get(i).getDireccion());
                tf_editar_cliente_telefono.setText(clientes.get(i).getTelefono());
                tf_editar_Cliente_nombreContacto.setText(clientes.get(i).getNombre());
            }
        }
    }//GEN-LAST:event_cb_editar_ClienteItemStateChanged

    private void cb_editar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_editar_ClienteActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < clientes.size(); i++) {
            if (cb_editar_Cliente.getSelectedItem().equals(clientes.get(i).getNombre_Empresa())) {
                id_Cliente = clientes.get(i).getCliente();
                tf_editar_Cliente_id.setText(Integer.toString(clientes.get(i).getCliente()));
                tf_editar_Cliente_empresa.setText(clientes.get(i).getNombre_Empresa());
                SpinnerDateModel model = (SpinnerDateModel)Sp_editar_Cliente_fecaInicio.getModel();
                model.setValue(clientes.get(i).getFecha_iniContrato());
                Sp_editar_Cliente_fecaInicio.setValue(model.getDate());
                tf_editar_Cliente_direccion.setText(clientes.get(i).getDireccion());
                tf_editar_cliente_telefono.setText(clientes.get(i).getTelefono());
                tf_editar_Cliente_nombreContacto.setText(clientes.get(i).getNombre());
            }
        }
    }//GEN-LAST:event_cb_editar_ClienteActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "UPDATE cliente SET telefono=?, direccion=?, nombrecontacto=?, fechainiciocontrato=?, nombreempresa=? "
                    + "WHERE idCliente=" + id_Cliente;
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, tf_editar_cliente_telefono.getText());
            pst.setString(2, tf_editar_Cliente_direccion.getText());
            pst.setString(3, tf_editar_Cliente_nombreContacto.getText());
            SpinnerDateModel model = (SpinnerDateModel)Sp_editar_Cliente_fecaInicio.getModel();
            pst.setDate(4, new java.sql.Date(model.getDate().getTime()));
            pst.setString(5, tf_editar_Cliente_empresa.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Cliente Actualizado con exito!");
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).getCliente() == id_Cliente) {
                        clientes.get(i).setCliente(id_Cliente);
                        clientes.get(i).setTelefono(tf_editar_cliente_telefono.getText());
                        clientes.get(i).setDireccion(tf_editar_Cliente_direccion.getText());
                        clientes.get(i).setNombre(tf_editar_Cliente_nombreContacto.getText());
                        clientes.get(i).setFecha_iniContrato(model.getDate());
                        clientes.get(i).setNombre_Empresa(tf_editar_Cliente_empresa.getText());
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < clientes.size(); i++) {
            modelo.addElement(clientes.get(i).getNombre_Empresa());
        }
        cb_borrar_cliente.setModel(modelo);
        cb_editar_Cliente.setModel(modelo);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTabbedPane18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane18MouseClicked
        // TODO add your handling code here:
        if (jTabbedPane18.getSelectedIndex() == 1) {
            DefaultTableModel tmodel = (DefaultTableModel) jTable_cliente.getModel();
            int fila = tmodel.getRowCount();
            for (int i = 1; i <= fila; i++) {
                tmodel.removeRow(0);
            }
            for (int i = 0; i < clientes.size(); i++) {
                tmodel.addRow(new Object[]{clientes.get(i).getCliente(),
                clientes.get(i).getNombre_Empresa(),
                clientes.get(i).getFecha_iniContrato(),
                clientes.get(i).getDireccion(),
                clientes.get(i).getTelefono(),
                clientes.get(i).getNombre()});
            }
            jTable_cliente.setModel(tmodel);
        } else if (jTabbedPane18.getSelectedIndex() == 2) {
            tf_nuevo_Cliente_id.setText(Integer.toString(clientes.get(clientes.size() - 1).getCliente() + 1));
        }
    }//GEN-LAST:event_jTabbedPane18MouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "DELETE FROM cliente "
                    + "WHERE idCliente=?";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, id_Cliente);
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Cliente Eliminado con exito!");
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).getCliente()== id_Cliente) {
                        clientes.remove(i);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < clientes.size(); i++) {
            modelo.addElement(clientes.get(i).getNombre_Empresa());
        }
        cb_borrar_cliente.setModel(modelo);
        cb_editar_Cliente.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) jTable_cliente.getModel();
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
<<<<<<< HEAD
        for (int i = 0; i < this.conductores.size(); i++) {
            tmodel.addRow(new Object[]{conductores.get(i).getId_conductor(),
                conductores.get(i).getNombre(),
                conductores.get(i).getApellido(),
                conductores.get(i).getEdad(),
                conductores.get(i).getDireccion(),
                conductores.get(i).getSueldo(),
                conductores.get(i).getViaticos(),
                conductores.get(i).getTelefono()
            });
        }
        this.jTable_conductor.setModel(tmodel);
    }//GEN-LAST:event_jTable_conductorMouseClicked

    private void cb_borrar_conductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_borrar_conductorActionPerformed
        // evento para cargar los id conductores en el combo box de la ventana borrar conductor
        this.cb_borrar_conductor.removeAllItems();
        for (int i = 0; i < this.conductores.size(); i++) {
            this.cb_borrar_conductor.addItem(Integer.toString(this.conductores.get(i).getId_conductor()));
        }
    }//GEN-LAST:event_cb_borrar_conductorActionPerformed

    private void jButton32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton32MouseClicked
        // evento para borrar un conductor
        int id_conductor_a_borrar = Integer.parseInt(this.cb_borrar_conductor.getSelectedItem().toString());
        for (int i = 0; i < this.conductores.size(); i++) {
            if (id_conductor_a_borrar == this.conductores.get(i).getId_conductor()) {
                this.conductores.remove(i);
                JOptionPane.showMessageDialog(this, "Borrado con exito");
                break;
            }
        }
    }//GEN-LAST:event_jButton32MouseClicked
=======
        for (int i = 0; i < clientes.size(); i++) {
            tmodel.addRow(new Object[]{clientes.get(i).getCliente(),
                clientes.get(i).getNombre_Empresa(),
                clientes.get(i).getFecha_iniContrato(),
                clientes.get(i).getDireccion(),
                clientes.get(i).getTelefono(),
                clientes.get(i).getNombre()});
        }
        jTable_cliente.setModel(tmodel);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "INSERT INTO cliente (idCliente, telefono, direccion, nombrecontacto, fechainiciocontrato, nombreempresa)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tf_nuevo_Cliente_id.getText()));
            pst.setString(2, tf_nuevo_cliente_telefono.getText());
            pst.setString(3, tf_nuevo_Cliente_direccion.getText());
            pst.setString(4, tf_nuevo_Cliente_nombreContacto.getText());
            SpinnerDateModel model = (SpinnerDateModel)Sp_nuevo_Cliente_fechaInicio.getModel();
            pst.setDate(5, new java.sql.Date(model.getDate().getTime()));
            pst.setString(6, tf_nuevo_Cliente_empresa.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Cliente Creadoo con exito!");
                Cliente clie = new Cliente(Integer.parseInt(tf_nuevo_Cliente_id.getText()),
                                           tf_nuevo_cliente_telefono.getText(),
                                           tf_nuevo_Cliente_direccion.getText(),
                                           tf_nuevo_Cliente_nombreContacto.getText(),
                                           model.getDate(),
                                           tf_nuevo_Cliente_empresa.getText());
                clientes.add(clie);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");

        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < productos.size(); i++) {
            modelo.addElement(productos.get(i).getNombre());
        }
        cb_borrar_producto.setModel(modelo);
        cb_editar_Producto.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) jTable_Producto.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < productos.size(); i++) {
            tmodel.addRow(new Object[]{productos.get(i).getId_Produto(),
                productos.get(i).getNombre(),
                productos.get(i).getPrecio(),
                productos.get(i).getCantidad(),
                productos.get(i).getIdProveedor()});
        }
        jTable_Producto.setModel(tmodel);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane4MouseClicked
>>>>>>> ccba3b2afd5b7cee20c348f95999def9060532fc

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Sp_editar_Cliente_fecaInicio;
    private javax.swing.JSpinner Sp_editar_Producto_Tcantidad;
    private javax.swing.JSpinner Sp_editar_Producto_precio;
    private javax.swing.JSpinner Sp_editar_conductor_edad;
    private javax.swing.JSpinner Sp_editar_conductor_salario;
    private javax.swing.JSpinner Sp_editar_conductor_viaticos;
    private javax.swing.JSpinner Sp_editar_factura_fechaInicio;
    private javax.swing.JSpinner Sp_editar_vehiculo_año;
    private javax.swing.JSpinner Sp_editar_vehiculo_capaCombus;
    private javax.swing.JTextField Sp_editar_vehiculo_color;
    private javax.swing.JSpinner Sp_editar_vehiculo_kilometraje;
    private javax.swing.JSpinner Sp_editar_vehiculo_tm;
    private javax.swing.JSpinner Sp_nuevo_Cliente_fechaInicio;
    private javax.swing.JSpinner Sp_nuevo_conductor_edad;
    private javax.swing.JSpinner Sp_nuevo_conductor_salario;
    private javax.swing.JSpinner Sp_nuevo_conductor_viaticos;
    private javax.swing.JSpinner Sp_nuevo_factura_fechaInicio;
    private javax.swing.JSpinner Sp_nuevo_producto_Tcantidad;
    private javax.swing.JSpinner Sp_nuevo_producto_precio;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_año;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_capaCombu;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_kilometra;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_tm;
    private javax.swing.JComboBox<String> cb_borrar_cliente;
    private javax.swing.JComboBox<String> cb_borrar_conductor;
    private javax.swing.JComboBox<String> cb_borrar_factura;
    private javax.swing.JComboBox<String> cb_borrar_producto;
    private javax.swing.JComboBox<String> cb_borrar_proveedor;
    private javax.swing.JComboBox<String> cb_borrar_traileta;
    private javax.swing.JComboBox<String> cb_borrar_vehiculo;
    private javax.swing.JComboBox<String> cb_editar_Cliente;
    private javax.swing.JComboBox<String> cb_editar_Producto;
    private javax.swing.JComboBox<String> cb_editar_Producto_proveedor;
    private javax.swing.JComboBox<String> cb_editar_conductor_id;
    private javax.swing.JComboBox<String> cb_editar_proveedor;
    private javax.swing.JComboBox<String> cb_editar_vehiculo;
    private javax.swing.JComboBox<String> cb_editar_vehiculo_tipoCombu;
    private javax.swing.JComboBox<String> cb_nuevo_Producto_proveedor;
    private javax.swing.JComboBox<String> cb_nuevo_vehiculo_tipoCombu;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane17;
    private javax.swing.JTabbedPane jTabbedPane18;
    private javax.swing.JTabbedPane jTabbedPane19;
    private javax.swing.JTabbedPane jTabbedPane20;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable_Producto;
    private javax.swing.JTable jTable_cliente;
    private javax.swing.JTable jTable_conductor;
    private javax.swing.JTable jTable_traileta;
    private javax.swing.JTable jTable_vehivculo;
    private javax.swing.JDialog jd_Cliente;
    private javax.swing.JDialog jd_Conductor;
    private javax.swing.JDialog jd_Factura;
    private javax.swing.JDialog jd_Producto;
    private javax.swing.JDialog jd_Proveedor;
    private javax.swing.JDialog jd_Vehiculo;
    private javax.swing.JLabel jl_CLIENTE;
    private javax.swing.JLabel jl_CONDUCTOR;
    private javax.swing.JLabel jl_FACTURA;
    private javax.swing.JLabel jl_PRODUCTO;
    private javax.swing.JLabel jl_PROVEEDOR;
    private javax.swing.JLabel jl_VEHICULO;
    private javax.swing.JLabel jl_cliente_editar_contacto;
    private javax.swing.JLabel jl_cliente_editar_direccion;
    private javax.swing.JLabel jl_cliente_editar_empresa;
    private javax.swing.JLabel jl_cliente_editar_fecaInicio;
    private javax.swing.JLabel jl_cliente_editar_fondo;
    private javax.swing.JLabel jl_cliente_editar_id;
    private javax.swing.JLabel jl_cliente_editar_nombre_de;
    private javax.swing.JLabel jl_cliente_editar_seleccionar;
    private javax.swing.JLabel jl_cliente_editar_telefono;
    private javax.swing.JLabel jl_cliente_fondo;
    private javax.swing.JLabel jl_cliente_nuevo_contacto;
    private javax.swing.JLabel jl_cliente_nuevo_direccion;
    private javax.swing.JLabel jl_cliente_nuevo_empresa;
    private javax.swing.JLabel jl_cliente_nuevo_fechaInicio;
    private javax.swing.JLabel jl_cliente_nuevo_fondo;
    private javax.swing.JLabel jl_cliente_nuevo_id;
    private javax.swing.JLabel jl_cliente_nuevo_nombre_de;
    private javax.swing.JLabel jl_cliente_nuevo_telefono;
    private javax.swing.JLabel jl_cliente_subtitulo;
    private javax.swing.JLabel jl_cliente_titulo;
    private javax.swing.JLabel jl_cliente_ver_fondo;
    private javax.swing.JLabel jl_cliente_ver_seleccionar;
    private javax.swing.JLabel jl_conductor_editar_apellidos;
    private javax.swing.JLabel jl_conductor_editar_direccion;
    private javax.swing.JLabel jl_conductor_editar_edad;
    private javax.swing.JLabel jl_conductor_editar_fondo;
    private javax.swing.JLabel jl_conductor_editar_id;
    private javax.swing.JLabel jl_conductor_editar_nombres;
    private javax.swing.JLabel jl_conductor_editar_salario;
    private javax.swing.JLabel jl_conductor_editar_seleccionar;
    private javax.swing.JLabel jl_conductor_editar_telefono;
    private javax.swing.JLabel jl_conductor_editar_vitalicio;
    private javax.swing.JLabel jl_conductor_fondo;
    private javax.swing.JLabel jl_conductor_nuevo_apellidos;
    private javax.swing.JLabel jl_conductor_nuevo_direccion;
    private javax.swing.JLabel jl_conductor_nuevo_edad;
    private javax.swing.JLabel jl_conductor_nuevo_fondo;
    private javax.swing.JLabel jl_conductor_nuevo_id;
    private javax.swing.JLabel jl_conductor_nuevo_nombres;
    private javax.swing.JLabel jl_conductor_nuevo_salario;
    private javax.swing.JLabel jl_conductor_nuevo_telefono;
    private javax.swing.JLabel jl_conductor_nuevo_viaticos;
    private javax.swing.JLabel jl_conductor_subtitulo;
    private javax.swing.JLabel jl_conductor_titulo;
    private javax.swing.JLabel jl_conductor_ver_conductor;
    private javax.swing.JLabel jl_conductor_ver_fondo;
    private javax.swing.JLabel jl_factura_editar_fecha;
    private javax.swing.JLabel jl_factura_editar_fondo;
    private javax.swing.JLabel jl_factura_editar_id_cliente;
    private javax.swing.JLabel jl_factura_editar_numero;
    private javax.swing.JLabel jl_factura_editar_rtn;
    private javax.swing.JLabel jl_factura_editar_subtotal;
    private javax.swing.JLabel jl_factura_editar_tm;
    private javax.swing.JLabel jl_factura_editar_total;
    private javax.swing.JLabel jl_factura_imagen_fondo;
    private javax.swing.JLabel jl_factura_nuevo_fecha;
    private javax.swing.JLabel jl_factura_nuevo_fondo;
    private javax.swing.JLabel jl_factura_nuevo_id_cliente;
    private javax.swing.JLabel jl_factura_nuevo_numero;
    private javax.swing.JLabel jl_factura_nuevo_rtn;
    private javax.swing.JLabel jl_factura_nuevo_subtotal;
    private javax.swing.JLabel jl_factura_nuevo_tm;
    private javax.swing.JLabel jl_factura_nuevo_total;
    private javax.swing.JLabel jl_factura_subtitulo;
    private javax.swing.JLabel jl_factura_titulo;
    private javax.swing.JLabel jl_factura_ver_fondo;
    private javax.swing.JLabel jl_factura_ver_seleccionar;
    private javax.swing.JLabel jl_imagen;
    private javax.swing.JLabel jl_opciones;
    private javax.swing.JLabel jl_producto_editar_Tcantidad;
    private javax.swing.JLabel jl_producto_editar_fondo;
    private javax.swing.JLabel jl_producto_editar_id;
    private javax.swing.JLabel jl_producto_editar_nombre;
    private javax.swing.JLabel jl_producto_editar_precio;
    private javax.swing.JLabel jl_producto_editar_proveedor;
    private javax.swing.JLabel jl_producto_editar_seleccionar;
    private javax.swing.JLabel jl_producto_imagen_fondo;
    private javax.swing.JLabel jl_producto_nuevo_Tcantidad;
    private javax.swing.JLabel jl_producto_nuevo_fondo;
    private javax.swing.JLabel jl_producto_nuevo_id;
    private javax.swing.JLabel jl_producto_nuevo_nombre;
    private javax.swing.JLabel jl_producto_nuevo_precio;
    private javax.swing.JLabel jl_producto_nuevo_proveedor;
    private javax.swing.JLabel jl_producto_subtitulo;
    private javax.swing.JLabel jl_producto_titulo;
    private javax.swing.JLabel jl_producto_ver_fondo;
    private javax.swing.JLabel jl_producto_ver_seleccionar;
    private javax.swing.JLabel jl_proveedor_editar_correo;
    private javax.swing.JLabel jl_proveedor_editar_direccion;
    private javax.swing.JLabel jl_proveedor_editar_fondo;
    private javax.swing.JLabel jl_proveedor_editar_id;
    private javax.swing.JLabel jl_proveedor_editar_nombre;
    private javax.swing.JLabel jl_proveedor_editar_pais;
    private javax.swing.JLabel jl_proveedor_editar_proveedor;
    private javax.swing.JLabel jl_proveedor_editar_telefono;
    private javax.swing.JLabel jl_proveedor_imagen_fondo;
    private javax.swing.JLabel jl_proveedor_nuevo_correo;
    private javax.swing.JLabel jl_proveedor_nuevo_direccion;
    private javax.swing.JLabel jl_proveedor_nuevo_fondo;
    private javax.swing.JLabel jl_proveedor_nuevo_id;
    private javax.swing.JLabel jl_proveedor_nuevo_nombre;
    private javax.swing.JLabel jl_proveedor_nuevo_pais;
    private javax.swing.JLabel jl_proveedor_nuevo_telefono;
    private javax.swing.JLabel jl_proveedor_subtitulo;
    private javax.swing.JLabel jl_proveedor_titulo;
    private javax.swing.JLabel jl_proveedor_ver_fondo;
    private javax.swing.JLabel jl_proveedor_ver_seleccionar;
    private javax.swing.JLabel jl_subrayado;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JPanel jp_cliente_editar;
    private javax.swing.JPanel jp_cliente_nuevo;
    private javax.swing.JPanel jp_cliente_ver;
    private javax.swing.JPanel jp_conductor_editar;
    private javax.swing.JPanel jp_conductor_nuevo;
    private javax.swing.JPanel jp_conductor_ver;
    private javax.swing.JPanel jp_factura_editar;
    private javax.swing.JPanel jp_factura_nuevo;
    private javax.swing.JPanel jp_factura_ver;
    private javax.swing.JPanel jp_producto_editar;
    private javax.swing.JPanel jp_producto_nuevo;
    private javax.swing.JPanel jp_producto_ver;
    private javax.swing.JPanel jp_proveedor_editar;
    private javax.swing.JPanel jp_proveedor_nuevo;
    private javax.swing.JPanel jp_proveedor_ver;
    private javax.swing.JPanel jp_vehiculo_editar;
    private javax.swing.JLabel jp_vehiculo_editar_anio;
    private javax.swing.JLabel jp_vehiculo_editar_capaCombus;
    private javax.swing.JLabel jp_vehiculo_editar_color;
    private javax.swing.JLabel jp_vehiculo_editar_fondo;
    private javax.swing.JLabel jp_vehiculo_editar_kilometraje;
    private javax.swing.JLabel jp_vehiculo_editar_localizador;
    private javax.swing.JLabel jp_vehiculo_editar_marca;
    private javax.swing.JLabel jp_vehiculo_editar_modelo;
    private javax.swing.JPanel jp_vehiculo_editar_nuevo;
    private javax.swing.JLabel jp_vehiculo_editar_placa;
    private javax.swing.JLabel jp_vehiculo_editar_tipoCombu;
    private javax.swing.JLabel jp_vehiculo_editar_tm;
    private javax.swing.JLabel jp_vehiculo_editar_traileta;
    private javax.swing.JLabel jp_vehiculo_fondo;
    private javax.swing.JLabel jp_vehiculo_nuevo_anio;
    private javax.swing.JLabel jp_vehiculo_nuevo_capaCombu;
    private javax.swing.JLabel jp_vehiculo_nuevo_color;
    private javax.swing.JLabel jp_vehiculo_nuevo_fondo;
    private javax.swing.JLabel jp_vehiculo_nuevo_kilometraje;
    private javax.swing.JLabel jp_vehiculo_nuevo_localizador;
    private javax.swing.JLabel jp_vehiculo_nuevo_marca;
    private javax.swing.JLabel jp_vehiculo_nuevo_modelo;
    private javax.swing.JLabel jp_vehiculo_nuevo_placa;
    private javax.swing.JLabel jp_vehiculo_nuevo_tipoCombu;
    private javax.swing.JLabel jp_vehiculo_nuevo_tm;
    private javax.swing.JLabel jp_vehiculo_nuevo_traileta;
    private javax.swing.JLabel jp_vehiculo_subtitulo;
    private javax.swing.JLabel jp_vehiculo_titulo;
    private javax.swing.JPanel jp_vehiculo_ver;
    private javax.swing.JLabel jp_vehiculo_ver_fondo;
    private javax.swing.JLabel jp_vehiculo_ver_seleccionar_traileta;
    private javax.swing.JLabel jp_vehiculo_ver_seleccionar_vehiculo;
    private javax.swing.JTable tabla_facturas;
    private javax.swing.JTable tabla_proveedores;
    private javax.swing.JTextField tf_editar_Cliente_direccion;
    private javax.swing.JTextField tf_editar_Cliente_empresa;
    private javax.swing.JTextField tf_editar_Cliente_id;
    private javax.swing.JTextField tf_editar_Cliente_nombreContacto;
    private javax.swing.JTextField tf_editar_Producto_id;
    private javax.swing.JTextField tf_editar_Producto_nombre;
    private javax.swing.JFormattedTextField tf_editar_cliente_telefono;
    private javax.swing.JTextField tf_editar_conductor_apellido;
    private javax.swing.JTextField tf_editar_conductor_direccion;
    private javax.swing.JTextField tf_editar_conductor_id;
    private javax.swing.JTextField tf_editar_conductor_nombre;
    private javax.swing.JTextField tf_editar_conductor_telefono;
    private javax.swing.JTextField tf_editar_factura_id_cliente;
    private javax.swing.JTextField tf_editar_factura_numero;
    private javax.swing.JTextField tf_editar_factura_rtn;
    private javax.swing.JTextField tf_editar_factura_subtotal;
    private javax.swing.JTextField tf_editar_factura_tm;
    private javax.swing.JTextField tf_editar_factura_total;
    private javax.swing.JTextField tf_editar_proveedor_correo;
    private javax.swing.JTextField tf_editar_proveedor_direccion;
    private javax.swing.JTextField tf_editar_proveedor_id;
    private javax.swing.JTextField tf_editar_proveedor_nombre;
    private javax.swing.JTextField tf_editar_proveedor_pais;
    private javax.swing.JFormattedTextField tf_editar_proveedor_telefono;
    private javax.swing.JTextField tf_editar_vehiculo_localizador;
    private javax.swing.JTextField tf_editar_vehiculo_marca;
    private javax.swing.JTextField tf_editar_vehiculo_modelo;
    private javax.swing.JTextField tf_editar_vehiculo_placa;
    private javax.swing.JTextField tf_nuevo_Cliente_direccion;
    private javax.swing.JTextField tf_nuevo_Cliente_empresa;
    private javax.swing.JTextField tf_nuevo_Cliente_id;
    private javax.swing.JTextField tf_nuevo_Cliente_nombreContacto;
    private javax.swing.JFormattedTextField tf_nuevo_cliente_telefono;
    private javax.swing.JTextField tf_nuevo_conductor_apellido;
    private javax.swing.JTextField tf_nuevo_conductor_direccion;
    private javax.swing.JTextField tf_nuevo_conductor_id;
    private javax.swing.JTextField tf_nuevo_conductor_nombre;
    private javax.swing.JTextField tf_nuevo_conductor_telefono;
    private javax.swing.JTextField tf_nuevo_factura_id_cliente;
    private javax.swing.JTextField tf_nuevo_factura_numero;
    private javax.swing.JTextField tf_nuevo_factura_rtn;
    private javax.swing.JTextField tf_nuevo_factura_subtotal;
    private javax.swing.JTextField tf_nuevo_factura_tm;
    private javax.swing.JTextField tf_nuevo_factura_total;
    private javax.swing.JTextField tf_nuevo_producto_id;
    private javax.swing.JTextField tf_nuevo_producto_nombre;
    private javax.swing.JTextField tf_nuevo_proveedor_correo;
    private javax.swing.JTextField tf_nuevo_proveedor_direccion;
    private javax.swing.JTextField tf_nuevo_proveedor_id;
    private javax.swing.JTextField tf_nuevo_proveedor_nombre;
    private javax.swing.JTextField tf_nuevo_proveedor_pais;
    private javax.swing.JFormattedTextField tf_nuevo_proveedor_telefono;
    private javax.swing.JTextField tf_nuevo_vehiculo_color;
    private javax.swing.JTextField tf_nuevo_vehiculo_localizador;
    private javax.swing.JTextField tf_nuevo_vehiculo_marca;
    private javax.swing.JTextField tf_nuevo_vehiculo_modelo;
    private javax.swing.JTextField tf_nuevo_vehiculo_placa;
    // End of variables declaration//GEN-END:variables
    ArrayList<Proveedor> proveedores = new ArrayList();
    ArrayList<Conductor> conductores = new ArrayList();
    ArrayList<Vehiculo> vehiculos = new ArrayList();
    ArrayList<Producto> productos = new ArrayList();
    ArrayList<Cliente> clientes = new ArrayList();
    ArrayList<Factura> facturas = new ArrayList();
    int id_Proveedor;
    int id_Producto;
    int id_Cliente;
}
