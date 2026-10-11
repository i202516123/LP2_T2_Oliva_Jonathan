package com.examenT2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_rubro")
public class RubroOlivaJonathan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro")
    private Integer idRubro;
    
    @Column(name = "denominacion", length = 50, nullable = false)
    private String denominacion;
}
