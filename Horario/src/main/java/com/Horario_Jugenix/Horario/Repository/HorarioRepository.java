package com.Horario_Jugenix.Horario.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Horario_Jugenix.Horario.Model.Horario;



@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    Optional<Horario> findById(Long id);
    Optional<Horario> findByIdUsuario(String idUsuario);

    

}
