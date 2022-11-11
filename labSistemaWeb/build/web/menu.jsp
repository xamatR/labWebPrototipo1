<%-- 
    Document   : menu
    Created on : 03/11/2022, 21:15:00
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String nome =(String)session.getAttribute("nome");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-black py-0 px-0">
        <div class="collapse navbar-collapse navbar-nav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="welcome.jsp">Welcome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="menu.jsp">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="indexhsdbjhadfs.html">Erro HTML</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ErrorsForce">Erro Java</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link link-danger" href="Valida?code=sair">sair</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="card-title justify-content-center d-flex">
            <h1 class="">Olá , <%=nome%></h1>
        </div>
        <div class="p-5 flex-wrap justify-content-center align-items-center">
            <p>Consectetur qui voluptate irure voluptate non elit. Ex minim culpa tempor eiusmod et magna. Duis quis in
                sunt ad reprehenderit. Sint dolore fugiat deserunt fugiat ea magna fugiat voluptate nisi amet ut elit.
            </p>

            <p>Eiusmod commodo cillum est laboris. Do laboris occaecat elit laborum cupidatat quis aute excepteur. Aute
                ea labore do officia. Pariatur esse exercitation enim veniam dolore do.</p>

            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit assumenda soluta possimus suscipit! Unde,
                facere assumenda nobis et fugiat earum quaerat enim tempore amet quidem cupiditate laborum esse numquam
                debitis?</p>

            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Commodi, unde earum totam magni aliquam in porro
                nobis error expedita debitis alias incidunt architecto ea explicabo modi? Libero corrupti dolores
                doloribus?</p>
        </div>
    </div>



        
    </body>
</html>








