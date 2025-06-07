package com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Service;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Model.Salas;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Repository.SalaReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;
import java.util.List;


@Service
public class SalaReservaService {

    @Autowired
    private SalaReservaRepository salaReservaRepository;


    public Optional<Salas> obtenerReservaPorCodigo(String codigoSala) {
        return salaReservaRepository.findByCodigoSala(codigoSala);
    }

    public void cancelarReserva(Long id) {
        Optional<Salas> reserva = salaReservaRepository.findById(id);
        if (reserva.isPresent()) {
            Salas sala = reserva.get();
            sala.setEstadoSala("disponible");
            sala.setFechaActualizacion(new Date());
            salaReservaRepository.save(sala);
        } else {
            throw new IllegalStateException("Reserva no encontrada.");
        }
    }

    public void actualizarReserva(Long id, Salas actualizacion) {
        Optional<Salas> reservaExistente = salaReservaRepository.findById(id);
        if (reservaExistente.isPresent()) {
            Salas sala = reservaExistente.get();
            sala.setNombreReserva(actualizacion.getNombreReserva());
            sala.setCapacidad(actualizacion.getCapacidad());
            sala.setCodigoSala(actualizacion.getCodigoSala());
            sala.setUbicacion(actualizacion.getUbicacion());
            sala.setFechaActualizacion(new Date());
            salaReservaRepository.save(sala);
        } else {
            throw new IllegalStateException("Reserva no encontrada.");
        }
    }
    public Optional<List<Salas>> obtenerSalasOcupadas() {
    List<Salas> salas = salaReservaRepository.findByEstadoSala("ocupada");
    return salas.isEmpty() ? Optional.empty() : Optional.of(salas);
}
    public Salas crearReserva(Salas nuevaReserva) {
    // Verifica si ya existe una sala reservada con el mismo código y fecha
    Optional<Salas> salaExistente = salaReservaRepository.findByCodigoSalaAndFechaReservaAndEstadoSala(
        nuevaReserva.getCodigoSala(),
        nuevaReserva.getFechaReserva(),
        "reservada" 
    );

    if (salaExistente.isPresent()) {
        throw new IllegalStateException("La sala ya está reservada para esa fecha.");
    }

    // Si no está reservada, guarda la nueva reserva
    nuevaReserva.setEstadoSala("reservada"); // Asegúrate de marcarla como reservada
    nuevaReserva.setFechaActualizacion(new Date());

    return salaReservaRepository.save(nuevaReserva);
}

public List<Salas> obtenerSalasReservadas() {
    return salaReservaRepository.findByEstadoSala("reservada");
}


}
