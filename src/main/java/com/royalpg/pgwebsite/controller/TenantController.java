package com.royalpg.pgwebsite.controller;

import com.royalpg.pgwebsite.entity.Tenant;
import com.royalpg.pgwebsite.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
//@CrossOrigin(origins = "*") // Allow frontend to access
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

    @GetMapping("/search-any")
    public List<Tenant> searchAny(@RequestParam String query) {
        return tenantService.search(query);
    }

    @GetMapping("/by-building/{building}")
    public ResponseEntity<List<Tenant>> getTenantsByBuilding(@PathVariable String building) {
        List<Tenant> tenants = tenantService.getTenantsByBuilding(building);
        return ResponseEntity.ok(tenants);
    }

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadTenantsExcel() throws IOException {
        ByteArrayOutputStream out = tenantService.exportTenantsToExcel();
        ByteArrayResource resource = new ByteArrayResource(out.toByteArray());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=tenants.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .contentLength(resource.contentLength())
                .body(resource);
    }




}
