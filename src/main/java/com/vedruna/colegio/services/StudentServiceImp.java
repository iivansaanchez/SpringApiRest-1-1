package com.vedruna.colegio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.colegio.dto.StudentAllInfo;
import com.vedruna.colegio.dto.StudentDTO;
import com.vedruna.colegio.dto.StudentInfoDTO;
import com.vedruna.colegio.persistance.models.Student;
import com.vedruna.colegio.persistance.models.StudentInfo;
import com.vedruna.colegio.persistance.repository.StudentInfoRepository;
import com.vedruna.colegio.persistance.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentServiceI{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentInfoRepository studentInfoRepository;


    @Override
    public List<StudentDTO> showAllStudent() {
        //Rescatamos todos los estudiantes
        List<Student> listStudents = studentRepository.findAll();
        //Una vez rescatada creamos una lista de StudentDTO
        List<StudentDTO> listStudentDTOs = new ArrayList<>();
        //Recorremos el array de estudiantes
        for(Student student : listStudents){
            //Por cada estudiante creamos un DTO
            StudentDTO studentDTO = new StudentDTO(student.getName(), student.getLastName());
            //Por último lo añadimos a la lista de DTO
            listStudentDTOs.add(studentDTO);
        }
        return listStudentDTOs;
    }

    @Override
    public StudentDTO showStudentById(Integer id) {
        //Creamos el objeto StudentDTO
        StudentDTO studentDTO = new StudentDTO();
        //Rescatamos el estudiante por su id
        Student student = studentRepository.findById(id).orElse(null);
        //Una vez rescatado si existe lo pasamos a DTO
        if(student!=null){
            studentDTO.setName(student.getName());
            studentDTO.setLastName(student.getLastName());
        }
        return studentDTO;
    }

    @Override
    public StudentInfoDTO showStudentInfoById(Integer id) {
        //Creamos el objeto StudentInfoDTO
        StudentInfoDTO  studentInfoDTO = new StudentInfoDTO();
        //Rescatamos el estudiante por su id
        Student student = studentRepository.findById(id).orElse(null);
        //Extraemos los datos de informacion y los añadimos a un StudentInfoDTO
        if(student!=null){
            studentInfoDTO.setId(student.getId());
            studentInfoDTO.setAddress(student.getStudentInfo().getAddress());
            studentInfoDTO.setTelephone(student.getStudentInfo().getTelephone());
        }

        return studentInfoDTO;
    }

    @Override
    public void addStudent(StudentAllInfo studentAllInfo) {
        //Creamos objeto student e infoStudent
        Student student = new Student();
        //Añadimos nombre y apellido
        student.setName(studentAllInfo.getName());
        student.setLastName(studentAllInfo.getLastName());

        //Creamos un objeto student info donde almacenaremos direccion y telefono
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setAddress(studentAllInfo.getAddress());
        studentInfo.setTelephone(studentAllInfo.getTelephone());

        //Añadimos el studentInfo a student y la inversa
        student.setStudentInfo(studentInfo);
        studentInfo.setStudent(student);

        //Añadimos el student
        studentRepository.save(student);
    }


    @Override
    public void deleteStudent(Integer id) {
        // Rescatamos el alumno
        Student student = studentRepository.findById(id).orElse(null);
        
        // Si el alumno existe, accedemos a su info y la eliminamos
        if (student != null && student.getStudentInfo() != null) {
            // Obtenemos la información de contacto del alumno
            StudentInfo studentInfo = student.getStudentInfo();
            
            // Elimina la información de contacto 
            studentInfoRepository.deleteById(studentInfo.getId());
        }
    } 
}
