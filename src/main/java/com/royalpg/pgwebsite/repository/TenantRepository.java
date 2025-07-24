package com.royalpg.pgwebsite.repository;

import com.royalpg.pgwebsite.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query("SELECT t FROM Tenant t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(t.guardianName) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR t.contactNo LIKE CONCAT('%', :query, '%')")
    List<Tenant> searchTenants(@Param("query") String query);
}
