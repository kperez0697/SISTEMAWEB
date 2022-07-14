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
public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;   
    
    public Producto buscar(int id){
        Producto p=new Producto();
        String sql="select * from producto where idproducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setCategoria(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public int actualizarstock(int id, int stock){
        String sql="update producto set stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    //operaciones CRUD
    public List listar(int cat){
        String sql="select * from producto where Categoria="+cat;
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setCategoria(rs.getInt(5));
                lista.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int agregar(Producto pr){
        String sql="insert into producto(Nombres,Precio,Stock,Categoria) values (?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setInt(4, pr.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public Producto listarId(int id){
        Producto pr=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setCategoria(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
    
    public int actualizar(Producto pr){
           String sql="update producto set Nombres=?,Precio=?,Stock=?,Categoria=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setInt(4, pr.getCategoria());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
