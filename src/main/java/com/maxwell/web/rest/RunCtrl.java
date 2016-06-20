package com.maxwell.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.maxwell.domain.Run;
import com.maxwell.service.RunService;
import com.maxwell.web.rest.dto.RunDTO;
import com.maxwell.web.rest.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by tomahavvq on 14.05.16.
 */
@RestController
@RequestMapping("/api/run")
public class RunCtrl {

    @Inject
    private RunService runService;

    @RequestMapping(value = "/user/{userId}",
            method = RequestMethod.POST)
    public ResponseEntity<?> savRun(@RequestBody RunDTO runDTO, @PathVariable Long userId) {
        return runService.saveRun(runDTO, userId)
                .map(run -> new ResponseEntity<>(run.getId(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/{runId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RunDTO> getRunDto(@PathVariable Long runId) {
        return runService.getRun(runId)
                .map(runDTO -> new ResponseEntity<>(runDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<Run>> getAllRuns(Pageable pageable)
        throws URISyntaxException {
        Page<Run> page = runService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/run");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
