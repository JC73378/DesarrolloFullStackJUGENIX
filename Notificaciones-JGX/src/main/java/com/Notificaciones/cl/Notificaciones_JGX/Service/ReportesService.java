package com.Notificaciones.cl.Notificaciones_JGX.Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.Notificaciones.cl.Notificaciones_JGX.Model.Reportes;
import com.Notificaciones.cl.Notificaciones_JGX.Repository.NotificacionRepository;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ReportesService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Reportes> findAll() {
        return notificacionRepository.findAll();
    }
    public Optional<Reportes> findById(int id) {
        return notificacionRepository.findById(id);
    }

    public Reportes saveReporte(Reportes reporte) {
        return notificacionRepository.save(reporte);
    }

    public void deleteById(Integer id) {
      notificacionRepository.deleteById(id);
    }

}
