<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>VENTAS</title>
        <style>
            
            @media print{
                
                .parte1, .btn, .formulario{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4 parte01">
                <div class="card">
                    <form class="formulario" action="Controlador?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        
                        <!-- DATOS DEL CLIENTE -->
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>
                        <div class="form-group d-flex cliente">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control clienteDNI" placeholder="Codigo">
                                <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <input type="text" name="nombrescliente" value="${c.getNombre()}" class="form-control" placeholder="Datos Cliente">
                            </div>
                        </div>
                         
                            <!-- DATOS DEL PRODUCTO -->
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <input type="text" name="nomproducto" value="${producto.getNombre()}" class="form-control" placeholder="Datos Producto">
                            </div>
                        </div>
                        <br>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="S/0.00">
                            </div>
                                <div class="col-sm-1"></div>
                            <div class="col-sm-2">
                                <input type="number" name="cantidad" value="1" class="form-control">
                            </div>
                                <div class="col-sm-1"></div>
                            <div class="col-sm-2">
                                <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock">
                            </div>
                    </div>
                            <br>
                            <!-- AGREGAR UN REGISTRO -->
                        <div class="form-group">
                            <div class="col-sm">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                            </div>
                        </div>
                </div>
                    </form>
            </div>
            </div>
            <div class="col-sm-1"></div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex ml-auto">
                            <div class="col-sm-5"></div>
                            <label>Numero Serie</label>
                            <div class="col-sm-1"></div>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta"  class="btn btn-success">Generar Venta</a>
                            <a href="Controlador?menu=NuevaVenta&accion=CancelarVenta" class="btn btn-danger">Cancelar Venta</a>
                            
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="S/. ${totalpagar}0" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>  
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
