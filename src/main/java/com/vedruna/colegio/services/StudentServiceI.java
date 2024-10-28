package com.vedruna.colegio.services;

import java.util.List;

import com.vedruna.colegio.dto.StudentAllInfo;
import com.vedruna.colegio.dto.StudentDTO;
import com.vedruna.colegio.dto.StudentInfoDTO;

public interface StudentServiceI {
    
    //Aqui crearemos todos los metodos necesarios para manejar la información del Alumno
    /*
    1. Consultar todos los alumnos (No debe verse su información de contacto)
    2. Consultar un solo alumno (No debe verse su información de contacto)
    3. Consultar los datos de contacto de un alumno (Debe verse el id del alumno)
    4. Crear nuevo alumno (Debe insertarse junto a él su información de contacto)
    5. Borrar alumno (Debe borrarse su información de contacto)
    */

    //Funcion para obtener todos los Alumnos
    List<StudentDTO> showAllStudent();

    //Funcion para obtener un alumno por su id
    StudentDTO showStudentById(Integer id);

    //Funcion para obtener los datos de contacto de un Alumno
    StudentInfoDTO showStudentInfoById(Integer id);

    //Funcion para añadir un Alumno y su informacion de contacto
    void addStudent(StudentAllInfo studentAllInfo);

    //Funcion para borrar un Alumno
    void deleteStudent(Integer id);
}
