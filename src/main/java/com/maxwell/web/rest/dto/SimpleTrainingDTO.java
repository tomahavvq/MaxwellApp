package com.maxwell.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/**
 * A DTO for the Training entity.
 */
public class SimpleTrainingDTO implements Serializable {

    private Long id;

    private Integer duration;


    private LocalDate dateTime;


    private String name;



    private Long userId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleTrainingDTO simpleTrainingDTO = (SimpleTrainingDTO) o;

        if ( ! Objects.equals(id, simpleTrainingDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SimpleTrainingDTO{" +
            "id=" + id +
            ", duration='" + duration + "'" +
            ", dateTime='" + dateTime + "'" +
            ", name='" + name + "'" +
            '}';
    }
}
