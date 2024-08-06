package com.totalplay.incidenciascompensacion.bootstrap;

import com.totalplay.incidenciascompensacion.entities.Empleado;
import com.totalplay.incidenciascompensacion.entities.Estatus;
import com.totalplay.incidenciascompensacion.entities.Puesto;
import com.totalplay.incidenciascompensacion.repositories.EmpleadoRepository;
import com.totalplay.incidenciascompensacion.repositories.EstatusRepository;
import com.totalplay.incidenciascompensacion.repositories.PuestoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData  implements CommandLineRunner {

    private final EmpleadoRepository empleadoRepository;

    private final PuestoRepository puestoRepository;

    private final EstatusRepository estatusRepository;

    @Override
    public void run(String... args) throws Exception {
        //empleadoRepository.deleteAll();
        if(estatusRepository.count() == 0) {
            loadEstatusData();
        }

        if(puestoRepository.count() == 0) {
            loadPuestoData();
        }

        if(empleadoRepository.count() == 0) {
            loadEmpleadoData();
        }
    }

    private void loadEstatusData() {
        log.debug("BootStrapData -> loadEstatusData");
        Estatus e1 = Estatus.builder()
                .descripcion("PENDIENTE POR APROBAR")
                .build();

        Estatus e2 = Estatus.builder()
                .descripcion("EN PROCESO DE APROBACION")
                .build();

        Estatus e3 = Estatus.builder()
                .descripcion("APROBADOS")
                .build();

        Estatus e4 = Estatus.builder()
                .descripcion("RECHAZADOS")
                .build();

        Estatus e5 = Estatus.builder()
                .descripcion("LIBERADO")
                .build();

        estatusRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
    }

    private void loadPuestoData() {
        log.debug("BootStrapData -> loadPuestoData");
        Puesto p1 = Puesto.builder()
                .nombre("CTO")
                .build();

        Puesto p2 = Puesto.builder()
                .nombre("Director de Producto")
                .build();

        Puesto p3 = Puesto.builder()
                .nombre("Gerente de Proyecto")
                .build();

        Puesto p4 = Puesto.builder()
                .nombre("Scrum Master")
                .build();

        Puesto p5 = Puesto.builder()
                .nombre("Arquitecto de Software")
                .build();

        Puesto p6 = Puesto.builder()
                .nombre("Líder Técnico")
                .build();

        Puesto p7 = Puesto.builder()
                .nombre("Desarrollador Full-Stack")
                .build();

        Puesto p8 = Puesto.builder()
                .nombre("Desarrollador Front-end")
                .build();

        Puesto p9 = Puesto.builder()
                .nombre("Desarrollador Back-end")
                .build();

        Puesto p10 = Puesto.builder()
                .nombre("Desarrollador Junior")
                .build();

        puestoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
    }

    private void loadEmpleadoData() {
        log.debug("BootStrapData -> loadEmpleadoData");

        List<Puesto> puestoList = puestoRepository.findAll();
        Puesto p1 = puestoList.getFirst();

        Empleado empleado = Empleado.builder()
                .nombre("Carlos Rivera")
                .id_puesto(p1.getId())
                .fechaIngreso(LocalDateTime.now().minusYears(2))
                .fechaUltimoIncremento(LocalDateTime.now().minusMonths(8))
                .salarioActual(new BigDecimal("10000.99"))
                .jefeDirecto("Juan Carlos SL")
                .build();

        empleadoRepository.saveAll(Arrays.asList(empleado));
    }


}
