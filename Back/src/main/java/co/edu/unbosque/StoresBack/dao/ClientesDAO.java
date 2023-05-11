package co.edu.unbosque.StoresBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.StoresBack.model.Clientes;


public interface ClientesDAO extends JpaRepository<Clientes, Long>{
}
