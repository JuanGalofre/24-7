<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="co.edu.unbosque.Stores.Productos"  %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú principal &middot; sección ventas</title>
<link rel="stylesheet" type="text/css" href="ventas.css">
</head>
<body>
	<div class="leftbar">
		<div class="accordion">
			<div>
				<input type="radio" name="example_accordion" id="section1"
					class="accordion__input"> <label for="section1"
					class="accordion__label">Panel de clientes</label>
				<div class="accordion__content">
					<a href="agregar_cliente.jsp" class="content__link">Crear</a><br>
					<a href="actualizar_cliente.jsp" class="content__link">Actualizar</a><br>
					<a href="consultar_cliente.jsp" class="content__link">Consultar</a><br>
					<a href="borrar_cliente.jsp" class="content__link">Borrar</a><br>
				</div>
			</div>
			<div>
				<input type="radio" name="example_accordion" id="section2"
					class="accordion__input"> <label for="section2"
					class="accordion__label">Panel de proveedores</label>
				<div class="accordion__content">
					<a href="agregar_proveedor.jsp" class="content__link">Crear</a><br>
					<a href="actualizar_proveedor.jsp" class="content__link">Actualizar</a><br>
					<a href="consultar_proveedor.jsp" class="content__link">Consultar</a><br>
					<a href="borrar_proveedor.jsp" class="content__link">Borrar</a><br>
				</div>
			</div>
			<div>
				<input type="radio" name="example_accordion" id="section3"
					class="accordion__input"> <label for="section3"
					class="accordion__label">Panel de usuarios</label>
				<div class="accordion__content">
					<a href="agregar_usuario.jsp" class="content__link">Crear</a><br>
					<a href="actualizar_usuario.jsp" class="content__link">Actualizar</a><br>
					<a href="consultar_usuario.jsp" class="content__link">Consultar</a><br>
					<a href="borrar_usuario.jsp" class="content__link">Borrar</a><br>
				</div>
			</div>
			<a href="productos.jsp" class="page__link">Productos</a> <a
				href="reportes.jsp" class="page__link">Reportes</a> <a href="#"
				class="page__link">Ventas</a>
			<%
			String nombre = (String)request.getAttribute("nombre");
			Long cedula = (Long)request.getAttribute("cedula");
			%>
			<a class="page__link">Cliente <%=nombre%></a>
			<a class="page__link">Cedula  <%=cedula%></a>
		</div>
	</div>

	<div class="rightbar">
		<form action="./StoresServlet" method="get" id="formulario_principal">
			<div class="sell-box">
				
					<div class="grid-three-column">
					
						<div class="column-one">
						<%
								ArrayList<Productos> lista =(ArrayList<Productos>) request.getAttribute("lista1");
								ArrayList<Productos> lista2 =(ArrayList<Productos>) request.getAttribute("lista2");
								ArrayList<Productos> lista3 =(ArrayList<Productos>) request.getAttribute("lista3");	
							
								if(lista == null){
									
							%>
							<form action="./StoresServlet" class="form-box" method="get" id="productos">
								<label>Código del producto</label> 
								<input type="text" placeholder="" name="codigo_producto_1" value="">
								<button type="submit" class="top_button" name="consultar_producto" form="productos">
									Consultar</button>
							</form>
		
							<input type="text" name="nombre_1" placeholder="Nombre del producto"> 
							
						</div>
						<%
						}else{Productos producto1 = lista.get(0);
						%>
						<form action="./StoresServlet" class="form-box" method="get" id="productos" >
								<label>Código del producto</label> 
								<input type="text" placeholder="" name="codigo_producto_1" value="<%=producto1.getCodigo_producto()%>">
								<button type="submit" class="top_button" name="consultar_producto" form="productos">
									Consultar</button>
							</form>
		
							<input type="text"  name="nombre_1" placeholder="Nombre del producto" value="<%=producto1.getNombre_producto()%>"> 
							
							
							<label>Valor unidad</label>
							<input type="text" name="valor_1" value="<%=producto1.getPrecio_venta()%>">
							
							<label>Valor unidad con iva</label>
							<input type="text" name="valor_iva_1" value="<%=producto1.getPrecio_venta()+producto1.getPrecio_venta()*(producto1.getIva_compra()/100)%>">
							
							
							<label>Cantidad a comprar</label>
							<input type="number" placeholder="" name="cantidad_1"  min="1">
						</div>
						<%} %>
						
						
						
						
						
						
						<div class="column-two">
							<%
								
								if(lista2 == null){
							%>
							
								<label>Código del producto</label> 
								<input type="text" placeholder="" name="codigo_producto_2" value="">
								<button type="submit" class="top_button" name="consultar_producto" form="productos">
									Consultar</button>
							</form>
		
							<input type="text"  name="nombre_2" placeholder="Nombre del producto"> 

						</div>
						<%
						}else{Productos producto2 = lista2.get(0);
						%>
						
								<label>Código del producto</label> 
								<input type="text" placeholder="" name="codigo_producto_2" value="<%=producto2.getCodigo_producto()%>">
								<button type="submit" class="top_button" name="consultar_producto" form="productos">
									Consultar</button>
							</form>
		
							<input type="text"  name="nombre_2" placeholder="Nombre del producto" value="<%=producto2.getNombre_producto()%>"> 
							
							
							<label>Valor unidad</label>
							<input type="text" name="valor_2" value="<%=producto2.getPrecio_venta()%>">
							
							<label>Valor unidad con iva</label>
							<input type="text" name="valor_iva_2" value="<%=producto2.getPrecio_venta()+producto2.getPrecio_venta()*(producto2.getIva_compra()/100)%>">
							
							<label>Cantidad a comprar</label>
							<input placeholder=""  name="cantidad_2"  type="number" min="1">
						</div>
						<%} %>
						
		
						<div class="column-three">
							<%

								
								if(lista3 == null){
							%>
							
								<label>Código del producto</label> 
								<input type="text" placeholder="" name="codigo_producto_3" value="">
								<button type="submit" class="top_button" name="consultar_producto" form="productos">
									Consultar</button>
							</form>
		
							<input type="text"  name="nombre_3" placeholder="Nombre del producto"> 

						</div>
						<%
						}else{Productos producto3 = lista3.get(0);
						%>
						
								<label>Código del producto</label> 
								<input type="text" placeholder="" name="codigo_producto_3" value="<%=producto3.getCodigo_producto()%>">
								<button type="submit" class="top_button" name="consultar_producto" form="productos">
									Consultar</button>
							</form>
		
							<input type="text" name="nombre_3" placeholder="Nombre del producto" value="<%=producto3.getNombre_producto()%>"> 
							
							
							<label>Valor unidad</label>
							<input type="text" name="valor_3" value="<%=producto3.getPrecio_venta()%>">
							
							<label>Valor unidad con iva</label>
							<input type="text" name="valor_iva_3" value="<%=producto3.getPrecio_venta()+producto3.getPrecio_venta()*(producto3.getIva_compra()/100)%>">
							
							<label>Cantidad a comprar</label>
							<input type="number" min="1" placeholder=""  name="cantidad_3" >
						</div>
						<%
						}
						%>
						
						
				</div>
							<button type="submit" name="calcular_guardar" form="formulario_principal">Confirmar cantidades</button>
						
			
			</div>
		</form>	
	</div>
</body>
</html>