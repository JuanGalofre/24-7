
<%@ page import="co.edu.unbosque.Stores.ReporteVentasDTO"  %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu de administración · sección</title>
<link rel="stylesheet" type="text/css"
	href="menu_administracion.css">
</head>
<body>
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
			 <a class="page__link">Total: <%=request.getAttribute("contador")   %></a>
		</div>

	</div>
	<div class="rightbar">
		<div class="form-box-container">
			<form action="./StoresServlet" class="form-box-report">
				<h1 class="form-title-report">Menú de reportes</h1>
				<div class="form-box-flex">
					<button type="submit" name="reportes_usuarios">Listado de usuarios</button>
					<button type="submit" name="reportes_clientes">Listado de clientes</button>
					<button type="submit" name="reportes_ventas_clientes">Ventas por cliente</button>
				</div>
			</form>

			<div class="form-box-report">
				<div class="list-box-container">
				
					<%
						
					ArrayList<ReporteVentasDTO> lista =(ArrayList<ReporteVentasDTO>) request.getAttribute("lista");
					for( ReporteVentasDTO venta:lista){
						
					%>
					<div class="list-box">
						<div class="list-get-text">
							<span>Cedula:</span>
							<span class="dinamyc-text"><%= venta.getCedula_cliente()%></span>
							<span>Nombre:</span>
							<span class="dinamyc-text"><%= venta.getNombre_cliente()%></span>
							<span>Valor:</span>
							<span class="dinamyc-text"><%= venta.getValor_venta()%></span>
							
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>


		</div>
	</div>
</body>
</html>