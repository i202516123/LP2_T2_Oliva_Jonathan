package com.examenT2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examenT2.entity.OrdenCompraOlivaJonathan;
import com.examenT2.entity.ProveedorOlivaJonathan;
import com.examenT2.repository.OrdenCompraOlivaJonathanRepository;
import com.examenT2.repository.ProveedorOlivaJonathanRepository;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraOlivaJonathanRepository ordenRepo;

    @Autowired
    private ProveedorOlivaJonathanRepository proveedorRepo;

    @Override
    public List<OrdenCompraOlivaJonathan> listarOrdenes() {
        return ordenRepo.findAllByOrderByNroOrdenDesc(); // Llama al método corregido
    }

    @Override
    public List<ProveedorOlivaJonathan> listarProveedores() {
        return proveedorRepo.findAll();
    }

    @Override
    public void guardar(OrdenCompraOlivaJonathan orden) {
        ordenRepo.save(orden);
    }

    @Override
    public OrdenCompraOlivaJonathan buscarPorId(Integer id) {
        return ordenRepo.findById(id).orElse(null);
    }
}
