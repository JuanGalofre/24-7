package co.edu.unbosque.StoresBack.api;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.StoresBack.dao.ProductosDAO;
import co.edu.unbosque.StoresBack.model.Productos;
@RestController //esta es una clase REST
@RequestMapping("productos")
public class ProductosBackAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private ProductosDAO productosDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody Productos productos) {

	productosDAO.save(productos);
	
}
@GetMapping("/listar")
public List<Productos> listar(){
return productosDAO.findAll();
}
@GetMapping("/buscar/{id}")
public Optional<Productos> buscar(@PathVariable(value="id") Long id){
return productosDAO.findById(id);
}



}