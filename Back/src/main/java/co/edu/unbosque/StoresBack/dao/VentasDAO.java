package co.edu.unbosque.StoresBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.StoresBack.model.Ventas;


public interface VentasDAO extends JpaRepository<Ventas, Long>{
}
