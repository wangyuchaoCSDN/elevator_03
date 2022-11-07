package com.hp.elevator_02.service;

import com.hp.elevator_02.pojo.Elevator;
import com.hp.elevator_02.utils.PageResult;

public interface ElevatorService {
    //查询所有
    PageResult findAll(int pageNum,int pageSize,Elevator elevator);
}
