package com.vendor.quotation_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vendor.quotation_management.entity.PurchaseRequest;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {
}
