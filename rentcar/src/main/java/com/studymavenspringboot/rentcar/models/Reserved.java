package com.studymavenspringboot.rentcar.models;

import java.lang.reflect.Member;
import java.util.Date;

public class Reserved {

private Vehicle vehicle;
private Member member;
private Date startDate;
private Date endDate;
private String endPoint;
private int money;
private Date reserveDate;
private Date untilDate;
private Date returnDate;
private Date cancelDate;
private RentStatus status;

public boolean reserveVehicle(Vehicle vehicle, Member member, Date startDate, Date startPoint, Date endDate, String endPoint, int money, Date reserveDate, Date untilDate, RentStatus status){
    return false;
}
public boolean reserveVehicle(Vehicle vehicle, Member member, Date startDate, Date startPoint, Date endDate, String endPoint, int money, Date reserveDate){
    return false;
}
public boolean cancelVehicle(Vehicle vehicle, Member member, Date cancelDate){
    return false;
}

}
