package com.example.policy.repository;


import com.example.policy.entity.Coverage;
import com.example.policy.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoverageDAOImplements implements CoverageDAO{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Coverage> getAllCoverage() {
        TypedQuery<Coverage> sql = entityManager.createQuery("from Coverage", Coverage.class);
        List<Coverage> coverage = sql.getResultList();
        return coverage;
    }

    @Override
    public Coverage getOneCoverage(int id) {
        Coverage coverage = entityManager.find(Coverage.class, id);
        return coverage;
    }
}
