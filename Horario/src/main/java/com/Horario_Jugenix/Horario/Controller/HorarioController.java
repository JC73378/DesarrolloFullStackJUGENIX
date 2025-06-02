package com.Horario_Jugenix.Horario.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Horario_Jugenix.Horario.Service.HorarioService;
import com.Horario_Jugenix.Horario.Model.Horario;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public ResponseEntity<List<Horario>> getAllHorarios() {
        List<Horario> horarios = horarioService.findAll();
        if (horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
    }

    @PostMapping
    public ResponseEntity<Horario> createHorario(@RequestBody Horario horario) {
        Horario savedHorario = horarioService.saveHorario(horario);
        return ResponseEntity.status(201).body(savedHorario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable Long id) {
        return horarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Integer id) {
        horarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Long id, @RequestBody Horario horario) {
        return horarioService.findById(id)
                .map(existingHorario -> {
                    existingHorario.setHoraInicio(horario.getHoraInicio());
                    existingHorario.setHoraFin(horario.getHoraFin());
                    existingHorario.setDia(horario.getDia());
                    existingHorario.setIdUsuario(horario.getIdUsuario());
                    existingHorario.setCodigoSala(horario.getCodigoSala());
                    Horario updatedHorario = horarioService.saveHorario(existingHorario);
                    return ResponseEntity.ok(updatedHorario);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
