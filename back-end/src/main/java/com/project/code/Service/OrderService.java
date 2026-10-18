package com.project.code.Service;

import com.project.code.Model.OrderDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Transactional
    public OrderDetails saveOrder(OrderDetails orderDetails) {
        return orderDetails;
    }
}
