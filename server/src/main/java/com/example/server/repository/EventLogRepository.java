package com.example.server.repository;

import com.example.server.domain.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {
    List<EventLog> findByAssetIdOrderByLoggedAtDesc(Long assetId);
}
