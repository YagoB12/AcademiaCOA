package cr.ac.ucr.ie.ProyectoLenguajesBackend.controller;

import cr.ac.ucr.ie.ProyectoLenguajesBackend.domain.Student;
import cr.ac.ucr.ie.ProyectoLenguajesBackend.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    private final String uploadDir = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/list")
    public List<Student> list() {
        return studentService.getList();
    }

    @GetMapping("/getById")
    public ResponseEntity<Student> findById(@RequestParam int studentId) {
        Student student = studentService.getById(studentId);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Student student) {
        try {
            if (student.getId() == 0) {
                if (studentService.emailExists(student.getEmail())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body("El correo ya existe. No se puede guardar.");
                }

                if (studentService.identificationExists(student.getIdentification())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body("Este estudiante ya existe. No se puede guardar.");
                }
            }

            // Eliminar imagen anterior si es necesario
            if (student.getId() > 0) {
                Student existingStudent = studentService.getById(student.getId());

                if (existingStudent != null
                        && existingStudent.getImg() != null
                        && !existingStudent.getImg().isEmpty()
                        && !existingStudent.getImg().equals(student.getImg())) {

                    File oldImage = new File(uploadDir + "/" + existingStudent.getImg());
                    if (oldImage.exists() && oldImage.delete()) {
                        System.out.println("Imagen anterior eliminada: " + oldImage.getName());
                    }
                }
            }

            studentService.save(student);
            return ResponseEntity.ok("Estudiante agregado o actualizado correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar o actualizar estudiante: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int studentID) {
        try {
            Student student = studentService.getById(studentID);

            if (student != null
                    && student.getImg() != null
                    && !student.getImg().isEmpty()) {

                File imageFile = new File(uploadDir + "/" + student.getImg());
                if (imageFile.exists() && imageFile.delete()) {
                    System.out.println("Imagen eliminada: " + imageFile.getName());
                }
            }

            studentService.delete(studentID);
            return ResponseEntity.ok("Estudiante eliminado correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar estudiante: " + e.getMessage());
        }
    }
}
