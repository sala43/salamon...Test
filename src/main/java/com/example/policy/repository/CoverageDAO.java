package com.example.policy.repository;

import com.example.policy.entity.Coverage;

import java.util.List;

public interface CoverageDAO {
    public List<Coverage> getAllCoverage();
    public Coverage getOneCoverage(int id);
}
