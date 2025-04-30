package org.example.loadbalancer.service;

import org.example.loadbalancer.exceptions.ServerIsDownException;
import org.example.loadbalancer.model.Log;
import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.repository.ServerLogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
public class LoadBalancerService {

    @Autowired
    private ServerLogRespository serverLogRespository;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean isServerUp(String serverUrl, Server server) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(serverUrl, String.class);
            serverLogRespository.save(new Log(server.getServerName() + " is running and active."));
            return response.getStatusCode().is2xxSuccessful();

        } catch (Exception e) {
            System.out.println(server.getServerName() + " is down and not running.");
            throw new ServerIsDownException("Server is down, kindly check..");
        }
    }

}
