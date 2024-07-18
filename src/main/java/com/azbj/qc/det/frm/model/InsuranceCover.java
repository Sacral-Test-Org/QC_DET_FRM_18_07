package com.azbj.qc.det.frm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "insurance_covers")
public class InsuranceCover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_id", nullable = false)
    private Long contractId;

    @Column(name = "version_no", nullable = false)
    private Integer versionNo;

    @Column(name = "object_id", nullable = false)
    private Long objectId;

    @Column(name = "action_code", nullable = false)
    private String actionCode;

    @Column(name = "top_indicator", nullable = false)
    private String topIndicator;

    @Column(name = "partition_no", nullable = false)
    private Integer partitionNo;

    @Column(name = "cover_code", nullable = false)
    private String coverCode;

    @Column(name = "cover_no", nullable = false)
    private Integer coverNo;

    @Column(name = "previous_version")
    private Integer previousVersion;

    @Column(name = "reversing_version")
    private Integer reversingVersion;

    @Column(name = "sum_insured_whole_cover")
    private Double sumInsuredWholeCover;

    @Column(name = "sum_insured_company_share")
    private Double sumInsuredCompanyShare;

    @Column(name = "full_term_premium_whole_cover")
    private Double fullTermPremiumWholeCover;

    @Column(name = "full_term_premium_company_share")
    private Double fullTermPremiumCompanyShare;

    @Column(name = "agent_commission_whole_cover")
    private Double agentCommissionWholeCover;

    @Column(name = "agent_commission_company_share")
    private Double agentCommissionCompanyShare;

    @Column(name = "share_portion")
    private Double sharePortion;

    @Column(name = "cvc_code")
    private String cvcCode;

    @Column(name = "surcharge_discount")
    private Double surchargeDiscount;

    @Column(name = "reinsurable_risk_amount")
    private Double reinsurableRiskAmount;

    @Column(name = "pcov_contract_id")
    private Long pcovContractId;

    @Column(name = "pcov_partition_no")
    private Integer pcovPartitionNo;

    @Column(name = "pcov_cover_code")
    private String pcovCoverCode;

    @Column(name = "pcov_cover_no")
    private Integer pcovCoverNo;

    // Rider Information
    @Column(name = "benefit_term")
    private Integer benefitTerm;

    @Column(name = "premium_term")
    private Integer premiumTerm;

    // QC Details
    @Column(name = "qc_status")
    private String qcStatus;

    @Column(name = "qc_substatus")
    private String qcSubstatus;

    // Control Functionalities
    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "substatus")
    private String substatus;

    @Column(name = "nominee_info")
    private String nomineeInfo;

    @Column(name = "images")
    private String images;

    @Column(name = "enriched_data")
    private String enrichedData;

    @Column(name = "checkboxes")
    private String checkboxes;

    @Column(name = "display_items")
    private String displayItems;

    @Column(name = "comments")
    private String comments;

    @Column(name = "qc_process_status")
    private String qcProcessStatus;

    // Reason Of Skip Dropdown
    @Column(name = "skip_reason")
    private String skipReason;

    // Nominee Information
    @Column(name = "nominee_name")
    private String nomineeName;

    @Column(name = "nominee_dob")
    private Date nomineeDob;

    @Column(name = "nominee_relation")
    private String nomineeRelation;

    @Column(name = "nominee_gender")
    private String nomineeGender;

    // Fund Details
    @Column(name = "fund_id")
    private String fundId;

    @Column(name = "fund_description")
    private String fundDescription;

    @Column(name = "apportionment")
    private Double apportionment;

    // Underwriting Comments
    @OneToMany(mappedBy = "insuranceCover", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UnderwritingComment> underwritingComments;

    // Dispatch Details
    @Column(name = "ship_no")
    private String shipNo;

    @Column(name = "awb_no")
    private String awbNo;

    @Column(name = "del_type")
    private String delType;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "des_type")
    private String desType;

    @Column(name = "pick_req_no")
    private String pickReqNo;

    @Column(name = "pr_ref")
    private String prRef;

    @Column(name = "consignee_name")
    private String consigneeName;

    @Column(name = "con_add1")
    private String conAdd1;

    @Column(name = "con_add2")
    private String conAdd2;

    @Column(name = "con_add3")
    private String conAdd3;

    @Column(name = "con_city")
    private String conCity;

    @Column(name = "con_state")
    private String conState;

    @Column(name = "des_pin")
    private String desPin;

    @Column(name = "wt")
    private Double wt;

    @Column(name = "gm")
    private String gm;

    @Column(name = "ven_code")
    private String venCode;

    // Physical Copy Status
    @Column(name = "physical_copy_status")
    private String physicalCopyStatus;

    // Policy Reference Validation and Processing
    @Column(name = "policy_reference_number")
    private String policyReferenceNumber;

    @Column(name = "beneficiary_dob")
    private Date beneficiaryDob;

    @Column(name = "beneficiary_name")
    private String beneficiaryName;

    @Column(name = "beneficiary_relation")
    private String beneficiaryRelation;

    @Column(name = "application_number")
    private String applicationNumber;

    @Column(name = "appointee_gender")
    private String appointeeGender;

    // QC Block
    @Column(name = "qc_block")
    private String qcBlock;

    // File Path
    @Column(name = "file_path")
    private String filePath;

    // Getters and Setters
    // (Omitted for brevity, but should be included for all fields)
}
