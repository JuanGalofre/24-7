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

import co.edu.unbosque.StoresBack.dao.ProveedoresDAO;
import co.edu.unbosque.StoresBack.model.Proveedores;
@RestController //esta es una clase REST
@RequestMapping("proveedores")
public class ProveedoresBackAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private ProveedoresDAO ProveedoresDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody Proveedores proveedores) {
ProveedoresDAO.save(proveedores);
}
@GetMapping("/listar")
public List<Proveedores> listar(){
return ProveedoresDAO.findAll();
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable(value="id") Long id) {
ProveedoresDAO.deleteById(id);
}
@PutMapping("/actualizar")
public void actualizar(@RequestBody Proveedores Proveedores) {
ProveedoresDAO.save(Proveedores);
}
@GetMapping("/buscar/{id}")
public Optional<Proveedores> buscar(@PathVariable(value="id") Long id){
return ProveedoresDAO.findById(id);
}



}