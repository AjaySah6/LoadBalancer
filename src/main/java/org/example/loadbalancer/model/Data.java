package org.example.loadbalancer.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Data extends BaseModel{
    private String message;

    public String getMessage() {
        return message;
    }
}
