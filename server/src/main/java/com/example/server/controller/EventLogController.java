package com.example.server.controller;

import com.example.server.domain.EventLog;
import com.example.server.repository.EventLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/event-logs")
@CrossOrigin(origins = "*")
public class EventLogController {

    @Autowired
    private EventLogRepository eventLogRepository;

    @GetMapping
    public List<EventLog> getAllEventLogs() {
        return eventLogRepository.findAll();
    }

    @GetMapping("/asset/{assetId}")
    public List<EventLog> getEventLogsByAsset(@PathVariable Long assetId) {
        return eventLogRepository.findByAssetIdOrderByLoggedAtDesc(assetId);
    }

    @PostMapping
    public EventLog createEventLog(@RequestBody EventLog eventLog) {
        if (eventLog.getLoggedAt() == null) {
            eventLog.setLoggedAt(LocalDateTime.now());
        }
        return eventLogRepository.save(eventLog);
    }
}
