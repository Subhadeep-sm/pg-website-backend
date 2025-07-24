package com.royalpg.pgwebsite.controller;

import com.royalpg.pgwebsite.entity.Tenant;
import com.royalpg.pgwebsite.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "*") // Allow frontend to access
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return tenantService.saveTenant(tenant);
    }

    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        return new ResponseEntity<>(tenantService.getAllTenants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        return new ResponseEntity<>(tenantService.getTenantById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @RequestBody Tenant updatedTenant) {
        Tenant tenant = tenantService.updateTenant(id, updatedTenant);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
        return ResponseEntity.ok("Tenant deleted successfully with id: " + id);
    }
}
