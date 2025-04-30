package org.example.loadbalancer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Server extends BaseModel{

    private String serverName;

    @Enumerated(EnumType.STRING)
    private HealthStatus healthStatus;

    private String serverUrl;

    public Server(String serverName, HealthStatus healthStatus, String serverUrl) {
        this.serverName = serverName;
        this.healthStatus = healthStatus;
        this.serverUrl = serverUrl;
    }

    // ✅ Getter method for serverName
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }
}
