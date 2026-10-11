package com.examenT2.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_orden_compra")
public class OrdenCompraOlivaJonathan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorOlivaJonathan proveedor;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "direccion_entrega", nullable = false)
    private String direccionEntrega;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    @Column(name = "estado", length = 1)
    private String estado = "P";
}
