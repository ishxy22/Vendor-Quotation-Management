package com.vendor.quotation_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "department")
    private String department;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PurchaseRequest> purchaseRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "approver", cascade = CascadeType.ALL)
    private List<PurchaseOrder> approvedOrders;

    public User() {
    }

    public User(Long userId, String name, String email, String password, String role, String department, String phone,
            String status, LocalDate createdDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.phone = phone;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<PurchaseRequest> getPurchaseRequests() {
        return purchaseRequests;
    }

    public void setPurchaseRequests(List<PurchaseRequest> purchaseRequests) {
        this.purchaseRequests = purchaseRequests;
    }

    public List<PurchaseOrder> getApprovedOrders() {
        return approvedOrders;
    }

    public void setApprovedOrders(List<PurchaseOrder> approvedOrders) {
        this.approvedOrders = approvedOrders;
    }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", name='" + name + "', email='" + email + "', role='" + role + "'}";
    }
}
