package com.vendor.quotation_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_id")
    private Long poId;

    @OneToOne
    @JoinColumn(name = "quotation_id", referencedColumnName = "quotation_id")
    private Quotation quotation;

    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "user_id")
    private User approver;

    @Column(name = "po_date")
    private LocalDate poDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "tax_amount")
    private Double taxAmount;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "final_amount")
    private Double finalAmount;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "order_status")
    private String orderStatus;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long poId, Quotation quotation, User approver, LocalDate poDate, LocalDate deliveryDate,
            Double subtotal, Double taxAmount, Double discount, Double finalAmount, String paymentStatus,
            String paymentMethod, LocalDate paymentDate, String orderStatus) {
        this.poId = poId;
        this.quotation = quotation;
        this.approver = approver;
        this.poDate = poDate;
        this.deliveryDate = deliveryDate;
        this.subtotal = subtotal;
        this.taxAmount = taxAmount;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.orderStatus = orderStatus;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public LocalDate getPoDate() {
        return poDate;
    }

    public void setPoDate(LocalDate poDate) {
        this.poDate = poDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{poId=" + poId + ", finalAmount=" + finalAmount + ", orderStatus='" + orderStatus + "'}";
    }
}
