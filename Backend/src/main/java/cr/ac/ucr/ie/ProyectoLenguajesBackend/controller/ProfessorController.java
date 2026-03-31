package cr.ac.ucr.ie.ProyectoLenguajesBackend.controller;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Professor;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Speciality;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.IProfessorService;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.ISpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService service;

    @Autowired
    private ISpecialityService serviceS;

    @GetMapping("/")
    public List<Professor> listAll() {
        return service.getList();
    }
    
    @GetMapping("/allSpecialities")
    public List<Speciality> listAllSpeciality() {
        return serviceS.getList();
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Professor professor) {
        try {
            List<Professor> existing = service.getList();
            boolean emailExists = existing.stream().anyMatch(p -> p.getEmail().equals(professor.getEmail()));
            boolean idExists = existing.stream().anyMatch(p -> p.getIdentification() == professor.getIdentification());

            if (emailExists) {
                return ResponseEntity.badRequest().body("Error: Ya existe un profesor con ese correo.");
            }
            if (idExists) {
                return ResponseEntity.badRequest().body("Error: Ya existe un profesor con esa identificación.");
            }

            // Recuperar especialidades por ID desde la base de datos
            List<Speciality> specialities = professor.getSpecialties()
                    .stream()
                    .map(s -> serviceS.getByid(s.getId()))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            professor.setSpecialties(specialities);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            professor.setPassword(encoder.encode(professor.getPassword()));

            service.save(professor);
            return ResponseEntity.ok("Profesor agregado correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al agregar profesor: " + e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam int professorId) {
        Professor professor = service.getByid(professorId);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.status(404).body("Profesor no encontrado");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int professorId) {
        try {
            Professor professor = service.getByid(professorId);
            if (professor != null) {
                service.delete(professorId);
                return ResponseEntity.ok("Profesor eliminado correctamente");
            } else {
                return ResponseEntity.status(404).body("Profesor no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar profesor: " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Validated Professor updatedProfessor) {
        try {
            Professor existingProfessor = service.getByid(updatedProfessor.getId());
            if (existingProfessor == null) {
                return ResponseEntity.status(404).body("Profesor no encontrado");
            }

            List<Speciality> specialities = updatedProfessor.getSpecialties()
                    .stream()
                    .map(s -> serviceS.getByid(s.getId()))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            updatedProfessor.setSpecialties(specialities);

            service.save(updatedProfessor);
            return ResponseEntity.ok("Profesor actualizado correctamente");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar profesor: " + e.getMessage());
        }
    }

}
