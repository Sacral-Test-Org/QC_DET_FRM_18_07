package com.azbj.qc.det.frm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    @Column(name = "supervisor_id", nullable = false, length = 10)
    private String supervisorId;

    @Column(name = "password", nullable = false, length = 10)
    private String password;

    @Column(name = "comments", length = 500)
    private String comments;

    // Default constructor
    public Authentication() {
    }

    // Parameterized constructor
    public Authentication(String supervisorId, String password, String comments) {
        this.supervisorId = supervisorId;
        this.password = password;
        this.comments = comments;
    }

    // Getters and Setters
    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId.toUpperCase(); // Ensure uppercase
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if (comments.length() <= 500) {
            this.comments = comments;
        } else {
            throw new IllegalArgumentException("Comments cannot exceed 500 characters");
        }
    }
}
