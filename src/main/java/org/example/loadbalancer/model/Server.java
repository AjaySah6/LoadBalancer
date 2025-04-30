package org.example.loadbalancer.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Server extends BaseModel{

    private String serverName;

    private String serverUrl;

    private HealthStatus healthStatus = HealthStatus.ACTIVE;

    public Server(String serverName, HealthStatus healthStatus, String serverUrl) {
        this.serverName = serverName;
        this.healthStatus = healthStatus;
        this.serverUrl = serverUrl;
    }
}
