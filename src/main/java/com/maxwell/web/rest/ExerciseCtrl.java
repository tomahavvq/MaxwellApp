package com.maxwell.web.rest;

import com.maxwell.domain.BodyPart;
import com.maxwell.domain.Exercise;
import com.maxwell.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;
import java.util.List;

/**
 * Created by matexo on 21.05.16.
 */
@RestController
@RequestMapping(value = "/api/exercise")
public class ExerciseCtrl {

    @Inject
    private ExerciseService exerciseService;

    //tylko dla admina
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveExercise(@RequestBody Exercise exercise) {
        return exerciseService.saveExercise(exercise)
                .map(addedExercise -> new ResponseEntity<>(addedExercise.getId() , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return new ResponseEntity<>( exerciseService.getAllExercise() , HttpStatus.OK);
    }

    @RequestMapping(value = "/bodyPart/{bodyPartDescription}" , method = RequestMethod.GET)
    public List<Exercise> getAllExercisesByBodyPart(@PathVariable String bodyPartDescription) {
        BodyPart bodyPart = new BodyPart();
        bodyPart.setDescription(bodyPartDescription);
        return exerciseService.getExerciseByBodyPart(bodyPart);
    }

    @RequestMapping(value = "/{exerciseId}" , method = RequestMethod.GET)
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long exerciseId)
    {
        return exerciseService.getExerciseById(exerciseId)
                .map(exercise -> new ResponseEntity<>(exercise , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
