package com.example.server.controller;

import com.example.server.domain.Inclusion;
import com.example.server.repository.InclusionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inclusions")
@CrossOrigin(origins = "*")
public class InclusionController {

    @Autowired
    private InclusionRepository inclusionRepository;

    @GetMapping
    public List<Inclusion> getAllInclusions() {
        return inclusionRepository.findAll();
    }

    @PostMapping
    public Inclusion createInclusion(@RequestBody Inclusion inclusion) {
        return inclusionRepository.save(inclusion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inclusion> getInclusionById(@PathVariable Long id) {
        return inclusionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInclusion(@PathVariable Long id) {
        inclusionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
