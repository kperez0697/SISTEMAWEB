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
public class PrivilegioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
       public List listar(int idemp){
        String sql="SELECT P.Id, P.Nombre,P.url FROM `Privilegios`  as P "
                + "INNER JOIN Privilegios_Rol AS PR on p.Id = pr.IdPrivilegios "
                + "INNER JOIN Rol AS R ON R.Id = PR.IdRol "
                + "INNER JOIN empleado AS E ON E.Rol = R.Id "
                + "WHERE E.IdEmpleado = "+idemp;
        List<Privilegio>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Privilegio pvl = new Privilegio();
                pvl.setId(rs.getInt(1));
                pvl.setNombre(rs.getString(2));
                pvl.setUrl(rs.getString(3));
                lista.add(pvl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
       
}
