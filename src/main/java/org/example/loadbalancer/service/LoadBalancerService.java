package org.example.loadbalancer.service;

import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.repository.ServerRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadBalancerService {

    private ServerRespository serverRespository;

    public List<Server> getAllServers() {
        return serverRespository.findAll();
    }

    public Server registerServer(Server server) {
        return serverRespository.save(server);
    }
}
