package com.azbj.qc.det.frm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "OCP_POLICY_COVERS")
public class Rider {

    @Id
    @Column(name = "COVER_CODE", nullable = false)
    private String coverCode;

    @Column(name = "SUM_INSURED_WHOLE_COVER", nullable = false)
    private Double sumInsuredWholeCover;

    @Column(name = "BENEFIT_TERM", nullable = false)
    private Integer benefitTerm;

    @Column(name = "PREMIUM_TERM", nullable = false)
    private Integer premiumTerm;

    // Getters and Setters
    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public Double getSumInsuredWholeCover() {
        return sumInsuredWholeCover;
    }

    public void setSumInsuredWholeCover(Double sumInsuredWholeCover) {
        this.sumInsuredWholeCover = sumInsuredWholeCover;
    }

    public Integer getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(Integer benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public Integer getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(Integer premiumTerm) {
        this.premiumTerm = premiumTerm;
    }
}
