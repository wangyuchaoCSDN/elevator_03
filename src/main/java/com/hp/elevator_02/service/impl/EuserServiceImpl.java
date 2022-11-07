package com.hp.elevator_02.service.impl;

import com.hp.elevator_02.mapper.EuserMapper;
import com.hp.elevator_02.pojo.Euser;
import com.hp.elevator_02.service.EuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EuserServiceImpl implements EuserService {

    @Autowired
    private EuserMapper euserMapper;

    //登录
    @Override
    public Euser login(Euser euser) {
        return euserMapper.login(euser);
    }
}
