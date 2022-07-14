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

public class ProveedorDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Proveedor buscar(String ruc){
        Proveedor pv=new Proveedor();
        String sql="Select * from proveedor where ruc="+ruc;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pv.setId(rs.getInt(1));
                pv.setTelefono(rs.getString(2));
                pv.setDireccion(rs.getString(3));
                pv.setRuc(rs.getString(4));
                pv.setRazonSocial(rs.getString(5));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pv;
    }
    
    //operaciones CRUD
    public List listar(){
        String sql="select * from proveedor";
        List<Proveedor>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Proveedor pv=new Proveedor();
                pv.setId(rs.getInt(1));
                pv.setTelefono(rs.getString(2));
                pv.setDireccion(rs.getString(3));
                pv.setRuc(rs.getString(4));
                pv.setRazonSocial(rs.getString(5));
                
                lista.add(pv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int agregar(Proveedor pv){
        String sql="insert into proveedor (telefono,direccion,ruc,razonSocial) values (?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pv.getTelefono());
            ps.setString(2, pv.getDireccion());
            ps.setString(3, pv.getRuc());
            ps.setString(4, pv.getRazonSocial());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public Proveedor listarId(int id){
        Proveedor pv=new Proveedor();
        String sql="select * from proveedor where IdProveedor="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                pv.setTelefono(rs.getString(2));
                pv.setDireccion(rs.getString(3));
                pv.setRuc(rs.getString(4));
                pv.setRazonSocial(rs.getString(5));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pv;
    }
    
        public int actualizar(Proveedor pv){
           String sql="update proveedor set telefono=?,direccion=?,ruc=?,razonSocial=? where IdProveedor=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps=con.prepareStatement(sql);
            ps.setString(1, pv.getTelefono());
            ps.setString(2, pv.getDireccion());
            ps.setString(3, pv.getRuc());
            ps.setString(4, pv.getRazonSocial());
            ps.setInt(5, pv.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from Proveedor where IdProveedor="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
