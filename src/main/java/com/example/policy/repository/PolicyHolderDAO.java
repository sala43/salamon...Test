package com.example.policy.repository;

import com.example.policy.entity.PolicyHolder;

import java.util.List;

public interface PolicyHolderDAO {
    public List<PolicyHolder> getAllPolicyHolder();

    public PolicyHolder getOnePolicyHolder(int id);

    public PolicyHolder insertPolicyHolder(PolicyHolder policyHolder);

    public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder);
}
