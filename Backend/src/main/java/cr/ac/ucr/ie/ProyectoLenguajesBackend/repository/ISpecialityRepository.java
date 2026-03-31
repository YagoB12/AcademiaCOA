/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.repository;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author danie
 */
public interface ISpecialityRepository extends JpaRepository<Speciality, Integer>{
    
}
