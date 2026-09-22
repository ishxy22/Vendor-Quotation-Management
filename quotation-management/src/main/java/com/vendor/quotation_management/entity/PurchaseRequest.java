package com.vendor.quotation_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "purchase_requests")
public class PurchaseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "department")
    private String department;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "total_estimated_cost")
    private Double totalEstimatedCost;

    @JsonIgnore
    @OneToMany(mappedBy = "purchaseRequest", cascade = CascadeType.ALL)
    private List<Quotation> quotations;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Long requestId, User user, Product product, LocalDate requestDate, LocalDate requiredDate,
            String department, String purpose, Integer quantity, String status, Double totalEstimatedCost) {
        this.requestId = requestId;
        this.user = user;
        this.product = product;
        this.requestDate = requestDate;
        this.requiredDate = requiredDate;
        this.department = department;
        this.purpose = purpose;
        this.quantity = quantity;
        this.status = status;
        this.totalEstimatedCost = totalEstimatedCost;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalEstimatedCost() {
        return totalEstimatedCost;
    }

    public void setTotalEstimatedCost(Double totalEstimatedCost) {
        this.totalEstimatedCost = totalEstimatedCost;
    }

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{requestId=" + requestId + ", status='" + status + "', quantity=" + quantity + "}";
    }
}
