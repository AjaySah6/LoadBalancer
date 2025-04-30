package org.example.loadbalancer.repository;

import org.example.loadbalancer.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRespository extends JpaRepository<Server, Long> {

}
