package com.vedruna.colegio.persistance.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="alumnos")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idalumno")
    private Integer id;
    
    @Column(name="nombre")
    private String name;

    @Column(name="apellidos")
    private String lastName;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentInfo studentInfo;

}
