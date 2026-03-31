/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.service;


import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Speciality;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danie
 */
public interface ISpecialityService {
    
     void save(Speciality speciality);
    List<Speciality> getList();
    void delete(int specialityId);
    Optional<Speciality> getByid(int specialityId);
}
