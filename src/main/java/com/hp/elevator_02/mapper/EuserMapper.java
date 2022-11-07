package com.hp.elevator_02.mapper;

import com.hp.elevator_02.pojo.Euser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EuserMapper {
    //登录
    Euser login(Euser euser);
}
