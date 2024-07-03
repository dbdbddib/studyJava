package com.studymavenspringboot.rentcar.models;

import java.lang.reflect.Member;
import java.util.Date;

public class Rented {



private Date vehicle;
private Member member;
private Date startDate;
private String startPoint;
private Date endDate;
private String endPoint;
private int money;
private Date rentDate;
private Date returnDate;
private Date brokenDate;
private RentStatus status;
private Reserved reserved;



public boolean rentVehicle(Vehicle v, Member member, Date startDate, String startPoint, int money, Date rentDate, RentStatus status){
    return false;
}
public boolean returnVehicle(Vehicle v, Member member, Date endDate, String endPoint, Date returnDate){
    return false;
}
public boolean brokenVehicle(Vehicle v, Member member, Date brokenDate){
    return false;
}

}
