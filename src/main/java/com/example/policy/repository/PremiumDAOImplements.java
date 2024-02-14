package com.example.policy.repository;

import com.example.policy.entity.Premium;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PremiumDAOImplements implements PremiumDAO {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Premium> getAllPremium() {

        TypedQuery<Premium> sql = entityManager.createQuery("from Premium", Premium.class);
        List<Premium> premium = sql.getResultList();
        return premium;
    }

    @Override
    public Premium getOnePremium(int id) {
        Premium premium = entityManager.find(Premium.class, id);
        return premium;
    }

    @Transactional
    @Override
    public Premium insertPremium(Premium premium) {
        return entityManager.merge(premium);
    }

    @Transactional
    @Override
    public Premium updatePremium(Premium premium) {
        return entityManager.merge(premium);
    }
}
