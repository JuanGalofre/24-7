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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;





public class UsuariosJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Usuarios> parsingUsuarios(String json) throws ParseException, org.json.simple.parser.ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		 JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		 Iterator i = usuarios.iterator();
		 while (i.hasNext()) {
		 JSONObject innerObj = (JSONObject) i.next();
		 Usuarios usuario = new Usuarios();
		 long cedula = Long.valueOf(innerObj.get("cedula_usuario").toString());
	     usuario.setCedula_usuario(cedula);
		 usuario.setEmail_usuario(innerObj.get("email_usuario").toString());
		 usuario.setNombre_usuario(innerObj.get("nombre_usuario").toString());
		 usuario.setClave_usuario(innerObj.get("clave_usuario").toString());

		 lista.add(usuario);
		 }
		 return lista;
		}
	
	public static ArrayList<Usuarios> getJSONUsuarios() throws IOException, ParseException, org.json.simple.parser.ParseException{
		url = new URL(sitio+"usuarios/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
		}
	public static int postJSONUsuarios(Usuarios usuario) throws IOException {
		url = new URL(sitio+"usuarios/guardar");
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
		+ "\"cedula_usuario\":\""+ usuario.getCedula_usuario()
		+"\",\"email_usuario\": \""+usuario.getEmail_usuario()
		+"\",\"nombre_usuario\": \""+usuario.getNombre_usuario()
		+"\",\"clave_usuario\":\""+usuario.getClave_usuario()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int putJSONUsuarios(Usuarios usuario) throws IOException {
		url = new URL(sitio+"usuarios/actualizar");
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
		+ "\"cedula_usuario\":\""+ usuario.getCedula_usuario()
		+"\",\"email_usuario\": \""+usuario.getEmail_usuario()
		+"\",\"nombre_usuario\": \""+usuario.getNombre_usuario()
		+"\",\"clave_usuario\":\""+usuario.getClave_usuario()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int delJSONUsuarios(Usuarios usuario) throws IOException {
		
		long cedula=usuario.getCedula_usuario();
		url = new URL(sitio+"usuarios/eliminar/"+cedula);
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
	public static ArrayList<Usuarios> buscarJSONUsuarios(Usuarios usuario) throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		long cedula=usuario.getCedula_usuario();
		url = new URL(sitio+"usuarios/buscar/"+cedula);
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
		}
}
	
	
