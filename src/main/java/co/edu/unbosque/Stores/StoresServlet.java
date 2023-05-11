package co.edu.unbosque.Stores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.ParseException;


/**
 * Servlet implementation class StoresServlet
 */
@WebServlet("/StoresServlet")
public class StoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long cedula_usuario_actual;
	private long cedula_cliente_actual;

    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		/*Flags*/
		
		
		String agregar_usuario   = request.getParameter("agregar_usuario");
		String agregar_cliente = request.getParameter("agregar_cliente");
		String agregar_proveedor = request.getParameter("agregar_proveedor");
		String verificar_usuario = request.getParameter("verificar_usuario");
		String verificar_cliente = request.getParameter("verificar_cliente");
		String verificar_proveedor = request.getParameter("verificar_proveedor");
		String actualizar_usuario =  request.getParameter("actualizar_usuario");
		String actualizar_cliente =  request.getParameter("actualizar_cliente");
		String actualizar_proveedor =  request.getParameter("actualizar_proveedor");
		String borrar_usuario =  request.getParameter("borrar_usuario");
		String borrar_cliente =  request.getParameter("borrar_cliente");
		String borrar_proveedor =  request.getParameter("borrar_proveedor");
		String consultar_usuario = request.getParameter("consultar_usuario");
		String consultar_cliente = request.getParameter("consultar_cliente");
		String consultar_proveedor = request.getParameter("consultar_proveedor");
		String reportes_clientes = request.getParameter("reportes_clientes");
		String reportes_usuarios =  request.getParameter("reportes_usuarios");
		String reportes_ventas_clientes =  request.getParameter("reportes_ventas_clientes");
		String guardar_productos = request.getParameter("guardar_productos");
		String ventas_cliente = request.getParameter("ventas_cliente");
		String seleccionar_producto = request.getParameter("consultar_producto");
		String ingresar = request.getParameter("ingresar");
		String calcular_guardar= request.getParameter("calcular_guardar");
		
		
		/* Sección de usuario*/
		
		if(agregar_usuario != null) {
			agregarUsuario(request,response);
		}
		if(verificar_usuario != null) {
			verificarUsuario(request,response);
		}
		if(actualizar_usuario != null) {
			actualizarUsuario(request, response);
		}
		if(borrar_usuario != null) {
			borrarUsuario(request, response);
		}
		if(consultar_usuario != null) {
			consultarUsuario(request,response);
			
		}
		
		/*Sección cliente*/
		
		if(agregar_cliente != null) {
			agregarCliente(request,response);
		}
		if(verificar_cliente != null) {
			verificarClientes(request,response);
		}
		
		if(actualizar_cliente != null) {
			actualizarCliente(request, response);
		}
		if(borrar_cliente != null) {
			borrarCliente(request, response);
		}
		if(consultar_cliente != null) {
			consultarClientes(request,response);
		}
		
		/*Sección proveedor*/
		
		if(agregar_proveedor != null) {
			agregarProveedor(request,response);
		}
		if(verificar_proveedor != null) {
			verificarProveedor(request, response);
		}
		if(actualizar_proveedor != null) {
			actualizarProveedor(request, response);
		}
		if(borrar_proveedor != null) {
			borrarProveedor(request, response);
		}
		if(consultar_proveedor != null) {
			consultarProveedor(request,response);
		}
		
		/*Ingreso*/
		
	
		if(ingresar != null) {
			try {
				cedula_usuario_actual=ingresarUsuario(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/*Sección productos y ventas */
		
		
		
		if(guardar_productos != null) {
			guardarProductos(request,response);
			
		}
		if(ventas_cliente != null) {
			cedula_cliente_actual=ventasCliente(request,response);
		}
		if(seleccionar_producto != null) {
			seleccionarProducto(request,response);
		}
	
		
		if(calcular_guardar != null) {
			try {
				calcularGuardar(request,response);
			} catch (ServletException | IOException | ParseException | org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*Sección reportes*/
		if(reportes_usuarios != null) {
			reportesUsuarios(request,response);
		}
		if(reportes_clientes != null) {
			reportesClientes(request,response);		
		}
		if(reportes_ventas_clientes != null) {
			reportesVentas(request,response);
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public long ingresarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, org.json.simple.parser.ParseException{
		ArrayList<Usuarios> verif = UsuariosJSON.getJSONUsuarios();
		int ingresos= verif.size();

		if(ingresos ==0) {
			if(request.getParameter("userdata").equals("adimininicial") && request.getParameter("userpassword").equals("admin123456"))
			{
				String paginaMatch = "/menu_administracion.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch); 
				dispatcher.forward(request, response);
				ingresos ++;
				return 999999;
			}
		}
		Usuarios usuario = new Usuarios();
		usuario.setEmail_usuario(request.getParameter("userdata"));
		usuario.setClave_usuario(request.getParameter("userpassword"));
		long cedula=0;
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSONUsuarios();
			
			
			boolean transladado = false;
			for(Usuarios i:lista) {
		
	
				if (i.getEmail_usuario().trim().equals(usuario.getEmail_usuario().trim()) || i.getNombre_usuario().trim().equals(usuario.getEmail_usuario().trim())) {
					if(i.getClave_usuario().equals(usuario.getClave_usuario())) {
						String paginaMatch = "/menu_administracion.jsp";
						cedula = i.getCedula_usuario();
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch); 
						dispatcher.forward(request, response); 
						transladado = true;
						ingresos ++;
					}	
				}
			}
			if(transladado ==false) {
				String paginaNoMatch = "/Login.jsp";
				String mensaje = "Usuario o contraseña errados, intente de nuevo";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNoMatch);
				dispatcher.forward(request, response);	
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		return cedula;	
	}
	public void verificarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long nit = Long.valueOf(request.getParameter("ingreso_nit_proveedor"));
		boolean encontrado = false;
		try {
			ArrayList<Proveedores> lista = ProveedoresJSON.getJSONProveedores();
			for(Proveedores i:lista) {
				if (i.getNitproveedor()== nit) {
					encontrado = true;
					String paginaMatch = "/actualizar_proveedor.jsp";
					String mensaje = "El proveedor se encuentra en la base de datos";
					request.setAttribute("mensaje_verificar_proveedor", mensaje);
					request.setAttribute("nit", nit);				
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
					dispatcher.forward(request, response);
					break;
					}	
				}
			if( encontrado == false) {
				String paginaMatch = "/actualizar_proveedor.jsp";
				String mensaje_cancelar = "No se pudo encontrar el proveedor en la base de datos ";
				request.setAttribute("mensaje_cancelar_proveedor", mensaje_cancelar);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		
	}
	public void verificarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long cedula = Long.valueOf(request.getParameter("ingreso_cedula_cliente"));
		boolean encontrado = false;
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSONClientes();
			for(Clientes i: lista) {
				if (i.getCedula_cliente() == cedula) {
					encontrado = true;
					String paginaMatch = "/actualizar_cliente.jsp";
					String mensaje = "El cliente se encuentra en la base de datos";
					request.setAttribute("mensaje_verificar_cliente", mensaje);
					request.setAttribute("cedula", cedula);				
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
					dispatcher.forward(request, response);
					break;
					}	
				}
			if( encontrado == false) {
				String paginaMatch = "/actualizar_cliente.jsp";
				String mensaje_cancelar = "No se pudo encontrar el cliente ";
				request.setAttribute("mensaje_cancelar_cliente", mensaje_cancelar);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		
	}
	public void verificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long cedula = Long.valueOf(request.getParameter("ingreso_cedula_usuario"));
		boolean encontrado = false;
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSONUsuarios();
			for(Usuarios i:lista) {
				if (i.getCedula_usuario() == cedula) {
					encontrado = true;
					String paginaMatch = "/actualizar_usuario.jsp";
					String mensaje = "El usuario se encuentra en la base de datos";
					request.setAttribute("mensaje_verificar_usuario", mensaje);
					request.setAttribute("cedula", cedula);				
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
					dispatcher.forward(request, response);
					break;
					}	
				}
			if( encontrado == false) {
				String paginaMatch = "/actualizar_usuario.jsp";
				String mensaje_cancelar = "No se pudo encontrar el usuario ";
				request.setAttribute("mensaje_cancelar_usuario", mensaje_cancelar);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		
	}
	public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Usuarios usuario = new Usuarios();
		usuario.setNombre_usuario(request.getParameter("nombre_usuario"));
		usuario.setCedula_usuario(Long.valueOf(request.getParameter("cedula_usuario")));
		usuario.setEmail_usuario(request.getParameter("correo_usuario"));
		usuario.setClave_usuario(request.getParameter("clave_usuario"));

		int respuesta = 0;
		try {
			respuesta = UsuariosJSON.postJSONUsuarios(usuario);
			PrintWriter writer= response.getWriter();
			if(respuesta==200) {
				String pagina = "/agregar_usuario.jsp";
				String mensaje = "Registro agregado satisfactoriamente";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			else {
				writer.println("Se genero un error en el metodo de agregar usuario ");
				writer.println("Error: "+ respuesta);
			}
			writer.close();	
		} catch(IOException e) {e.printStackTrace();}
	}
	
	
	public void agregarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Clientes cliente = new Clientes();
		cliente.setNombre_cliente(request.getParameter("nombre_cliente"));
		cliente.setCedula_cliente(Long.valueOf(request.getParameter("cedula_cliente")));
		cliente.setDireccion_cliente(request.getParameter("direccion_cliente"));
		cliente.setEmail_cliente(request.getParameter("correo_cliente"));
		cliente.setTelefono_cliente(request.getParameter("telefono_cliente"));

		int respuesta = 0;
		try {
			respuesta = ClientesJSON.postJSONClientes(cliente);
			PrintWriter writer= response.getWriter();
			if(respuesta==200) {
				String pagina = "/agregar_cliente.jsp";
				String mensaje = "Registro agregado satisfactoriamente";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			else {
				writer.println("Se genero un error en el metodo de agregar cliente ");
				writer.println("Error: "+ respuesta);
			}
			writer.close();	
		} catch(IOException e) {e.printStackTrace();}
			
	}
	public void agregarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Proveedores proveedores = new Proveedores();
		proveedores.setCiudad_proveedor(request.getParameter("ciudad_proveedor"));
		proveedores.setNombre_proveedor(request.getParameter("nombre_proveedor"));
		proveedores.setNitproveedor(Long.valueOf(request.getParameter("nit_proveedor")));
		proveedores.setTelefono_proveedor(request.getParameter("telefono_proveedor"));

		int respuesta = 0;
		try {
			respuesta = ProveedoresJSON.postJSONProveedores(proveedores);
			PrintWriter writer= response.getWriter();
			if(respuesta==200) {
				String pagina = "/agregar_proveedor.jsp";
				String mensaje = "Registro agregado satisfactoriamente";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			else {
				writer.println("Se genero un error en el metodo de agregar proveedor ");
				writer.println("Error: "+ respuesta);
			}
			writer.close();	
		} catch(IOException e) {e.printStackTrace();}
	}	
	
				
	public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Usuarios usuario = new Usuarios();
		usuario.setNombre_usuario(request.getParameter("nombre_usuario_actualizar"));
		long cedula = Long.valueOf(request.getParameter("ingreso_cedula_usuario"));
		usuario.setCedula_usuario(Long.valueOf(request.getParameter("ingreso_cedula_usuario")));
		usuario.setEmail_usuario(request.getParameter("correo_usuario_actualizar"));
		usuario.setClave_usuario(request.getParameter("clave_usuario_actualizar"));

		int respuesta = 0;
		try {
			respuesta = UsuariosJSON.putJSONUsuarios(usuario);
			if(respuesta==200) {
				String paginaMatch = "/actualizar_usuario.jsp";
				String mensaje = "El usuario se actualizó correctamente";
				request.setAttribute("mensaje_actualizar_usuario", mensaje);	
				request.setAttribute("cedula", cedula);	
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			else {
				String paginaMatch = "/actualizar_usuario.jsp";
				String mensaje = "El usuario no se actualizó, porfavor intente más tarde";
				request.setAttribute("mensaje_actualizar_usuario", mensaje);			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			
		} catch(IOException e) {e.printStackTrace();}
		
		
		
		
		
	}
	public void actualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Clientes cliente = new Clientes();
		cliente.setNombre_cliente(request.getParameter("nombre_cliente_actualizar"));
		cliente.setCedula_cliente(Long.valueOf(request.getParameter("ingreso_cedula_cliente")));
		cliente.setDireccion_cliente(request.getParameter("direccion_cliente_actualizar"));
		cliente.setEmail_cliente(request.getParameter("correo_cliente_actualizar"));
		cliente.setTelefono_cliente(request.getParameter("telefono_cliente_actualizar"));

		int respuesta = 0;
		try {
			respuesta = ClientesJSON.putJSONClientes(cliente);
			if(respuesta==200) {
				String paginaMatch = "/actualizar_cliente.jsp";
				String mensaje = "El cliente se actualizó correctamente";
				request.setAttribute("mensaje_actualizar_cliente", mensaje);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			else {
				String paginaMatch = "/actualizar_cliente.jsp";
				String mensaje = "El cliente no se actualizó, porfavor intente más tarde";
				request.setAttribute("mensaje_actualizar_cliente", mensaje);			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			
		} catch(IOException e) {e.printStackTrace();}

		
	}
	public void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Proveedores proveedores = new Proveedores();
		proveedores.setCiudad_proveedor(request.getParameter("ciudad_proveedor"));
		proveedores.setNombre_proveedor(request.getParameter("nombre_proveedor"));
		long nit = Long.valueOf(request.getParameter("ingreso_nit_proveedor"));
		proveedores.setNitproveedor(nit);
		proveedores.setTelefono_proveedor(request.getParameter("telefono_proveedor"));	
		int respuesta = 0;
		try {
			respuesta = ProveedoresJSON.putJSONProveedores(proveedores);
			if(respuesta==200) {
				String paginaMatch = "/actualizar_proveedor.jsp";
				String mensaje = "El proveedor se actualizó correctamente";
				request.setAttribute("mensaje_actualizar_proveedor", mensaje);	
				request.setAttribute("nit", nit);	
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			else {
				String paginaMatch = "/actualizar_proveedor.jsp";
				String mensaje = "El proveedor no se actualizó, porfavor intente más tarde";
				request.setAttribute("mensaje_actualizar_proveedor", mensaje);			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			
		} catch(IOException e) {e.printStackTrace();}

	}
	
	
	
	public void borrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Usuarios usuario = new Usuarios();
		Long cedula = Long.valueOf(request.getParameter("ingresar_cedula_usuario"));
		usuario.setCedula_usuario(cedula);
		int respuesta=0;
		try {
		respuesta = UsuariosJSON.delJSONUsuarios(usuario);
		if(respuesta==200) {
			String pagina = "/borrar_usuario.jsp";
			String mensaje ="El usuario se ha borrado";
			request.setAttribute("mensaje_borrar_usuario", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		else {
			String pagina = "/borrar_usuario.jsp";
			String mensaje ="El usuario no se ha podido borrar";
			request.setAttribute("mensaje_borrar_usuario", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
	} catch(IOException e) {e.printStackTrace();}
		
}
	public void borrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Clientes cliente = new Clientes();
		Long cedula = Long.valueOf(request.getParameter("ingresar_cedula_cliente"));
		cliente.setCedula_cliente(cedula);
		int respuesta=0;
		try {
		respuesta = ClientesJSON.delJSONClientes(cliente);
		if(respuesta==200) {
			String pagina = "/borrar_cliente.jsp";
			String mensaje ="El cliente se ha borrado";
			request.setAttribute("mensaje_borrar_cliente", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		else {
			String pagina = "/borrar_cliente.jsp";
			String mensaje ="El cliente no se ha podido borrar, por favor intente más tarde";
			request.setAttribute("mensaje_borrar_cliente", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
	} catch(IOException e) {e.printStackTrace();}
		
}

	public void borrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		Proveedores proveedores = new Proveedores();
		Long nit = Long.valueOf(request.getParameter("ingresar_nit_proveedor"));
		proveedores.setNitproveedor(nit);
	
		int respuesta=0;
		try {
		respuesta = ProveedoresJSON.delJSONProveedores(proveedores);
		if(respuesta==200) {
			String pagina = "/borrar_proveedor.jsp";
			String mensaje ="El proveedores se ha borrado";
			request.setAttribute("mensaje_borrar_proveedor", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		else {
			String pagina = "/borrar_proveedor.jsp";
			String mensaje ="El proveedores no se ha podido borrar, por favor intente más tarde";
			request.setAttribute("mensaje_borrar_proveedor", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
	} catch(IOException e) {e.printStackTrace();}
		
	}
		


	
	public void consultarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Usuarios usuario = new Usuarios();
		long cedula = Long.valueOf(request.getParameter("ingresar_cedula_usuario"));
		try {
		
			boolean encontrado = false;
			ArrayList<Usuarios> lista = UsuariosJSON.getJSONUsuarios();
			for(Usuarios i:lista) {
				System.out.println("entre3");
				if (i.getCedula_usuario() == cedula) {
					usuario =i;
					String pagina = "/consultar_usuario.jsp";
					request.setAttribute("usuario", usuario);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
					dispatcher.forward(request, response);
					encontrado = true;
					}	
				}
		
			if(encontrado == false)
			{
				String pagina = "/consultar_usuario.jsp";	
				String mensaje = "No se encontro el usuario ";
				request.setAttribute("mensaje", mensaje);	
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
				
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		
	}		
	
	public void consultarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Proveedores proveedores = new Proveedores();
		long nit = Long.valueOf(request.getParameter("ingreso_nit_proveedor"));
		boolean encontrado = false;
		try {
			ArrayList<Proveedores> lista = ProveedoresJSON.getJSONProveedores();
			for(Proveedores i:lista) {
				if (i.getNitproveedor() == nit) {
					proveedores =i;
					String pagina = "/consultar_proveedor.jsp";
					request.setAttribute("proveedor", proveedores);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
					dispatcher.forward(request, response);
					encontrado = true;
					}	
				}
			if(encontrado == false)
			{
				String pagina = "/consultar_proveedor.jsp";	
				String mensaje = "No se encontro el proveedor ";
				request.setAttribute("mensaje", mensaje);	
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
				
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}		
	}

	
	public void consultarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Clientes cliente = new Clientes();
		long cedula = Long.valueOf(request.getParameter("ingreso_cedula_cliente"));
		boolean encontrado = false;
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSONClientes();
			for(Clientes i:lista) {
				if (i.getCedula_cliente() == cedula) {
					cliente =i;
					
					String pagina = "/consultar_cliente.jsp";
					request.setAttribute("cliente", cliente);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
					dispatcher.forward(request, response);
					encontrado = true;
					break;
					}	
				}
			if(encontrado == false)
			{
				String pagina = "/consultar_cliente.jsp";	
				String mensaje = "No se encontro el cliente";
				request.setAttribute("mensaje", mensaje);	
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
				
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
	}

	public void reportesClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSONClientes();
			String pagina = "/reportes_clientes.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}	
	
	
	
	}
	
	
	public void reportesUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSONUsuarios();
			String pagina = "/reportes_usuarios.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}	
	
	}
	public void guardarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String direccion = request.getParameter("ruta_archivo");
	    if (direccion.contains(".csv")== false) {
	    	String pagina = "/productos.jsp";	
			String mensaje = "El archivo sumplementado no es un .csv";
			request.setAttribute("mensaje", mensaje);	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
	    }
		String linea;
    	String partes[];
    	int a=0;
    	int contador=0;
    	Productos producto = new Productos();
    	ArrayList<String> subir = new ArrayList<String>();
    	
	   
    	try {
    		
    		BufferedReader lector = new BufferedReader(new FileReader(direccion));
        	while((linea = lector.readLine())!= null) {
        		
        		
        		partes = linea.split(",");
        		a = linea.split(",").length;

        		for(int i=0;i<partes.length;i++) {
        			
        			subir.add(partes[i]);
        			   			
        		}
        		
        	}
        	
        	int t = 0;
        	while(t<subir.size()) {
        		producto.setCodigo_producto(Long.parseLong(subir.get(t)));
        		producto.setIva_compra(Double.parseDouble(subir.get(t+4)));		
                producto.setNitproveedor(Long.parseLong(subir.get(t+2)));
             
                producto.setNombre_producto(subir.get(t+1));
                producto.setPrecio_compra(Double.parseDouble((subir.get(t+3))));
                producto.setPrecio_venta(Double.parseDouble(subir.get(t+5)));
        		int respuesta = 0;
        	    try {
    				   respuesta = ProductoJSON.postJSONProductos(producto);
    				   
    				   if (respuesta==200) {
    					    
    						

    				   } else {
    					  
    					    String pagina = "/productos.jsp";	
    						String mensaje = "El archivo  no se cargo correctamente" +"Error producido en postJson: " +  respuesta ;
    						request.setAttribute("mensaje", mensaje);	
    						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
    						dispatcher.forward(request, response);
    					   
    					}
    					  
    					} catch (Exception e) {
    					   e.printStackTrace();
    					}
        		
        		
        		t = t + a;
        	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	String pagina = "/productos.jsp";	
		String mensaje = "El archivo se cargo efectivamente";
		request.setAttribute("mensaje", mensaje);	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
    	
	}
	public long ventasCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long cedula = Long.valueOf(request.getParameter("ingreso_cedula_cliente"));
		boolean encontrado = false;
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSONClientes();
			for(Clientes i: lista) {
				if (i.getCedula_cliente() == cedula) {
					encontrado = true;
					String paginaMatch = "/ventas.jsp";
					String mensaje = "El cliente se encuentra en la base de datos";
					String nombre = i.getNombre_cliente();
					request.setAttribute("mensaje_verificar_cliente", mensaje);
					request.setAttribute("cedula", cedula);	
					request.setAttribute("nombre", nombre);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
					dispatcher.forward(request, response);
					break;
					}	
				}
			if( encontrado == false) {
				String paginaMatch = "/ventasCliente.jsp";
				String mensaje_cancelar = "No se pudo encontrar el cliente ";
				request.setAttribute("mensaje_cancelar_cliente", mensaje_cancelar);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
				
			}
		}
		catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		return cedula;
	}
	public void seleccionarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer numero =1;
		String nombre;
		ArrayList<Productos> listaDePeticiones = new ArrayList();
		Productos producto1 = new Productos();
		try {
			long codigo1=Long.parseLong(request.getParameter("codigo_producto_1"));
			producto1.setCodigo_producto(codigo1);
			}
			catch(NumberFormatException e){producto1.setCodigo_producto(0);}
		Productos producto2 = new Productos();
		try {
		long codigo2=Long.parseLong(request.getParameter("codigo_producto_2"));
		producto2.setCodigo_producto(codigo2);
		}
		catch(NumberFormatException e){producto2.setCodigo_producto(0);}
		Productos producto3 = new Productos();
		try {
			long codigo3=Long.parseLong(request.getParameter("codigo_producto_3"));
			producto3.setCodigo_producto(codigo3);
		}
		catch(NumberFormatException e){producto3.setCodigo_producto(0);}
		listaDePeticiones.add(producto1);
		listaDePeticiones.add(producto2);
		listaDePeticiones.add(producto3);
	
		
		for(Productos producto:listaDePeticiones) {
		
			try {
				if(producto.getCodigo_producto() != 0) {
					ArrayList<Productos> lista = ProductoJSON.buscarJSONProductos(producto);
					if( lista != null) {
						
						nombre=numero.toString();
						request.setAttribute(("lista"+nombre),lista);
						System.out.print("entre");
						numero ++;
						
					}
					else {
						nombre=numero.toString();
						ArrayList<Productos> listaError = new ArrayList();
						Productos productoError = new Productos();
						productoError.setNombre_producto("No se encontró el producto buscado");
						producto1.setCodigo_producto(0000000);
						request.setAttribute(("lista"+nombre), listaError);
						numero ++;
					}
				}
			}catch(IOException | ParseException | org.json.simple.parser.ParseException e) {e.printStackTrace();}
		}
		String paginaMatch = "/ventas.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
		dispatcher.forward(request, response);
		
		
		
	}
	public void calcularGuardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, org.json.simple.parser.ParseException{
		String codigo1=request.getParameter("codigo_producto_1");
		String nombre1=request.getParameter("nombre_1");
		double valor1 = Double.parseDouble(request.getParameter("valor_1"));
		double valoriva1= Double.parseDouble(request.getParameter("valor_iva_1"));
		Integer cantidad1= Integer.parseInt(request.getParameter("cantidad_1"));
		
		double valorTotal1= valor1*cantidad1;
		double totalVenta1=valoriva1*cantidad1;
		
		String codigo2=request.getParameter("codigo_producto_2");
		String nombre2=request.getParameter("nombre_2");
		double valor2 = Double.parseDouble(request.getParameter("valor_2"));
		double valoriva2= Double.parseDouble(request.getParameter("valor_iva_2"));
		Integer cantidad2= Integer.parseInt(request.getParameter("cantidad_2"));
		
		
		double valorTotal2= valor2*cantidad2;
		double totalVenta2=valoriva2*cantidad2;
		
		String codigo3=request.getParameter("codigo_producto_3");
		String nombre3=request.getParameter("nombre_3");
		double valor3 = Double.parseDouble(request.getParameter("valor_3"));
		double valoriva3= Double.parseDouble(request.getParameter("valor_iva_3"));
		Integer cantidad3= Integer.parseInt(request.getParameter("cantidad_3"));
		
		
		double valorTotal3= valor3*cantidad3;
		double totalVenta3=valoriva3*cantidad3;
		
		
		double valorVenta = valorTotal1+valorTotal2+valorTotal3;
		double totalVenta = totalVenta1+totalVenta2+totalVenta3;
		double totalIVA= totalVenta-valorVenta;
		
		request.setAttribute("codigo1",codigo1);
		request.setAttribute("nombre1",nombre1);
		request.setAttribute("cantidad1",cantidad1);
		request.setAttribute("valortotal1",valorTotal1);
		request.setAttribute("totalventa1",totalVenta1);
		
		request.setAttribute("codigo2",codigo2);
		request.setAttribute("nombre2",nombre2);
		request.setAttribute("cantidad2",cantidad2);
		request.setAttribute("valortotal2",valorTotal2);
		request.setAttribute("totalventa2",totalVenta2);
		
		request.setAttribute("codigo3",codigo3);
		request.setAttribute("nombre3",nombre3);
		request.setAttribute("cantidad3",cantidad3);
		request.setAttribute("valortotal3",valorTotal3);
		request.setAttribute("totalventa3",totalVenta3);
		
		request.setAttribute("valortotalventa", valorVenta);
		request.setAttribute("totalventa", totalVenta);
		request.setAttribute("totaliva", totalIVA);
		
		ArrayList<Ventas> nuymero=VentasJSON.getJSONVentas();
		int codigoventa = nuymero.size() +1;
		
		String paginaMatch = "/ventas_resultado.jsp";
		request.setAttribute("codigoventa", codigoventa);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
		dispatcher.forward(request, response);
		
		Ventas venta = new Ventas();
		  venta.setCedula_cliente(cedula_cliente_actual);
		  venta.setCedula_usuario(cedula_usuario_actual);
		  venta.setCodigo_venta(codigoventa);
		  venta.setIvaventa(totalIVA);
		  venta.setTotal_venta(totalVenta);
		  venta.setValor_venta(valorVenta);
		

		int respuesta = 0;
		try {
			respuesta = VentasJSON.postJSONVentas(venta);
			PrintWriter writer= response.getWriter();
			if(respuesta==200) {
			}
			else {
				writer.println("Se genero un error en el metodo de registrar ventas");
				writer.println("Error: "+ respuesta);
			}
			writer.close();	
		} catch(IOException e) {e.printStackTrace();}
		
		 detalleVentas detalleVenta1 = new detalleVentas();
	
	     detalleVenta1.setCantidad_producto(cantidad1);
	     detalleVenta1.setCodigo_producto(Long.parseLong(codigo1));
	     detalleVenta1.setCodigo_venta(codigoventa);
	     detalleVenta1.setValor_total(valorTotal1);
	     detalleVenta1.setValor_venta(totalVenta1);
	     
	     detalleVentas detalleVenta2 = new detalleVentas();
	 	
	     detalleVenta2.setCantidad_producto(cantidad2);
	     detalleVenta2.setCodigo_producto(Long.parseLong(codigo2));
	     detalleVenta2.setCodigo_venta(codigoventa);
	     detalleVenta2.setValor_total(valorTotal2);
	     detalleVenta2.setValor_venta(totalVenta2);
	     
	     detalleVentas detalleVenta3 = new detalleVentas();
		 	
	     detalleVenta2.setCantidad_producto(cantidad3);
	     detalleVenta2.setCodigo_producto(Long.parseLong(codigo3));
	     detalleVenta2.setCodigo_venta(codigoventa);
	     detalleVenta2.setValor_total(valorTotal3);
	     detalleVenta2.setValor_venta(totalVenta3);
		
	     codigoventa ++;	
	     
	     int respuesta1 = 0;
	     int respuesta2 = 0;
	     int respuesta3 = 0;
			try {
				respuesta1 = detalleVentasJSON.postJSONdetalleVentas(detalleVenta1);
				respuesta2 = detalleVentasJSON.postJSONdetalleVentas(detalleVenta2);
				respuesta3 = detalleVentasJSON.postJSONdetalleVentas(detalleVenta3);
				PrintWriter writer= response.getWriter();
				if(respuesta==200) {
				}
				else {
					writer.println("Se genero un error en el metodo de registrar ventas");
					writer.println("Error: "+ respuesta);
				}
				writer.close();	
			} catch(IOException e) {e.printStackTrace();}
			
	}
	
	public void reportesVentas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int contador = 0;
		try {
			
			ArrayList<Ventas> listaVentas = VentasJSON.getJSONVentas();
			ArrayList<Clientes> cliente = new ArrayList();
			ArrayList<ReporteVentasDTO> lista = new ArrayList();
			if(  listaVentas != null) {
				for( Ventas venta: listaVentas) {
					ReporteVentasDTO reporte = new ReporteVentasDTO();
					cliente = ClientesJSON.buscarJSONClientes(venta.getCedula_cliente());
					reporte.setCedula_cliente(cliente.get(0).getCedula_cliente());
					reporte.setNombre_cliente(cliente.get(0).getNombre_cliente());
					reporte.setValor_venta(venta.getValor_venta());
					contador+=venta.getValor_venta();
					lista.add(reporte);
				}
				
				request.setAttribute("lista", lista);
				request.setAttribute("contador", contador);
				String paginaMatch = "/reportes_ventas.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
			else {
				String mensaje = "No hay ninguna venta registrada";
				String paginaMatch = "/reportes_ventas.jsp";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaMatch);
				dispatcher.forward(request, response);
			}
		} catch (IOException | ParseException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
}	
	
	
	
