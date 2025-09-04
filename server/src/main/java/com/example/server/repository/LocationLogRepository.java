package com.example.server.repository;

import com.example.server.domain.LocationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationLogRepository extends JpaRepository<LocationLog, Long> {
    List<LocationLog> findByAssetIdOrderByLoggedAtDesc(Long assetId);
}
