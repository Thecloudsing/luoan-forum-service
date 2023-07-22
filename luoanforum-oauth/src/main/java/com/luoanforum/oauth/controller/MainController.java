package com.luoanforum.oauth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/oauth")
public class MainController {
    @GetMapping("/{id}")
    @SentinelResource(value = "/", blockHandler = "indexBlockHandler", fallback = "indexFallback")
    public String index(@PathVariable("id") Integer id) {
        int i = 1 / id;
        log.info("index: id={}", id);
        return "index:MainController-OAuth " + id;
    }

    public String indexBlockHandler(Integer id, BlockException blockException) {
        log.warn("indexBlockHandler: id={}, exception={}", id, blockException.getMessage());
        return "indexBlockHandler:MainController-OAuth " + id;
    }

    public String indexFallback(Integer id, Throwable throwable) {
        log.error("indexFallback: id={}, exception={}", id, throwable.getMessage());
        return "indexFallback:MainController-OAuth " + id;
    }

    /**
     * Sentinel配置
     */
//    @PostConstruct
    public void init() {
        System.out.println("MainController-OAuth");
        // 配置限流规则
        ArrayList<FlowRule> flowRules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource("/");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(2);
        flowRules.add(rule);

        FlowRuleManager.loadRules(flowRules);

        // 配置熔断降级规则
        ArrayList<DegradeRule> degradeRules = new ArrayList<>();

        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("/");
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        degradeRule.setCount(2);
        degradeRule.setTimeWindow(10);
        degradeRule.setMinRequestAmount(2);
        degradeRules.add(degradeRule);

        DegradeRuleManager.loadRules(degradeRules);

    }
}
