package com.project.code.Controller;

import com.project.code.Model.OrderDetails;
import com.project.code.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/validate/{storeId}")
    public ResponseEntity<String> validateStore(@PathVariable Long storeId) {
        try {
            boolean exists = storeId != null && storeId > 0;
            if (exists) {
                return ResponseEntity.ok("Store exists and is valid.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error validating store: " + e.getMessage());
        }
    }

    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDetails orderDetails) {
        try {
            OrderDetails savedOrder = orderService.saveOrder(orderDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to place order: " + e.getMessage());
        }
    }
}
