package com.Infraestructura.Infraestructura.Service;

import com.Infraestructura.Infraestructura.Model.InfraestructuraModel;
import com.Infraestructura.Infraestructura.Repository.InfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfraestructuraService {

    @Autowired
    private final InfraestructuraRepository infraestructuraRepository;

    
    public InfraestructuraService(InfraestructuraRepository infraestructuraRepository) {
        this.infraestructuraRepository = infraestructuraRepository;
    }

    public List<InfraestructuraModel> getAllInfraestructuras() {
        return infraestructuraRepository.findAll();
    }

    public Optional<InfraestructuraModel> getInfraestructuraById(Long id) {
        return infraestructuraRepository.findById(id);
    }

    public InfraestructuraModel createInfraestructura(InfraestructuraModel infraestructura) {
        return infraestructuraRepository.save(infraestructura);
    }

    public InfraestructuraModel updateInfraestructura(Long id, InfraestructuraModel infraestructura) {
        infraestructura.setId(id);
        return infraestructuraRepository.save(infraestructura);
    }

    public void deleteInfraestructura(Long id) {
        infraestructuraRepository.deleteById(id);
    }

    public Optional<InfraestructuraModel> InfraestructuraIndisponible(Long id) {
        Optional<InfraestructuraModel> infraestructuraOptional = infraestructuraRepository.findById(id);
        if (infraestructuraOptional.isPresent()) {
            InfraestructuraModel infraestructura = infraestructuraOptional.get();
            infraestructura.setDisponible(false);
            return Optional.of(infraestructuraRepository.save(infraestructura));
        }
        return Optional.empty();
    }

}