package co.edu.unbosque.Stores;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.tomcat.util.json.ParseException;
import org.apache.tomcat.util.log.SystemLogHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;





public class ClientesJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Clientes> parsingClientes(String json) throws ParseException, org.json.simple.parser.ParseException {
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		try {
		JSONParser parser = new JSONParser();
		
		Object obj  = parser.parse(json);
		JSONArray clientes = (JSONArray) obj;
		Iterator i = clientes.iterator();	
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Clientes cliente = new Clientes();
			long cedula = Long.valueOf(innerObj.get("cedula_cliente").toString());
			cliente.setCedula_cliente(cedula);
			cliente.setDireccion_cliente(innerObj.get("direccion_cliente").toString());
			cliente.setEmail_cliente(innerObj.get("email_cliente").toString());
			cliente.setNombre_cliente(innerObj.get("nombre_cliente").toString());
			cliente.setTelefono_cliente(innerObj.get("telefono_cliente").toString());
		 
			lista.add(cliente);
		}
		}
		catch(ClassCastException e) {
			 JSONParser parser = new JSONParser();
			 Object obj  = parser.parse(json);
			 JSONArray array = new JSONArray();
			 array.add(obj);
			 Iterator i = array.iterator();
			 while (i.hasNext()) {
				 JSONObject innerObj = (JSONObject) i.next();
				 Clientes cliente = new Clientes();
				 long cedula = Long.valueOf(innerObj.get("cedula_cliente").toString());
			     cliente.setCedula_cliente(cedula);
			     cliente.setDireccion_cliente(innerObj.get("direccion_cliente").toString());
				 cliente.setEmail_cliente(innerObj.get("email_cliente").toString());
				 cliente.setNombre_cliente(innerObj.get("nombre_cliente").toString());
				 cliente.setTelefono_cliente(innerObj.get("telefono_cliente").toString());
				 
				 lista.add(cliente);
				}
			
			
		}
		
		return lista;
	}
	
	public static ArrayList<Clientes> getJSONClientes() throws IOException, ParseException, org.json.simple.parser.ParseException{
		url = new URL(sitio+"clientes/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
		}
	public static int postJSONClientes(Clientes cliente) throws IOException {
		url = new URL(sitio+"clientes/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"cedula_cliente\":\""+ cliente.getCedula_cliente()
		+"\",\"direccion_cliente\": \""+cliente.getDireccion_cliente()
		+"\",\"email_cliente\": \""+cliente.getEmail_cliente()
		+"\",\"nombre_cliente\": \""+cliente.getNombre_cliente()
		+"\",\"telefono_cliente\":\""+cliente.getTelefono_cliente()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int putJSONClientes(Clientes cliente) throws IOException {
		url = new URL(sitio+"clientes/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
		http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"cedula_cliente\":\""+ cliente.getCedula_cliente()
		+"\",\"direccion_cliente\": \""+cliente.getDireccion_cliente()
		+"\",\"email_cliente\": \""+cliente.getEmail_cliente()
		+"\",\"nombre_cliente\": \""+cliente.getNombre_cliente()
		+"\",\"telefono_cliente\":\""+cliente.getTelefono_cliente()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int delJSONClientes(Clientes cliente) throws IOException {
		
		long cedula=cliente.getCedula_cliente();
		url = new URL(sitio+"clientes/eliminar/"+cedula);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
		http.setRequestMethod("DELETE");
		
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static ArrayList<Clientes> buscarJSONClientes(Long cedula) throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		url = new URL(sitio+"clientes/buscar/"+cedula);
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
		}
}