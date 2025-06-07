package com.Notificaciones.cl.Notificaciones_JGX;
import com.Notificaciones.cl.Notificaciones_JGX.Model.Reportes;
import com.Notificaciones.cl.Notificaciones_JGX.Repository.NotificacionRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GeneradorReportes {

    public static void main(String[] args) {
        SpringApplication.run(NotificacionesJgxApplication.class, args);
    }

    // Este bean se ejecutará después de que la aplicación Spring Boot se haya iniciado completamente
    @Bean
    public CommandLineRunner demoData(  NotificacionRepository notificacionRepository) {
        return args -> {
            Faker faker = new Faker();
            Random random = new Random();

            String[] tiposNotificacion = {
                    "Horario de Clases",
                    "Entrega de Proyecto",
                    "Mantenimiento",
                    "Taller",
                    "Evento Académico",
                    "Reunión Interna",
                    "Suspensión de Clases",
                    "Cierre de Inscripción",
                    "Estado de Sala",
                    "Reserva de Sala",
                    "Incidencia Técnica"
            };
       String[] detallesNotificacion = {
                "Se ha publicado la actualización del horario de todas las asignaturas para el próximo semestre. Favor de revisar en la plataforma.",
                "Recordatorio: La fecha límite para la entrega del proyecto final de Desarrollo de Software es el 25 de junio a las 23:59 hrs.",
                "Aviso de mantenimiento preventivo en los servidores del campus principal. Posibles interrupciones de servicio entre las 02:00 y 05:00 AM.",
                "Inscripciones abiertas para el 'Taller intensivo de Ciberseguridad: Fundamentos y Práctica'. ¡Cupos limitados!",
                "Invitación a la 'Charla Magistral sobre Inteligencia Artificial en la Industria 4.0' este viernes a las 10:00 AM en el Auditorio Central.",
                "Convocatoria a reunión de coordinación de equipo para discutir los avances del proyecto JUGENIX el lunes a las 14:00 hrs en Sala 305.",
                "Comunicado oficial: Suspensión de todas las actividades académicas presenciales para el día 10 de junio debido a alerta ambiental.",
                "Último día para el proceso de inscripción a cursos de nivelación de matemáticas. El sistema cerrará a las 17:00 hrs.",
                "La sala de estudio B-102 está ahora disponible para reservas después de completar su sanitización.",
                "Confirmación de su reserva para la sala de reuniones D-201 el 5 de julio de 10:00 a 12:00 hrs. Código de acceso enviado por correo.",
                "Incidencia reportada: Problemas de conexión a la red cableada en la biblioteca del primer piso. Equipo técnico en camino."
            };

            String[] nivelesUrgencia = {"ALTO", "MEDIO", "BAJO"};

           
            System.out.println("Generando y guardando 10 reportes aleatorios...");
            for (int i = 0; i < 10; i++) {
                Reportes reporte = new Reportes();
                // Genera un índice aleatorio que será usado para ambos arrays: tiposNotificacion y detallesNotificacion
                int randomIndex = random.nextInt(tiposNotificacion.length); 

                reporte.setNombre_profesor(faker.name().fullName());
                // Asigna el tipo de notificación usando el índice aleatorio
                reporte.setTipo_notificacion(tiposNotificacion[randomIndex]);
                // Asigna el detalle de notificación usando el MISMO índice aleatorio para que sea coherente
                reporte.setDetalle_notificacion(detallesNotificacion[randomIndex]);
                
                reporte.setNivel_urgencia(nivelesUrgencia[random.nextInt(nivelesUrgencia.length)]);
                reporte.setFecha(faker.date().past(365, TimeUnit.DAYS)
                                       .toInstant()
                                       .atZone(ZoneId.systemDefault())
                                       .toLocalDate());

        notificacionRepository.save(reporte); // Guarda el reporte en la base de datos
            }
            System.out.println("10 reportes aleatorios guardados exitosamente.");
        };
    }
}