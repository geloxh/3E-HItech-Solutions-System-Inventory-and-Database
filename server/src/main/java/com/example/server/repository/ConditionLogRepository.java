package com.example.server.repository;

import com.example.server.domain.ConditionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionLogRepository extends JpaRepository<ConditionLog, Long> {
    List<ConditionLog> findByAssetIdOrderByLoggedAtDesc(Long assetId);
}
