package com.maxwell.service;

import com.maxwell.domain.*;
import com.maxwell.repository.RunRepository;
import com.maxwell.repository.TrainingRepository;
import com.maxwell.web.rest.dto.StatisticDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pysiek on 08.06.16.
 */
@Service
@Transactional
public class StatisticService {
    @Inject
    private RunRepository runRepository;

    @Inject
    private TrainingRepository trainingRepository;

    @Inject
    private ExerciseService exerciseService;

    public StatisticDTO getUserStatistics(Long userId) {
        StatisticDTO statistics = new StatisticDTO();
        statistics.setUserId(userId);
        statistics.setSumOfRepetitions(0);
        statistics.setSumOfSeries(0);
        statistics.setSumOfWeight(0);
        statistics.setRunDistance(0);
        statistics.setRunDuration(0);

        getTrainingStatistics(statistics);
        getRunStatistics(statistics);

        return statistics;
    }

    private void getTrainingStatistics(StatisticDTO statistics) {
        Map<Long, Integer> done, all;
        done = new HashMap<>();
        all = new HashMap<>();

        for (Exercise exercise : exerciseService.getAllExercise()) {
            done.put(exercise.getId(), 0);
            all.put(exercise.getId(), 0);
        }

        Iterable<Training> trainings = trainingRepository.findAll(QTraining.training.user.id.eq(statistics.getUserId()));
        for (Training training : trainings) {
            for (ExerciseDetails exerciseDetails : training.getExercises()) {
                if (exerciseDetails.getDone()) {
                    done.put(exerciseDetails.getExercise().getId(), done.get(exerciseDetails.getExercise().getId()) + 1);
                    statistics.setSumOfRepetitions(statistics.getSumOfRepetitions() + exerciseDetails.getRepeatation());
                    statistics.setSumOfSeries(statistics.getSumOfSeries() + exerciseDetails.getSeries());
                    statistics.setSumOfWeight(statistics.getSumOfWeight() + exerciseDetails.getWeight());
                }
                all.put(exerciseDetails.getExercise().getId(), all.get(exerciseDetails.getExercise().getId()) + 1);
            }
        }

        statistics.setSumOfAllDoneExercises(done);
        statistics.setSumOfAllExercises(all);
    }

    private void getRunStatistics(StatisticDTO statistics) {
        Iterable<Run> runs = runRepository.findAll(QRun.run.user.id.eq(statistics.getUserId()));
        Double sumOfPace = 0.;
        Integer paceCounter = 0;
        for (Run run : runs) {
            statistics.setRunDistance(statistics.getRunDistance() + run.getDistance());
            statistics.setRunDuration(statistics.getRunDuration() + run.getDuration());
            for (Pace pace : run.getPaceList()) {
                sumOfPace += pace.getPace();
                paceCounter++;
            }
        }
        statistics.setAverageRunPace(sumOfPace / paceCounter);
    }
}
