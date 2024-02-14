package com.example.policy.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String policyNumber;
    private String status;
    @ManyToOne
    private PolicyHolder policyHolder;

    @ManyToMany
    private List<Coverage> policyService ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }


    public List<Coverage> getPolicyService() {
        return policyService;
    }

    public void setPolicyService(List<Coverage> policyService) {
        this.policyService = policyService;
    }
}/*
* @Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String status;

    @ManyToOne
    private PolicyHolder policyHolder;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private Set<Coverage> coverages = new HashSet<>();

    // Getters and setters
}

@Entity
public class Coverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Policy policy;

    // Getters and setters
}

@Entity
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    private Policy policy;

    // Getters and setters
}

@Entity
public class PolicyHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String addressLine1;
    private String addressLine2;
    private String state;

    // Getters and setters
}
 */