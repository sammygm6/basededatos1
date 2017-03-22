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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

        //toma los valores de la tabla de conductor
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
                rs = stmt.executeQuery("select idConductor, direccion, nombres, apellidos, localizador, salario, edad, viaticos, telefono \n"
                        + "FROM transportecarmen.conductor c \n"
                        + ";");
                /*Carga los datos de la base de datos a las propiedades de la clase*/
                while (rs.next()) {
                    Conductor con = new Conductor(rs.getInt("idConductor"),
                            rs.getString("direccion"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("localizador"),
                            rs.getDouble("salario"),
                            rs.getInt("edad"),
                            rs.getDouble("viaticos"),
                            rs.getString("telefono"));
                    conductores.add(con);
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
        jPanel9 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        tf_editar_proveedor_id = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        tf_editar_proveedor_correo = new javax.swing.JTextField();
        tf_editar_proveedor_pais = new javax.swing.JTextField();
        tf_editar_proveedor_direccion = new javax.swing.JTextField();
        tf_editar_proveedor_nombre = new javax.swing.JTextField();
        tf_editar_proveedor_telefono = new javax.swing.JFormattedTextField();
        jButton7 = new javax.swing.JButton();
        cb_editar_proveedor = new javax.swing.JComboBox<String>();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_proveedores = new javax.swing.JTable();
        jLabel167 = new javax.swing.JLabel();
        cb_borrar_proveedor = new javax.swing.JComboBox<String>();
        jButton24 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        tf_nuevo_proveedor_id = new javax.swing.JTextField();
        tf_nuevo_proveedor_nombre = new javax.swing.JTextField();
        tf_nuevo_proveedor_direccion = new javax.swing.JTextField();
        tf_nuevo_proveedor_pais = new javax.swing.JTextField();
        tf_nuevo_proveedor_correo = new javax.swing.JTextField();
        tf_nuevo_proveedor_telefono = new javax.swing.JFormattedTextField();
        jButton9 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jd_Producto = new javax.swing.JDialog();
        jTabbedPane17 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        tf_editar_Producto_id = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        cb_editar_Producto_proveedor = new javax.swing.JComboBox<String>();
        tf_editar_Producto_nombre = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        cb_editar_Producto = new javax.swing.JComboBox<String>();
        Sp_editar_Producto_Tcantidad = new javax.swing.JSpinner();
        Sp_editar_Producto_precio = new javax.swing.JSpinner();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();
        jLabel166 = new javax.swing.JLabel();
        cb_borrar_producto = new javax.swing.JComboBox<String>();
        jButton22 = new javax.swing.JButton();
        jLabel168 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        tf_nuevo_producto_id = new javax.swing.JTextField();
        tf_nuevo_producto_nombre = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        cb_nuevo_Producto_proveedor = new javax.swing.JComboBox<String>();
        jButton23 = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        Sp_nuevo_producto_precio = new javax.swing.JSpinner();
        jLabel163 = new javax.swing.JLabel();
        Sp_nuevo_producto_Tcantidad = new javax.swing.JSpinner();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jd_Cliente = new javax.swing.JDialog();
        jTabbedPane18 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        tf_editar_Cliente_id = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        tf_editar_Cliente_direccion = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        cb_editar_Cliente = new javax.swing.JComboBox<String>();
        Sp_editar_Cliente_fecaInicio = new javax.swing.JSpinner();
        jLabel179 = new javax.swing.JLabel();
        tf_editar_Cliente_empresa = new javax.swing.JTextField();
        tf_editar_Cliente_nombreContacto = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        tf_editar_cliente_telefono = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_cliente = new javax.swing.JTable();
        jLabel181 = new javax.swing.JLabel();
        cb_borrar_cliente = new javax.swing.JComboBox<String>();
        jButton26 = new javax.swing.JButton();
        jLabel182 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jLabel194 = new javax.swing.JLabel();
        tf_nuevo_Cliente_id = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        tf_nuevo_Cliente_direccion = new javax.swing.JTextField();
        Sp_nuevo_Cliente_fechaInicio = new javax.swing.JSpinner();
        tf_nuevo_Cliente_empresa = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        tf_nuevo_Cliente_nombreContacto = new javax.swing.JTextField();
        tf_nuevo_Cliente_telefono = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jd_Vehiculo = new javax.swing.JDialog();
        jTabbedPane19 = new javax.swing.JTabbedPane();
        jPanel30 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        tf_editar_vehiculo_placa = new javax.swing.JTextField();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        tf_editar_vehiculo_modelo = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        cb_editar_vehiculo = new javax.swing.JComboBox<String>();
        Sp_editar_vehiculo_tm = new javax.swing.JSpinner();
        jLabel205 = new javax.swing.JLabel();
        tf_editar_vehiculo_marca = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        Sp_editar_vehiculo_año = new javax.swing.JSpinner();
        cb_editar_vehiculo_tipoCombu = new javax.swing.JComboBox<String>();
        Sp_editar_vehiculo_color = new javax.swing.JTextField();
        jLabel249 = new javax.swing.JLabel();
        tf_editar_vehiculo_localizador = new javax.swing.JTextField();
        Sp_editar_vehiculo_kilometraje = new javax.swing.JSpinner();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        Sp_editar_vehiculo_capaCombus = new javax.swing.JSpinner();
        jLabel209 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_vehivculo = new javax.swing.JTable();
        jLabel210 = new javax.swing.JLabel();
        cb_borrar_vehiculo = new javax.swing.JComboBox<String>();
        jButton29 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_traileta = new javax.swing.JTable();
        jLabel227 = new javax.swing.JLabel();
        cb_borrar_traileta = new javax.swing.JComboBox<String>();
        jButton35 = new javax.swing.JButton();
        jLabel211 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jLabel253 = new javax.swing.JLabel();
        tf_nuevo_vehiculo_placa = new javax.swing.JTextField();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        tf_nuevo_vehiculo_color = new javax.swing.JTextField();
        Sp_nuevo_vehiculo_año = new javax.swing.JSpinner();
        tf_nuevo_vehiculo_modelo = new javax.swing.JTextField();
        tf_nuevo_vehiculo_marca = new javax.swing.JTextField();
        jLabel260 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        Sp_nuevo_vehiculo_capaCombu = new javax.swing.JSpinner();
        cb_nuevo_vehiculo_tipoCombu = new javax.swing.JComboBox<String>();
        tf_nuevo_vehiculo_localizador = new javax.swing.JTextField();
        Sp_nuevo_vehiculo_kilometra = new javax.swing.JSpinner();
        Sp_nuevo_vehiculo_tm = new javax.swing.JSpinner();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jd_Conductor = new javax.swing.JDialog();
        jTabbedPane20 = new javax.swing.JTabbedPane();
        jPanel33 = new javax.swing.JPanel();
        jLabel212 = new javax.swing.JLabel();
        tf_editar_conductor_id = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        tf_editar_conductor_direccion = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        cb_editar_conductor = new javax.swing.JComboBox<String>();
        Sp_editar_conductor_viaticos = new javax.swing.JSpinner();
        jLabel216 = new javax.swing.JLabel();
        tf_editar_conductor_nombre = new javax.swing.JTextField();
        tf_editar_conductor_apellido = new javax.swing.JTextField();
        tf_editar_conductor_localizador = new javax.swing.JTextField();
        jLabel217 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        tf_editar_conductor_telefono = new javax.swing.JTextField();
        Sp_editar_conductor_edad = new javax.swing.JSpinner();
        Sp_editar_conductor_salario = new javax.swing.JSpinner();
        jLabel218 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_conductor = new javax.swing.JTable();
        jLabel235 = new javax.swing.JLabel();
        cb_borrar_conductor = new javax.swing.JComboBox<String>();
        jButton32 = new javax.swing.JButton();
        jLabel236 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        tf_nuevo_conductor_direccion = new javax.swing.JTextField();
        Sp_nuevo_conductor_edad = new javax.swing.JSpinner();
        tf_nuevo_conductor_apellido = new javax.swing.JTextField();
        tf_nuevo_conductor_nombre = new javax.swing.JTextField();
        tf_nuevo_conductor_id = new javax.swing.JTextField();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        tf_nuevo_conductor_telefono = new javax.swing.JTextField();
        jLabel252 = new javax.swing.JLabel();
        tf_nuevo_conductor_localizador = new javax.swing.JTextField();
        Sp_nuevo_conductor_viaticos = new javax.swing.JSpinner();
        Sp_nuevo_conductor_salario = new javax.swing.JSpinner();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jl_CONDUCTOR = new javax.swing.JLabel();
        jl_PRODUCTO = new javax.swing.JLabel();
        jl_FACTURA = new javax.swing.JLabel();
        jl_VEHICULO = new javax.swing.JLabel();
        jl_CLIENTE = new javax.swing.JLabel();
        jl_PROVEEDOR = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();

        jd_Proveedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane3.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane3.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setText("ID");
        jPanel9.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 102, -1, -1));

        tf_editar_proveedor_id.setEditable(false);
        tf_editar_proveedor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel9.add(tf_editar_proveedor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 97, 227, -1));

        jLabel69.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(204, 204, 204));
        jLabel69.setText("Nombre");
        jPanel9.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 156, -1, -1));

        jLabel70.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(204, 204, 204));
        jLabel70.setText("Direccion");
        jPanel9.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 210, -1, -1));

        jLabel71.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(204, 204, 204));
        jLabel71.setText("Pais");
        jPanel9.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 264, -1, -1));

        jLabel72.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(204, 204, 204));
        jLabel72.setText("Telefono");
        jPanel9.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 318, -1, -1));

        jLabel73.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(204, 204, 204));
        jLabel73.setText("Correo electronico");
        jPanel9.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 372, -1, -1));

        tf_editar_proveedor_correo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel9.add(tf_editar_proveedor_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 367, 227, -1));

        tf_editar_proveedor_pais.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel9.add(tf_editar_proveedor_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 259, 227, -1));

        tf_editar_proveedor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel9.add(tf_editar_proveedor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 205, 227, -1));

        tf_editar_proveedor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel9.add(tf_editar_proveedor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 151, 227, -1));

        try {
            tf_editar_proveedor_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_editar_proveedor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel9.add(tf_editar_proveedor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 310, 230, 40));

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
        jPanel9.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 241, 76));

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
        jPanel9.add(cb_editar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        jLabel74.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(204, 204, 204));
        jLabel74.setText("Seleccione Proveedor");
        jPanel9.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel9.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane3.addTab("E d i t a r          ", jPanel9);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1130, 360));

        jLabel167.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(204, 204, 204));
        jLabel167.setText("Seleccione Proveedor");
        jPanel11.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel11.add(cb_borrar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

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
        jPanel11.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jPanel11.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane3.addTab("        V e r / B o r r a r     ", jPanel11);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(204, 204, 204));
        jLabel85.setText("ID");
        jPanel12.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 34, -1, -1));

        jLabel86.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(204, 204, 204));
        jLabel86.setText("Nombre");
        jPanel12.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 93, -1, -1));

        jLabel87.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(204, 204, 204));
        jLabel87.setText("Direccion");
        jPanel12.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 147, -1, -1));

        jLabel88.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(204, 204, 204));
        jLabel88.setText("Pais");
        jPanel12.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 201, -1, -1));

        jLabel89.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(204, 204, 204));
        jLabel89.setText("Telefono");
        jPanel12.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 255, -1, -1));

        jLabel90.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(204, 204, 204));
        jLabel90.setText("Correo electronico");
        jPanel12.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 309, -1, -1));

        tf_nuevo_proveedor_id.setEditable(false);
        tf_nuevo_proveedor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel12.add(tf_nuevo_proveedor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 29, 186, -1));

        tf_nuevo_proveedor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel12.add(tf_nuevo_proveedor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 88, 186, -1));

        tf_nuevo_proveedor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel12.add(tf_nuevo_proveedor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 142, 186, -1));

        tf_nuevo_proveedor_pais.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel12.add(tf_nuevo_proveedor_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 196, 186, -1));

        tf_nuevo_proveedor_correo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel12.add(tf_nuevo_proveedor_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 304, 186, -1));

        try {
            tf_nuevo_proveedor_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_nuevo_proveedor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel12.add(tf_nuevo_proveedor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 190, 40));

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
        jPanel12.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel12.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane3.addTab("N u e v o          ", jPanel12);

        jd_Proveedor.getContentPane().add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jLabel68.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(204, 204, 204));
        jLabel68.setText("Transportes   Carmen");
        jd_Proveedor.getContentPane().add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jLabel66.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(204, 204, 0));
        jLabel66.setText("PROVEEDOR");
        jd_Proveedor.getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 860, 140));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Proveedor.getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

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

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(204, 204, 204));
        jLabel158.setText("ID");
        jPanel24.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 102, -1, -1));

        tf_editar_Producto_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel24.add(tf_editar_Producto_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 97, 227, -1));

        jLabel159.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(204, 204, 204));
        jLabel159.setText("Nombre");
        jPanel24.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 156, -1, -1));

        jLabel160.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(204, 204, 204));
        jLabel160.setText("Precio");
        jPanel24.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 210, -1, -1));

        jLabel161.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(204, 204, 204));
        jLabel161.setText("Proveedor");
        jPanel24.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel183.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(204, 204, 204));
        jLabel183.setText("Cantidad Total");
        jPanel24.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 264, -1, -1));

        cb_editar_Producto_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel24.add(cb_editar_Producto_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 227, -1));

        tf_editar_Producto_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel24.add(tf_editar_Producto_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 151, 227, -1));

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
        jPanel24.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 241, 76));

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
        jPanel24.add(cb_editar_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_Producto_Tcantidad.setModel(new javax.swing.SpinnerNumberModel());
        jPanel24.add(Sp_editar_Producto_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 220, -1));

        Sp_editar_Producto_precio.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));
        jPanel24.add(Sp_editar_Producto_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 220, -1));

        jLabel164.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(204, 204, 204));
        jLabel164.setText("Seleccione Producto");
        jPanel24.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel24.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane17.addTab("E d i t a r        ", jPanel24);

        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel26.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 1130, 350));

        jLabel166.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(204, 204, 204));
        jLabel166.setText("Seleccione Producto");
        jPanel26.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_producto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel26.add(cb_borrar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

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
        jPanel26.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jPanel26.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane17.addTab("        V e r / B o r r a r     ", jPanel26);

        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel169.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(204, 204, 204));
        jLabel169.setText("ID");
        jPanel27.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jLabel170.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(204, 204, 204));
        jLabel170.setText("Nombre");
        jPanel27.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        tf_nuevo_producto_id.setEditable(false);
        tf_nuevo_producto_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel27.add(tf_nuevo_producto_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 220, -1));

        tf_nuevo_producto_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel27.add(tf_nuevo_producto_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 220, -1));

        jLabel184.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(204, 204, 204));
        jLabel184.setText("Proveedor");
        jPanel27.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        cb_nuevo_Producto_proveedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel27.add(cb_nuevo_Producto_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 310, 230, -1));

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
        jPanel27.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        jLabel162.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(204, 204, 204));
        jLabel162.setText("Precio");
        jPanel27.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        Sp_nuevo_producto_precio.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(1.0d)));
        jPanel27.add(Sp_nuevo_producto_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 220, -1));

        jLabel163.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(204, 204, 204));
        jLabel163.setText("Cantidad Total");
        jPanel27.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        Sp_nuevo_producto_Tcantidad.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(1.0d)));
        jPanel27.add(Sp_nuevo_producto_Tcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 220, -1));

        jLabel175.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel27.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane17.addTab("N u e v o            ", jPanel27);

        jd_Producto.getContentPane().add(jTabbedPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jLabel176.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(204, 204, 204));
        jLabel176.setText("Transportes   Carmen");
        jd_Producto.getContentPane().add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jLabel177.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(204, 0, 0));
        jLabel177.setText("PRODUCTO");
        jd_Producto.getContentPane().add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 670, 140));

        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Producto.getContentPane().add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

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

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel171.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(204, 204, 204));
        jLabel171.setText("ID:");
        jPanel25.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 130, 40, -1));

        tf_editar_Cliente_id.setEditable(false);
        tf_editar_Cliente_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel25.add(tf_editar_Cliente_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 120, 250, -1));

        jLabel172.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(204, 204, 204));
        jLabel172.setText("Nombre de Empresa:");
        jPanel25.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jLabel173.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(204, 204, 204));
        jLabel173.setText("Fecha Inicio de Contrato:");
        jPanel25.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 240, 300, -1));

        jLabel174.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(204, 204, 204));
        jLabel174.setText("Direccion:");
        jPanel25.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        tf_editar_Cliente_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel25.add(tf_editar_Cliente_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 720, -1));

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
        jPanel25.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 241, 76));

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
        jPanel25.add(cb_editar_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_Cliente_fecaInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_Cliente_fecaInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        jPanel25.add(Sp_editar_Cliente_fecaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 250, -1));

        jLabel179.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(204, 204, 204));
        jLabel179.setText("Seleccione Cliente");
        jPanel25.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        tf_editar_Cliente_empresa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel25.add(tf_editar_Cliente_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 180, 250, -1));

        tf_editar_Cliente_nombreContacto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel25.add(tf_editar_Cliente_nombreContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 250, -1));

        jLabel191.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(204, 204, 204));
        jLabel191.setText("Nombre de ");
        jPanel25.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 150, -1));

        tf_editar_cliente_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel25.add(tf_editar_cliente_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 250, -1));

        jLabel192.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(204, 204, 204));
        jLabel192.setText("Contacto:");
        jPanel25.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 130, 40));

        jLabel193.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(204, 204, 204));
        jLabel193.setText("Telefono:");
        jPanel25.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 130, 40));

        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel25.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane18.addTab("E d i t a r        ", jPanel25);

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_cliente.setForeground(new java.awt.Color(0, 0, 102));
        jTable_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "EMPRESA", "FECHA DE INICIO", "DIRECCION", "TELEFONO", "NOMBRE DE CONTACTO"
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
        jScrollPane3.setViewportView(jTable_cliente);
        if (jTable_cliente.getColumnModel().getColumnCount() > 0) {
            jTable_cliente.getColumnModel().getColumn(2).setHeaderValue("");
            jTable_cliente.getColumnModel().getColumn(3).setHeaderValue("Modelo");
        }

        jPanel28.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 1130, 350));

        jLabel181.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(204, 204, 204));
        jLabel181.setText("Seleccione Cliente:");
        jPanel28.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel28.add(cb_borrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

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
        jPanel28.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jLabel182.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jPanel28.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1210, 520));

        jTabbedPane18.addTab("        V e r / B o r r a r     ", jPanel28);

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel29.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        jLabel194.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(204, 204, 204));
        jLabel194.setText("ID:");
        jPanel29.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 130, 40, -1));

        tf_nuevo_Cliente_id.setEditable(false);
        tf_nuevo_Cliente_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel29.add(tf_nuevo_Cliente_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 120, 250, -1));

        jLabel195.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(204, 204, 204));
        jLabel195.setText("Telefono:");
        jPanel29.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 130, 40));

        jLabel196.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(204, 204, 204));
        jLabel196.setText("Nombre de Empresa:");
        jPanel29.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jLabel197.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(204, 204, 204));
        jLabel197.setText("Fecha Inicio de Contrato:");
        jPanel29.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 240, 300, -1));

        jLabel198.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(204, 204, 204));
        jLabel198.setText("Direccion:");
        jPanel29.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        tf_nuevo_Cliente_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel29.add(tf_nuevo_Cliente_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 720, -1));

        Sp_nuevo_Cliente_fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_Cliente_fechaInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        jPanel29.add(Sp_nuevo_Cliente_fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 250, -1));

        tf_nuevo_Cliente_empresa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel29.add(tf_nuevo_Cliente_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 180, 250, -1));

        jLabel199.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(204, 204, 204));
        jLabel199.setText("Nombre de ");
        jPanel29.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 150, -1));

        jLabel200.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(204, 204, 204));
        jLabel200.setText("Contacto:");
        jPanel29.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 130, 40));

        tf_nuevo_Cliente_nombreContacto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel29.add(tf_nuevo_Cliente_nombreContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 250, -1));

        tf_nuevo_Cliente_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel29.add(tf_nuevo_Cliente_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 250, -1));

        jLabel187.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel29.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane18.addTab("N u e v o            ", jPanel29);

        jd_Cliente.getContentPane().add(jTabbedPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jLabel188.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(204, 204, 204));
        jLabel188.setText("Transportes   Carmen");
        jd_Cliente.getContentPane().add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jLabel189.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 204, 0));
        jLabel189.setText("CLIENTE");
        jd_Cliente.getContentPane().add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 490, 140));

        jLabel190.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Cliente.getContentPane().add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Vehiculo.setMinimumSize(new java.awt.Dimension(1213, 851));
        jd_Vehiculo.setResizable(false);
        jd_Vehiculo.setSize(new java.awt.Dimension(1213, 851));
        jd_Vehiculo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane19.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane19.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane19.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel201.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(204, 204, 204));
        jLabel201.setText("Numero de Placa:");
        jPanel30.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 210, -1));

        tf_editar_vehiculo_placa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel30.add(tf_editar_vehiculo_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        jLabel202.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(204, 204, 204));
        jLabel202.setText("Kilometraje:");
        jPanel30.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jLabel203.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(204, 204, 204));
        jLabel203.setText("Marca:");
        jPanel30.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, -1));

        jLabel204.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(204, 204, 204));
        jLabel204.setText("Año:");
        jPanel30.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 130, -1));

        tf_editar_vehiculo_modelo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel30.add(tf_editar_vehiculo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));

        jButton28.setBackground(new java.awt.Color(204, 204, 204));
        jButton28.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton28.setForeground(new java.awt.Color(153, 153, 0));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton28.setText("Editar");
        jPanel30.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 241, 76));

        cb_editar_vehiculo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel30.add(cb_editar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 227, -1));

        Sp_editar_vehiculo_tm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_tm.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(1.0d)));
        jPanel30.add(Sp_editar_vehiculo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 150, -1));

        jLabel205.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(204, 204, 204));
        jLabel205.setText("Seleccione Vehiculo:");
        jPanel30.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        tf_editar_vehiculo_marca.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel30.add(tf_editar_vehiculo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, -1));

        jLabel208.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(204, 204, 204));
        jLabel208.setText("Tipo Combustible:");
        jPanel30.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 210, 40));

        jLabel223.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(204, 204, 204));
        jLabel223.setText("Modelo:");
        jPanel30.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        jLabel224.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(204, 204, 204));
        jLabel224.setText("Capacidad de Combustible:");
        jPanel30.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 310, -1));

        jLabel225.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(204, 204, 204));
        jLabel225.setText("Color:");
        jPanel30.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 140, -1));

        Sp_editar_vehiculo_año.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_año.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2000), Integer.valueOf(1900), null, Integer.valueOf(1)));
        jPanel30.add(Sp_editar_vehiculo_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 250, -1));

        cb_editar_vehiculo_tipoCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_editar_vehiculo_tipoCombu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gasolina", "Regular" }));
        jPanel30.add(cb_editar_vehiculo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 170, 150, -1));

        Sp_editar_vehiculo_color.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel30.add(Sp_editar_vehiculo_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 250, -1));

        jLabel249.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel249.setForeground(new java.awt.Color(204, 204, 204));
        jLabel249.setText("Localizador:");
        jPanel30.add(jLabel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 140, -1));

        tf_editar_vehiculo_localizador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel30.add(tf_editar_vehiculo_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 260, -1));

        Sp_editar_vehiculo_kilometraje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_kilometraje.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(1.0d)));
        jPanel30.add(Sp_editar_vehiculo_kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));

        jLabel250.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel250.setForeground(new java.awt.Color(204, 0, 0));
        jLabel250.setText("TRAILETA");
        jPanel30.add(jLabel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 210, -1));

        jLabel251.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel251.setForeground(new java.awt.Color(204, 204, 204));
        jLabel251.setText("Toneladas Metricas:");
        jPanel30.add(jLabel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 250, -1));

        Sp_editar_vehiculo_capaCombus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_vehiculo_capaCombus.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel30.add(Sp_editar_vehiculo_capaCombus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 100, -1));

        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel30.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 590));

        jTabbedPane19.addTab("E d i t a r        ", jPanel30);

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel31.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1130, 230));

        jLabel210.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(204, 204, 204));
        jLabel210.setText("Seleccione Vehiculo:");
        jPanel31.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        cb_borrar_vehiculo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel31.add(cb_borrar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 370, -1));

        jButton29.setBackground(new java.awt.Color(204, 204, 204));
        jButton29.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton29.setForeground(new java.awt.Color(0, 102, 102));
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton29.setText("Borrar");
        jPanel31.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 241, 76));

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

        jPanel31.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 530, 120));

        jLabel227.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(204, 204, 204));
        jLabel227.setText("Seleccione Traileta:");
        jPanel31.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        cb_borrar_traileta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel31.add(cb_borrar_traileta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 370, -1));

        jButton35.setBackground(new java.awt.Color(204, 204, 204));
        jButton35.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton35.setForeground(new java.awt.Color(0, 102, 102));
        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton35.setText("Borrar");
        jPanel31.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 241, 76));

        jLabel211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jPanel31.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 580));

        jTabbedPane19.addTab("        V e r / B o r r a r     ", jPanel31);

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton30.setBackground(new java.awt.Color(204, 204, 204));
        jButton30.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton30.setForeground(new java.awt.Color(0, 153, 153));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton30.setText("Crear");
        jPanel32.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        jLabel253.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel253.setForeground(new java.awt.Color(204, 204, 204));
        jLabel253.setText("Numero de Placa:");
        jPanel32.add(jLabel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 210, -1));

        tf_nuevo_vehiculo_placa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel32.add(tf_nuevo_vehiculo_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 250, -1));

        jLabel254.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel254.setForeground(new java.awt.Color(204, 204, 204));
        jLabel254.setText("Kilometraje:");
        jPanel32.add(jLabel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 250, -1));

        jLabel255.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel255.setForeground(new java.awt.Color(204, 204, 204));
        jLabel255.setText("Marca:");
        jPanel32.add(jLabel255, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 300, -1));

        jLabel256.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel256.setForeground(new java.awt.Color(204, 204, 204));
        jLabel256.setText("Modelo:");
        jPanel32.add(jLabel256, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, -1));

        jLabel257.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel257.setForeground(new java.awt.Color(204, 204, 204));
        jLabel257.setText("Año:");
        jPanel32.add(jLabel257, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        jLabel258.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel258.setForeground(new java.awt.Color(204, 204, 204));
        jLabel258.setText("Color:");
        jPanel32.add(jLabel258, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 140, -1));

        tf_nuevo_vehiculo_color.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel32.add(tf_nuevo_vehiculo_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 250, -1));

        Sp_nuevo_vehiculo_año.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_año.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2000), Integer.valueOf(1900), null, Integer.valueOf(1)));
        jPanel32.add(Sp_nuevo_vehiculo_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));

        tf_nuevo_vehiculo_modelo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel32.add(tf_nuevo_vehiculo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, -1));

        tf_nuevo_vehiculo_marca.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel32.add(tf_nuevo_vehiculo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));

        jLabel260.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel260.setForeground(new java.awt.Color(204, 204, 204));
        jLabel260.setText("Toneladas Metricas:");
        jPanel32.add(jLabel260, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 290, -1));

        jLabel261.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel261.setForeground(new java.awt.Color(204, 0, 0));
        jLabel261.setText("TRAILETA");
        jPanel32.add(jLabel261, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 210, -1));

        jLabel262.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel262.setForeground(new java.awt.Color(204, 204, 204));
        jLabel262.setText("Localizador:");
        jPanel32.add(jLabel262, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 140, -1));

        jLabel263.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel263.setForeground(new java.awt.Color(204, 204, 204));
        jLabel263.setText("Tipo Combustible:");
        jPanel32.add(jLabel263, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 210, 40));

        jLabel264.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel264.setForeground(new java.awt.Color(204, 204, 204));
        jLabel264.setText("Capacidad de Combustible:");
        jPanel32.add(jLabel264, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 310, -1));

        Sp_nuevo_vehiculo_capaCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_capaCombu.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel32.add(Sp_nuevo_vehiculo_capaCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 100, -1));

        cb_nuevo_vehiculo_tipoCombu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_nuevo_vehiculo_tipoCombu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gasolina", "Regular" }));
        jPanel32.add(cb_nuevo_vehiculo_tipoCombu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 150, -1));

        tf_nuevo_vehiculo_localizador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel32.add(tf_nuevo_vehiculo_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 260, -1));

        Sp_nuevo_vehiculo_kilometra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_kilometra.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel32.add(Sp_nuevo_vehiculo_kilometra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        Sp_nuevo_vehiculo_tm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_vehiculo_tm.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel32.add(Sp_nuevo_vehiculo_tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, 150, -1));

        jLabel219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel32.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 580));

        jTabbedPane19.addTab("N u e v o            ", jPanel32);

        jd_Vehiculo.getContentPane().add(jTabbedPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 650));

        jLabel220.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(204, 204, 204));
        jLabel220.setText("Transportes   Carmen");
        jd_Vehiculo.getContentPane().add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jLabel221.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(153, 255, 204));
        jLabel221.setText("VEHICULO");
        jd_Vehiculo.getContentPane().add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 610, 140));

        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Vehiculo.getContentPane().add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        jd_Conductor.setMinimumSize(new java.awt.Dimension(1219, 801));
        jd_Conductor.setResizable(false);
        jd_Conductor.setSize(new java.awt.Dimension(1219, 801));
        jd_Conductor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane20.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane20.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane20.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jTabbedPane20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane20MouseClicked(evt);
            }
        });

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel212.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(204, 204, 204));
        jLabel212.setText("ID:");
        jPanel33.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 40, -1));

        tf_editar_conductor_id.setEditable(false);
        tf_editar_conductor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel33.add(tf_editar_conductor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 250, -1));

        jLabel213.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(204, 204, 204));
        jLabel213.setText("Nombres:");
        jPanel33.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, 250, -1));

        jLabel214.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(204, 204, 204));
        jLabel214.setText("Apellidos:");
        jPanel33.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, -1));

        jLabel215.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(204, 204, 204));
        jLabel215.setText("Direccion:");
        jPanel33.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 130, -1));

        tf_editar_conductor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel33.add(tf_editar_conductor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 720, -1));

        jButton31.setBackground(new java.awt.Color(204, 204, 204));
        jButton31.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton31.setForeground(new java.awt.Color(153, 153, 0));
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compose-64.png"))); // NOI18N
        jButton31.setText("Editar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel33.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 241, 76));

        cb_editar_conductor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_editar_conductor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_editar_conductorItemStateChanged(evt);
            }
        });
        cb_editar_conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_editar_conductorActionPerformed(evt);
            }
        });
        jPanel33.add(cb_editar_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 43, 300, -1));

        Sp_editar_conductor_viaticos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_viaticos.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel33.add(Sp_editar_conductor_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 250, -1));

        jLabel216.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(204, 204, 204));
        jLabel216.setText("Seleccione Conductor");
        jPanel33.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 48, -1, -1));

        tf_editar_conductor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel33.add(tf_editar_conductor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, -1));

        tf_editar_conductor_apellido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel33.add(tf_editar_conductor_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, -1));

        tf_editar_conductor_localizador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel33.add(tf_editar_conductor_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 250, -1));

        jLabel217.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(204, 204, 204));
        jLabel217.setText("Localizador:");
        jPanel33.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 160, 40));

        jLabel232.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(204, 204, 204));
        jLabel232.setText("Edad:");
        jPanel33.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, -1));

        jLabel233.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(204, 204, 204));
        jLabel233.setText("Viaticos:");
        jPanel33.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 140, -1));

        jLabel234.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(204, 204, 204));
        jLabel234.setText("Salario:");
        jPanel33.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 140, -1));

        jLabel226.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(204, 204, 204));
        jLabel226.setText("Telefono:");
        jPanel33.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 40));

        tf_editar_conductor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel33.add(tf_editar_conductor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 250, -1));

        Sp_editar_conductor_edad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_edad.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(15), Integer.valueOf(15), null, Integer.valueOf(1)));
        jPanel33.add(Sp_editar_conductor_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 250, -1));

        Sp_editar_conductor_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_editar_conductor_salario.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel33.add(Sp_editar_conductor_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 250, -1));

        jLabel218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel33.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane20.addTab("E d i t a r        ", jPanel33);

        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_conductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_conductor.setForeground(new java.awt.Color(0, 0, 102));
        jTable_conductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Edad", "Direccion", "Salario", "Viaticos", "Telefono", "Localizador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

        jPanel34.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 1130, 350));

        jLabel235.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(204, 204, 204));
        jLabel235.setText("Seleccione Conductor:");
        jPanel34.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        cb_borrar_conductor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel34.add(cb_borrar_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 370, -1));

        jButton32.setBackground(new java.awt.Color(204, 204, 204));
        jButton32.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton32.setForeground(new java.awt.Color(0, 102, 102));
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-_delete_minus_cancel_close-64.png"))); // NOI18N
        jButton32.setText("Borrar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel34.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 241, 76));

        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dark-Gray-Background-for-Free-Download.jpg"))); // NOI18N
        jPanel34.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane20.addTab("        V e r / B o r r a r     ", jPanel34);

        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton33.setBackground(new java.awt.Color(204, 204, 204));
        jButton33.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButton33.setForeground(new java.awt.Color(0, 153, 153));
        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/07_plus-64.png"))); // NOI18N
        jButton33.setText("Crear");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel35.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        jLabel237.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(204, 204, 204));
        jLabel237.setText("ID:");
        jPanel35.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, -1));

        jLabel238.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(204, 204, 204));
        jLabel238.setText("Nombres:");
        jPanel35.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 250, -1));

        jLabel239.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(204, 204, 204));
        jLabel239.setText("Apellidos:");
        jPanel35.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 300, -1));

        jLabel240.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(204, 204, 204));
        jLabel240.setText("Edad:");
        jPanel35.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, -1));

        jLabel241.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel241.setForeground(new java.awt.Color(204, 204, 204));
        jLabel241.setText("Direccion:");
        jPanel35.add(jLabel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 130, -1));

        tf_nuevo_conductor_direccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel35.add(tf_nuevo_conductor_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 720, -1));

        Sp_nuevo_conductor_edad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_edad.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(15), Integer.valueOf(15), null, Integer.valueOf(1)));
        jPanel35.add(Sp_nuevo_conductor_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 250, -1));

        tf_nuevo_conductor_apellido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel35.add(tf_nuevo_conductor_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 250, -1));

        tf_nuevo_conductor_nombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel35.add(tf_nuevo_conductor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 250, -1));

        tf_nuevo_conductor_id.setEditable(false);
        tf_nuevo_conductor_id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel35.add(tf_nuevo_conductor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 250, -1));

        jLabel242.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel242.setForeground(new java.awt.Color(204, 204, 204));
        jLabel242.setText("Salario:");
        jPanel35.add(jLabel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 140, -1));

        jLabel243.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel243.setForeground(new java.awt.Color(204, 204, 204));
        jLabel243.setText("Viaticos:");
        jPanel35.add(jLabel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 140, -1));

        jLabel244.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(204, 204, 204));
        jLabel244.setText("Telefono:");
        jPanel35.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 130, 40));

        tf_nuevo_conductor_telefono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel35.add(tf_nuevo_conductor_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, 250, -1));

        jLabel252.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel252.setForeground(new java.awt.Color(204, 204, 204));
        jLabel252.setText("Localizador:");
        jPanel35.add(jLabel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 150, 40));

        tf_nuevo_conductor_localizador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel35.add(tf_nuevo_conductor_localizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, 250, -1));

        Sp_nuevo_conductor_viaticos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_viaticos.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel35.add(Sp_nuevo_conductor_viaticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 250, -1));

        Sp_nuevo_conductor_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sp_nuevo_conductor_salario.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        jPanel35.add(Sp_nuevo_conductor_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 250, -1));

        jLabel245.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark-grey-background-pattern-i7.jpg"))); // NOI18N
        jPanel35.add(jLabel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        jTabbedPane20.addTab("N u e v o            ", jPanel35);

        jd_Conductor.getContentPane().add(jTabbedPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1220, 600));

        jLabel246.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(204, 204, 204));
        jLabel246.setText("Transportes   Carmen");
        jd_Conductor.getContentPane().add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 50));

        jLabel247.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 120)); // NOI18N
        jLabel247.setForeground(new java.awt.Color(153, 0, 255));
        jLabel247.setText("CONDUCTOR");
        jd_Conductor.getContentPane().add(jLabel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 790, 140));

        jLabel248.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buffalo-Free-Quirky-Script-Font.jpg"))); // NOI18N
        jd_Conductor.getContentPane().add(jLabel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1230, 290));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel56.setFont(new java.awt.Font("Pristina", 0, 100)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(245, 237, 237));
        jLabel56.setText("________________");

        jLabel57.setFont(new java.awt.Font("Pristina", 1, 100)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(245, 237, 237));
        jLabel57.setText("Transportes   Carmen");

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

        jLabel58.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/43950_miscellaneous_empty_road.jpg"))); // NOI18N

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
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(390, 390, 390)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jl_CONDUCTORMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CONDUCTORMouseEntered
        jl_CONDUCTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/929-128.png"))); // NOI18N
        jLabel58.setText("CONDUCTOR");
    }//GEN-LAST:event_jl_CONDUCTORMouseEntered

    private void jl_CONDUCTORMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CONDUCTORMouseExited
        jl_CONDUCTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/929-64.png"))); // NOI18N
        jLabel58.setText("");
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
        jLabel58.setText("PRODUCTO");
    }//GEN-LAST:event_jl_PRODUCTOMouseEntered

    private void jl_PRODUCTOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PRODUCTOMouseExited
        jl_PRODUCTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Noun_Project_20Icon_10px_grid-17-64.png"))); // NOI18N
        jLabel58.setText("");
    }//GEN-LAST:event_jl_PRODUCTOMouseExited

    private void jl_FACTURAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_FACTURAMouseEntered
        jl_FACTURA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill-rule-paper-document-128.png"))); // NOI18N
        jLabel58.setText("FACTURA");
    }//GEN-LAST:event_jl_FACTURAMouseEntered

    private void jl_FACTURAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_FACTURAMouseExited
        jl_FACTURA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill-rule-paper-document-64.png"))); // NOI18N
        jLabel58.setText("");
    }//GEN-LAST:event_jl_FACTURAMouseExited

    private void jl_VEHICULOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_VEHICULOMouseEntered
        jl_VEHICULO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/truck_1-128.png"))); // NOI18N
        jLabel58.setText("VEHICULO");
    }//GEN-LAST:event_jl_VEHICULOMouseEntered

    private void jl_VEHICULOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_VEHICULOMouseExited
        jl_VEHICULO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/truck_1-64.png"))); // NOI18N
        jLabel58.setText("");
    }//GEN-LAST:event_jl_VEHICULOMouseExited

    private void jl_CLIENTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CLIENTEMouseEntered
        jl_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/handshake3-128.png"))); // NOI18N
        jLabel58.setText("CLIENTE");
    }//GEN-LAST:event_jl_CLIENTEMouseEntered

    private void jl_CLIENTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CLIENTEMouseExited
        jl_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/handshake3-64.png"))); // NOI18N
        jLabel58.setText("");
    }//GEN-LAST:event_jl_CLIENTEMouseExited

    private void jl_PROVEEDORMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PROVEEDORMouseEntered
        jl_PROVEEDOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gold-128.png"))); // NOI18N
        jLabel58.setText("PROVEEDOR");
    }//GEN-LAST:event_jl_PROVEEDORMouseEntered

    private void jl_PROVEEDORMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_PROVEEDORMouseExited
        jl_PROVEEDOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gold-64.png")));
        jLabel58.setText("");
    }//GEN-LAST:event_jl_PROVEEDORMouseExited

    private void jl_CONDUCTORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CONDUCTORMouseClicked
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < conductores.size(); i++) {
            modelo.addElement(conductores.get(i).getNombre());
        }
        DefaultTableModel tmodel = (DefaultTableModel) jTable_conductor.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < conductores.size(); i++) {
            tmodel.addRow(new Object[]{conductores.get(i).getId_conductor(),
                conductores.get(i).getNombre(),
                conductores.get(i).getApellido(),
                conductores.get(i).getEdad(),
                conductores.get(i).getDireccion(),
                conductores.get(i).getSueldo(),
                conductores.get(i).getViaticos(),
                conductores.get(i).getTelefono(),
                conductores.get(i).getLocalizador()});
        }
        jTable_conductor.setModel(tmodel);
        cb_borrar_conductor.setModel(modelo);
        cb_editar_conductor.setModel(modelo);
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
                JOptionPane.showMessageDialog(rootPane, "Proveedor Creado con exito!");
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
        tf_nuevo_proveedor_direccion.setText("");
        tf_nuevo_proveedor_telefono.setText("");
        tf_nuevo_proveedor_nombre.setText("");
        tf_nuevo_proveedor_pais.setText("");
        tf_nuevo_proveedor_correo.setText("");
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
                JOptionPane.showMessageDialog(rootPane, "Producto Creado con exito!");
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
        Sp_nuevo_producto_Tcantidad.setValue(0);
        tf_nuevo_producto_nombre.setText("");
        Sp_nuevo_producto_precio.setValue(0);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void cb_editar_conductorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_editar_conductorItemStateChanged
        for (int i = 0; i < conductores.size(); i++) {
            if (conductores.get(i).getNombre().equals(cb_editar_conductor.getSelectedItem().toString())) {
                id_conductor = conductores.get(i).getId_conductor();
                tf_editar_conductor_id.setText(Integer.toString(id_conductor));
                tf_editar_conductor_nombre.setText(conductores.get(i).getNombre());
                tf_editar_conductor_apellido.setText(conductores.get(i).getApellido());
                Sp_editar_conductor_edad.setValue(conductores.get(i).getEdad());
                tf_editar_conductor_direccion.setText(conductores.get(i).getDireccion());
                Sp_editar_conductor_salario.setValue(conductores.get(i).getSueldo());
                Sp_editar_conductor_viaticos.setValue(conductores.get(i).getViaticos());
                tf_editar_conductor_telefono.setText(conductores.get(i).getTelefono());
                tf_editar_conductor_localizador.setText(conductores.get(i).getLocalizador());
            }
        }
    }//GEN-LAST:event_cb_editar_conductorItemStateChanged

    private void cb_editar_conductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_editar_conductorActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < conductores.size(); i++) {
            if (conductores.get(i).getNombre().equals(cb_editar_conductor.getSelectedItem().toString())) {
                id_conductor = conductores.get(i).getId_conductor();
                tf_editar_conductor_id.setText(Integer.toString(id_conductor));
                tf_editar_conductor_nombre.setText(conductores.get(i).getNombre());
                tf_editar_conductor_apellido.setText(conductores.get(i).getApellido());
                Sp_editar_conductor_edad.setValue(conductores.get(i).getEdad());
                tf_editar_conductor_direccion.setText(conductores.get(i).getDireccion());
                Sp_editar_conductor_salario.setValue(conductores.get(i).getSueldo());
                Sp_editar_conductor_viaticos.setValue(conductores.get(i).getViaticos());
                tf_editar_conductor_telefono.setText(conductores.get(i).getTelefono());
                tf_editar_conductor_localizador.setText(conductores.get(i).getLocalizador());
            }
        }
    }//GEN-LAST:event_cb_editar_conductorActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "UPDATE conductor SET  direccion=?, nombres=?, apellidos=?, localizador=?, salario=?, edad=?, viaticos=?, telefono=?"
                    + "WHERE idConductor=" + id_conductor;
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, tf_editar_conductor_direccion.getText());
            pst.setString(2, tf_editar_conductor_nombre.getText());
            pst.setString(3, tf_editar_conductor_apellido.getText());
            pst.setString(4, tf_editar_conductor_localizador.getText());
            pst.setDouble(5, Double.parseDouble(Sp_editar_conductor_salario.getValue().toString()));
            pst.setInt(6, Integer.parseInt(Sp_editar_conductor_edad.getValue().toString()));
            pst.setDouble(7, Double.parseDouble(Sp_editar_conductor_viaticos.getValue().toString()));
            pst.setString(8, tf_editar_conductor_telefono.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Conductor Actualizado con exito!");
                for (int i = 0; i < conductores.size(); i++) {
                    if (conductores.get(i).getId_conductor()== id_conductor) {
                        conductores.get(i).setDireccion(tf_editar_conductor_direccion.getText());
                        conductores.get(i).setNombre(tf_editar_conductor_nombre.getText());
                        conductores.get(i).setApellido(tf_editar_conductor_apellido.getText());
                        conductores.get(i).setLocalizador(tf_editar_conductor_localizador.getText());
                        conductores.get(i).setSueldo(Double.parseDouble(Sp_editar_conductor_salario.getValue().toString()));
                        conductores.get(i).setEdad(Integer.parseInt(Sp_editar_conductor_edad.getValue().toString()));
                        conductores.get(i).setViaticos(Double.parseDouble(Sp_editar_conductor_viaticos.getValue().toString()));
                        conductores.get(i).setTelefono(tf_editar_conductor_telefono.getText());
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < conductores.size(); i++) {
            modelo.addElement(conductores.get(i).getNombre());
        }
        cb_borrar_conductor.setModel(modelo);
        cb_editar_conductor.setModel(modelo);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jTabbedPane20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane20MouseClicked
        // TODO add your handling code here:
        if (jTabbedPane20.getSelectedIndex() == 1) {
            DefaultTableModel tmodel = (DefaultTableModel) jTable_conductor.getModel();
            int fila = tmodel.getRowCount();
            for (int i = 1; i <= fila; i++) {
                tmodel.removeRow(0);
            }
            for (int i = 0; i < conductores.size(); i++) {
                tmodel.addRow(new Object[]{conductores.get(i).getId_conductor(),
                conductores.get(i).getNombre(),
                conductores.get(i).getApellido(),
                conductores.get(i).getEdad(),
                conductores.get(i).getDireccion(),
                conductores.get(i).getSueldo(),
                conductores.get(i).getViaticos(),
                conductores.get(i).getTelefono(),
                conductores.get(i).getLocalizador()});
            }
            jTable_conductor.setModel(tmodel);
        } else if (jTabbedPane20.getSelectedIndex() == 2) {
            tf_nuevo_conductor_id.setText(Integer.toString(conductores.get(conductores.size() - 1).getId_conductor()+ 1));
        }
    }//GEN-LAST:event_jTabbedPane20MouseClicked

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "DELETE FROM conductor "
                    + "WHERE idConductor=?";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, id_conductor);
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Proveedor Eliminado con exito!");
                for (int i = 0; i < conductores.size(); i++) {
                    if (conductores.get(i).getId_conductor() == id_conductor) {
                        conductores.remove(i);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");
        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < conductores.size(); i++) {
            modelo.addElement(conductores.get(i).getNombre());
        }
        cb_borrar_conductor.setModel(modelo);
        cb_editar_conductor.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) jTable_conductor.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < conductores.size(); i++) {
            tmodel.addRow(new Object[]{conductores.get(i).getId_conductor(),
                conductores.get(i).getNombre(),
                conductores.get(i).getApellido(),
                conductores.get(i).getEdad(),
                conductores.get(i).getDireccion(),
                conductores.get(i).getSueldo(),
                conductores.get(i).getViaticos(),
                conductores.get(i).getTelefono(),
                conductores.get(i).getLocalizador()});
        }
        jTable_conductor.setModel(tmodel);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        Conn cn = new Conn();
        try {
            Connection cc = cn.mkConnRe();// Obtiene la conexion
            String sql = "";
            sql = "INSERT INTO conductor (idConductor, direccion, nombres, apellidos, localizador, salario, edad, viaticos, telefono)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tf_nuevo_conductor_id.getText()));
            pst.setString(2, tf_nuevo_conductor_direccion.getText());
            pst.setString(3, tf_nuevo_conductor_nombre.getText());
            pst.setString(4, tf_nuevo_conductor_apellido.getText());
            pst.setString(5, tf_nuevo_conductor_localizador.getText());
            pst.setDouble(6, Double.parseDouble(Sp_nuevo_conductor_salario.getValue().toString()));
            pst.setInt(7, Integer.parseInt(Sp_nuevo_conductor_edad.getValue().toString()));
            pst.setDouble(8, Double.parseDouble(Sp_nuevo_conductor_viaticos.getValue().toString()));
            pst.setString(9, tf_nuevo_conductor_telefono.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Conductor Creado con exito!");
                Conductor con = new Conductor(Integer.parseInt(tf_nuevo_conductor_id.getText()),
                                              tf_nuevo_conductor_direccion.getText(),
                                              tf_nuevo_conductor_nombre.getText(),
                                              tf_nuevo_conductor_apellido.getText(),
                                              tf_nuevo_conductor_localizador.getText(),
                                              Double.parseDouble(Sp_nuevo_conductor_salario.getValue().toString()),
                                              Integer.parseInt(Sp_nuevo_conductor_edad.getValue().toString()),
                                              Double.parseDouble(Sp_nuevo_conductor_viaticos.getValue().toString()),
                                              tf_nuevo_conductor_telefono.getText());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la coneccion!");

        } catch (Exception ex) {
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < conductores.size(); i++) {
            modelo.addElement(conductores.get(i).getNombre());
        }
        cb_borrar_conductor.setModel(modelo);
        cb_editar_conductor.setModel(modelo);
        DefaultTableModel tmodel = (DefaultTableModel) jTable_conductor.getModel();
        int fila = tmodel.getRowCount();
        for (int i = 1; i <= fila; i++) {
            tmodel.removeRow(0);
        }
        for (int i = 0; i < conductores.size(); i++) {
            tmodel.addRow(new Object[]{conductores.get(i).getId_conductor(),
                conductores.get(i).getNombre(),
                conductores.get(i).getApellido(),
                conductores.get(i).getEdad(),
                conductores.get(i).getDireccion(),
                conductores.get(i).getSueldo(),
                conductores.get(i).getViaticos(),
                conductores.get(i).getTelefono(),
                conductores.get(i).getLocalizador()});
        }
        jTable_conductor.setModel(tmodel);
        tf_nuevo_conductor_id.setText("");
        tf_nuevo_conductor_direccion.setText("");
        tf_nuevo_conductor_nombre.setText("");
        tf_nuevo_conductor_apellido.setText("");
        tf_nuevo_conductor_localizador.setText("");
        Sp_nuevo_conductor_salario.setValue(0);
        Sp_nuevo_conductor_edad.setValue(20);
        Sp_nuevo_conductor_viaticos.setValue(0);
        tf_nuevo_conductor_telefono.setText("");
    }//GEN-LAST:event_jButton33ActionPerformed

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
            pst.setString(2, tf_nuevo_Cliente_telefono.getText());
            pst.setString(3, tf_nuevo_Cliente_direccion.getText());
            pst.setString(4, tf_nuevo_Cliente_nombreContacto.getText());
            SpinnerDateModel model = (SpinnerDateModel)Sp_nuevo_Cliente_fechaInicio.getModel();
            pst.setDate(5, new java.sql.Date(model.getDate().getTime()));
            pst.setString(6, tf_nuevo_Cliente_empresa.getText());
            int nu = pst.executeUpdate();
            if (nu > 0) {
                JOptionPane.showMessageDialog(rootPane, "Cliente Creado con exito!");
                Cliente clie = new Cliente(Integer.parseInt(tf_nuevo_Cliente_id.getText()),
                                           tf_nuevo_Cliente_telefono.getText(),
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
        tf_nuevo_Cliente_telefono.setText("");
        tf_nuevo_Cliente_direccion.setText("");
        tf_nuevo_Cliente_nombreContacto.setText("");
        tf_nuevo_Cliente_empresa.setText("");
    }//GEN-LAST:event_jButton27ActionPerformed

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
    private javax.swing.JSpinner Sp_editar_vehiculo_año;
    private javax.swing.JSpinner Sp_editar_vehiculo_capaCombus;
    private javax.swing.JTextField Sp_editar_vehiculo_color;
    private javax.swing.JSpinner Sp_editar_vehiculo_kilometraje;
    private javax.swing.JSpinner Sp_editar_vehiculo_tm;
    private javax.swing.JSpinner Sp_nuevo_Cliente_fechaInicio;
    private javax.swing.JSpinner Sp_nuevo_conductor_edad;
    private javax.swing.JSpinner Sp_nuevo_conductor_salario;
    private javax.swing.JSpinner Sp_nuevo_conductor_viaticos;
    private javax.swing.JSpinner Sp_nuevo_producto_Tcantidad;
    private javax.swing.JSpinner Sp_nuevo_producto_precio;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_año;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_capaCombu;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_kilometra;
    private javax.swing.JSpinner Sp_nuevo_vehiculo_tm;
    private javax.swing.JComboBox<String> cb_borrar_cliente;
    private javax.swing.JComboBox<String> cb_borrar_conductor;
    private javax.swing.JComboBox<String> cb_borrar_producto;
    private javax.swing.JComboBox<String> cb_borrar_proveedor;
    private javax.swing.JComboBox<String> cb_borrar_traileta;
    private javax.swing.JComboBox<String> cb_borrar_vehiculo;
    private javax.swing.JComboBox<String> cb_editar_Cliente;
    private javax.swing.JComboBox<String> cb_editar_Producto;
    private javax.swing.JComboBox<String> cb_editar_Producto_proveedor;
    private javax.swing.JComboBox<String> cb_editar_conductor;
    private javax.swing.JComboBox<String> cb_editar_proveedor;
    private javax.swing.JComboBox<String> cb_editar_vehiculo;
    private javax.swing.JComboBox<String> cb_editar_vehiculo_tipoCombu;
    private javax.swing.JComboBox<String> cb_nuevo_Producto_proveedor;
    private javax.swing.JComboBox<String> cb_nuevo_vehiculo_tipoCombu;
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
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane17;
    private javax.swing.JTabbedPane jTabbedPane18;
    private javax.swing.JTabbedPane jTabbedPane19;
    private javax.swing.JTabbedPane jTabbedPane20;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable_Producto;
    private javax.swing.JTable jTable_cliente;
    private javax.swing.JTable jTable_conductor;
    private javax.swing.JTable jTable_traileta;
    private javax.swing.JTable jTable_vehivculo;
    private javax.swing.JDialog jd_Cliente;
    private javax.swing.JDialog jd_Conductor;
    private javax.swing.JDialog jd_Producto;
    private javax.swing.JDialog jd_Proveedor;
    private javax.swing.JDialog jd_Vehiculo;
    private javax.swing.JLabel jl_CLIENTE;
    private javax.swing.JLabel jl_CONDUCTOR;
    private javax.swing.JLabel jl_FACTURA;
    private javax.swing.JLabel jl_PRODUCTO;
    private javax.swing.JLabel jl_PROVEEDOR;
    private javax.swing.JLabel jl_VEHICULO;
    private javax.swing.JTable tabla_proveedores;
    private javax.swing.JTextField tf_editar_Cliente_direccion;
    private javax.swing.JTextField tf_editar_Cliente_empresa;
    private javax.swing.JTextField tf_editar_Cliente_id;
    private javax.swing.JTextField tf_editar_Cliente_nombreContacto;
    private javax.swing.JTextField tf_editar_Producto_id;
    private javax.swing.JTextField tf_editar_Producto_nombre;
    private javax.swing.JTextField tf_editar_cliente_telefono;
    private javax.swing.JTextField tf_editar_conductor_apellido;
    private javax.swing.JTextField tf_editar_conductor_direccion;
    private javax.swing.JTextField tf_editar_conductor_id;
    private javax.swing.JTextField tf_editar_conductor_localizador;
    private javax.swing.JTextField tf_editar_conductor_nombre;
    private javax.swing.JTextField tf_editar_conductor_telefono;
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
    private javax.swing.JTextField tf_nuevo_Cliente_telefono;
    private javax.swing.JTextField tf_nuevo_conductor_apellido;
    private javax.swing.JTextField tf_nuevo_conductor_direccion;
    private javax.swing.JTextField tf_nuevo_conductor_id;
    private javax.swing.JTextField tf_nuevo_conductor_localizador;
    private javax.swing.JTextField tf_nuevo_conductor_nombre;
    private javax.swing.JTextField tf_nuevo_conductor_telefono;
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
    int id_conductor;
}
