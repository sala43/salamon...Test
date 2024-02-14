package com.example.policy.services;


import com.example.policy.entity.Coverage;
import com.example.policy.entity.Policy;
import com.example.policy.entity.PolicyHolder;
import com.example.policy.entity.Premium;


import java.util.List;

public interface PolicyService {
    public List<Policy> getAllPolicy();
    public Policy getOnePolicy(int id);
    public Policy addPolicy(Policy policy);
    public Policy updatePolicy(Policy policy);
    public void deletePolicy(int id);
    public List<Coverage> getAllCoverage();
    public Coverage getOneCoverage(int id);
    public PolicyHolder insertPolicyHolder(PolicyHolder policyHolder);

    public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder);
    public List<PolicyHolder> getAllPolicyHolder();

    public PolicyHolder getOnePolicyHolder(int id);

    public List<Premium> getAllPremium();
    public Premium getOnePremium(int id);
    public Premium insertPremium(Premium premium);
    public Premium updatePremium(Premium premium);
}
