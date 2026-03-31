/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.service;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Course;
import java.util.List;

/**
 *
 * @author danie
 */
public interface ICourseService {   
    void save(Course course);
    List<Course> getList();
    void delete(int CourseId);
    Course getByid(int CourseId);
   
}
