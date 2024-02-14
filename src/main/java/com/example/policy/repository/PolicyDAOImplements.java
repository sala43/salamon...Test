package com.example.policy.repository;

import com.example.policy.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolicyDAOImplements implements PolicyDAO {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Policy> getAllPolicy() {
        TypedQuery<Policy> sql = entityManager.createQuery("from Policy", Policy.class);
        List<Policy> policy = sql.getResultList();
        return policy;
    }

    @Override
    public Policy getOnePolicy(int id) {
        Policy policy = entityManager.find(Policy.class, id);
        return policy;
    }

    @Override
    public Policy addPolicy(Policy policy) {
        return entityManager.merge(policy);
    }

    @Override
    public Policy updatePolicy(Policy policy) {
        return entityManager.merge(policy);
    }

    @Override
    public void deletePolicy(int id) {
        Policy policy = entityManager.find(Policy.class, id);
        entityManager.remove(policy);
    }
}
