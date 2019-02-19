package com.example.bl.adminer.service.impl;

import com.example.bl.adminer.commons.RequestStatus;
import com.example.bl.adminer.entity.VacationsRequest;
import com.example.bl.adminer.repository.VacationsRequestDAO;
import com.example.bl.adminer.service.VacationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacationsServiceImpl implements VacationsService {
    @Autowired
    VacationsRequestDAO vacationsRequestDAO;

    private static final Logger logger = LoggerFactory.getLogger(VacationsServiceImpl.class);


    @Override
    @Transactional
    public VacationsRequest createRequest(VacationsRequest vacationsRequest) {
        logger.info("Service POST request/id");
        vacationsRequest.setStatus(RequestStatus.NEW);
        return vacationsRequestDAO.create(vacationsRequest);
    }

    @Override
    @Transactional
    public VacationsRequest updateRequest(VacationsRequest vacationsRequest, long id) {
        logger.info("Service PUT request/id");
        vacationsRequest.setId(id);
        return vacationsRequestDAO.update(vacationsRequest);
    }

    @Override
    public List<VacationsRequest> getAllRequests() {
        return vacationsRequestDAO.getAllVacationsRequests();
    }

    @Override
    @Transactional
    public void deleteRequest(long id) {
        logger.info("Service DELETE request/id");
        vacationsRequestDAO.delete(id);
    }

    @Override
    public VacationsRequest getRequestDetails(long id) {
        logger.info("Service GET request/id");
        return vacationsRequestDAO.getvacationsRequestById(id);
    }
}
