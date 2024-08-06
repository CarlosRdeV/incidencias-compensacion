package com.totalplay.incidenciascompensacion.repositories;

import com.totalplay.incidenciascompensacion.entities.TipoPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoPeriodoRepository extends JpaRepository<TipoPeriodo, UUID> {
}

