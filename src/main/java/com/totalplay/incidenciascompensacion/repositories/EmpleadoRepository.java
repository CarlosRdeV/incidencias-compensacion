package com.totalplay.incidenciascompensacion.repositories;

import com.totalplay.incidenciascompensacion.entities.Empleado;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
}
