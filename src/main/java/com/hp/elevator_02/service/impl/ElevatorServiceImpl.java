package com.hp.elevator_02.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.elevator_02.mapper.ElevatorMapper;
import com.hp.elevator_02.pojo.Elevator;
import com.hp.elevator_02.service.ElevatorService;
import com.hp.elevator_02.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevatorServiceImpl implements ElevatorService {

    @Autowired
    private ElevatorMapper elevatorMapper;

    @Override
    public PageResult findAll(int pageNum,int pageSize,Elevator elevator) {
       //调用分页方法
      PageHelper.startPage(pageNum,pageSize);

        Page<Elevator> page = (Page<Elevator>) elevatorMapper.findAll(elevator);

        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());

        return pageResult;
    }

}
