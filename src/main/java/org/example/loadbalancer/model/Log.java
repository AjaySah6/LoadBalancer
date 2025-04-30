package org.example.loadbalancer.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Log extends BaseModel {

    private String responseLog;
    private String serverUrl;

}
