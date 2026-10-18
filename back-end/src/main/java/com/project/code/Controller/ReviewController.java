package com.project.code.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @GetMapping("/{storeId}/{productId}")
    public ResponseEntity<?> getReviews(
            @PathVariable Long storeId,
            @PathVariable Long productId) {
        try {
            List<String> reviews = List.of("Great product!", "Very satisfied with the store service.");
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching reviews: " + e.getMessage());
        }
    }
}
