package com.maxwell.service;

import com.maxwell.domain.Pace;
import com.maxwell.domain.Run;
import com.maxwell.repository.PaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomahavvq on 14.05.16.
 */
@Service
@Transactional
public class PaceService {

    @Inject
    private PaceRepository paceRepository;

    public List<Pace> savePace(Integer[] pace, Run run) {
        List<Pace> paceList = new ArrayList<>();
        for (int i = 0; i < pace.length; i++) {
            Pace paceEntity = new Pace();
            paceEntity.setRun(run);
            paceEntity.setPace(pace[0]);
            paceList.add(paceEntity);
        }

        return paceRepository.save(paceList);
    }
}
