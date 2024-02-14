package com.example.policy.repository;

import com.example.policy.entity.Premium;

import java.util.List;

public interface PremiumDAO {
    public List<Premium> getAllPremium();
    public Premium getOnePremium(int id);
    public Premium insertPremium(Premium premium);
    public Premium updatePremium(Premium premium);
}
