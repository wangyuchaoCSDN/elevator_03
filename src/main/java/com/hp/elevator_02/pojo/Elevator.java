package com.hp.elevator_02.pojo;

import lombok.Data;

@Data
public class Elevator{

    private Integer eid;
    /*注册码*/
    private String serial;
    /*使用单位*/
    private String building;
    /*电梯位置*/
    private String address;
    /*电梯状态*/
    private String status;

    private Integer tid;
    /*栋数*/
    private Integer number;
    /*单元*/
    private  String unit;

    private String supplier;

    private String type;

}
