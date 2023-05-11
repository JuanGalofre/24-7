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

import co.edu.unbosque.StoresBack.dao.VentasDAO;
import co.edu.unbosque.StoresBack.model.Ventas;
@RestController //esta es una clase REST
@RequestMapping("ventas")
public class VentasBackAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private VentasDAO ventasDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody Ventas ventas) {
	ventasDAO.save(ventas);
}
@GetMapping("/listar")
public List<Ventas> listar(){
return ventasDAO.findAll();
}
@GetMapping("/buscar/{id}")
public Optional<Ventas> buscar(@PathVariable(value="id") Long id){
return ventasDAO.findById(id);
}



}