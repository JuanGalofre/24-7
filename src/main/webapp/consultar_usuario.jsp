<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="co.edu.unbosque.Stores.Usuarios"  %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menú principal de usuarios</title>
	<link rel="stylesheet" type="text/css" href="menu_administracion.css">
</head>
<body>
	<div class="leftbar">
		<div class="accordion">
			 <div>
			   <input type="radio" name="example_accordion" id="section1" class="accordion__input">
			   <label for="section1" class="accordion__label">Panel de clientes</label>
			   <div class="accordion__content">
			     <a href="agregar_cliente.jsp" class="content__link">Crear</a><br>
			     <a href="actualizar_cliente.jsp" class="content__link">Actualizar</a><br>
			     <a href="consultar_cliente.jsp" class="content__link">Consultar</a><br>
			     <a href="borrar_cliente.jsp" class="content__link">Borrar</a><br>
			   </div>
			 </div>
			 <div>
			   <input type="radio" name="example_accordion" id="section2" class="accordion__input">
			   <label for="section2" class="accordion__label">Panel de proveedores</label>
			   <div class="accordion__content">
			     <a href="agregar_proveedor.jsp" class="content__link">Crear</a><br>
			     <a href="actualizar_proveedor.jsp" class="content__link">Actualizar</a><br>
			     <a href="consultar_proveedor.jsp" class="content__link">Consultar</a><br>
			     <a href="borrar_proveedor.jsp" class="content__link">Borrar</a><br>
			   </div>
			 </div>
			 <div>
			   <input type="radio" name="example_accordion" id="section3" class="accordion__input">
			   <label for="section3" class="accordion__label">Panel de usuarios</label>
			   <div class="accordion__content">
			     <a href="agregar_usuario.jsp" class="content__link">Crear</a><br>
			     <a href="actualizar_usuario.jsp" class="content__link">Actualizar</a><br>
			     <a href="consultar_usuario.jsp" class="content__link">Consultar</a><br>
			     <a href="borrar_usuario.jsp" class="content__link">Borrar</a><br>
			   </div>			   
			 </div>
			 <a href="productos.jsp" class="page__link">Productos</a>
			 <a href="reportes.jsp" class="page__link">Reportes</a>
			 <a href="ventasCliente.jsp" class="page__link">Ventas</a>
		</div>

	</div>	
	<div class="rightbar">
	    <%	
	    		String mensaje =(String) request.getAttribute("mensaje");  
				Usuarios usuario =(Usuarios) request.getAttribute("usuario");
				if(usuario != null){
	    %>	
		<div class="form-box-container">
        <form action="./StoresServlet"  class="form-box" method="get">
            <h1 class="form-title">Consultar datos del usuario</h1>
            <label for="username" >Ingresar cedula del usuario</label>
            <input type="text" name="ingresar_cedula_usuario" placeholder="" value="<%=usuario.getCedula_usuario() %>">
            <button type="submit" class="top_button" name="consultar_usuario" disabled>
                Confirmar
            </button>
			
            <label for="username" >Nombre</label>
            <input type="text" id="nombre_usuario_consultar" placeholder="" value="<%= usuario.getNombre_usuario() %>">
            <label for="id" >Correo electronico</label>
            <input type="text" id="correo_usuario_consultar" placeholder="" value="<%= usuario.getEmail_usuario() %>">
            <label for="id" >Usuario</label>
            <input type="text" id="usuario" placeholder="" value="<%= usuario.getNombre_usuario() %>">
            <label for="id" >Contraseña</label>
            <input type="text" id="correo_usuario_consultar" placeholder="" value="<%= usuario.getClave_usuario() %>">
	    <%} else{ %>
		<div class="form-box-container">
        <form action="./StoresServlet" class="form-box" method="get">
            <h1 class="form-title">Consultar datos del usuario</h1>
            <label for="username" >Ingresar cedula del usuario</label>
            <input type="text" name="ingresar_cedula_usuario" placeholder="">
            <button type="submit" class="top_button" name="consultar_usuario">
                Confirmar
            </button>
             <%
            if(mensaje != null){
            	 %>		
            <label><%= mensaje %></label>
            <% }%>	
        <%} %>        
        </form>
    </div>
</body>
</html>