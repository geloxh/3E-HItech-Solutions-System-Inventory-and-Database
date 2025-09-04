package com.example.server.repository;

import com.example.server.domain.AssetUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetUsageLogRepository extends JpaRepository<AssetUsageLog, Long> {
    List<AssetUsageLog> findByAssetIdOrderByLoggedAtDesc(Long assetId);
}
