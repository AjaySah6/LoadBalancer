package org.example.loadbalancer.repository;

import org.example.loadbalancer.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerLogRespository extends JpaRepository<Log, Long> {

}
