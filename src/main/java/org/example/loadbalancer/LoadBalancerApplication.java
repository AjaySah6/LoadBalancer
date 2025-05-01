package org.example.loadbalancer;

import org.example.loadbalancer.model.HealthStatus;
import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.repository.ServerRepository;
import org.example.loadbalancer.service.RoundRobinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoadBalancerApplication implements CommandLineRunner {

    @Autowired
    private RoundRobinService roundRobinService;
    @Autowired
    private ServerRepository serverRespository;

    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String server_1_Url = "http://localhost:9090/server/hello";
        serverRespository.save(new Server("Server_1", HealthStatus.ACTIVE, server_1_Url));

        String server_2_Url = "http://localhost:9091/server/hello";
        serverRespository.save(new Server("Server_2", HealthStatus.ACTIVE, server_2_Url));

        String server_3_Url = "http://localhost:9092/server/hello";
        serverRespository.save(new Server("Server_3", HealthStatus.ACTIVE, server_3_Url));

        roundRobinService.startCheck();

        System.out.println("LoadBalancerApplication run() method finished. Application started. ###");
    }

}
