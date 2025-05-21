package com.SoporteTecnico.Service;
import org.springframework.stereotype.Service;
import com.SoporteTecnico.Repository.SoporteRepository;

import jakarta.transaction.Transactional;

import com.SoporteTecnico.Model.TicketSoporte;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Transactional
@Service
public class SoporteService {
    @Autowired
    private SoporteRepository soporteRepository;

    public List<TicketSoporte> findAll() {
        return soporteRepository.findAll();
    }

    public TicketSoporte findById(Integer id) {
        return soporteRepository.findById(id).orElse(null);
    }


    public TicketSoporte saveTicket(TicketSoporte ticket) {
        return soporteRepository.save(ticket);
    }

    public void deleteById(int id) {
        soporteRepository.deleteById(id);
    }
    

}
