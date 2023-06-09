<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Men� principal de usuarios</title>
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
		
		<div class="form-box-container">
        	<form action="./StoresServlet" class="form-box">
	            <h1 class="form-title">Crear proveedor</h1>
	          	<%
				String mensaje =(String) request.getAttribute("mensaje");
					if(mensaje != null){
				%>
	          	<label for="message"> <%= mensaje %></label>
	          	<%}%> 
	          	 
	          	 
	          	 
	          	 
	            <label for="username" >Nombre del proveedor</label>
	            
	            <input type="text" name="nombre_proveedor" placeholder="" require="">
	            <label for="apellido" >NIT</label>
	            <input type="text" name="nit_proveedor" placeholder="" require="">
	            <label for="id" >Direcci�n</label>
	            <input type="text" name="direccion_proveedor" placeholder="" require=""> 
	            <label for="usuario" >Telefono</label>
	            <input type="text" name="telefono_proveedor" placeholder="" require="">
	            <label for="correo" >Ciudad</label>
	            <input type="text" name="ciudad_proveedor" placeholder="" require="">
	            <button type="submit" name="agregar_proveedor">
	                Registrar
	            </button>
        </form>
    </div>
		
	</div>
</body>
</html>