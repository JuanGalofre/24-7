<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="co.edu.unbosque.Stores.Clientes"  %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menú principal de clientes</title>
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
				Clientes cliente =(Clientes) request.getAttribute("cliente");
				if(cliente != null){
	    %>	
		<div class="form-box-container">
        <form action="./StoresServlet"  class="form-box" method="get">
            <h1 class="form-title">Consultar datos del cliente</h1>
            <label for="username" >Ingresar cedula del cliente</label>
            <input type="text" name="ingreso_cedula_cliente" placeholder="" value="<%= cliente.getCedula_cliente() %>">
            <button type="submit" class="top_button" name="consultar_cliente">
                Confirmar
            </button>
			
            <label for="username" >Nombre</label>
            <input type="text" id="nombre_cliente_consultar" placeholder="" value="<%= cliente.getNombre_cliente() %>">
            <label for="id" >Correo electronico</label>
            <input type="text" id="correo_cliente_consultar" placeholder="" value="<%= cliente.getEmail_cliente() %>">
            <label for="id" >Dirección</label>
            <input type="text" id="dirección_cliente_consultar" placeholder="" value="<%= cliente.getDireccion_cliente() %>">
            <label for="id" >Telefono</label>
            <input type="text" id="telefono_cliente_consultar" placeholder="" value="<%= cliente.getTelefono_cliente() %>">   
	    <%} else{ %>
		<div class="form-box-container">
        <form action="./StoresServlet"  class="form-box" method="get">
            <h1 class="form-title">Consultar datos del cliente</h1>
            <label for="username" >Ingresar cedula del cliente</label>
            <input type="text" name="ingreso_cedula_cliente" placeholder="">
            <button type="submit" class="top_button" name="consultar_cliente">
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