package org.example.loadbalancer;

import org.example.loadbalancer.model.HealthStatus;
import org.example.loadbalancer.model.Server;
import org.example.loadbalancer.repository.ServerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class LoadBalancerApplication implements CommandLineRunner {

    @Autowired
    private ServerRespository serverRespository;

    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String server_1_Url = "http://localhost:8081";
        serverRespository.save(new Server("Server_1", HealthStatus.ACTIVE, server_1_Url));

        String server_2_Url = "http://localhost:8082";
        serverRespository.save(new Server("Server_2", HealthStatus.ACTIVE, server_2_Url));

        String server_3_Url = "http://localhost:8083";
        serverRespository.save(new Server("Server_2", HealthStatus.ACTIVE, server_3_Url));
    }
}
