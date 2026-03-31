/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.jpa;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Professor;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.repository.IProfessorRepository;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.IProfessorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */

@Service
public class ProfessorServiceJPA implements IProfessorService{
    
    @Autowired
    private IProfessorRepository repo;

    @Override
    public void save(Professor professor) {
        repo.save(professor);
    }

    @Override
    public List<Professor> getList() {
        return repo.findAll();
    }

    @Override
    public void delete(int professorId) {
        repo.deleteById(professorId);
    }

    @Override
    public Professor getByid(int professorId) {
        return repo.findById(professorId).get();
    }
    
}
