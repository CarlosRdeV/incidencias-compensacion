package com.totalplay.incidenciascompensacion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(generator = "StringSequenceIdGenerator")
    @GenericGenerator(
            name = "StringSequenceIdGenerator",
            strategy = "com.totalplay.incidenciascompensacion.entities.StringSequenceIdGenerator"
    )
    @Column(length = 8, nullable = false, updatable = false)
    private String id;


    @NotBlank
    @NotNull
    @Size(max = 255)
    @Column(length = 255, nullable = false)
    private String nombre;

    @NotBlank
    @NotNull
    @Size(max = 255)
    @Column(length = 255, nullable = false)
    private String puesto;

    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaUltimoIncremento;

    @NotNull
    @Positive
    private BigDecimal salarioActual;

    @Size(max = 255)
    @Column(length = 255, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private String jefeDirecto;
}
