package com.totalplay.incidenciascompensacion.repositories;

import com.totalplay.incidenciascompensacion.entities.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PuestoRepository extends JpaRepository<Puesto, UUID> {
}
