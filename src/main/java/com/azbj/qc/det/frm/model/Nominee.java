package com.azbj.qc.det.frm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nominee_table")
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contract_id", nullable = false)
    private Long contractId;

    @Column(name = "version_no", nullable = false)
    private Long versionNo;

    @Column(name = "object_id", nullable = false)
    private Long objectId;

    @Column(name = "action_code", nullable = false)
    private String actionCode;

    @Column(name = "top_indicator", nullable = false)
    private char topIndicator;

    @Column(name = "partition_no", nullable = false)
    private Long partitionNo;

    @Column(name = "cover_code", nullable = false)
    private String coverCode;

    @Column(name = "cover_no", nullable = false)
    private Long coverNo;

    @Column(name = "previous_version")
    private Long previousVersion;

    @Column(name = "reversing_version")
    private Long reversingVersion;

    @Column(name = "sum_insured_whole_cover")
    private Long sumInsuredWholeCover;

    @Column(name = "sum_insured_company_share")
    private Long sumInsuredCompanyShare;

    @Column(name = "ftpremium_or_whole_cover")
    private Long ftpremiumOrWholeCover;

    @Column(name = "ftpremium_sys_company_share")
    private Long ftpremiumSysCompanyShare;

    @Column(name = "agent_commission_whole_cover")
    private Long agentCommissionWholeCover;

    @Column(name = "agent_commission_company_share")
    private Long agentCommissionCompanyShare;

    @Column(name = "share_portion")
    private Long sharePortion;

    @Column(name = "cvc_code")
    private String cvcCode;

    @Column(name = "surcharge_discount")
    private Long surchargeDiscount;

    @Column(name = "reinsurable_risk_amount")
    private Long reinsurableRiskAmount;

    @Column(name = "pcov_contract_id")
    private Long pcovContractId;

    @Column(name = "pcov_partition_no")
    private Long pcovPartitionNo;

    @Column(name = "pcov_cover_code")
    private String pcovCoverCode;

    @Column(name = "pcov_cover_no")
    private Long pcovCoverNo;

    @Column(name = "mis_user", nullable = false)
    private String misUser;

    @Column(name = "scan_date")
    @Temporal(TemporalType.DATE)
    private Date scanDate;

    @Column(name = "flag")
    private Integer flag;

    @Column(name = "insert_date")
    @Temporal(TemporalType.DATE)
    private Date insertDate;

    @Column(name = "flag1")
    private String flag1;

    @Column(name = "description", insertable = false, updatable = false)
    private String description;

    @Column(name = "opus_value", insertable = false, updatable = false)
    private String opusValue;

    @Column(name = "ci_nominee", nullable = false)
    private char ciNominee = 'N';

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public char getTopIndicator() {
        return topIndicator;
    }

    public void setTopIndicator(char topIndicator) {
        this.topIndicator = topIndicator;
    }

    public Long getPartitionNo() {
        return partitionNo;
    }

    public void setPartitionNo(Long partitionNo) {
        this.partitionNo = partitionNo;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public Long getCoverNo() {
        return coverNo;
    }

    public void setCoverNo(Long coverNo) {
        this.coverNo = coverNo;
    }

    public Long getPreviousVersion() {
        return previousVersion;
    }

    public void setPreviousVersion(Long previousVersion) {
        this.previousVersion = previousVersion;
    }

    public Long getReversingVersion() {
        return reversingVersion;
    }

    public void setReversingVersion(Long reversingVersion) {
        this.reversingVersion = reversingVersion;
    }

    public Long getSumInsuredWholeCover() {
        return sumInsuredWholeCover;
    }

    public void setSumInsuredWholeCover(Long sumInsuredWholeCover) {
        this.sumInsuredWholeCover = sumInsuredWholeCover;
    }

    public Long getSumInsuredCompanyShare() {
        return sumInsuredCompanyShare;
    }

    public void setSumInsuredCompanyShare(Long sumInsuredCompanyShare) {
        this.sumInsuredCompanyShare = sumInsuredCompanyShare;
    }

    public Long getFtpremiumOrWholeCover() {
        return ftpremiumOrWholeCover;
    }

    public void setFtpremiumOrWholeCover(Long ftpremiumOrWholeCover) {
        this.ftpremiumOrWholeCover = ftpremiumOrWholeCover;
    }

    public Long getFtpremiumSysCompanyShare() {
        return ftpremiumSysCompanyShare;
    }

    public void setFtpremiumSysCompanyShare(Long ftpremiumSysCompanyShare) {
        this.ftpremiumSysCompanyShare = ftpremiumSysCompanyShare;
    }

    public Long getAgentCommissionWholeCover() {
        return agentCommissionWholeCover;
    }

    public void setAgentCommissionWholeCover(Long agentCommissionWholeCover) {
        this.agentCommissionWholeCover = agentCommissionWholeCover;
    }

    public Long getAgentCommissionCompanyShare() {
        return agentCommissionCompanyShare;
    }

    public void setAgentCommissionCompanyShare(Long agentCommissionCompanyShare) {
        this.agentCommissionCompanyShare = agentCommissionCompanyShare;
    }

    public Long getSharePortion() {
        return sharePortion;
    }

    public void setSharePortion(Long sharePortion) {
        this.sharePortion = sharePortion;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(String cvcCode) {
        this.cvcCode = cvcCode;
    }

    public Long getSurchargeDiscount() {
        return surchargeDiscount;
    }

    public void setSurchargeDiscount(Long surchargeDiscount) {
        this.surchargeDiscount = surchargeDiscount;
    }

    public Long getReinsurableRiskAmount() {
        return reinsurableRiskAmount;
    }

    public void setReinsurableRiskAmount(Long reinsurableRiskAmount) {
        this.reinsurableRiskAmount = reinsurableRiskAmount;
    }

    public Long getPcovContractId() {
        return pcovContractId;
    }

    public void setPcovContractId(Long pcovContractId) {
        this.pcovContractId = pcovContractId;
    }

    public Long getPcovPartitionNo() {
        return pcovPartitionNo;
    }

    public void setPcovPartitionNo(Long pcovPartitionNo) {
        this.pcovPartitionNo = pcovPartitionNo;
    }

    public String getPcovCoverCode() {
        return pcovCoverCode;
    }

    public void setPcovCoverCode(String pcovCoverCode) {
        this.pcovCoverCode = pcovCoverCode;
    }

    public Long getPcovCoverNo() {
        return pcovCoverNo;
    }

    public void setPcovCoverNo(Long pcovCoverNo) {
        this.pcovCoverNo = pcovCoverNo;
    }

    public String getMisUser() {
        return misUser;
    }

    public void setMisUser(String misUser) {
        this.misUser = misUser;
    }

    public Date getScanDate() {
        return scanDate;
    }

    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getDescription() {
        return description;
    }

    public String getOpusValue() {
        return opusValue;
    }

    public char getCiNominee() {
        return ciNominee;
    }

    public void setCiNominee(char ciNominee) {
        this.ciNominee = ciNominee;
    }
}
