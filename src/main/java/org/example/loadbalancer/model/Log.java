package org.example.loadbalancer.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data


public class Log extends BaseModel {

    private String responseLog;

    public Log(String responseLog) {
        this.responseLog = responseLog;
    }
    public Log() {}
}
