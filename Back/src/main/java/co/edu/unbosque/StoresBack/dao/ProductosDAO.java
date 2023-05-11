package co.edu.unbosque.StoresBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.StoresBack.model.Productos;


public interface ProductosDAO extends JpaRepository<Productos, Long>{
}
