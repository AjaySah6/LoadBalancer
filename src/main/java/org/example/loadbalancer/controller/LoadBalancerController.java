package org.example.loadbalancer.controller;

import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.service.LoadBalancerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/servers")
public class LoadBalancerController {

    private LoadBalancerService loadBalancerService;
    public LoadBalancerController(LoadBalancerService loadBalancerService) {
        this.loadBalancerService = loadBalancerService;
    }

    @GetMapping
    public List<Server> getAllServers() {
        return loadBalancerService.getAllServers();
    }




}
