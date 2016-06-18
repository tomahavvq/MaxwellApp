package com.maxwell.web.rest.mapper;

import com.maxwell.domain.Exercise;
import com.maxwell.domain.ExerciseDetails;
import com.maxwell.domain.Training;
import com.maxwell.web.rest.dto.ExersiseDTO;
import com.maxwell.web.rest.dto.TrainingDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matexo on 21.05.16.
 */
public class TrainingMapper {

    public static TrainingDTO mapTrainingEntityToDTO(Training training)
    {
        TrainingDTO trainingDTO = getTrainingDTO(training);
        trainingDTO.setExersiseDTOList(getExersiseDTOList(training));
        return trainingDTO;
    }

    private static TrainingDTO getTrainingDTO(Training training) {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setDone(training.getDone());
        trainingDTO.setId(training.getId());
        trainingDTO.setTrainingDate(training.getDateTime());
        trainingDTO.setUserId(training.getUser().getId());
        trainingDTO.setName(training.getName());
        return trainingDTO;
    }

    private static List<ExersiseDTO> getExersiseDTOList(Training training) {
        List<ExersiseDTO> exersiseDTOList = new ArrayList<>();
        for(ExerciseDetails ed : training.getExercises())
        {
            ExersiseDTO exersiseDTO = new ExersiseDTO();
            exersiseDTO.setId(ed.getId());
            exersiseDTO.setDone(ed.getDone());
            exersiseDTO.setRepeatation(ed.getRepeatation());
            exersiseDTO.setSeries(ed.getSeries());
            exersiseDTO.setWeight(ed.getWeight());

            Exercise exercise = ed.getExercise();
            exersiseDTO.setBodyPart(exercise.getBodyPart().getDescription());
            exersiseDTO.setDescription(exercise.getDescription());
            exersiseDTO.setName(exercise.getName());
            exersiseDTO.setExerciseId(exercise.getId());
            exersiseDTOList.add(exersiseDTO);
        }
        return exersiseDTOList;
    }

    public static List<TrainingDTO> mapTrainingListToTrainingDTOList(Iterable<Training> list)
    {
        List<TrainingDTO> trainingDTOList = new ArrayList<>();
        for(Training training : list)
        {
            trainingDTOList.add(mapTrainingEntityToDTO(training));
        }
        return trainingDTOList;
    }

}
