/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.domain;

import java.time.LocalDate;

/**
 *
 * @author tonys
 */
public class Notices {
    //preguntar por relacion con el profesor
    private int id;
    private String title;
    private String description;
    private LocalDate datePublish;
    private String autor;
    private boolean visibility;
    private String tag;

    
    //Contructor por default
    public Notices(int id, String title, String description, LocalDate datePublish, String autor, boolean visibility, String tag) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datePublish = datePublish;
        this.autor = autor;
        this.visibility = visibility;
        this.tag = tag;
    }

    public Notices() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
}
