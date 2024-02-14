package com.example.policy.services;

import com.example.policy.entity.Coverage;
import com.example.policy.entity.Policy;

import com.example.policy.entity.PolicyHolder;
import com.example.policy.entity.Premium;
import com.example.policy.repository.CoverageDAO;
import com.example.policy.repository.PolicyDAO;

import com.example.policy.repository.PolicyHolderDAO;
import com.example.policy.repository.PremiumDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImplements implements PolicyService {
    @Autowired
    PolicyDAO policyDAO;
    @Autowired
    CoverageDAO coverageDAO;
    @Autowired
    PolicyHolderDAO policyHolderDAO;
    @Autowired
    PremiumDAO premiumDAO;


    @Override
    public List<Policy> getAllPolicy() {
        return policyDAO.getAllPolicy();
    }

    @Override
    public Policy getOnePolicy(int id) {
        return policyDAO.getOnePolicy(id);
    }

    @Transactional
    @Override
    public Policy addPolicy(Policy policy) {
        return policyDAO.addPolicy(policy);
    }

    @Transactional
    @Override
    public Policy updatePolicy(Policy policy) {
        return policyDAO.updatePolicy(policy);
    }

    @Transactional
    @Override
    public void deletePolicy(int id) {
        policyDAO.deletePolicy(id);
    }

    @Override
    public List<Coverage> getAllCoverage() {
        return coverageDAO.getAllCoverage();
    }

    @Override
    public Coverage getOneCoverage(int id) {
        return coverageDAO.getOneCoverage(id);
    }
    @Transactional
    @Override
    public PolicyHolder insertPolicyHolder(PolicyHolder policyHolder) {
        return policyHolderDAO.insertPolicyHolder(policyHolder);
    }
    @Transactional
    @Override
    public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) {
        return policyHolderDAO.updatePolicyHolder(policyHolder);
    }

    @Override
    public List<PolicyHolder> getAllPolicyHolder() {
        return policyHolderDAO.getAllPolicyHolder();
    }

    @Override
    public PolicyHolder getOnePolicyHolder(int id) {
        return policyHolderDAO.getOnePolicyHolder(id);
    }

    @Override
    public List<Premium> getAllPremium() {
        return premiumDAO.getAllPremium();
    }

    @Override
    public Premium getOnePremium(int id) {
        return premiumDAO.getOnePremium(id);
    }

    @Override
    public Premium insertPremium(Premium premium) {
        return premiumDAO.insertPremium(premium);
    }

    @Override
    public Premium updatePremium(Premium premium) {
        return premiumDAO.updatePremium(premium);
    }


}
