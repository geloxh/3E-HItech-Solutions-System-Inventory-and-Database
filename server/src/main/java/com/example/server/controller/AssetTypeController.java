package com.example.server.controller;

import com.example.server.domain.AssetType;
import com.example.server.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asset-types")
@CrossOrigin(origins = "*")
public class AssetTypeController {

    @Autowired
    private AssetTypeRepository assetTypeRepository;

    @GetMapping
    public List<AssetType> getAllAssetTypes() {
        return assetTypeRepository.findAll();
    }

    @PostMapping
    public AssetType createAssetType(@RequestBody AssetType assetType) {
        return assetTypeRepository.save(assetType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetType> getAssetTypeById(@PathVariable Long id) {
        return assetTypeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssetType(@PathVariable Long id) {
        assetTypeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
