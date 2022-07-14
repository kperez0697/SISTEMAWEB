<%-- 
    Document   : DetalleVenta
    Created on : 5 jul. 2022, 16:28:55
    Author     : alex
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-sm-1"></div>
        <!--<input type="text" name="txtidventa">
        <a class="btn btn-info" href="Controlador?menu=DetalleVenta&accion=Buscar&id=txtidventa">BUSCAR</a>-->
        <div class="col-sm-6">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>IDVENTA</th>
                        <th>ID_DETALLE</th>
                        <th>PRODUCTO</th>
                        <th>CANTIDAD</th>
                        <th>PRECIO UNITARIO</th>
                        <th>CLIENTE</th>
                        <th>EMPLEADO</th>
                        <th>FECHA</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dv" items="${detalleVentas}">
                    <tr>
                        <td>${dv.getIdventas()}</td>
                        <td>${dv.getId()}</td>
                        <td>${dv.getProducto()}</td>
                        <td>${dv.getCantidad()}</td>
                        <td>${dv.getPrecio()}</td>
                        <td>${dv.getCliente()}</td>
                        <td>${dv.getEmpleado()}</td>
                        <td>${dv.getFecha()}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>  
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
