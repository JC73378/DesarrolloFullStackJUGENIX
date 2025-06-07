package com.Mantenimiento.Mantenimiento.Service;

import com.Mantenimiento.Mantenimiento.Model.MantenimientoModel;
import com.Mantenimiento.Mantenimiento.Repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired; //  Inyección de dependencias
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  Indica que esta clase es un servicio
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;

    @Autowired //  Inyecta la dependencia del repositorio
    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public List<MantenimientoModel> getAllMantenimientos() {
        return mantenimientoRepository.findAll();
    }

    public Optional<MantenimientoModel> getMantenimientoById(Long id) {
        return mantenimientoRepository.findById(id);
    }

    public MantenimientoModel createMantenimiento(MantenimientoModel mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    public MantenimientoModel updateMantenimiento(Long id, MantenimientoModel mantenimiento) {
        mantenimiento.setId(id);
        return mantenimientoRepository.save(mantenimiento);
    }

    public void deleteMantenimiento(Long id) {
        mantenimientoRepository.deleteById(id);
    }

    public Optional<MantenimientoModel> setMantenimientoCompletado(Long id) {
        Optional<MantenimientoModel> mantenimientoOptional = mantenimientoRepository.findById(id);
        if (mantenimientoOptional.isPresent()) {
            MantenimientoModel mantenimiento = mantenimientoOptional.get();
            mantenimiento.setCompletado(true);
            return Optional.of(mantenimientoRepository.save(mantenimiento));
        }
        return Optional.empty();
    }
}