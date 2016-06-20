package com.maxwell.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.maxwell.domain.Training;
import com.maxwell.service.TrainingService;
import com.maxwell.web.rest.dto.SimpleTrainingDTO;
import com.maxwell.web.rest.dto.TrainingDTO;
import com.maxwell.web.rest.mapper.SimpleTrainingMapper;
import com.maxwell.web.rest.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by matexo on 21.05.16.
 */
@RestController
@RequestMapping(value = "/api/training")
public class TrainingCtrl {

    @Inject
    private TrainingService trainingService;

    @Inject
    private SimpleTrainingMapper simpleTrainingMapper;

    @RequestMapping(value = "/{trainingId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> getTraining(@PathVariable Long trainingId) {
        return trainingService.getTraining(trainingId)
                .map(trainingDTO -> new ResponseEntity<>(trainingDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    // TODO do pomyslenia// URL: http://10.0.0.10:8080/api/exercise GET
    @RequestMapping(value = "/user/{userId}" , method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTraining(@RequestBody TrainingDTO trainingDTO, @PathVariable Long userId)
    {
    return trainingService.editTraining(trainingDTO , userId)
            .map(training -> new ResponseEntity<>(training.getId() , HttpStatus.OK ))
            .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/user/{trainingId}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTraining(@PathVariable Long trainingId)
    {
        return trainingService.deleteTraining(trainingId)
                .map(training -> new ResponseEntity<>(training.getId() , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/user/{userId}" , method = RequestMethod.GET)
    public ResponseEntity<?> getAllTrainingForUser(@PathVariable Long userId)
    {
        return new ResponseEntity<>(trainingService.getAllTrainingForUser(userId).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{userId}/active" , method = RequestMethod.GET)
    public ResponseEntity<List<TrainingDTO>> getActiveTrainingForUser(@PathVariable Long userId)
    {
        return new ResponseEntity<>(trainingService.getAllActiveTrainingForUser(userId).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{userId}" , method = RequestMethod.POST)
    public ResponseEntity<?> addTrainingForUser(@RequestBody TrainingDTO trainingDTO , @PathVariable Long userId)
    {
        return trainingService.saveTrainingForUser(trainingDTO , userId)
                .map(training -> new ResponseEntity<>(training.getId() , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/user/{userId}")
    public ResponseEntity<TrainingDTO> getTraining(@PathVariable Long trainingId , @PathVariable Long userId) {
        return trainingService.getTraining(trainingId)
                .map(trainingDTO -> new ResponseEntity<>(trainingDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/{trainingId}")
    public ResponseEntity<TrainingDTO> getTrainingId(@PathVariable Long trainingId) {
        return trainingService.getTraining(trainingId)
            .map(trainingDTO -> new ResponseEntity<>(trainingDTO, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleTrainingDTO>> getAllTrainings(Pageable pageable)
        throws URISyntaxException {
        Page<Training> page = trainingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/training");
        return new ResponseEntity<>(simpleTrainingMapper.trainingsToTrainingDTOs(page.getContent()), headers, HttpStatus.OK);
    }
}
