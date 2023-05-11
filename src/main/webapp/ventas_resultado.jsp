<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
			Integer nombre = (Integer)request.getAttribute("codigoventa");
			
			%>	
			<a class="page__link">Codigo de Venta <%=nombre%></a>
		</div>
	</div>

	<div class="rightbar">
			<div class="sell-box">
					<div class="grid-three-column">
	
						<div class="column-one">
							<form action="./StoresServlet" class="form-box" method="get">
								<label>Código del producto</label> <input type="text"
									placeholder="" value="<%= request.getAttribute("codigo1") %>">
								<button type="submit" class="top_button" disabled name="consultar_cliente">
									Consultar</button>
							</form>
		
							<input type="text" value="<%= request.getAttribute("nombre1") %>" name="nombre_product_one" > 
							
							<label>Cantidad</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("cantidad1") %>">
							
							<label>Valor total</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("valortotal1") %>">
							
							<label>Total venta</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("totalventa1") %>">
						</div>
		
						<div class="column-two">
							<form action="./StoresServlet" class="form-box" method="get">
								<label>Código del producto</label> 
								<input type="text"value="<%= request.getAttribute("codigo2") %>"	placeholder="" value="">
								<button type="submit" class="top_button" disabled name="">
									Consultar</button>
							</form>
		
							<input type="text" value="<%= request.getAttribute("nombre2") %>" name="nombre_product_two" placeholder="Nombre del producto"> 
							<label>Cantidad</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("cantidad2") %>">
							
							<label>Valor total</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("valortotal2") %>">
							
							<label>Total IVA</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("totalventa2") %>">	
						</div>
		
						<div class="column-three">
							<form action="./StoresServlet" class="form-box" method="get">
								<label>Código del producto</label> <input type="text"placeholder="" value="<%= request.getAttribute("codigo3") %>">
								<button type="submit" class="top_button" disabled name="">
									Consultar</button>
							</form>
		
							<input type="text" value="<%= request.getAttribute("nombre3") %>" name="nombre_product_three" placeholder="Nombre del producto"> 
							<label>Cantidad</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("cantidad3") %>">
							
							<label>Valor total</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("valortotal3") %>">
							
							<label>Total con IVA</label>
							<input type="text" value="<%= request.getAttribute("totalventa3") %>">
						</div>
				</div>
							<label class="center">Total Venta</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("valortotalventa") %>" >
							
							<label class="center">Total IVA</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("totaliva") %>">
							
							<label class="center">Total con IVA</label>
							<input type="text" placeholder="" value="<%= request.getAttribute("totalventa") %>">
							
							
							<label class="center">Se registró su venta satisfactoriamente</label>
							
			
			</div>

	</div>
</body>
</html>