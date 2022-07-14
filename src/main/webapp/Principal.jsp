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
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
              <div class="container-fluid collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav align-middle">
                  <li>
                      <img src="img/WhatsApp Image 2022-05-31 at 7.15.24 PM.jpeg" alt="60" width="65"/>
                  </li>
                  <c:forEach var="cpr" items="${privilegio}">
                  <li class="nav-item">
                      <a style="margin-left: 10px; border: none" class="btn btn-outline-light py-2" href="${cpr.getUrl()}" target="myFrame">${cpr.getNombre()}</a>
                  </li>
                  </c:forEach>
                </ul>
                  
              </div>
                <div class="dropdown col-sm-2">
                    <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                      ${usuario.getNom()}
                    </button>
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                            <img src="img/Clientes.png" alt="60" width="60"/>
                        </a>
                      <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                      <a class="dropdown-item" href="#">${usuario.getUser()}@gmail.com</a>
                      <div class="dropdown-divider"></div>
                      <form action="Validar" method="POST">
                          <button name="menu" value="Salir" class="dropdown-item" href="#">Salir</button>
                      </form>
                    </div>
                </div>
          </nav>
                      <div class="m-4" style="height: 550px;">
                          <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
                      </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>  
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
