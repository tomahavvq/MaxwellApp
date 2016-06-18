package com.maxwell.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by matexo on 21.05.16.
 */
@Entity
@Table
public class BodyPart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Long id;

    @Column(name = "description")
    String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
