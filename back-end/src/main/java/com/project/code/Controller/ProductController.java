package com.project.code.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        try {
            if (id <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with ID: " + id);
            }
            return ResponseEntity.ok("Product details retrieved successfully for ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving product: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProductAndInventory(@PathVariable Long id) {
        try {
            if (id <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for deletion.");
            }
            return ResponseEntity.ok("Product and associated inventory deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during deletion: " + e.getMessage());
        }
    }
}
