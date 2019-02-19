package com.example.bl.adminer.entity;

import com.example.bl.adminer.commons.RequestStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacations_request")
public class VacationsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name="init_date")
    private Date initDate;

    @Column(name = "number_of_days")
    private int numOfDays;

    @Column(name = "status")
    private RequestStatus status;

    public VacationsRequest(){}

    public VacationsRequest(String name,Date initDate, int numOfDays){
        this.name =name;
        this.initDate =initDate;
        this.numOfDays =numOfDays;
        this.status = RequestStatus.NEW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
