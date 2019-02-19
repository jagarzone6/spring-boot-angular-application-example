package com.example.bl.adminer.controller;

import com.example.bl.adminer.entity.VacationsRequest;
import com.example.bl.adminer.service.VacationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
@RequestMapping("api/v1")
public class VacationsController {
    private static final Logger logger = LoggerFactory.getLogger(VacationsController.class);

    @Autowired
    VacationsService vacationsService;

    @GetMapping(value="/request/{id}")
    public ResponseEntity<VacationsRequest> getVacationsRequest(@PathVariable(value="id") long id ){
        logger.info("Controller GET request/id");
        return new ResponseEntity<VacationsRequest>(vacationsService.getRequestDetails(id),HttpStatus.OK);
    }

    @GetMapping(value="/request")
    public ResponseEntity<List<VacationsRequest>> getVacationsRequest(){
        logger.info("Controller GET request");
        return new ResponseEntity<List<VacationsRequest>>(vacationsService.getAllRequests(),HttpStatus.OK);
    }

    @PostMapping(value = "/request")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createVacationsRequest(@RequestBody VacationsRequest vacationsRequest){
        logger.info("Controller POST request/id");
        if(! (vacationsRequest.getName() == null) ) {
            VacationsRequest newVR = vacationsService.createRequest(vacationsRequest);
            return new ResponseEntity<VacationsRequest>(newVR, HttpStatus.OK);
        }else {
            return new ResponseEntity<String>(new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Bad payload").toString(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/request/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateVacationsRequest(
            @PathVariable(value="id") long id ,
            @RequestBody VacationsRequest vacationsRequest
    ){
        logger.info("Controller PUT request/id");
            VacationsRequest updatedVR = vacationsService.updateRequest(vacationsRequest,id);
            return new ResponseEntity<VacationsRequest>(updatedVR, HttpStatus.OK);

    }

    @DeleteMapping(value = "/request/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteVacationsRequest(
            @PathVariable(value="id") long id
    ){
        logger.info("Controller DELETE request/id");
        vacationsService.deleteRequest(id);
        return new ResponseEntity<String>("{\"success\": true}", HttpStatus.OK);
    }

}
