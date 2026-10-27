package com.vendor.quotation_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vendor.quotation_management.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
