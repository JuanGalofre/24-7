<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tiendas 24/7 iniciar sesión</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
   <div class="form-box-container">
       <form method="get" action="./StoresServlet" class="form-box" >
       		<h2>${errorMsg}</h2>
           <h1 class="form-title">Mi Cuenta</h1>
           
             <%
				String mensaje =(String) request.getAttribute("mensaje");
					if(mensaje != null){
			 %>
	         <label for="message"> <%= mensaje %></label>
	         <%}%>
	          	
           
           
           
           
           <%/*
           <a href="/" class="ini" ><span>Iniciar sesión</span></a>
           <a href="/registro"><span>Registrarme</span></a><br>
           */
           %>
           <label for="username" >Correo electronico o usuario</label>
           <input type="text" id="username" placeholder="" name= "userdata">
           <label for="clave">Contraseña</label>
           <input type="text" id="clave" placeholder="" name = "userpassword">
           <button type="submit" name="ingresar">
               Ingresar
           </button>
           <a class="forget">¿Olvidaste tu contraseña?</a>
       </form>
   </div>
</body>
</html>