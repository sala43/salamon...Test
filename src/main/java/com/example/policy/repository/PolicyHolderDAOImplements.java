package com.example.policy.repository;

import com.example.policy.entity.Policy;
import com.example.policy.entity.PolicyHolder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolicyHolderDAOImplements implements PolicyHolderDAO{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<PolicyHolder> getAllPolicyHolder() {
        TypedQuery<PolicyHolder> sql = entityManager.createQuery("from PolicyHolder", PolicyHolder.class);
        List<PolicyHolder> policyHolder = sql.getResultList();
        return policyHolder;
    }

    @Override
    public PolicyHolder getOnePolicyHolder(int id) {
        PolicyHolder policyHolder = entityManager.find(PolicyHolder.class, id);
        return policyHolder;
    }

    @Override
    public PolicyHolder insertPolicyHolder(PolicyHolder policyHolder) {
        return entityManager.merge(policyHolder);
    }

    @Override
    public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) {
         return entityManager.merge(policyHolder);
    }
}
