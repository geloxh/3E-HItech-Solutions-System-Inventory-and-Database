package com.example.server.service;

import com.example.server.domain.Office;
import com.example.server.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {
    
    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Optional<Office> getOfficeById(Long id) {
        return officeRepository.findById(id);
    }

    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    public Office updateOffice(Long id, Office officeDetails) {
        Office office = officeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Office not found with id: " + id));
        
        office.setName(officeDetails.getName());
        office.setAddress(officeDetails.getAddress());
        
        return officeRepository.save(office);
    }

    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}
