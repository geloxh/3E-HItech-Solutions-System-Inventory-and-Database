package com.example.server.repository;

import com.example.server.domain.Inclusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InclusionRepository extends JpaRepository<Inclusion, Long> {
}
