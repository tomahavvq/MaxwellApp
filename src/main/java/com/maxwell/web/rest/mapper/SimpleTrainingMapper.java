package com.maxwell.web.rest.mapper;

import com.maxwell.domain.Training;
import com.maxwell.web.rest.dto.SimpleTrainingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for the entity Training and its DTO SimpleTrainingDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class,})
public interface SimpleTrainingMapper {

    @Mapping(source = "user.id", target = "userId")
    SimpleTrainingDTO trainingToTrainingDTO(Training training);

    List<SimpleTrainingDTO> trainingsToTrainingDTOs(List<Training> trainings);

    @Mapping(source = "userId", target = "user")
    Training trainingDTOToTraining(SimpleTrainingDTO simpleTrainingDTO);

    List<Training> trainingDTOsToTrainings(List<SimpleTrainingDTO> simpleTrainingDTOs);
}
