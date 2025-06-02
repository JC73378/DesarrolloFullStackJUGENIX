package com.Horario_Jugenix.Horario.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.Horario_Jugenix.Horario.Repository.HorarioRepository;
import com.Horario_Jugenix.Horario.Model.Horario;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

   public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    public Horario saveHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Optional<Horario> findById(Long id) {
        return horarioRepository.findById(id);
    }

    public void deleteById(Integer id) {
        horarioRepository.deleteById(id);
    }

}
