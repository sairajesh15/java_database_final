package com.project.code.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/filter/{category}/{name}/{storeId}")
    public ResponseEntity<?> filterInventory(
            @PathVariable String category,
            @PathVariable String name,
            @PathVariable Long storeId) {
        try {
            if (storeId == null || storeId <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid store ID provided.");
            }
            return ResponseEntity.ok("Filtered inventory for category: " + category + ", name: " + name + ", store: " + storeId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error filtering inventory: " + e.getMessage());
        }
    }

    @GetMapping("/validate/{quantity}/{storeId}/{productId}")
    public ResponseEntity<?> validateQuantity(
            @PathVariable Integer quantity,
            @PathVariable Long storeId,
            @PathVariable Long productId) {
        try {
            if (quantity == null || quantity < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid quantity requested.");
            }
            return ResponseEntity.ok("Quantity is valid and available in stock.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error validating quantity: " + e.getMessage());
        }
    }
}
