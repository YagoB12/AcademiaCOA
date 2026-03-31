package cr.ac.ucr.ie.ProyectoLenguajesBackend.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "name_category")
    private String nameCategory;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public SubCategory() {}

    public SubCategory(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // Getters y setters

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

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
