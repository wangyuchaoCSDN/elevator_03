package com.hp.elevator_02.mapper;

import com.hp.elevator_02.pojo.Elevator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElevatorMapper {
    //查询所有
    List<Elevator> findAll(Elevator elevator);
}
