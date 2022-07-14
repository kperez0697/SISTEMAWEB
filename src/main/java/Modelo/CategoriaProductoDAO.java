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
public class CategoriaProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public CategoriaProducto buscar(int id){
        CategoriaProducto cp=new CategoriaProducto();
        String sql="select * from CategoriaProducto where IdCategoria="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cp.setId(rs.getInt(1));
                cp.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cp;
    }
    
    public List listar(){
        String sql="select * from CategoriaProducto";
        List<CategoriaProducto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                CategoriaProducto pr = new CategoriaProducto();
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                lista.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int agregar(CategoriaProducto cpr){
        String sql="insert into CategoriaProducto(Nombre) values (?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cpr.getNombre());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public CategoriaProducto listarId(int id){
        CategoriaProducto cpr=new CategoriaProducto();
        String sql="select * from CategoriaProducto where IdCategoria="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cpr.setId(rs.getInt(1));
                cpr.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpr;
    }
    
    public int actualizar(CategoriaProducto cpr){
           String sql="update CategoriaProducto set Nombre=? where IdCategoria=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cpr.getNombre());
            ps.setInt(2, cpr.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from CategoriaProducto where IdCategoria="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
