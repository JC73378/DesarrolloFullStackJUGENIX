package com.SoporteTecnico.Controller;
import com.SoporteTecnico.Model.TicketSoporte;
import com.SoporteTecnico.Service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/soportetecnico")

public class SoporteController {
    @Autowired
    private SoporteService soporteService;

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketSoporte>> listar() {
        List<TicketSoporte>tickets =soporteService.findAll();
        if(tickets.isEmpty()){
            return ResponseEntity.noContent().build();
    }
        return ResponseEntity.ok(tickets);
         
    }

    @PostMapping("/tickets")
    public ResponseEntity<TicketSoporte> guardar(@RequestBody TicketSoporte ticket) {
        TicketSoporte nuevoTicket = soporteService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }

    @GetMapping("/{id}")
        public ResponseEntity<TicketSoporte> buscar(@PathVariable Integer id) {
        try{
            
            TicketSoporte ticket = soporteService.findById(id);
            if(ticket == null){
                return ResponseEntity.notFound().build();
            }
            // Si el ticket no existe, devolver un error 404
            // Si el ticket existe, devolverlo
            return ResponseEntity.ok(ticket);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketSoporte> actualizar(@PathVariable Integer id, @RequestBody TicketSoporte ticketSoporte) {
        try{
            TicketSoporte tick= soporteService.findById(id);
            tick.setId(id);
            tick.setNombre(ticketSoporte.getNombre());
            tick.setAsunto(ticketSoporte.getAsunto());
            tick.setDescripcion(ticketSoporte.getDescripcion());
            tick.setFechaCreacion(ticketSoporte.getFechaCreacion());
            tick.setFechaResolucion(ticketSoporte.getFechaResolucion());
            tick.setEstado(ticketSoporte.getEstado());
             
            soporteService.saveTicket(tick);
            return ResponseEntity.ok(tick);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            soporteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    

   
}

