package com.royalpg.pgwebsite.repository;

import com.royalpg.pgwebsite.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
