package com.vendor.quotation_management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vendor.quotation_management.entity.PurchaseOrder;
import com.vendor.quotation_management.repository.PurchaseOrderRepository;

@RestController
public class PurchaseOrderController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Autowired
    private PurchaseOrderRepository repo;

    @GetMapping("/purchaseorders")
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return repo.findAll();
    }

    @GetMapping("/purchaseorder/{id}")
    public Object getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrder order = repo.findById(id).orElse(null);
        if (order == null) {
            return "Purchase Order Not Found";
        }
        logger.info("Purchase Order found: {}", order);
        return order;
    }

    @PostMapping("/addpurchaseorder")
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder order) {
        logger.info("Purchase Order Saved Successfully: {}", order);
        return repo.save(order);
    }

    @DeleteMapping("/purchaseorder/{id}")
    public String deletePurchaseOrder(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return "Purchase Order Not Found";
        }
        repo.deleteById(id);
        logger.info("Purchase Order deleted successfully with id: {}", id);
        return "Purchase Order deleted successfully";
    }

    @PutMapping("/updatepurchaseorder/{id}")
    public String updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrder order) {
        if (!repo.existsById(id)) {
            return "Purchase Order not found";
        }
        order.setPoId(id);
        repo.save(order);
        logger.info("Purchase Order updated successfully: {}", order);
        return "Purchase Order updated successfully";
    }
}
