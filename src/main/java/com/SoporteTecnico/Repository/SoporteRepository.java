package com.SoporteTecnico.Repository;
import com.SoporteTecnico.Model.TicketSoporte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface SoporteRepository extends JpaRepository<TicketSoporte, Integer> {
    // permite buscar tickets por id
    
    
    // permite buscar tickets por estado o por fecha de creación
    List<TicketSoporte> findByEstado(String estado);
    List<TicketSoporte> findByFechaCreacionBetween(Date startDate, Date endDate);

}
