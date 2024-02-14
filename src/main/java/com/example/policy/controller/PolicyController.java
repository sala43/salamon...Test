package com.example.policy.controller;

import com.example.policy.entity.Coverage;
import com.example.policy.entity.Policy;
import com.example.policy.entity.PolicyHolder;
import com.example.policy.entity.Premium;
import com.example.policy.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/policy/")
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("create")
    public String createPolicy(Model model) {
        model.addAttribute("policy", new Policy());
        model.addAttribute("policyholder", new PolicyHolder());
        model.addAttribute("coverages", policyService.getAllCoverage());
        return "createpolicy";
    }

    @PostMapping("insertpolicy")
    public String insertPolicy(@ModelAttribute("policy") Policy policy, @ModelAttribute("policyholder") PolicyHolder policyholder, @RequestParam("coverageIds") String[] coverageIds) {
        List<Coverage> cov = new ArrayList<>();
        Premium p=new Premium();
        for (String id : coverageIds) {
            Coverage coverage = policyService.getOneCoverage(Integer.parseInt(id));

            cov.add(coverage);

        }
        policyService.insertPolicyHolder(policyholder);
        policy.setPolicyHolder(policyholder);
        policy.setPolicyService(cov);

        policyService.addPolicy(policy);
       // List<Coverage> cov = policy.getPolicyService();
        PolicyHolder ph = policy.getPolicyHolder();
        String state = ph.getState();
        //System.out.println("state.."+state);
        double amount =0;
        if (state.equals("AZ")) {
            for (Coverage c : cov) {
                //System.out.println("state.."+c.getName());
                if ((c.getName()).equals("Auto Liability")) {
                    double rate = 5;
                    amount = amount + rate;
                } else if ((c.getName()).equals("Collision")) {
                    double rate = 2;
                    amount = amount + rate;
                } else if ((c.getName()).equals("Bosily Injury")) {
                    double rate = 3;
                    amount = amount + rate;
                }
                p.setAmount(amount);
            }
        } else if (state.equals("NH")) {
            for (Coverage c : cov) {
                if ((c.getName()).equals("Auto Liability")) {
                    double rate = 4;
                    amount = amount + rate;
                } else if ((c.getName()).equals("Collision")) {
                    double rate = 6;
                    amount = amount + rate;
                } else if ((c.getName()).equals("Bosily Injury")) {
                    double rate = 3;
                    amount = amount + rate;
                }
                p.setAmount(amount);
            }
        } else if (state.equals("NY")) {
            for (Coverage c : cov) {
                if ((c.getName()).equals("Auto Liability")) {
                    double rate = 3;
                    amount = amount + rate;
                } else if ((c.getName()).equals("Collision")) {
                    double rate = 5;
                    amount = amount + rate;
                } else if ((c.getName()).equals("Bosily Injury")) {
                    double rate = 1;
                    amount = amount + rate;
                }
                p.setAmount(amount);
            }
        }
        //System.out.println("gggggg"+p.getAmount());

        p.setPolicy(policy);
        policyService.insertPremium(p);
        return "redirect:/policy/index"; // Redirect to the index page after adding the policy
    }

    @GetMapping("view")
    public String viewPolicy(Model model) {

        model.addAttribute("policy", policyService.getAllPolicy());
        model.addAttribute("coverage", policyService.getAllCoverage());
        model.addAttribute("policyholder", policyService.getAllPolicyHolder());
        model.addAttribute("premium", policyService.getAllPremium());

        return "viewpolicy";
    }

    public String getAmount() {
        Policy policy=new Policy();
        List<Coverage> cov = policy.getPolicyService();
        PolicyHolder ph = policy.getPolicyHolder();
        String state = ph.getState();
        double amount = 0;
        if (state.equals("AZ")) {
            for (Coverage c : cov) {
                if (c.equals("Auto Liability")) {
                    double rate = 5;
                    amount = amount + rate;
                } else if (c.equals("Collision")) {
                    double rate = 2;
                    amount = amount + rate;
                } else if (c.equals("Bosily Injury")) {
                    double rate = 3;
                    amount = amount + rate;
                }
            }
        } else if (state.equals("NH")) {
            for (Coverage c : cov) {
                if (c.equals("Auto Liability")) {
                    double rate = 4;
                    amount = amount + rate;
                } else if (c.equals("Collision")) {
                    double rate = 6;
                    amount = amount + rate;
                } else if (c.equals("Bosily Injury")) {
                    double rate = 3;
                    amount = amount + rate;
                }
            }
        } else if (state.equals("NY")) {
            for (Coverage c : cov) {
                if (c.equals("Auto Liability")) {
                    double rate = 3;
                    amount = amount + rate;
                } else if (c.equals("Collision")) {
                    double rate = 5;
                    amount = amount + rate;
                } else if (c.equals("Bosily Injury")) {
                    double rate = 1;
                    amount = amount + rate;
                }
            }
        }
        Premium p=new Premium();
        p.setAmount(amount);

        p.setPolicy(policy);
        policyService.insertPremium(p);
        return "/policy/index";
    }


}
