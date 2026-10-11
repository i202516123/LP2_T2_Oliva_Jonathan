package com.examenT2.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity // <-- ESTA ANOTACIÓN ES LA QUE FALTA O TIENE ERROR DE IMPORTACIÓN
@Table(name = "tbl_proveedor")
public class ProveedorOlivaJonathan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    
    @Column(name = "ruc", length = 11, nullable = false)
    private String ruc;
    
    @Column(name = "razon_social", length = 50, nullable = false, unique = true)
    private String razonSocial;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
    
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;
    
    @Column(name = "pagina_web", length = 100)
    private String paginaWeb;
    
    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private RubroOlivaJonathan rubro;
}
