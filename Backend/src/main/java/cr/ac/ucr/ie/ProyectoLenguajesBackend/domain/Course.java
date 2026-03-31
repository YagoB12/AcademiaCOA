package cr.ac.ucr.ie.ProyectoLenguajesBackend.domain;


import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private int assestment;
    private String description;
    private String requirements;
    private String code;

    private String nameProfesor;
    private String nameCategory;
    private String subNameCategory;
    private int idProfessor;
    private int idSubcategory;


    @ManyToMany
    @JoinTable(
        name = "course_professor",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professors;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;


    public Course() {}

    public Course(int id, String name, double price, int assestment, String description, String requirements, String code) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.assestment = assestment;
        this.description = description;
        this.requirements = requirements;
        this.code = code;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAssestment() {
        return assestment;
    }

    public void setAssestment(int assestment) {
        this.assestment = assestment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameProfesor() {
        return nameProfesor;
    }

    public void setNameProfesor(String nameProfesor) {
        this.nameProfesor = nameProfesor;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getSubNameCategory() {
        return subNameCategory;
    }

    public void setSubNameCategory(String subNameCategory) {
        this.subNameCategory = subNameCategory;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(int idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
