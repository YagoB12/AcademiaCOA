/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.jpa;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Course;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.repository.ICourseRepository;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.ICourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */

@Service
public class CourseServiceJPA implements ICourseService{
    
    @Autowired
    private ICourseRepository repo;

    @Override
    public void save(Course course) {
        repo.save(course);
    }

    @Override
    public List<Course> getList() {
        return repo.findAll();
    }

    @Override
    public void delete(int courseId) {
        repo.deleteById(courseId);
    }

    @Override
    public Course getByid(int courseId) {
        return repo.findById(courseId).get();
    }
    
}
