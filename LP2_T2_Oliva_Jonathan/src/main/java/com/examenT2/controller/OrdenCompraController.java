package com.examenT2.controller;

// IMPORTACIONES CORREGIDAS
import com.examenT2.entity.OrdenCompraOlivaJonathan;
import com.examenT2.service.OrdenCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenService;

    // 1. LISTADO (Muestra todas las órdenes)
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("ordenes", ordenService.listarOrdenes());
        return "listadoOlivaJonathan";
    }

    // 2. REGISTRO - MOSTRAR FORMULARIO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("ordenCompra", new OrdenCompraOlivaJonathan());
        model.addAttribute("proveedores", ordenService.listarProveedores());
        return "nuevoOlivaJonathan";
    }

    // 2. REGISTRO - PROCESAR Y GUARDAR
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("ordenCompra") OrdenCompraOlivaJonathan orden, RedirectAttributes flash) {
        ordenService.guardar(orden);
        // Mostrar mensaje exacto solicitado por la rúbrica
        flash.addFlashAttribute("success", "Orden de compra Nro. " + orden.getNroOrden() + " registrada.");
        return "redirect:/ordenes/listar";
    }

    // 3. EDICIÓN - CARGAR DATOS EN FORMULARIO
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ordenCompra", ordenService.buscarPorId(id));
        model.addAttribute("proveedores", ordenService.listarProveedores());
        return "edicionOlivaJonathan";
    }

    // 3. EDICIÓN - PROCESAR ACTUALIZACIÓN
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("ordenCompra") OrdenCompraOlivaJonathan orden, RedirectAttributes flash) {
        ordenService.guardar(orden);
        // Mostrar mensaje exacto solicitado por la rúbrica
        flash.addFlashAttribute("success", "Orden de compra Nro. " + orden.getNroOrden() + " actualizada.");
        return "redirect:/ordenes/listar";
    }
}
