package com.vendor.quotation_management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vendor.quotation_management.entity.Quotation;
import com.vendor.quotation_management.repository.QuotationRepository;

@RestController
public class QuotationController {

    private static final Logger logger = LoggerFactory.getLogger(QuotationController.class);

    @Autowired
    private QuotationRepository repo;

    @GetMapping("/quotations")
    public List<Quotation> getAllQuotations() {
        return repo.findAll();
    }

    @GetMapping("/quotation/{id}")
    public Object getQuotationById(@PathVariable Long id) {
        Quotation quotation = repo.findById(id).orElse(null);
        if (quotation == null) {
            return "Quotation Not Found";
        }
        logger.info("Quotation found: {}", quotation);
        return quotation;
    }

    @PostMapping("/addquotation")
    public Quotation addQuotation(@RequestBody Quotation quotation) {
        logger.info("Quotation Saved Successfully: {}", quotation);
        return repo.save(quotation);
    }

    @DeleteMapping("/quotation/{id}")
    public String deleteQuotation(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return "Quotation Not Found";
        }
        repo.deleteById(id);
        logger.info("Quotation deleted successfully with id: {}", id);
        return "Quotation deleted successfully";
    }

    @PutMapping("/updatequotation/{id}")
    public String updateQuotation(@PathVariable Long id, @RequestBody Quotation quotation) {
        if (!repo.existsById(id)) {
            return "Quotation not found";
        }
        quotation.setQuotationId(id);
        repo.save(quotation);
        logger.info("Quotation updated successfully: {}", quotation);
        return "Quotation updated successfully";
    }
}
