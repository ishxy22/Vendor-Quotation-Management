package com.vendor.quotation_management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vendor.quotation_management.entity.PurchaseRequest;
import com.vendor.quotation_management.repository.PurchaseRequestRepository;

@RestController
public class PurchaseRequestController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequestController.class);

    @Autowired
    private PurchaseRequestRepository repo;

    @GetMapping("/purchaserequests")
    public List<PurchaseRequest> getAllPurchaseRequests() {
        return repo.findAll();
    }

    @GetMapping("/purchaserequest/{id}")
    public Object getPurchaseRequestById(@PathVariable Long id) {
        PurchaseRequest request = repo.findById(id).orElse(null);
        if (request == null) {
            return "Purchase Request Not Found";
        }
        logger.info("Purchase Request found: {}", request);
        return request;
    }

    @PostMapping("/addpurchaserequest")
    public PurchaseRequest addPurchaseRequest(@RequestBody PurchaseRequest request) {
        logger.info("Purchase Request Saved Successfully: {}", request);
        return repo.save(request);
    }

    @DeleteMapping("/purchaserequest/{id}")
    public String deletePurchaseRequest(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return "Purchase Request Not Found";
        }
        repo.deleteById(id);
        logger.info("Purchase Request deleted successfully with id: {}", id);
        return "Purchase Request deleted successfully";
    }

    @PutMapping("/updatepurchaserequest/{id}")
    public String updatePurchaseRequest(@PathVariable Long id, @RequestBody PurchaseRequest request) {
        if (!repo.existsById(id)) {
            return "Purchase Request not found";
        }
        request.setRequestId(id);
        repo.save(request);
        logger.info("Purchase Request updated successfully: {}", request);
        return "Purchase Request updated successfully";
    }
}
