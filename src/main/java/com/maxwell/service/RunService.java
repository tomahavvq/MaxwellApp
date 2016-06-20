package com.maxwell.service;

import com.maxwell.domain.Run;
import com.maxwell.domain.User;
import com.maxwell.repository.RunRepository;
import com.maxwell.service.CoordinateService;
import com.maxwell.service.PaceService;
import com.maxwell.service.UserService;
import com.maxwell.web.rest.dto.RunDTO;
import com.maxwell.web.rest.mapper.RunMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by tomahavvq on 14.05.16.
 */
@Service
@Transactional
public class RunService {

    @Inject
    private RunRepository runRepository;

    @Inject
    private UserService userService;

    @Inject
    private CoordinateService coordinateService;

    @Inject
    private PaceService paceService;

    public Optional<Run> saveRun(RunDTO runDTO, Long userId) {
        User user = userService.getUser(userId).get();

        Run run = new Run();
        run.setDateTime(runDTO.getDateTime());
        run.setDuration(runDTO.getDuration());
        run.setName(runDTO.getName());
        run.setDistance(runDTO.getDistance());
        run.setUser(user);

        run = runRepository.save(run);
        run.setCoordinates(coordinateService.saveCoordinates(runDTO.getCoordinates(), run));
        run.setPaceList(paceService.savePace(runDTO.getPace(), run));

        return Optional.of(run);
    }

    public Optional<RunDTO> getRun(Long runId) {
        Run run = runRepository.getOne(runId);
        return Optional.ofNullable(RunMapper.mapRunEntityToDTO(run));

    }

    @Transactional(readOnly = true)
    public Page<Run> findAll(Pageable pageable) {
        Page<Run> result = runRepository.findAll(pageable);
        return result;
    }


}
