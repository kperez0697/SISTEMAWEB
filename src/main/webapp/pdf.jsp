<%-- 
    Document   : pdf
    Created on : 27 jun. 2022, 16:32:41
    Author     : alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assets/css/main.css">
    <style>
        @media print{
            .imprimir, .btn{
                display: none;
            }
        }
    </style>
</head>
<body>
    <form class="text-center"  border="1"  width="22">
        <div class="form-group row justify-content-center py-4">
        <img src="img/WhatsApp Image 2022-05-31 at 7.15.24 PM.jpeg" alt=""/>
        <div><h2>BOLETA DE VENTA ELECTRONICA</h2></div>
        <div><h3>NRO: ${bVenta.getNumserie()} </h3></div>
        <div><h2>              </h2></div>
        <div align="left">
            <h3>TIENDA : 001</h3>
            <h3>CAJERO: ${bEmpleado.getNom()}</h3>
            <h3>ATE-LIMA</h3>
            <h3>FECHA DE EMISION: ${bVenta.getFecha()} </h3>
            <h3>TIPO DE MONEDA: NUEVO SOL</h3>
            <h3>CLIENTE: ${bCliente.getNombre()}</h3>
            <br>
            <br>
            <h3>NRO DOCUMENTO: ${bCliente.getDni()}</h3>
            <br>
        </div>
        <table>
            <thead>
                <tr>
                    <td>DESCRIPCION | </td>
                    
                    <td>CANTIDAD | </td>
                    
                    <td>PRECIO U | </td>
                    
                    <td>SUBTOTAL</td>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="dt" items="${bDetalle}">
                <tr>
                <td>${dt.getProducto()}</td>
                <td>${dt.getCantidad()}</td>
                <td>${dt.getPrecio()}</td>
                <td>${dt.getCapr()}</td>
                </tr>
                </c:forEach>
            </tbody>
            <tr>
                <td colspan="3" align="right">TOTAL</td>
                <td>${bVenta.getMonto()}</td>
            </tr>
        </table>
        <div>
            <h5>☺ Gracias por su compra ☺︎</h5>
        </div>
        </div>
    </form>
            <a class="imprimir" onclick="print()">imprimir</a>
</body>
</html>
