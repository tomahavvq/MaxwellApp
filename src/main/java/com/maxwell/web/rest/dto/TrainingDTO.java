package com.maxwell.web.rest.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by matexo on 21.05.16.
 */
public class TrainingDTO {

    private Long id;
    private LocalDate trainingDate;
    private Boolean isDone;
    private String name;
    private Integer duration;
    private List<ExersiseDTO> exersiseDTOList;
    private Long userId;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public List<ExersiseDTO> getExersiseDTOList() {
        return exersiseDTOList;
    }

    public void setExersiseDTOList(List<ExersiseDTO> exersiseDTOList) {
        this.exersiseDTOList = exersiseDTOList;
    }
}
