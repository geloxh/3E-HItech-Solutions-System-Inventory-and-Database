package com.example.server.controller;

import com.example.server.domain.LocationLog;
import com.example.server.repository.LocationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/location-logs")
@CrossOrigin(origins = "*")
public class LocationLogController {

    @Autowired
    private LocationLogRepository locationLogRepository;

    @GetMapping
    public List<LocationLog> getAllLocationLogs() {
        return locationLogRepository.findAll();
    }

    @GetMapping("/asset/{assetId}")
    public List<LocationLog> getLocationLogsByAsset(@PathVariable Long assetId) {
        return locationLogRepository.findByAssetIdOrderByLoggedAtDesc(assetId);
    }

    @PostMapping
    public LocationLog createLocationLog(@RequestBody LocationLog locationLog) {
        if (locationLog.getLoggedAt() == null) {
            locationLog.setLoggedAt(LocalDateTime.now());
        }
        return locationLogRepository.save(locationLog);
    }
}
