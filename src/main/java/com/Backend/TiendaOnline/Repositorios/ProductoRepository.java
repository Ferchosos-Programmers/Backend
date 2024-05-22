package com.Backend.TiendaOnline.Repositorios;

import com.Backend.TiendaOnline.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Productos, Integer> {
}
