package com.hitol.springboot.manager.trainTime;

import com.hitol.springboot.model.trainTime.StationDO;
import com.hitol.springboot.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StationManageImpl implements StationManage {

    @Autowired
    StationRepository stationRepository;

    @Override
    public void save(List<StationDO> stationDOList) {
        if (CollectionUtils.isEmpty(stationDOList)) {
            return;
        }
        for (StationDO stationDO : stationDOList) {
            stationRepository.save(stationDO);
        }
    }
}
