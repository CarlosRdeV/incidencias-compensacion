package com.totalplay.incidenciascompensacion.repositories;

import com.totalplay.incidenciascompensacion.entities.Estatus;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EstatusRepository extends CrudRepository<Estatus, UUID> {
}
