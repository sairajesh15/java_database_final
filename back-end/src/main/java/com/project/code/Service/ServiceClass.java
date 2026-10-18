package com.project.code.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

    public boolean validateInventory(Long productId, Long storeId) {
        return productId != null && storeId != null;
    }

    public Long getInventoryId(Long productId, Long storeId) {
        return 100L; 
    }
}
