package co.edu.unbosque.StoresBack.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuarios {
@Id
private long cedula_usuario;
private String nombre_usuario;
private String email_usuario;
private String clave_usuario;



public long getCedula_usuario() {
	return cedula_usuario;
}
public void setCedula_usuario(long cedula_usuario) {
	this.cedula_usuario = cedula_usuario;
}
public String getNombre_usuario() {
	return nombre_usuario;
}
public void setNombre_usuario(String nombre_usuario) {
	this.nombre_usuario = nombre_usuario;
}
public String getEmail_usuario() {
	return email_usuario;
}
public void setEmail_usuario(String email_usuario) {
	this.email_usuario = email_usuario;
}
public String getClave_usuario() {
	return clave_usuario;
}
public void setClave_usuario(String clave_usuario) {
	this.clave_usuario = clave_usuario;
}



}