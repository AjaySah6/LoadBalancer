package org.example.loadbalancer.service;

import org.example.loadbalancer.exceptions.NoActiveServers;
import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.repository.ServerRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoundRobinService {

    private AtomicInteger counter = new AtomicInteger(0);
    private ServerRepository serverRepository;
    private LoadBalancerService loadBalancerService;

    public RoundRobinService(ServerRepository serverRepository, LoadBalancerService loadBalancerService) {
        this.serverRepository = serverRepository;
        this.loadBalancerService = loadBalancerService;
    }


    public void startCheck() throws NoActiveServers {

        List<Server> allServers = serverRepository.findAll();

        if(allServers.size() == 0){
            System.err.println("ERROR: No servers configured. Background health check cannot start.");
            return;
        }

        while(true){
            try {

                int currentIndex = counter.incrementAndGet() % allServers.size();

                Server server = allServers.get(currentIndex);

                boolean status = loadBalancerService.isServerUp(server.getServerUrl(), server);

                if (status) {
                    System.out.println(server.getServerName() + " is up and running.");
                } else {
                    System.out.println(server.getServerName() + " is not up.");
                }

            }catch(Exception e){
                System.out.println("test");
            }

        }
    }
}
