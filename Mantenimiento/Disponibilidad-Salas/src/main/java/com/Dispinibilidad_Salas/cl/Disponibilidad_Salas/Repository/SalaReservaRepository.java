package com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Repository;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Model.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import java.util.Date;
public interface SalaReservaRepository extends JpaRepository<Salas, Long> {

    Optional<Salas> findByCodigoSala(String codigoSala);
    List<Salas> findByEstadoSala(String estadoSala);
    Optional<Salas> findByCodigoSalaAndFechaReservaAndEstadoSala(String codigoSala, Date fechaReserva, String estadoSala);
    


    // Métodos personalizados para consultas específicas pueden ser añadidos aquí

}
