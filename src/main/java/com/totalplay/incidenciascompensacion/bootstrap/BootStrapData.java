package com.totalplay.incidenciascompensacion.bootstrap;

import com.totalplay.incidenciascompensacion.entities.Empleado;
import com.totalplay.incidenciascompensacion.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData  implements CommandLineRunner {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        empleadoRepository.deleteAll();

        if(empleadoRepository.count() == 0) {
            loadEmpleadoData();
        }
    }

    private void loadEmpleadoData() {
        Empleado empleado = Empleado.builder()
                .nombre("Carlos Rivera")
                .puesto("Lider Tecnico")
                .fechaIngreso(LocalDateTime.now().minusYears(2))
                .fechaUltimoIncremento(LocalDateTime.now().minusMonths(8))
                .salarioActual(new BigDecimal("10000.99"))
                .jefeDirecto("Juan Carlos SL")
                .build();


        empleadoRepository.saveAll(Arrays.asList(empleado));
    }


}
