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
	            <h1 class="form-title">Actualizar cliente</h1>
	            <label for="username" >Ingresar cedula del cliente</label>
	            <%
			    String mensaje =(String) request.getAttribute("mensaje_verificar_cliente");
	            String mens =(String) request.getAttribute("mensaje_actualizar_cliente");
	            String mensajeCancelar =(String) request.getAttribute("mensaje_cancelar_cliente");
	            Long cedula = (Long) request.getAttribute("cedula");	
			    if(mensaje != null){
			    %>
		        <label for="message"> <%= mensaje %></label>
		        <%
				}
				if(cedula != null){
			    %>  	
	            <input type="text" name="ingreso_cedula_cliente" placeholder="" value="<%= cedula.toString() %>">
	            <button type="submit" name ="verificar_cliente" class="top_button" >
	                Confirmar
	            </button>
	            <%
					}else{
				%> 		
				<input type="text" name="ingreso_cedula_cliente" placeholder="">
			    <button type="submit" name ="verificar_cliente" class="top_button">
			    Confirmar
			    </button>
				<%			
					}
				if(mens != null){
			    %>  
		        <label for="message"> <%= mens %></label>
		    	<% 
				} if(mensajeCancelar != null){
					
		    	%>  	
	            
	            <label for="message"> <%= mensajeCancelar %></label>
	            
	            
	            <%	
				}
				if(mensaje != null && mensajeCancelar==null){
			    %> 
			    	  
		         	<label for="nombre" >Nombre del cliente</label>
		            <input type="text" required ="" name="nombre_cliente_actualizar" placeholder="" require="">
		            <label for="apellido" >Dirección</label>
		            <input type="text" required ="" name="direccion_cliente_actualizar" placeholder=""require="">
		            <label for="id" >Correo electronico</label>
		            <input type="text" required ="" name="correo_cliente_actualizar" placeholder="usuario@dominio.es"require="">
		            <label for="usuario" >Telefono</label>
		            <input type="text" required ="" name="telefono_cliente_actualizar" placeholder=""require="">
	             
			        <button type="submit" name="actualizar_cliente">
		                Actualizar
		            </button>
		    	<% 
				} else{
		    	%>  
			        <button type="submit" name="actualizar_cliente" disabled >
		                Porfavor verifique el cliente
		            </button>
		    	<% 
				}
		    	%> 
	            
	      </form>   
    </div>
</body>
</html>		