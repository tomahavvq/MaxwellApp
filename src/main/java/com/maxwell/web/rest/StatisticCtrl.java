package com.maxwell.web.rest;

import com.maxwell.service.StatisticService;
import com.maxwell.web.rest.dto.StatisticDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.inject.Inject;

/**
 * Created by pysiek on 12.06.16.
 */
@RestController
@RequestMapping("api/statistic")
public class StatisticCtrl {

    @Inject
    private StatisticService statisticService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<StatisticDTO> getStatisticDTOByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(statisticService.getUserStatistics(userId), HttpStatus.OK);
    }
}
