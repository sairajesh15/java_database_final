package com.project.code.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Object, Long> {

    List<Object> findByCategory(String category);

    @Query("SELECT p FROM Product p JOIN p.store s WHERE s.id = :storeId AND p.category = :category")
    List<Object> findByStoreIdAndCategory(@Param("storeId") Long storeId, @Param("category") String category);
}
