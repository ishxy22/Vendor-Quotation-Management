package com.vendor.quotation_management.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "gstin")
    private String gstin;

    @Column(name = "category")
    private String category;

    @Column(name = "vendor_rating")
    private Double vendorRating;

    @Column(name = "verification_status")
    private String verificationStatus;

    @Column(name = "bank_details")
    private String bankDetails;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Quotation> quotations;

    public Vendor() {
    }

    public Vendor(Long vendorId, String vendorName, String email, String phone, String address, String gstin,
            String category, Double vendorRating, String verificationStatus, String bankDetails, String status) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gstin = gstin;
        this.category = category;
        this.vendorRating = vendorRating;
        this.verificationStatus = verificationStatus;
        this.bankDetails = bankDetails;
        this.status = status;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getVendorRating() {
        return vendorRating;
    }

    public void setVendorRating(Double vendorRating) {
        this.vendorRating = vendorRating;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }

    @Override
    public String toString() {
        return "Vendor{vendorId=" + vendorId + ", vendorName='" + vendorName + "', email='" + email + "'}";
    }
}
