package com.vedruna.colegio.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="infocontacto")
public class StudentInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idinfocontacto")
    private Integer id;

    @Column(name="direccion")
    private String address;

    @Column(name="telefono")
    private Integer telephone;

    @OneToOne
    @JoinColumn(name="alumnos_idalumno", referencedColumnName = "idalumno")
    private Student student;
}
