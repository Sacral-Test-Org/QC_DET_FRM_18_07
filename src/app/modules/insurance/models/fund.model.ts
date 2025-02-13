export class Fund {
  CONTRACT_ID: number;
  VERSION_NO: number;
  OBJECT_ID: number;
  ACTION_CODE: string;
  TOP_INDICATOR: string;
  PARTITION_NO: number;
  COVER_CODE: string;
  COVER_NO: number;
  PREVIOUS_VERSION?: number;
  REVERSING_VERSION?: number;
  SUM_INSURED_WHOLE_COVER?: number;
  SUM_INSURED_WHOLE_COVER_SWF?: string;
  SUM_INSURED_COMPANY_SHARE?: number;
  SUM_INSURED_COMPANY_SHARE_SWF?: string;
  FTPREMIUM_OR_WHOLE_COVER?: number;
  FTPREMIUM_OR_WHOLE_COVER_SWF?: string;
  FTPREMIUM_SYS_COMPANY_SHARE?: number;
  FTPREMIUM_SYS_COMP_SHARE_SWF?: string;
  AGENT_COMMISSION_WHOLE_COVER?: number;
  AGENT_COMMISSION_WHOLE_COV_SWF?: string;
  AGENT_COMMISSION_COMPANY_SHARE?: number;
  AGENT_COMMISSION_COM_SHARE_SWF?: string;
  SHARE_PORTION?: number;
  CVC_CODE?: string;
  SURCHARGE_DISCOUNT?: number;
  FTPREMIUM_OR_COMPANY_SHARE?: number;
  FTPREMIUM_OR_COMPANY_SHARE_SWF?: string;
  FTPREMIUM_SYS_WHOLE_COVER?: number;
  FTPREMIUM_SYS_WHOLE_COVER_SWF?: string;
  REINSURABLE_RISK_AMOUNT?: number;
  REINSURABLE_RISK_AMOUNT_SWF?: string;
  PCOV_CONTRACT_ID?: number;
  PCOV_PARTITION_NO?: number;
  PCOV_COVER_CODE?: string;
  PCOV_COVER_NO?: number;

  constructor(
    CONTRACT_ID: number,
    VERSION_NO: number,
    OBJECT_ID: number,
    ACTION_CODE: string,
    TOP_INDICATOR: string,
    PARTITION_NO: number,
    COVER_CODE: string,
    COVER_NO: number,
    PREVIOUS_VERSION?: number,
    REVERSING_VERSION?: number,
    SUM_INSURED_WHOLE_COVER?: number,
    SUM_INSURED_WHOLE_COVER_SWF?: string,
    SUM_INSURED_COMPANY_SHARE?: number,
    SUM_INSURED_COMPANY_SHARE_SWF?: string,
    FTPREMIUM_OR_WHOLE_COVER?: number,
    FTPREMIUM_OR_WHOLE_COVER_SWF?: string,
    FTPREMIUM_SYS_COMPANY_SHARE?: number,
    FTPREMIUM_SYS_COMP_SHARE_SWF?: string,
    AGENT_COMMISSION_WHOLE_COVER?: number,
    AGENT_COMMISSION_WHOLE_COV_SWF?: string,
    AGENT_COMMISSION_COMPANY_SHARE?: number,
    AGENT_COMMISSION_COM_SHARE_SWF?: string,
    SHARE_PORTION?: number,
    CVC_CODE?: string,
    SURCHARGE_DISCOUNT?: number,
    FTPREMIUM_OR_COMPANY_SHARE?: number,
    FTPREMIUM_OR_COMPANY_SHARE_SWF?: string,
    FTPREMIUM_SYS_WHOLE_COVER?: number,
    FTPREMIUM_SYS_WHOLE_COVER_SWF?: string,
    REINSURABLE_RISK_AMOUNT?: number,
    REINSURABLE_RISK_AMOUNT_SWF?: string,
    PCOV_CONTRACT_ID?: number,
    PCOV_PARTITION_NO?: number,
    PCOV_COVER_CODE?: string,
    PCOV_COVER_NO?: number
  ) {
    this.CONTRACT_ID = CONTRACT_ID;
    this.VERSION_NO = VERSION_NO;
    this.OBJECT_ID = OBJECT_ID;
    this.ACTION_CODE = ACTION_CODE;
    this.TOP_INDICATOR = TOP_INDICATOR;
    this.PARTITION_NO = PARTITION_NO;
    this.COVER_CODE = COVER_CODE;
    this.COVER_NO = COVER_NO;
    this.PREVIOUS_VERSION = PREVIOUS_VERSION;
    this.REVERSING_VERSION = REVERSING_VERSION;
    this.SUM_INSURED_WHOLE_COVER = SUM_INSURED_WHOLE_COVER;
    this.SUM_INSURED_WHOLE_COVER_SWF = SUM_INSURED_WHOLE_COVER_SWF;
    this.SUM_INSURED_COMPANY_SHARE = SUM_INSURED_COMPANY_SHARE;
    this.SUM_INSURED_COMPANY_SHARE_SWF = SUM_INSURED_COMPANY_SHARE_SWF;
    this.FTPREMIUM_OR_WHOLE_COVER = FTPREMIUM_OR_WHOLE_COVER;
    this.FTPREMIUM_OR_WHOLE_COVER_SWF = FTPREMIUM_OR_WHOLE_COVER_SWF;
    this.FTPREMIUM_SYS_COMPANY_SHARE = FTPREMIUM_SYS_COMPANY_SHARE;
    this.FTPREMIUM_SYS_COMP_SHARE_SWF = FTPREMIUM_SYS_COMP_SHARE_SWF;
    this.AGENT_COMMISSION_WHOLE_COVER = AGENT_COMMISSION_WHOLE_COVER;
    this.AGENT_COMMISSION_WHOLE_COV_SWF = AGENT_COMMISSION_WHOLE_COV_SWF;
    this.AGENT_COMMISSION_COMPANY_SHARE = AGENT_COMMISSION_COMPANY_SHARE;
    this.AGENT_COMMISSION_COM_SHARE_SWF = AGENT_COMMISSION_COM_SHARE_SWF;
    this.SHARE_PORTION = SHARE_PORTION;
    this.CVC_CODE = CVC_CODE;
    this.SURCHARGE_DISCOUNT = SURCHARGE_DISCOUNT;
    this.FTPREMIUM_OR_COMPANY_SHARE = FTPREMIUM_OR_COMPANY_SHARE;
    this.FTPREMIUM_OR_COMPANY_SHARE_SWF = FTPREMIUM_OR_COMPANY_SHARE_SWF;
    this.FTPREMIUM_SYS_WHOLE_COVER = FTPREMIUM_SYS_WHOLE_COVER;
    this.FTPREMIUM_SYS_WHOLE_COVER_SWF = FTPREMIUM_SYS_WHOLE_COVER_SWF;
    this.REINSURABLE_RISK_AMOUNT = REINSURABLE_RISK_AMOUNT;
    this.REINSURABLE_RISK_AMOUNT_SWF = REINSURABLE_RISK_AMOUNT_SWF;
    this.PCOV_CONTRACT_ID = PCOV_CONTRACT_ID;
    this.PCOV_PARTITION_NO = PCOV_PARTITION_NO;
    this.PCOV_COVER_CODE = PCOV_COVER_CODE;
    this.PCOV_COVER_NO = PCOV_COVER_NO;
  }
}
