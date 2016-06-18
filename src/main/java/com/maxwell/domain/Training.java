package com.maxwell.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by matexo on 21.05.16.
 */
@Entity
@Table
public class Training extends AbstractTrainingEntity{

    @NotNull
    @Column(name="is_done")
    private Boolean isDone = Boolean.FALSE;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "training")
    private List<ExerciseDetails> exercises;

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public List<ExerciseDetails> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDetails> exercises) {
        this.exercises = exercises;
    }
}
