package com.btm.webapp.models;

import jakarta.persistence.*;

@Entity
@Table(name="Shireen")
public class Shireen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true,nullable = false, length=50)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
}
