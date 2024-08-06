package com.totalplay.incidenciascompensacion.repositories;

import com.totalplay.incidenciascompensacion.entities.TipoIncidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoIncidenciaRepository extends JpaRepository<TipoIncidencia, UUID> {
}
