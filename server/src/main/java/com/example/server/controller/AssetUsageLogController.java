package com.example.server.controller;

import com.example.server.domain.AssetUsageLog;
import com.example.server.repository.AssetUsageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/asset-usage-logs")
@CrossOrigin(origins = "*")
public class AssetUsageLogController {

    @Autowired
    private AssetUsageLogRepository assetUsageLogRepository;

    @GetMapping
    public List<AssetUsageLog> getAllUsageLogs() {
        return assetUsageLogRepository.findAll();
    }

    @GetMapping("/asset/{assetId}")
    public List<AssetUsageLog> getUsageLogsByAsset(@PathVariable Long assetId) {
        return assetUsageLogRepository.findByAssetIdOrderByLoggedAtDesc(assetId);
    }

    @PostMapping
    public AssetUsageLog createUsageLog(@RequestBody AssetUsageLog usageLog) {
        if (usageLog.getLoggedAt() == null) {
            usageLog.setLoggedAt(LocalDateTime.now());
        }
        return assetUsageLogRepository.save(usageLog);
    }
}
