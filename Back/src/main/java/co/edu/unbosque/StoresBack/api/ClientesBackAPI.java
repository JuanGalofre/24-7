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

import co.edu.unbosque.StoresBack.dao.ClientesDAO;
import co.edu.unbosque.StoresBack.model.Clientes;
@RestController //esta es una clase REST
@RequestMapping("clientes")
public class ClientesBackAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private ClientesDAO clientesDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody Clientes clientes) {
clientesDAO.save(clientes);
}
@GetMapping("/listar")
public List<Clientes> listar(){
return clientesDAO.findAll();
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable(value="id") Long id) {
clientesDAO.deleteById(id);
}
@PutMapping("/actualizar")
public void actualizar(@RequestBody Clientes clientes) {
clientesDAO.save(clientes);
}
@GetMapping("/buscar/{id}")
public Optional<Clientes> buscar(@PathVariable(value="id") Long id){
return clientesDAO.findById(id);
}



}