package com.hp.elevator_02.controller;

import com.alibaba.fastjson.JSONArray;
import com.hp.elevator_02.pojo.Elevator;
import com.hp.elevator_02.service.ElevatorService;
import com.hp.elevator_02.utils.PageResult;
import com.hp.elevator_02.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ele")
public class ElevatorController {

    @Autowired
    private ElevatorService elevatorService;

    //显示电梯基础数据管理页面
    @GetMapping("/showList")
    public String showList(){
        return "/view/elevator/table.html";
    }
    //电梯基础数据管理
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(Integer page, Integer limit, Elevator elevator){
        PageResult pageResult = elevatorService.findAll(page,limit,elevator);
        PageUtil pageUtil = new PageUtil();

        pageUtil.setCode(null);
        pageUtil.setMsg("");
        pageUtil.setCount(pageResult.getTotal()+"");
        pageUtil.setData(JSONArray.toJSONString(pageResult.getRows()));
        System.out.println(elevator);
        return pageUtil.toString();
    }
}
