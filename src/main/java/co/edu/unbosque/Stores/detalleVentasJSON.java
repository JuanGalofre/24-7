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





public class detalleVentasJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<detalleVentas> parsingdetalleVentas(String json) throws ParseException, org.json.simple.parser.ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<detalleVentas> lista = new ArrayList<detalleVentas>();
		 JSONArray detalleVentas = (JSONArray) jsonParser.parse(json);
		 Iterator i = detalleVentas.iterator();
		 while (i.hasNext()) {
		 JSONObject innerObj = (JSONObject) i.next();
		 detalleVentas detalleVenta = new detalleVentas();
		 long codigo_producto = Long.valueOf(innerObj.get("codigo_producto").toString());
		 long codigo_venta = Long.valueOf(innerObj.get("codigo_venta").toString());
		 Integer cantidad_producto= Integer.valueOf(innerObj.get("cantidad_producto").toString());
		 double valor_total = Double.valueOf(innerObj.get("valor_total").toString());
		 double valor_venta = Double.valueOf(innerObj.get("valor_venta").toString());

	     detalleVenta.setCantidad_producto(cantidad_producto);
	     detalleVenta.setCodigo_producto(codigo_producto);
	     detalleVenta.setCodigo_venta(codigo_venta);
	
	     detalleVenta.setValor_total(valor_total);
	     detalleVenta.setValor_venta(valor_venta);
		 
		 lista.add(detalleVenta);
		 }
		 return lista;
		}
	
	public static ArrayList<detalleVentas> getJSONdetalleVentas() throws IOException, ParseException, org.json.simple.parser.ParseException{
		url = new URL(sitio+"detalleVentas/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<detalleVentas> lista = new ArrayList<detalleVentas>();
		lista = parsingdetalleVentas(json);
		http.disconnect();
		return lista;
		}
	public static int postJSONdetalleVentas(detalleVentas detalleVenta) throws IOException {
		url = new URL(sitio+"detalleVentas/guardar");
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
		+ "\"cantidad_producto\":\""+ detalleVenta.getCantidad_producto()
		+"\",\"codigo_producto\": \""+detalleVenta.getCodigo_producto()
		+"\",\"codigo_venta\": \""+detalleVenta.getCodigo_venta()
	
		+"\",\"valor_total\":\""+detalleVenta.getValor_total()
		+"\",\"valor_venta\":\""+detalleVenta.getValor_venta()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int putJSONdetalleVentas(detalleVentas detalleVenta) throws IOException {
		url = new URL(sitio+"detalleVentas/actualizar");
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
				+ "\"cantidad_producto\":\""+ detalleVenta.getCantidad_producto()
				+"\",\"codigo_producto\": \""+detalleVenta.getCodigo_producto()
				+"\",\"codigo_venta\": \""+detalleVenta.getCodigo_venta()
		
				+"\",\"valor_total\":\""+detalleVenta.getValor_total()
				+"\",\"valor_venta\":\""+detalleVenta.getValor_venta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int delJSONdetalleVentas(detalleVentas detalleVenta) throws IOException {
		
		long cedula=detalleVenta.getCodigo_venta();
		url = new URL(sitio+"detalleVentas/eliminar/"+cedula);
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
	public static ArrayList<detalleVentas> buscarJSONUsuarios(detalleVentas detalleVenta) throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		long cedula=detalleVenta.getCodigo_venta();
		url = new URL(sitio+"detalleVentas/buscar/"+cedula);
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<detalleVentas> lista = new ArrayList<detalleVentas>();
		lista = parsingdetalleVentas(json);
		http.disconnect();
		return lista;
		}
}