package org.example.loadbalancer.service;

import org.example.loadbalancer.exceptions.NoActiveServers;
import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.repository.ServerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundRobinService {

    private int counter = -1;

    @Autowired
    private ServerRespository serverRespository;

    @Autowired
    private LoadBalancerService loadBalancerService;

    public void startCheck() throws InterruptedException {

        List<Server> allServers = serverRespository.findAll();

        if(allServers.size() == 0){
            throw new NoActiveServers("No active servers found");
        }

        while(true){
            counter = (counter + 1)%allServers.size();
            Server server = allServers.get(counter);
            Boolean status = loadBalancerService.isServerUp(server.getServerUrl(), server);
            if(status){
            }else{
                System.out.println(server.getServerName() + " is not up");
            }
            Thread.sleep(3000); // wait of 3 seconds

        }
    }
}
