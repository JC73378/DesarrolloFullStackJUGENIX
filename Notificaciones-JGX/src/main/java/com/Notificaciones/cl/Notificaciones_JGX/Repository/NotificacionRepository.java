package com.Notificaciones.cl.Notificaciones_JGX.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Notificaciones.cl.Notificaciones_JGX.Model.Reportes;
import java.util.Optional;


@Repository
public interface NotificacionRepository extends JpaRepository<Reportes, Integer> {

    
    
    Optional<Reportes> findById(int id);
    
    
    

}
