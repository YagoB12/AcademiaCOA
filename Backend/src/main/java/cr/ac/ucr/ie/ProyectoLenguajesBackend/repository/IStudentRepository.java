/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.repository;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ldieg
 */
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    boolean existsByEmail(String email);
    boolean existsByIdentification(int identification);
    
}
