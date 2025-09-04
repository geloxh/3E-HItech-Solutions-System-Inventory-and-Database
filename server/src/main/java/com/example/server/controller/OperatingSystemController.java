package com.example.server.controller;

import com.example.server.domain.OperatingSystem;
import com.example.server.repository.OperatingSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operating-systems")
@CrossOrigin(origins = "*")
public class OperatingSystemController {

    @Autowired
    private OperatingSystemRepository operatingSystemRepository;

    @GetMapping
    public List<OperatingSystem> getAllOperatingSystems() {
        return operatingSystemRepository.findAll();
    }

    @PostMapping
    public OperatingSystem createOperatingSystem(@RequestBody OperatingSystem operatingSystem) {
        return operatingSystemRepository.save(operatingSystem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperatingSystem> getOperatingSystemById(@PathVariable Long id) {
        return operatingSystemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOperatingSystem(@PathVariable Long id) {
        operatingSystemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
