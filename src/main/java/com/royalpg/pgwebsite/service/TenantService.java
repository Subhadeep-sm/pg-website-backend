package com.royalpg.pgwebsite.service;

import com.royalpg.pgwebsite.entity.Tenant;
import com.royalpg.pgwebsite.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.royalpg.pgwebsite.entity.Tenant;

import java.util.List;

@Service
public class TenantService  {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }
}
