package com.maxwell.service;


import com.maxwell.domain.ExerciseDetails;
import com.maxwell.domain.QTraining;
import com.maxwell.domain.Training;
import com.maxwell.repository.ExerciseDetailsRepository;
import com.maxwell.repository.ExerciseRepository;
import com.maxwell.repository.TrainingRepository;
import com.maxwell.repository.UserRepository;
import com.maxwell.web.rest.dto.ExersiseDTO;
import com.maxwell.web.rest.dto.TrainingDTO;
import com.maxwell.web.rest.mapper.TrainingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by matexo on 21.05.16.
 */
@Service
@Transactional
public class TrainingService {

    @Inject
    private TrainingRepository trainingRepository;

    @Inject
    private ExerciseDetailsRepository exerciseDetailsRepository;

    @Inject
    private ExerciseRepository exerciseRepository;

    @Inject
    private UserRepository userRepository;

    public Optional<TrainingDTO> getTraining(Long trainingId) {
        Training training = trainingRepository.getOne(trainingId);
        return Optional.of(TrainingMapper.mapTrainingEntityToDTO(training));
    }


    public Optional<Training> editTraining(TrainingDTO trainingDTO , Long userId)
    {
        //szpachla
        deleteTraining(trainingDTO.getId());
        return saveTrainingForUser(trainingDTO,userId);
    }

    //do testow
    public Optional<Training> deleteTraining(Long id)
    {
        Training training = null;
        if(trainingRepository.exists(id)){
        training = trainingRepository.getOne(id);
            //for (ExerciseDetails exerciseDetails : training.getExercises())
            //    exerciseDetailsRepository.delete(exerciseDetails.getId());
            trainingRepository.delete(id);
        } //else return false;
        return Optional.of(training);
    }

    public Optional<List<TrainingDTO>> getAllTrainingForUser(Long userId)
    {
        Iterable<Training> list = trainingRepository.findAll(QTraining.training.user.id.eq(userId));
        return Optional.of(TrainingMapper.mapTrainingListToTrainingDTOList(list));
    }

    public Optional<List<TrainingDTO>> getAllActiveTrainingForUser(Long userId)
    {
        Iterable<Training> list = trainingRepository.findAll
                (QTraining.training.user.id.eq(userId).and(QTraining.training.isDone.eq(false)));
        return Optional.of(TrainingMapper.mapTrainingListToTrainingDTOList(list));
    }

    public Optional<Training> saveTrainingForUser(TrainingDTO trainingDTO , Long userId)
    {
        Training training = new Training();
        training.setDone(trainingDTO.getDone());
        training.setDateTime(trainingDTO.getTrainingDate());
        training = trainingRepository.save(training);

        List<ExerciseDetails> exerciseDetailsList = new ArrayList<>();
        for(ExersiseDTO exersiseDTO : trainingDTO.getExersiseDTOList())
        {
            ExerciseDetails exerciseDetails = new ExerciseDetails();
            exerciseDetails.setTraining(training);
            exerciseDetails.setSeries(exersiseDTO.getSeries());
            exerciseDetails.setDone(exersiseDTO.getDone());
            exerciseDetails.setRepeatation(exersiseDTO.getRepeatation());
            exerciseDetails.setWeight(exersiseDTO.getWeight());
            exerciseDetails.setExercise(exerciseRepository.getOne(exersiseDTO.getExerciseId()));
            exerciseDetails = exerciseDetailsRepository.save(exerciseDetails);
            exerciseDetailsList.add(exerciseDetails);
        }
        training.setExercises(exerciseDetailsList);
        training.setUser(userRepository.getOne(userId));
        return Optional.of(trainingRepository.save(training));
    }
}
