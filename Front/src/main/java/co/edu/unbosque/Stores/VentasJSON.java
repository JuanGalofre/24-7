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

public class VentasJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Ventas> parsingVentas(String json) throws ParseException, org.json.simple.parser.ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<Ventas> lista = new ArrayList<Ventas>();
		 JSONArray Ventas = (JSONArray) jsonParser.parse(json);
		 Iterator i = Ventas.iterator();
		 while (i.hasNext()) {
		 JSONObject innerObj = (JSONObject) i.next();
		 Ventas venta = new Ventas();
	     
	     venta.setCedula_cliente(Long.valueOf(innerObj.get("cedula_cliente").toString()));
	     venta.setCedula_usuario(Long.valueOf(innerObj.get("cedula_usuario").toString()));
	     venta.setCodigo_venta(Long.valueOf(innerObj.get("codigo_venta").toString()));
	     venta.setIvaventa(Double.valueOf(innerObj.get("ivaventa").toString()));
	     venta.setTotal_venta(Double.valueOf(innerObj.get("total_venta").toString()));
	     venta.setValor_venta(Double.valueOf(innerObj.get("valor_venta").toString()));
		

		 lista.add(venta);
		 }
		 return lista;
		}
	
	public static ArrayList<Ventas> getJSONVentas() throws IOException, ParseException, org.json.simple.parser.ParseException{
		url = new URL(sitio+"ventas/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
		}
	public static int postJSONVentas(Ventas ventas) throws IOException {
		url = new URL(sitio+"ventas/guardar");
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
		+ "\"cedula_cliente\":\""+ ventas.getCedula_cliente()
		+"\",\"cedula_usuario\": \""+ventas.getCedula_usuario()
		+"\",\"codigo_venta\": \""+ventas.getCodigo_venta()
		+"\",\"ivaventa\":\""+ventas.getIvaventa()
		+"\",\"total_venta\":\""+ventas.getTotal_venta()
		+"\",\"valor_venta\":\""+ventas.getValor_venta()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int putJSONVentas(Ventas ventas) throws IOException {
		url = new URL(sitio+"ventas/actualizar");
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
				+ "\"cedula_cliente\":\""+ ventas.getCedula_cliente()
				+"\",\"cedula_usuario\": \""+ventas.getCedula_usuario()
				+"\",\"codigo_venta\": \""+ventas.getCodigo_venta()
				+"\",\"ivaventa\":\""+ventas.getIvaventa()
				+"\",\"total_venta\":\""+ventas.getTotal_venta()
				+"\",\"valor_venta\":\""+ventas.getValor_venta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int delJSONVentas(Ventas ventas) throws IOException {
		
		long cedula=ventas.getCodigo_venta();
		url = new URL(sitio+"ventas/eliminar/"+cedula);
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
	public static ArrayList<Ventas> buscarJSONVentas(Ventas ventas) throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		long cedula=ventas.getCodigo_venta();
		url = new URL(sitio+"ventas/buscar/"+cedula);
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
		}
}
