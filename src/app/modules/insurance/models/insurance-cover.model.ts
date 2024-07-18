export class InsuranceCover {
  contract_id: string;
  version_no: number;
  object_id: string;
  action_code: string;
  top_indicator: string;
  partition_no: number;
  cover_code: string;
  cover_no: string;
  previous_version?: number;
  reversing_version?: number;
  sum_insured_whole_cover: number;
  sum_insured_company_share: number;
  full_term_premium_whole_cover: number;
  full_term_premium_company_share: number;
  agent_commission_whole_cover: number;
  agent_commission_company_share: number;
  share_portion: number;
  cvc_code: string;
  surcharge_discount: number;
  reinsurable_risk_amount: number;
  pcov_contract_id: string;
  pcov_partition_no: number;
  pcov_cover_code: string;
  pcov_cover_no: string;

  constructor(
    contract_id: string,
    version_no: number,
    object_id: string,
    action_code: string,
    top_indicator: string,
    partition_no: number,
    cover_code: string,
    cover_no: string,
    sum_insured_whole_cover: number,
    sum_insured_company_share: number,
    full_term_premium_whole_cover: number,
    full_term_premium_company_share: number,
    agent_commission_whole_cover: number,
    agent_commission_company_share: number,
    share_portion: number,
    cvc_code: string,
    surcharge_discount: number,
    reinsurable_risk_amount: number,
    pcov_contract_id: string,
    pcov_partition_no: number,
    pcov_cover_code: string,
    pcov_cover_no: string,
    previous_version?: number,
    reversing_version?: number
  ) {
    this.contract_id = contract_id;
    this.version_no = version_no;
    this.object_id = object_id;
    this.action_code = action_code;
    this.top_indicator = top_indicator;
    this.partition_no = partition_no;
    this.cover_code = cover_code;
    this.cover_no = cover_no;
    this.previous_version = previous_version;
    this.reversing_version = reversing_version;
    this.sum_insured_whole_cover = sum_insured_whole_cover;
    this.sum_insured_company_share = sum_insured_company_share;
    this.full_term_premium_whole_cover = full_term_premium_whole_cover;
    this.full_term_premium_company_share = full_term_premium_company_share;
    this.agent_commission_whole_cover = agent_commission_whole_cover;
    this.agent_commission_company_share = agent_commission_company_share;
    this.share_portion = share_portion;
    this.cvc_code = cvc_code;
    this.surcharge_discount = surcharge_discount;
    this.reinsurable_risk_amount = reinsurable_risk_amount;
    this.pcov_contract_id = pcov_contract_id;
    this.pcov_partition_no = pcov_partition_no;
    this.pcov_cover_code = pcov_cover_code;
    this.pcov_cover_no = pcov_cover_no;
  }
}
