package com.Backend.TiendaOnline.Controladores;


import com.Backend.TiendaOnline.Entidades.Productos;
import com.Backend.TiendaOnline.Repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {
    @Autowired
    ProductoRepository productoRepository;

    /////////////// CREACIÓN DE SERVICIOS /////////////

     ///// GET
    @GetMapping("/productos")
    public List <Productos> productos(){
      //  List <Autor> autores = autorRepository.findAll();
        return productoRepository.findAll();
    }

    @GetMapping("/productos/{id}")
    public Optional<Productos> getProductosById(@PathVariable Integer id) {
        return productoRepository.findById(id);
    }

    //// POST
    @PostMapping("/productos")
    public Productos crear(@RequestBody Productos productos){
        return productoRepository.save(productos);
    }

    //////  DELETE
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Boolean> eliminarProductos(@PathVariable int id){
        Optional <Productos> productos = productoRepository.findById(id);
        productoRepository.delete(productos.get());
        return ResponseEntity.ok(true);
    }

    /////// PUT
    @PutMapping("/productos/{id}")
    public  ResponseEntity <Productos> actualizarProductos(@PathVariable int id, @RequestBody Productos productosData){
        Optional <Productos> opcionalProductos = productoRepository.findById(id);

        Productos productos = opcionalProductos.get();
        //actualizar
        productos.setCodigo(productosData.getCodigo());
        productos.setNombre(productosData.getNombre());
        productos.setMarca(productosData.getMarca());
        productos.setPrecio(productosData.getPrecio());
        productos.setColor(productosData.getColor());
        productos.setDescripcion(productosData.getDescripcion());
        productos.setImagen(productosData.getImagen());

        Productos productosGuardado = productoRepository.save(productos);
        return ResponseEntity.ok(productosGuardado);

    }
}
