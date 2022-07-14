
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VentaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;   
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numeroserie;
    }
    
    public int IdVenta(){
        int idventas=0;
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idventas=rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idventas ;
    }
    public String NroVenta(int nro){
        String idnro="";
        String sql="select NumeroSerie from ventas where IdVentas="+nro;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idnro=rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idnro;
    }
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idventas;
    }
    
    public Venta buscarXNroS(String nro){
        Venta ven = new Venta();
        String sql="select * from ventas where NumeroSerie="+nro;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                ven.setId(rs.getInt(1));
                ven.setIdcliente(rs.getInt(2));
                ven.setIdempleado(rs.getInt(3));
                ven.setNumserie(rs.getString(4));
                ven.setFecha(rs.getString(5));
                ven.setMonto(rs.getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ven;
    }
    
    public int guardaVenta(Venta ve){
        String sql="insert into ventas(IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql="insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta) values (?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
