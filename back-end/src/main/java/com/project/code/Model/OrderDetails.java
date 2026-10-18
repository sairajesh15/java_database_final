package com.project.code.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    /**
     * The store where the order was placed.
     */
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    /**
     * The date and time when the order was placed.
     */
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    private Integer quantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
