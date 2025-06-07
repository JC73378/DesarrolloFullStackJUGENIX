package com.Mantenimiento.Mantenimiento.Controller;

import com.Mantenimiento.Mantenimiento.Model.MantenimientoModel;
import com.Mantenimiento.Mantenimiento.Service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //  Indica que esta clase es un controlador REST
@RequestMapping("/api/mantenimientos") //  Endpoint principal para los mantenimientos
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @Autowired
    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @GetMapping
    public ResponseEntity<List<MantenimientoModel>> getAllMantenimientos() {
        return ResponseEntity.ok(mantenimientoService.getAllMantenimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoModel> getMantenimientoById(@PathVariable Long id) {
        Optional<MantenimientoModel> mantenimiento = mantenimientoService.getMantenimientoById(id);
        return mantenimiento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MantenimientoModel> createMantenimiento(@RequestBody MantenimientoModel mantenimiento) {
        MantenimientoModel nuevoMantenimiento = mantenimientoService.createMantenimiento(mantenimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMantenimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoModel> updateMantenimiento(@PathVariable Long id, @RequestBody MantenimientoModel mantenimiento) {
        Optional<MantenimientoModel> mantenimientoExistente = mantenimientoService.getMantenimientoById(id);
        if (mantenimientoExistente.isPresent()) {
            MantenimientoModel updatedMantenimiento = mantenimientoService.updateMantenimiento(id, mantenimiento);
            return ResponseEntity.ok(updatedMantenimiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMantenimiento(@PathVariable Long id) {
        mantenimientoService.deleteMantenimiento(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/completado")
    public ResponseEntity<MantenimientoModel> setMantenimientoCompletado(@PathVariable Long id) {
        Optional<MantenimientoModel> mantenimiento = mantenimientoService.setMantenimientoCompletado(id);
        return mantenimiento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}