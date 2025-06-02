package com.Infraestructura.Infraestructura.Controller;

import com.Infraestructura.Infraestructura.Model.InfraestructuraModel;
import com.Infraestructura.Infraestructura.Service.InfraestructuraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/infraestructuras")
public class InfraestructuraController {

    @Autowired
    private final InfraestructuraService infraestructuraService;

    
    public InfraestructuraController(InfraestructuraService infraestructuraService) {
        this.infraestructuraService = infraestructuraService;
    }

    @GetMapping
    public ResponseEntity<List<InfraestructuraModel>> getAllInfraestructuras() {
        return ResponseEntity.ok(infraestructuraService.getAllInfraestructuras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfraestructuraModel> getInfraestructuraById(@PathVariable Long id) {
        Optional<InfraestructuraModel> infraestructura = infraestructuraService.getInfraestructuraById(id);
        return infraestructura.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<InfraestructuraModel> createInfraestructura(@RequestBody InfraestructuraModel infraestructura) {
        InfraestructuraModel nuevaInfraestructura = infraestructuraService.createInfraestructura(infraestructura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaInfraestructura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfraestructuraModel> updateInfraestructura(@PathVariable Long id, @RequestBody InfraestructuraModel infraestructura) {
        Optional<InfraestructuraModel> infraestructuraExistente = infraestructuraService.getInfraestructuraById(id);
        if (infraestructuraExistente.isPresent()) {
            InfraestructuraModel updatedInfraestructura = infraestructuraService.updateInfraestructura(id, infraestructura);
            return ResponseEntity.ok(updatedInfraestructura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfraestructura(@PathVariable Long id) {
        infraestructuraService.deleteInfraestructura(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/indisponible")
    public ResponseEntity<InfraestructuraModel> setInfraestructuraIndisponible(@PathVariable Long id) {
        Optional<InfraestructuraModel> infraestructura = infraestructuraService.InfraestructuraIndisponible(id);
        return infraestructura.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}