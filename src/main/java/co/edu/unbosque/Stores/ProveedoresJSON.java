package co.edu.unbosque.Stores;

import co.edu.unbosque.Stores.Proveedores;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;





public class ProveedoresJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Proveedores> parsingProveedores(String json) throws ParseException, org.json.simple.parser.ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		 JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		 Iterator i = proveedores.iterator();
		 while (i.hasNext()) {
		 JSONObject innerObj = (JSONObject) i.next();
		 Proveedores proveedores1 = new Proveedores();
		 long Nit_Proveedor = Long.valueOf(innerObj.get("nit_proveedor").toString());
		 proveedores1.setNitproveedor(Nit_Proveedor);
		 proveedores1.setCiudad_proveedor(innerObj.get("ciudad_proveedor").toString());
		 proveedores1.setTelefono_proveedor(innerObj.get("telefono_proveedor").toString());
		 proveedores1.setNombre_proveedor(innerObj.get("nombre_proveedor").toString());
		 lista.add(proveedores1);
		 }
		 return lista;
		}
	
	public static ArrayList<Proveedores> getJSONProveedores() throws IOException, ParseException, org.json.simple.parser.ParseException{
		url = new URL(sitio+"proveedores/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
		}
	public static int postJSONProveedores(Proveedores proveedores) throws IOException {
		url = new URL(sitio+"proveedores/guardar");
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
		+ "\"nit_proveedor\":\""+proveedores.getNitproveedor()
		
		+"\",\"ciudad_proveedor\": \""+ proveedores.getCiudad_proveedor()
		
		+"\",\"nombre_proveedor\": \""+proveedores.getNombre_proveedor()
		
		+"\",\"telefono_proveedor\":\""+ proveedores.getTelefono_proveedor()
	
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int putJSONProveedores(Proveedores proveedores) throws IOException {
		url = new URL(sitio+"proveedores/actualizar");
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
				+ "\"nit_proveedor\":\""+proveedores.getNitproveedor()
				
				+"\",\"ciudad_proveedor\": \""+ proveedores.getCiudad_proveedor()
				
				+"\",\"nombre_proveedor\": \""+proveedores.getNombre_proveedor()
				
				+"\",\"telefono_proveedor\":\""+ proveedores.getTelefono_proveedor()
			
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int delJSONProveedores(Proveedores proveedores)throws IOException {
		
		long Nit =proveedores.getNitproveedor();
		url = new URL(sitio+"proveedores/eliminar/"+Nit);
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
	public static ArrayList<Proveedores> buscarJSONProveedores(Proveedores proveedores) throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		long Nit =proveedores.getNitproveedor();
		url = new URL(sitio+"proveedores/buscar/"+Nit);
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
		}
}
	
