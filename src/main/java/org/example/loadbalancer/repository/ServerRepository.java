package org.example.loadbalancer.repository;

import org.example.loadbalancer.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {

}
