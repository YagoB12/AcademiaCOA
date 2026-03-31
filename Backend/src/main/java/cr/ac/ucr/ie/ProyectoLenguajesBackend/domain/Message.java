/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.ProyectoLenguajesBackend.domain;

import java.time.LocalDateTime;

/**
 *
 * @author danie
 */
public class Message {
    private int id;
    private String message;
    private LocalDateTime dateHour;

    public Message(int id, String message, LocalDateTime dateHour) {
        this.id = id;
        this.message = message;
        this.dateHour = dateHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }
    
    
}