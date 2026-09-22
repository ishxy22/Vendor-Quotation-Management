package com.vendor.quotation_management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vendor.quotation_management.entity.Vendor;
import com.vendor.quotation_management.repository.VendorRepository;

@RestController
public class VendorController {

    private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    private VendorRepository repo;

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return repo.findAll();
    }

    @GetMapping("/vendor/{id}")
    public Object getVendorById(@PathVariable Long id) {
        Vendor vendor = repo.findById(id).orElse(null);
        if (vendor == null) {
            return "Vendor Not Found";
        }
        logger.info("Vendor found: {}", vendor);
        return vendor;
    }

    @PostMapping("/addvendor")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        logger.info("Vendor Saved Successfully: {}", vendor);
        return repo.save(vendor);
    }

    @DeleteMapping("/vendor/{id}")
    public String deleteVendor(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return "Vendor Not Found";
        }
        repo.deleteById(id);
        logger.info("Vendor deleted successfully with id: {}", id);
        return "Vendor deleted successfully";
    }

    @PutMapping("/updatevendor/{id}")
    public String updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        if (!repo.existsById(id)) {
            return "Vendor not found";
        }
        vendor.setVendorId(id);
        repo.save(vendor);
        logger.info("Vendor updated successfully: {}", vendor);
        return "Vendor updated successfully";
    }
}
