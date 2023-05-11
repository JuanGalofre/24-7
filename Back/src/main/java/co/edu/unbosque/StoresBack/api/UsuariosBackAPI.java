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

import co.edu.unbosque.StoresBack.dao.Stores247DAO;
import co.edu.unbosque.StoresBack.model.Usuarios;
@RestController //esta es una clase REST
@RequestMapping("usuarios")
public class UsuariosBackAPI {
@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
private Stores247DAO usuariosDAO;
@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
public void guardar(@RequestBody Usuarios usuarios) {
usuariosDAO.save(usuarios);
}
@GetMapping("/listar")
public List<Usuarios> listar(){
return usuariosDAO.findAll();
}
@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable(value="id") Long id) {
usuariosDAO.deleteById(id);
}
@PutMapping("/actualizar")
public void actualizar(@RequestBody Usuarios usuarios) {
usuariosDAO.save(usuarios);
}
@GetMapping("/buscar/{id}")
public Optional<Usuarios> buscar(@PathVariable(value="id") Long id){
return usuariosDAO.findById(id);
}



}
