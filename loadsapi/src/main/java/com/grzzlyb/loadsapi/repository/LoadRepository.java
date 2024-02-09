package com.grzzlyb.loadsapi.repository;

import com.grzzlyb.loadsapi.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
    List<Load> findByShipperId(UUID shipperId);
}
