/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "professor")
public class Professor extends User {

    @Column(length = 1000)
    private String biography;

    @ManyToMany
    @JoinTable(
            name = "professor_specialties",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id")
    )
    private List<Speciality> specialties;

    @Min(0)
    @Max(5)
    private int averageAssessment;

    private String professionalNetWork;

    public Professor() {
        this.specialties = new LinkedList<>();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Speciality> specialties) {
        this.specialties = specialties;
    }

    public int getAverageAssessment() {
        return averageAssessment;
    }

    public void setAverageAssessment(int averageAssessment) {
        this.averageAssessment = averageAssessment;
    }

    public String getProfessionalNetWork() {
        return professionalNetWork;
    }

    public void setProfessionalNetWork(String professionalNetWorks) {
        this.professionalNetWork = professionalNetWorks;
    }

}
