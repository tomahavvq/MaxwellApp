package com.maxwell.service;

import com.google.common.collect.Lists;
import com.maxwell.domain.BodyPart;
import com.maxwell.domain.Exercise;
import com.maxwell.domain.QExercise;
import com.maxwell.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by matexo on 21.05.16.
 */
@Service
@Transactional
public class ExerciseService {

    @Inject
    private ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercise(){
        return exerciseRepository.findAll();
    }

    public List<Exercise> getExerciseByBodyPart(BodyPart bodyPart){
        Iterable<Exercise> exercises = exerciseRepository.findAll(QExercise.exercise.bodyPart.eq(bodyPart));
        return Lists.newArrayList(exercises.iterator());
    }

    public Optional<Exercise> saveExercise(Exercise exercise)
    {
        return Optional.of(exerciseRepository.save(exercise));
    }

    public void deleteExercise(Long id)
    {
        if(exerciseRepository.exists(id)) {
            exerciseRepository.delete(id);
        }
    }

    public Optional<Exercise> getExerciseById(Long id)
    {
        return Optional.of(exerciseRepository.findOne(id));
    }
}
