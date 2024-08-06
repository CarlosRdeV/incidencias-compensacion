package com.totalplay.incidenciascompensacion.bootstrap;

import com.totalplay.incidenciascompensacion.entities.TipoPeriodo;
import com.totalplay.incidenciascompensacion.repositories.TipoPeriodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData  implements CommandLineRunner {

    private final TipoPeriodoRepository tipoPeriodoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (tipoPeriodoRepository.count() == 0) {
            loadTipoPeriodoData();
        }
    }

    private void loadTipoPeriodoData() {
        log.debug("BootStrapData -> loadTipoPeriodoData");
        TipoPeriodo tipoPeriodo1 = TipoPeriodo.builder()
                .nombre("Semanal")
                .activo(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        TipoPeriodo tipoPeriodo2 = TipoPeriodo.builder()
                .nombre("Quincenal")
                .activo(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        TipoPeriodo tipoPeriodo3 = TipoPeriodo.builder()
                .nombre("Mensual")
                .activo(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        tipoPeriodoRepository.saveAll(Arrays.asList(tipoPeriodo1, tipoPeriodo2, tipoPeriodo3));
    }
}
