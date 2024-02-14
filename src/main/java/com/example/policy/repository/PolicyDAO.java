package com.example.policy.repository;

import com.example.policy.entity.Policy;

import java.util.List;

public interface PolicyDAO {
    public List<Policy> getAllPolicy();
    public Policy getOnePolicy(int id);
    public Policy addPolicy(Policy policy);
    public Policy updatePolicy(Policy policy);
    public void deletePolicy(int id);
}
