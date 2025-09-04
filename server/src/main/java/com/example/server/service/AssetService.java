package com.example.server.service;

import com.example.server.domain.Asset;
import com.example.server.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    
    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetById(Long id) {
        return assetRepository.findById(id);
    }

    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
        
        asset.setAssetTag(assetDetails.getAssetTag());
        asset.setAssetType(assetDetails.getAssetType());
        asset.setBrand(assetDetails.getBrand());
        asset.setOperatingSystem(assetDetails.getOperatingSystem());
        asset.setOffice(assetDetails.getOffice());
        asset.setAcquiredAt(assetDetails.getAcquiredAt());
        asset.setAssignedToUser(assetDetails.getAssignedToUser());
        
        return assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
