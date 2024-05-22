package com.Backend.TiendaOnline.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@Validated
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String codigo;
    private String nombre;
    private String marca;
    private Integer precio;
    private String color;
    private String descripcion;
    @Column(length = 800000) // Ajusta la longitud según tus necesidades
    private String imagen;

}
