package com.example.bl.adminer.repository;

import com.example.bl.adminer.entity.VacationsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VacationsRequestDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(VacationsRequestDAO.class);


    public VacationsRequest create(VacationsRequest vacationsRequest) {
        logger.info("DAO POST request/id");
        entityManager.persist(vacationsRequest);
        entityManager.flush();
        return vacationsRequest;
    }


    public VacationsRequest update(VacationsRequest vacationsRequest) {
        logger.info("DAO PUT request/id");
        entityManager.merge(vacationsRequest);
        entityManager.flush();
        return vacationsRequest;
    }


    public VacationsRequest getvacationsRequestById(long id) {
        logger.info("DAO GET request/id");
        return entityManager.find(VacationsRequest.class, id);
    }

    public List<VacationsRequest> getAllVacationsRequests(){
        return entityManager.createQuery("SELECT request FROM VacationsRequest request",VacationsRequest.class).getResultList();
    }


    public void delete(long id) {
        logger.info("DAO DELETE request/id");
        VacationsRequest vacationsRequest = getvacationsRequestById(id);
        if (vacationsRequest != null) {
            entityManager.remove(vacationsRequest);
        }
    }
}
