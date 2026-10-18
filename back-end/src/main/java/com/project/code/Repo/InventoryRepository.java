package com.project.code.Repo;

import com.project.code.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("SELECT i FROM Inventory i WHERE i.product.id = :productId AND i.store.id = :storeId")
    Optional<Inventory> findByProductAndStoreIds(@Param("productId") Long productId, @Param("storeId") Long storeId);

    @Query("SELECT i FROM Inventory i WHERE i.store.id = :storeId")
    List<Inventory> findAllByStoreId(@Param("storeId") Long storeId);
}
