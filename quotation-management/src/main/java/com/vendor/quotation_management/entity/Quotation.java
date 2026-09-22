package com.vendor.quotation_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quotations")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotation_id")
    private Long quotationId;

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private PurchaseRequest purchaseRequest;

    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id")
    private Vendor vendor;

    @Column(name = "quotation_date")
    private LocalDate quotationDate;

    @Column(name = "valid_until")
    private LocalDate validUntil;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "delivery_days")
    private Integer deliveryDays;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToOne(mappedBy = "quotation", cascade = CascadeType.ALL)
    private PurchaseOrder purchaseOrder;

    public Quotation() {
    }

    public Quotation(Long quotationId, PurchaseRequest purchaseRequest, Vendor vendor, LocalDate quotationDate,
            LocalDate validUntil, Integer quantity, Double unitPrice, Double discount, Double tax, Integer deliveryDays,
            Double totalAmount, String status) {
        this.quotationId = quotationId;
        this.purchaseRequest = purchaseRequest;
        this.vendor = vendor;
        this.quotationDate = quotationDate;
        this.validUntil = validUntil;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.tax = tax;
        this.deliveryDays = deliveryDays;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public LocalDate getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(LocalDate quotationDate) {
        this.quotationDate = quotationDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public String toString() {
        return "Quotation{quotationId=" + quotationId + ", totalAmount=" + totalAmount + ", status='" + status + "'}";
    }
}
