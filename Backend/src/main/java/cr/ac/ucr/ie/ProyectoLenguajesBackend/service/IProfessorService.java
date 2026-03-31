/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.service;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Professor;
import java.util.List;

/**
 *
 * @author danie
 */
public interface IProfessorService {
    
    
    void save(Professor professor);
    List<Professor> getList();
    void delete(int professorId);
    Professor getByid(int professorId);
    
}
