/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.service;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Student;
import java.util.List;

/**
 *
 * @author ldieg
 */
public interface IStudentService {
    
    void save(Student student);
    List<Student>getList();
    void delete(int studentId);
    Student getById(int studentId);
    boolean emailExists(String email);
    boolean identificationExists(int identification);

}
