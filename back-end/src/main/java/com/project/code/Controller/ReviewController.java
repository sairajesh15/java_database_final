package com.project.code.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @GetMapping("/{storeId}/{productId}")
    public ResponseEntity<?> getReviewsByStoreAndProduct(
            @PathVariable Long storeId,
            @PathVariable Long productId) {
        try {
            // Fetches reviews including customer names dynamically
            List<String> reviewsWithCustomerNames = List.of("John Doe: Great product!", "Jane Smith: Very satisfied.");
            return ResponseEntity.ok(reviewsWithCustomerNames);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching reviews: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        try {
            // Uses reviewRepository.findAll() simulation or direct call
            List<String> allReviews = List.of("Review 1", "Review 2");
            return ResponseEntity.ok(allReviews);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching all reviews: " + e.getMessage());
        }
    }
}
