package com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Service;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Model.Salas;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Repository.SalaReservaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class SalasDataSeeder implements  CommandLineRunner{
    private final SalaReservaRepository salaReservaRepository;

    public SalasDataSeeder(SalaReservaRepository salaReservaRepository) {
        this.salaReservaRepository = salaReservaRepository;
    }

    @Override
    public void run(String... args) {
        if (salaReservaRepository.count() == 0) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                Date fecha1 = formatter.parse("2025-06-01");
                Date fecha2 = formatter.parse("2025-06-15");

                Salas sala1 = new Salas();
                sala1.setNombreReserva("Reunión de proyecto");
                sala1.setCapacidad(12);
                sala1.setCodigoSala("SAL-001");
                sala1.setUbicacion("Edificio A - Piso 1");
                sala1.setFechaReserva(fecha1);
                sala1.setFechaActualizacion(new Date());
                sala1.setEstadoSala("Disponible");

                Salas sala2 = new Salas();
                sala2.setNombreReserva("Arturo Pérez");
                sala2.setCapacidad(20);
                sala2.setCodigoSala("SAL-002");
                sala2.setUbicacion("Edificio B - Piso 2");
                sala2.setFechaReserva(fecha2);
                sala2.setFechaActualizacion(new Date());
                sala2.setEstadoSala("Ocupada");

                List<Salas> salas = Arrays.asList(sala1, sala2);
                salaReservaRepository.saveAll(salas);

                System.out.println(">>> Se insertaron datos predeterminados en la tabla SALAS.");
            } catch (Exception e) {
                System.err.println("Error al insertar datos iniciales: " + e.getMessage());
            }
        }
    }

}
