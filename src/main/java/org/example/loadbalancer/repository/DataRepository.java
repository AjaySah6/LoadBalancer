package org.example.loadbalancer.repository;

import org.example.loadbalancer.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
