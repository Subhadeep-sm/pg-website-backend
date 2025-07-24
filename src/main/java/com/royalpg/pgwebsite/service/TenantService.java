package com.royalpg.pgwebsite.service;

import com.royalpg.pgwebsite.entity.Tenant;
import com.royalpg.pgwebsite.repository.TenantRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.royalpg.pgwebsite.entity.Tenant;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
        existingTenant.setAdmissionDate(updatedTenant.getAdmissionDate());
        existingTenant.setWorkPlace(updatedTenant.getWorkPlace());
        existingTenant.setAadhaarNo(updatedTenant.getAadhaarNo());
        existingTenant.setBuilding(updatedTenant.getBuilding());
        existingTenant.setRoomNo(updatedTenant.getRoomNo());
        existingTenant.setRoomType(updatedTenant.getRoomType());

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

    public ByteArrayOutputStream exportTenantsToExcel() throws IOException {
        List<Tenant> tenants = tenantRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Tenants");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {
                "ID", "Name", "Contact No", "Guardian Name", "Guardian Contact No",
                "Admission Date", "Work Place", "Aadhaar No", "Building", "Room No", "Room Type"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Fill data rows
        int rowNum = 1;
        for (Tenant tenant : tenants) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tenant.getId());
            row.createCell(1).setCellValue(tenant.getName());
            row.createCell(2).setCellValue(tenant.getContactNo());
            row.createCell(3).setCellValue(tenant.getGuardianName());
            row.createCell(4).setCellValue(tenant.getGuardianContactNo());
            row.createCell(5).setCellValue(tenant.getAdmissionDate() != null ? tenant.getAdmissionDate().toString() : "");
            row.createCell(6).setCellValue(tenant.getWorkPlace());
            row.createCell(7).setCellValue(tenant.getAadhaarNo());
            row.createCell(8).setCellValue(tenant.getBuilding());
            row.createCell(9).setCellValue(tenant.getRoomNo());
            row.createCell(10).setCellValue(tenant.getRoomType());
        }

        // Autosize columns for better readability
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out;
    }

}
