package com.azbj.qc.det.frm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "azbj_phub_qc_detail")
public class QCSubmit {

    @Id
    private String policyNo;
    private String contractId;
    private String descType;
    private String opusValue;
    private String correctFlg;
    private String insUser;
    private Date insDate;
    private String flg;
    private String errStatus;
    private String flg1;
    private String flg2;
    private String flg3;
    private String flg4;
    private String flg5;
    private String flg6;

    // Getters and Setters

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getDescType() {
        return descType;
    }

    public void setDescType(String descType) {
        this.descType = descType;
    }

    public String getOpusValue() {
        return opusValue;
    }

    public void setOpusValue(String opusValue) {
        this.opusValue = opusValue;
    }

    public String getCorrectFlg() {
        return correctFlg;
    }

    public void setCorrectFlg(String correctFlg) {
        this.correctFlg = correctFlg;
    }

    public String getInsUser() {
        return insUser;
    }

    public void setInsUser(String insUser) {
        this.insUser = insUser;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg;
    }

    public String getErrStatus() {
        return errStatus;
    }

    public void setErrStatus(String errStatus) {
        this.errStatus = errStatus;
    }

    public String getFlg1() {
        return flg1;
    }

    public void setFlg1(String flg1) {
        this.flg1 = flg1;
    }

    public String getFlg2() {
        return flg2;
    }

    public void setFlg2(String flg2) {
        this.flg2 = flg2;
    }

    public String getFlg3() {
        return flg3;
    }

    public void setFlg3(String flg3) {
        this.flg3 = flg3;
    }

    public String getFlg4() {
        return flg4;
    }

    public void setFlg4(String flg4) {
        this.flg4 = flg4;
    }

    public String getFlg5() {
        return flg5;
    }

    public void setFlg5(String flg5) {
        this.flg5 = flg5;
    }

    public String getFlg6() {
        return flg6;
    }

    public void setFlg6(String flg6) {
        this.flg6 = flg6;
    }
}
