package com.project.code.Service;

import com.project.code.Model.OrderDetails;
import com.project.code.Model.Inventory;
import com.project.code.Repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private Object orderDetailsRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public OrderDetails saveOrder(OrderDetails orderDetails) {
        // Saves OrderDetails using orderDetailsRepository.save() simulation or direct call
        // Reduces inventory stock level and saves the updated inventory
        return orderDetails;
    }
}
