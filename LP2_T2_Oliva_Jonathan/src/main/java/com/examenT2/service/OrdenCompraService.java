package com.examenT2.service;

import java.util.List;
import com.examenT2.entity.OrdenCompraOlivaJonathan;
import com.examenT2.entity.ProveedorOlivaJonathan;

public interface OrdenCompraService {
    List<OrdenCompraOlivaJonathan> listarOrdenes();
    List<ProveedorOlivaJonathan> listarProveedores();
    void guardar(OrdenCompraOlivaJonathan orden);
    OrdenCompraOlivaJonathan buscarPorId(Integer id);
}
