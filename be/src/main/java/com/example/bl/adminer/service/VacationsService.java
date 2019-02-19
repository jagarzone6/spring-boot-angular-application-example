package com.example.bl.adminer.service;

import com.example.bl.adminer.entity.VacationsRequest;

import java.util.List;

public interface VacationsService {
    VacationsRequest createRequest(VacationsRequest vacationsRequest);
    VacationsRequest updateRequest(VacationsRequest vacationsRequest,long id);
    List<VacationsRequest> getAllRequests();
    void deleteRequest(long id);
    VacationsRequest getRequestDetails(long id);
}
