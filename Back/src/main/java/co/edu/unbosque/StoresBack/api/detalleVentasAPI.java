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

import co.edu.unbosque.StoresBack.dao.detalleVentasDAO;
import co.edu.unbosque.StoresBack.model.detalleVentas;
@RestController //esta es una clase REST
@RequestMapping("detalleVentas")
public class detalleVentasAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private detalleVentasDAO detalleVentasDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody detalleVentas detalleVenta) {
	detalleVentasDAO.save(detalleVenta);
}
@GetMapping("/listar")
public List<detalleVentas> listar(){
return detalleVentasDAO.findAll();
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable(value="id") Long id) {
	detalleVentasDAO.deleteById(id);
}
@PutMapping("/actualizar")
public void actualizar(@RequestBody detalleVentas detalleVenta) {
	detalleVentasDAO.save(detalleVenta);
}
@GetMapping("/buscar/{id}")
public Optional<detalleVentas> buscar(@PathVariable(value="id") Long id){
return detalleVentasDAO.findById(id);
}



}