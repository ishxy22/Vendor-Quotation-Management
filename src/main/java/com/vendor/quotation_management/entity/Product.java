package com.vendor.quotation_management.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "unit")
    private String unit;

    @Column(name = "estimated_price")
    private Double estimatedPrice;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PurchaseRequest> purchaseRequests;

    public Product() {
    }

    public Product(Long productId, String productName, String description, String category, String unit,
            Double estimatedPrice) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.unit = unit;
        this.estimatedPrice = estimatedPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public List<PurchaseRequest> getPurchaseRequests() {
        return purchaseRequests;
    }

    public void setPurchaseRequests(List<PurchaseRequest> purchaseRequests) {
        this.purchaseRequests = purchaseRequests;
    }

    @Override
    public String toString() {
        return "Product{productId=" + productId + ", productName='" + productName + "', estimatedPrice="
                + estimatedPrice + "}";
    }
}
