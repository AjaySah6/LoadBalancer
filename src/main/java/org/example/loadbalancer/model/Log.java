package org.example.loadbalancer.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Log extends BaseModel {

    private String responseLog;

    public Log(String responseLog) {
        this.responseLog = responseLog;
    }
}
