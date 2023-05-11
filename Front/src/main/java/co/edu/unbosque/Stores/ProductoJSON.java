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

import org.json.simple.*;
import org.json.simple.parser.JSONParser;






public class ProductoJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Productos> parsingProductos(String json) throws ParseException, org.json.simple.parser.ParseException {
		 JSONParser parser = new JSONParser();
		 Object obj  = parser.parse(json);
		 JSONArray array = new JSONArray();
		 ArrayList<Productos> lista = new ArrayList<Productos>();
		 array.add(obj);
		 Iterator i = array.iterator();
		 
		 while (i.hasNext()) {
		 JSONObject innerObj = (JSONObject) i.next();
		 Productos producto = new Productos();
		 long codigo = Long.valueOf(innerObj.get("codigo_producto").toString());
	     producto.setCodigo_producto(codigo);
	     double iva = Double.valueOf(innerObj.get("iva_compra").toString());
	     producto.setIva_compra(iva);
	     long nit_proveedor = Long.valueOf(innerObj.get("nit_proveedor").toString());
	     producto.setNitproveedor(nit_proveedor);
	     producto.setNombre_producto(innerObj.get("nombre_producto").toString());
	     double precio_compra = Double.valueOf(innerObj.get("precio_compra").toString());
	     producto.setPrecio_compra(precio_compra);
	     double precio_venta = Double.valueOf(innerObj.get("precio_venta").toString());
	     producto.setPrecio_venta(precio_venta);

		 lista.add(producto);
		 }
		 return lista;
		}
	
	
	public static int postJSONProductos(Productos productos) throws IOException {
		url = new URL(sitio+"productos/guardar");
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
		+ "\"codigo_producto\":\""+productos.getCodigo_producto()
		
		+"\",\"iva_compra\": \""+ productos.getIva_compra()
		
		+"\",\"nit_proveedor\": \""+productos.getNitproveedor()
		
		+"\",\"nombre_producto\":\""+ productos.getNombre_producto()
		
		+"\",\"precio_compra\":\""+ productos.getPrecio_compra()
		
		+"\",\"precio_venta\":\""+ productos.getPrecio_venta()
	
		+ "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
public static ArrayList<Productos> buscarJSONProductos(Productos producto) throws IOException, ParseException, org.json.simple.parser.ParseException {
		long codigo = producto.getCodigo_producto();
		url = new URL(sitio+"productos/buscar/"+codigo);
		HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		System.out.println(json);
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		http.disconnect();
		return lista;
		}

}