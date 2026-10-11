package com.examenT2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examenT2.entity.OrdenCompraOlivaJonathan;

@Repository
public interface OrdenCompraOlivaJonathanRepository extends JpaRepository<OrdenCompraOlivaJonathan, Integer> {
    
    // CORREGIDO: Spring Boot generará automáticamente el ordenamiento descendente por la llave primaria
    List<OrdenCompraOlivaJonathan> findAllByOrderByNroOrdenDesc();
}
