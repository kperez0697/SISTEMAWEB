/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class DetalleVentasDAO {
     Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;   
    
        public List listarIdVenta(int id){
        List<DetalleVentas>lista=new ArrayList<>();
        double subtotal;
        String sql="SELECT pr.Nombres, dv.Cantidad, dv.PrecioVenta from detalle_ventas dv "
                + "INNER JOIN producto pr "
                + "ON pr.IdProducto=dv.IdProducto where dv.IdVentas ="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                DetalleVentas dv=new DetalleVentas();
                dv.setProducto(rs.getString(1));
                dv.setCantidad(rs.getInt(2));
                dv.setPrecio(rs.getDouble(3));
                subtotal = dv.getCantidad()*dv.getPrecio();
                dv.setCapr(subtotal);
                lista.add(dv);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
        
    }
    public List listar(){
        String sql="SELECT dv.IdVentas, dv.IdDetalleVentas,pr.Nombres,dv.Cantidad,dv.PrecioVenta, "
                + "c.Nombres, e.Nombres, v.FechaVentas FROM detalle_ventas dv INNER JOIN ventas v "
                + "ON dv.IdVentas = v.IdVentas INNER JOIN cliente c ON c.IdCliente = v.IdCliente "
                + "INNER JOIN empleado e ON e.IdEmpleado = v.IdEmpleado INNER JOIN producto pr "
                + "ON pr.IdProducto = dv.IdProducto ORDER BY dv.IdVentas;";
        List<DetalleVentas>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                DetalleVentas dv = new DetalleVentas();
                dv.setIdventas(rs.getInt(1));
                dv.setId(rs.getInt(2));
                dv.setProducto(rs.getString(3));
                dv.setCantidad(rs.getInt(4));
                dv.setPrecio(rs.getDouble(5));
                dv.setCliente(rs.getString(6));
                dv.setEmpleado(rs.getString(7));
                dv.setFecha(rs.getString(8));
                lista.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
        public List buscar(int idventa){
        String sql="SELECT dv.IdVentas, dv.IdDetalleVentas,pr.Nombres,dv.Cantidad,dv.PrecioVenta, c.Nombres, e.Nombres, v.FechaVentas "
                + "FROM detalle_ventas dv INNER JOIN ventas v ON dv.IdVentas = v.IdVentas "
                + "INNER JOIN cliente c ON c.IdCliente = v.IdCliente INNER JOIN empleado e "
                + "ON e.IdEmpleado = v.IdEmpleado INNER JOIN producto pr ON pr.IdProducto = dv.IdProducto "
                + "WHERE dv.IdVentas = "+idventa+" ORDER BY dv.IdVentas;";
        List<DetalleVentas>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                DetalleVentas dv = new DetalleVentas();
                dv.setIdventas(rs.getInt(1));
                dv.setId(rs.getInt(2));
                dv.setProducto(rs.getString(3));
                dv.setCantidad(rs.getInt(4));
                dv.setPrecio(rs.getDouble(5));
                dv.setCliente(rs.getString(6));
                dv.setEmpleado(rs.getString(7));
                dv.setFecha(rs.getString(8));
                lista.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
