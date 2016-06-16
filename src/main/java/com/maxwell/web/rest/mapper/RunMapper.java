package com.maxwell.web.rest.mapper;

import com.maxwell.domain.Coordinate;
import com.maxwell.domain.Pace;
import com.maxwell.domain.Run;
import com.maxwell.web.rest.dto.RunDTO;

import java.util.List;

/**
 * Created by tomahavvq on 14.05.16.
 */
public class RunMapper {

    public static RunDTO mapRunEntityToDTO(Run run) {
        RunDTO runDTO = new RunDTO();
        Double[][] coordinates = mapCoordinates(run.getCoordinates());
        Integer[] pace = mapPace(run.getPaceList());

        runDTO.setCoordinates(coordinates);
        runDTO.setPace(pace);
        runDTO.setDateTime(run.getDateTime());
        runDTO.setDuration(run.getDuration());
        runDTO.setDistance(run.getDistance());
        runDTO.setName(run.getName());
        runDTO.setRunId(run.getId());

        return runDTO;
    }

    private static Integer[] mapPace(List<Pace> paceList) {
        Integer[] pace = new Integer[paceList.size()];
        int i = 0;

        for (Pace paceEntity : paceList) {
            pace[i] = paceEntity.getPace();
            i++;
        }
        return pace;
    }

    public static Double[][] mapCoordinates(List<Coordinate> coordinates) {
        Double[][] loc = new Double[coordinates.size()][2];
        int i = 0;

        for (Coordinate coordinate : coordinates) {
            loc[i][0] = coordinate.getAltitude();
            loc[i][1] = coordinate.getLatitude();
            i++;
        }

        return loc;
    }
}
