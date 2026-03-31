/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.jpa;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Student;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.repository.IStudentRepository;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ldieg
 */
@Service
public class StudentServiceJPA implements IStudentService {

    
    @Autowired
    private IStudentRepository repo;
    
    @Override
    public void save(Student student) {
        repo.save(student);
    }
    
    @Override
    public List<Student> getList() {
        return repo.findAll();
    }

    @Override
    public void delete(int studentId) {
        repo.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
        return repo.findById(studentId).get();
    }
    
    @Override
public boolean emailExists(String email) {
    return repo.existsByEmail(email);
}

@Override
public boolean identificationExists(int identification) {
    return repo.existsByIdentification(identification);
}

    
}
