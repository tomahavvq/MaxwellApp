package com.maxwell.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by matexo on 21.05.16.
 */

@Entity
@Table(name = "exercise_details")
public class ExerciseDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Min(0)
    @Column(name = "repeatation")
    private Integer repeatation;
    @NotNull
    @Min(0)
    @Column(name = "series")
    private Integer series;
    @NotNull
    @Min(0)
    @Column(name = "weight")
    private Integer weight;
    @NotNull
    @Column(name = "is_done")
    private Boolean isDone = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRepeatation() {
        return repeatation;
    }

    public void setRepeatation(Integer repeatation) {
        this.repeatation = repeatation;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
