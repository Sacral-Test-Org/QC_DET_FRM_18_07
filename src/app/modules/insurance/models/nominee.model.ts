export class Nominee {
  contractId: number;
  versionNo: number;
  objectId: number;
  actionCode: string;
  topIndicator: string;
  partitionNo: number;
  coverCode: string;
  coverNo: number;
  previousVersion?: number;
  reversingVersion?: number;
  sumInsuredWholeCover?: number;
  sumInsuredWholeCoverSwf?: string;
  sumInsuredCompanyShare?: number;
  sumInsuredCompanyShareSwf?: string;
  ftpremiumOrWholeCover?: number;
  ftpremiumOrWholeCoverSwf?: string;
  ftpremiumSysCompanyShare?: number;
  ftpremiumSysCompShareSwf?: string;
  agentCommissionWholeCover?: number;
  agentCommissionWholeCovSwf?: string;
  agentCommissionCompanyShare?: number;
  agentCommissionComShareSwf?: string;
  sharePortion?: number;
  cvcCode?: string;
  surchargeDiscount?: number;
  ftpremiumOrCompanyShare?: number;
  ftpremiumOrCompanyShareSwf?: string;
  ftpremiumSysWholeCover?: number;
  ftpremiumSysWholeCoverSwf?: string;
  reinsurableRiskAmount?: number;
  reinsurableRiskAmountSwf?: string;
  pcovContractId?: number;
  pcovPartitionNo?: number;
  pcovCoverCode?: string;
  pcovCoverNo?: number;

  // Additional fields as per the user story
  misUser: string; // hidden field
  scanDate: Date; // Date field
  flag: number; // Numeric field
  insertDate: Date; // Date field
  flag1: string; // Text field
  description: string; // Display-only field
  opusValue: string; // Read-only text field
  ciNominee: string = 'N'; // Radio button with default value 'N'

  constructor(init?: Partial<Nominee>) {
    Object.assign(this, init);
  }
}