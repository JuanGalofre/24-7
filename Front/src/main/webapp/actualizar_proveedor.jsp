<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
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
		<div class="form-box-container">
        <form action="./StoresServlet" class="form-box" method="GET">
            <h1 class="form-title">Actualizar proveedor</h1>
            <label for="username" >Ingresar NIT del proveedor</label>
            <%
		    String mensaje =(String) request.getAttribute("mensaje_verificar_proveedor");
            String mens =(String) request.getAttribute("mensaje_actualizar_proveedor");
            Long nit = (Long) request.getAttribute("nit");	
		    if(mensaje != null){
		    %>
	        <label for="message"> <%= mensaje %></label>
	        <%
			}
			if(nit != null){
		    %>  	
            <input type="text" name="ingreso_nit_proveedor" placeholder="" value="<%= nit.toString() %>">
            <button type="submit" name ="verificar_proveedor" class="top_button" >
                Confirmar
            </button>
            <%
				}else{
			%> 		
			<input type="text" name="ingreso_nit_proveedor" placeholder="">
		    <button type="submit" name ="verificar_proveedor" class="top_button">
		    Confirmar
		    </button>
			<%			
				}
			if(mens != null){
		    %>  
	        <label for="message"> <%= mens %></label>
	    	<% 
			}
	    	%>  	
            
            
            
        
            
            <%			
				
			if(mensaje != null){
		    %>  
		    	<label for="apellido" >Nombre del Proveedor</label>
		        <input type="text" name="nombre_proveedor" placeholder="" require="">
		        <label for="id" >Dirección</label>
		        <input type="text" name="direccion_proveedor" placeholder="" require="">
	            <label for="usuario" >Telefono</label>
		        <input type="text" name="telefono_proveedor" placeholder="" require="">
		        <label for="correo" >Ciudad</label>
		        <input type="text" name="ciudad_proveedor" placeholder="" require="">
		        <button type="submit" name="actualizar_proveedor">
	                Actualizar
	            </button>
	    	<% 
			} else{
	    	%>  
		        <button type="submit" name="actualizar_proveedor" disabled >
	                Porfavor verifique el proveedor
	            </button>
	    	<% 
			}
	    	%> 
            
            
            
            
    </div>
	
	
	
	
	
	
	
</body>
</html>