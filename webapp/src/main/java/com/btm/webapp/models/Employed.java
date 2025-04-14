package com.btm.webapp.models;
import jakarta.persistence.*;

@Entity
@Table(name="Employments")
public class Employed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employedName;

    public String getEmployedName() {
        return employedName;
    }

    public void setEmployedName(String employedName) {
        this.employedName = employedName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
