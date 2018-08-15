package com.hitol.springboot.manager.trainTime;

import com.hitol.springboot.model.trainTime.StationDO;

import java.util.List;

public interface StationManage {

    void save(List<StationDO> stationDO);
}
