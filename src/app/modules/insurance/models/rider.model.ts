export class Rider {
  coverCode: string;
  sumInsuredWholeCover: number;
  benefitTerm: number;
  premiumTerm: number;

  constructor(
    coverCode: string,
    sumInsuredWholeCover: number,
    benefitTerm: number,
    premiumTerm: number
  ) {
    this.coverCode = coverCode;
    this.sumInsuredWholeCover = sumInsuredWholeCover;
    this.benefitTerm = benefitTerm;
    this.premiumTerm = premiumTerm;
  }
}
