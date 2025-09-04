package com.example.server.controller;

import com.example.server.domain.ConditionLog;
import com.example.server.repository.ConditionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/condition-logs")
@CrossOrigin(origins = "*")
public class ConditionLogController {

    @Autowired
    private ConditionLogRepository conditionLogRepository;

    @GetMapping
    public List<ConditionLog> getAllConditionLogs() {
        return conditionLogRepository.findAll();
    }

    @GetMapping("/asset/{assetId}")
    public List<ConditionLog> getConditionLogsByAsset(@PathVariable Long assetId) {
        return conditionLogRepository.findByAssetIdOrderByLoggedAtDesc(assetId);
    }

    @PostMapping
    public ConditionLog createConditionLog(@RequestBody ConditionLog conditionLog) {
        if (conditionLog.getLoggedAt() == null) {
            conditionLog.setLoggedAt(LocalDateTime.now());
        }
        return conditionLogRepository.save(conditionLog);
    }
}
