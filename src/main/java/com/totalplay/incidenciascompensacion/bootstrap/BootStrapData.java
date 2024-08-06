package com.totalplay.incidenciascompensacion.bootstrap;

import com.totalplay.incidenciascompensacion.entities.TipoIncidencia;
import com.totalplay.incidenciascompensacion.entities.TipoPeriodo;
import com.totalplay.incidenciascompensacion.repositories.TipoIncidenciaRepository;
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

    private final TipoIncidenciaRepository tipoIncidenciaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (tipoPeriodoRepository.count() == 0) {
            loadTipoPeriodoData();
        }

        if (tipoIncidenciaRepository.count() == 0) {
            loadTipoIncidenciaData();
        }
    }

    private void loadTipoIncidenciaData() {
        log.debug("BootStrapData -> loadTipoIncidenciaData");
        TipoIncidencia tipoIncidencia1 = TipoIncidencia.builder()
                .nombre("Compensacion")
                .activo(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        TipoIncidencia tipoIncidencia2 = TipoIncidencia.builder()
                .nombre("Reembolso")
                .activo(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        TipoIncidencia tipoIncidencia3 = TipoIncidencia.builder()
                .nombre("Faltas mal aplicadas")
                .activo(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        tipoIncidenciaRepository.saveAll(Arrays.asList(tipoIncidencia1, tipoIncidencia2, tipoIncidencia3));
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
