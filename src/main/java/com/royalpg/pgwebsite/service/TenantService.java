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

    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));
    }

    public Tenant updateTenant(Long id, Tenant updatedTenant) {
        Tenant existingTenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));

        existingTenant.setName(updatedTenant.getName());
        existingTenant.setContactNo(updatedTenant.getContactNo());
        existingTenant.setGuardianName(updatedTenant.getGuardianName());
        existingTenant.setGuardianContactNo(updatedTenant.getGuardianContactNo());
        existingTenant.setRent(updatedTenant.getRent());
        existingTenant.setAdmissionDate(updatedTenant.getAdmissionDate());
        existingTenant.setAddress(updatedTenant.getAddress());
        existingTenant.setWork(updatedTenant.getWork());
        existingTenant.setBuilding(updatedTenant.getBuilding());

        return tenantRepository.save(existingTenant);
    }

    public void deleteTenant(Long id) {
        Tenant existingTenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));
        tenantRepository.delete(existingTenant);
    }

    public List<Tenant> search(String query) {
        return tenantRepository.searchTenants(query);
    }

    public List<Tenant> getTenantsByBuilding(String building) {
        return tenantRepository.findByBuilding(building);
    }


}
