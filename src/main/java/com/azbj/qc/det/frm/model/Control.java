package com.azbj.qc.det.frm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "CONTROL")
public class Control {

    @Id
    @Column(name = "POLICY_REF")
    private String policyRef;

    @Column(name = "FLG")
    private String flg;

    @Column(name = "QC_STATUS")
    private String qcStatus;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SUBSTATUS")
    private String substatus;

    @Column(name = "NOMINEE_INFO")
    private String nomineeInfo;

    @Column(name = "IMAGES")
    private String images;

    @Column(name = "ENRICHED_DATA")
    private String enrichedData;

    @Column(name = "CHECKBOXES")
    private String checkboxes;

    @Column(name = "DISPLAY_ITEMS")
    private String displayItems;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "QC_PROCESS_STATUS")
    private String qcProcessStatus;

    // Getters and Setters

    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubstatus() {
        return substatus;
    }

    public void setSubstatus(String substatus) {
        this.substatus = substatus;
    }

    public String getNomineeInfo() {
        return nomineeInfo;
    }

    public void setNomineeInfo(String nomineeInfo) {
        this.nomineeInfo = nomineeInfo;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getEnrichedData() {
        return enrichedData;
    }

    public void setEnrichedData(String enrichedData) {
        this.enrichedData = enrichedData;
    }

    public String getCheckboxes() {
        return checkboxes;
    }

    public void setCheckboxes(String checkboxes) {
        this.checkboxes = checkboxes;
    }

    public String getDisplayItems() {
        return displayItems;
    }

    public void setDisplayItems(String displayItems) {
        this.displayItems = displayItems;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getQcProcessStatus() {
        return qcProcessStatus;
    }

    public void setQcProcessStatus(String qcProcessStatus) {
        this.qcProcessStatus = qcProcessStatus;
    }
}
