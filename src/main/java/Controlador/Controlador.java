/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.*;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alex
 */
public class Controlador extends HttpServlet {
    
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    Producto pr=new Producto();
    ProductoDAO pdao=new ProductoDAO();
    Cliente cli=new Cliente();
    ClienteDAO cdao=new ClienteDAO();
    CategoriaProducto ctp=new CategoriaProducto();
    CategoriaProductoDAO ctdao=new CategoriaProductoDAO();
    Proveedor prov=new Proveedor();
    ProveedorDAO pvdao=new ProveedorDAO();
    Privilegio pvl = new Privilegio();
    PrivilegioDAO pvldao = new PrivilegioDAO();
    DetalleVentas dv = new DetalleVentas();
    DetalleVentasDAO dvdao = new DetalleVentasDAO();
    int ide;
    int idePR;
    int ideCL;
    int ideCTPR;
    int idePV;
    int idePVL;
    Venta v=new Venta();
    List<Venta> lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao=new VentaDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        
        if(menu.equals("Home")){
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        if(menu.equals("boleta")){
            int idventa = vdao.IdVenta();
            String nroSerie = vdao.NroVenta(idventa);
            Venta lista = vdao.buscarXNroS(nroSerie);
            request.setAttribute("bVenta", lista);
            Empleado listaempleado = edao.listarId(lista.getIdempleado());
            request.setAttribute("bEmpleado", listaempleado);
            Cliente listacliente = cdao.listarId(lista.getIdcliente());
            request.setAttribute("bCliente", listacliente);
            List listaDetalle = dvdao.listarIdVenta(lista.getId());
            request.setAttribute("bDetalle", listaDetalle);
            request.getRequestDispatcher("pdf.jsp").forward(request, response);
        }
        if (menu.equals("DetalleVenta")){
            switch(accion){
                case "Listar":
                    List lista = dvdao.listar();
                    request.setAttribute("detalleVentas",lista);
                    break;
                case "Buscar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    List lis = dvdao.buscar(ide);
                    request.setAttribute("detalleVentas", lis);
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("DetalleVenta.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch(accion){
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String est=request.getParameter("txtestado");
                    String user=request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTel");
                    String est1=request.getParameter("txtestado");
                    String user1=request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch(accion){
                case "Listar":
                    List listar=cdao.listar();
                    request.setAttribute("clientes", listar);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombre");
                    String dir=request.getParameter("txtDireccion");
                    
                    cli.setDni(dni);
                    cli.setNombre(nom);
                    cli.setDireccion(dir);
                    
                    cdao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ideCL=Integer.parseInt(request.getParameter("id"));
                    Cliente clie=cdao.listarId(ideCL);
                    request.setAttribute("cliente", clie);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombre");
                    String dir1=request.getParameter("txtDireccion");
                    
                    cli.setDni(dni1);
                    cli.setNombre(nom1);
                    cli.setDireccion(dir1);
                    
                    cli.setId(ideCL);
                    cdao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ideCL=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(ideCL);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            em = (Empleado)request.getSession().getAttribute("usuario");     
            String rol = edao.listarRol(em.getId());
            System.out.println("Estado    :  "+rol);
            if(rol.equals("2"))
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);  
            else
            request.getRequestDispatcher("Clientes_1.jsp").forward(request, response);  
           
        }
        if (menu.equals("Proveedor")) {
            switch(accion){
                case "Listar":
                    List listar=pvdao.listar();
                    request.setAttribute("proveedores", listar);
                    break;
                case "Agregar":
                    String telf=request.getParameter("txtTelefono");
                    String dir=request.getParameter("txtDireccion");
                    String ruc=request.getParameter("txtRuc");
                    String rz=request.getParameter("txtRazonSocial");
                    prov.setTelefono(telf);
                    prov.setDireccion(dir);
                    prov.setRuc(ruc);
                    prov.setRazonSocial(rz);
                    pvdao.agregar(prov);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idePV=Integer.parseInt(request.getParameter("id"));
                    Proveedor prove=pvdao.listarId(idePV);
                    request.setAttribute("proveedor", prove);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String telf1=request.getParameter("txtTelefono");
                    String dir1=request.getParameter("txtDireccion");
                    String ruc1=request.getParameter("txtRuc");
                    String rz1=request.getParameter("txtRazonSocial");
                    
                    prov.setTelefono(telf1);
                    prov.setDireccion(dir1);
                    prov.setRuc(ruc1);
                    prov.setRazonSocial(rz1);
                    
                    prov.setId(idePV);
                    pvdao.actualizar(prov);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idePV=Integer.parseInt(request.getParameter("id"));
                    pvdao.delete(idePV);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
        if(menu.equals("Principal")){
            switch(accion){
                case "Listar":
                    em = (Empleado)request.getSession().getAttribute("usuario");
                    
                    List listar=pvldao.listar(em.getId());
                    request.setAttribute("privilegio", listar);
                    break;
            }
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("MostrarCategoria")){
            switch(accion){
                case "Listar":
                    List listar=ctdao.listar();
                    request.setAttribute("categorias", listar);
                    break;
            }
            request.getRequestDispatcher("CategorizacionProducto.jsp").forward(request, response);
        }
        if(menu.equals("CategoriaProducto")){
            switch(accion){
                case "Listar":
                    List listar=ctdao.listar();
                    request.setAttribute("categorias", listar);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    ctp.setNombre(nom);
                    ctdao.agregar(ctp);
                    request.getRequestDispatcher("Controlador?menu=CategoriaProducto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ideCTPR=Integer.parseInt(request.getParameter("id"));
                    CategoriaProducto ctpO=ctdao.listarId(ideCTPR);
                    request.setAttribute("productocat", ctpO);
                    request.getRequestDispatcher("Controlador?menu=CategoriaProducto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombre");
                    
                    ctp.setNombre(nom1);
                    
                    ctp.setId(ideCTPR);
                    ctdao.actualizar(ctp);
                    request.getRequestDispatcher("Controlador?menu=CategoriaProducto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ideCTPR=Integer.parseInt(request.getParameter("id"));
                    ctdao.delete(ideCTPR);
                    request.getRequestDispatcher("Controlador?menu=CategoriaProducto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("EditarCategorias.jsp").forward(request, response);
        }
        if (menu.equals("Producto")){
            System.out.println(request.getParameter("ide"));
            
            
            switch(accion){
                case "Listar":
                    ideCTPR = Integer.parseInt(request.getParameter("ide"));
                    List listar=pdao.listar(ideCTPR);
                    request.setAttribute("productos", listar);
                    
                    ctp.setId(ideCTPR);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    double pre=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stc=Integer.parseInt(request.getParameter("txtStock"));
                    //CAMBIAR EL PLANO DE SELECCION POR EL ID Q OBTENGAS DEL PRINCIPAL
                    pr.setNombre(nom);
                    pr.setPrecio(pre);
                    pr.setStock(stc);
                    pr.setCategoria(ctp.getId());
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar&ide="+ctp.getId()).forward(request, response);
                    break;
                case "Editar":
                    idePR=Integer.parseInt(request.getParameter("id"));
                    Producto prO=pdao.listarId(idePR);
                    request.setAttribute("producto", prO);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar&ide="+ctp.getId()).forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombre");
                    double pre1=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stc1=Integer.parseInt(request.getParameter("txtStock"));
                    //CAMBIAR POR EL EL PLANO DE SELECCION
                    pr.setNombre(nom1);
                    pr.setPrecio(pre1);
                    pr.setStock(stc1);
                    pr.setCategoria(ideCTPR);
                    pr.setId(idePR);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar&ide="+ctp.getId()).forward(request, response);
                    break;
                case "Delete":
                    idePR=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idePR);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar&ide="+ctp.getId()).forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch(accion){
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cli.setDni(dni);
                    cli = cdao.buscar(dni);
                    request.setAttribute("c", cli);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    pr=pdao.listarId(id);
                    request.setAttribute("c", cli);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    request.setAttribute("c", cli);
                    totalPagar = 0.0;
                    item = item+1;
                    cod=pr.getId();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cantidad"));
                    subtotal=precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for(int i=0; i<lista.size(); i++){
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("c", cli);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "GenerarVenta":
                    //actualizacion del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pr=aO.buscar(idproducto);
                        int sac=pr.getStock()-cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    v.setIdcliente(cli.getId());
                    //SE PUEDE CAMBIAR POR FRAME
                    em = (Empleado)request.getSession().getAttribute("usuario");
                    
                    v.setIdempleado(em.getId());
                    v.setNumserie(numeroserie);
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                    v.setFecha(formatter.format(new Date()));
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardaVenta(v);
                    //Guardar Detalle Ventas
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for(int i=0; i < lista.size(); i++){
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    lista=new ArrayList<>();
                    request.getRequestDispatcher("Controlador?menu=boleta").forward(request, response);

                    break;
                case "CancelarVenta":
                    lista=new ArrayList<>();
                    break;
                
                default:
                    numeroserie=vdao.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
