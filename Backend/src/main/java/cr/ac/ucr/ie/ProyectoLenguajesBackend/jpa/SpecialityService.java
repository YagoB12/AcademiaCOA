/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.jpa;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Speciality;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.repository.ISpecialityRepository;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.ISpecialityService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class SpecialityService implements ISpecialityService {

    @Autowired
    private ISpecialityRepository repo;

    @Override
    public void save(Speciality speciality) {
        repo.save(speciality);
    }

    @Override
    public List<Speciality> getList() {
        return repo.findAll();
    }

    @Override
    public void delete(int specialityId) {
        repo.deleteById(specialityId);
    }

    @Override
    public Optional<Speciality> getByid(int specialityId) {
        return repo.findById(specialityId);
    }

}
