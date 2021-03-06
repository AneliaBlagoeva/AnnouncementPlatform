package com.project.AnnouncementPlatform.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "degree")
public class Degree {

    @Id
    @Column(name = "iddegree")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "degree_description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Degree() {
    }

    public Degree(int id, String description) {
        this.id = id;
        this.description = description;
    }

}
