<%-- 
    Document   : index
    Created on : 04/11/2022, 04:22:31
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String msg = (String) session.getAttribute("msg");%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </head>
    <body style="height: 100vh;" class="d-flex justify-content-center align-items-center">
        <div class="form-control d-flex flex-lg-row justify-content-center align-items-center align-self-center w-75
             "
             style="background-color: #d3d3d3"
             >
            <form method="post" action="Valida" class="p-lg-2 w-50">
                <div class="form-floating mb-3 d-flex justify-content-center">
                    <input type="text" class="form-control" id="floatingInput" placeholder="nome" name="nome">
                    <label for="floatingInput">Nome</label>
                </div>
                <div class="form-floating d-flex justify-content-center">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="senha">
                    <label for="floatingPassword">Password</label>
                </div>
                <% if (msg != null) {%>
                <div class="d-flex justify-content-center mt-2">
                    <p class="text-danger"><%=msg%></p>
                </div>
                <%}%>
                <div class="d-flex justify-content-center mt-2">
                    <button type="submit" class="btn btn-outline-primary">enviar</button>
                </div>
            </form>
        </div>
    </body>
</html>

