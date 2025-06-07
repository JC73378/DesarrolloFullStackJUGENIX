package com.Notificaciones.cl.Notificaciones_JGX.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Notificaciones.cl.Notificaciones_JGX.Model.Reportes;
import com.Notificaciones.cl.Notificaciones_JGX.Service.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v2/reportes")
public class ReporteController {

    @Autowired
    private ReportesService reportesService;

  @GetMapping
  public ResponseEntity<List<Reportes>> listar() {
    List<Reportes> reportes = reportesService.findAll();
    if(reportes.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(reportes);
  }

  @PostMapping("/crear")
  public ResponseEntity<Reportes> guardar(@RequestBody Reportes reporte) {
     Reportes reportenuevo= reportesService.saveReporte(reporte);
      return ResponseEntity.status(HttpStatus.CREATED).body(reportenuevo);
}



  @GetMapping("/{id}")
    public ResponseEntity<Reportes> buscar(@PathVariable Integer id) {
      Optional<Reportes> reporteOptional = reportesService.findById(id);
      if (reporteOptional.isPresent()) {
        return ResponseEntity.ok(reporteOptional.get());
      } else {
        return ResponseEntity.notFound().build();
    }
  }


     @PutMapping("/{id}")
        public ResponseEntity<Reportes> actualizar(@PathVariable Integer id, @RequestBody Reportes reporte) {
        Optional<Reportes> reporteOptional = reportesService.findById(id);
          if (reporteOptional.isPresent()) {
        Reportes reporteExistente = reporteOptional.get();
        reporteExistente.setNombre_profesor(reporte.getNombre_profesor());
        reporteExistente.setTipo_notificacion(reporte.getTipo_notificacion());
        reporteExistente.setNivel_urgencia(reporte.getNivel_urgencia());
        reporteExistente.setFecha(reporte.getFecha());
        reporteExistente.setDetalle_notificacion(reporte.getDetalle_notificacion());

        reportesService.saveReporte(reporteExistente);
        return ResponseEntity.ok(reporteExistente);
    } else {
        return ResponseEntity.notFound().build();
    }
}

  @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
      try {
        reportesService.deleteById(id);
        return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}
}