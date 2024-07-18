export class QCModel {
  ci: string;
  flg: number;
  ch1: string;
  ch6: string;
  socialStatus: string;

  constructor(
    ci: string,
    flg: number,
    ch1: string,
    ch6: string,
    socialStatus: string
  ) {
    this.ci = ci;
    this.flg = flg;
    this.ch1 = ch1;
    this.ch6 = ch6;
    this.socialStatus = socialStatus;
  }

  handleCIRadioButtonChange(newCIValue: string, flgValue: number, contractId: string): void {
    this.ci = newCIValue;
    this.flg = flgValue;

    if (newCIValue === 'N') {
      if (flgValue === 10) {
        alert('Please select the error category first.');
        this.ch1 = 'Y';
        // Halt the process
        return;
      } else if (flgValue === 3) {
        this.retrieveSocialStatus(contractId).then((socialStatus) => {
          if (socialStatus.startsWith('R')) {
            alert('Do not fail the print QC if the pronunciation is the same even if the spelling is different.');
          }
        });
      } else if (flgValue === 11) {
        alert('Please select the error category first.');
        this.ch6 = 'Y';
        // Halt the process
        return;
      }
    } else if (newCIValue === 'Y') {
      if (flgValue === 10) {
        this.resetControlFields(['ch1', 'ch2', 'ch3', 'ch4', 'ch5', 'ch27']);
      } else if (flgValue === 11) {
        this.resetControlFields(['ch6', 'ch7', 'ch8', 'ch9', 'ch10', 'ch28']);
      }
    }
  }

  private async retrieveSocialStatus(contractId: string): Promise<string> {
    // Simulate a database call to retrieve the social status
    const query = `
      SELECT SOCIAL_STATUS 
      INTO v_sector
      FROM AZBJ_POLICY_BASES_EXT
      WHERE CONTRACT_ID = azbj_pk0_acc.get_contract_id(:contractId)
      AND TOP_INDICATOR = 'Y';
    `;
    // Replace with actual database call
    const socialStatus = await this.mockDatabaseCall(query, contractId);
    this.socialStatus = socialStatus;
    return socialStatus;
  }

  private async mockDatabaseCall(query: string, contractId: string): Promise<string> {
    // Simulate a delay for the database call
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve('R123'); // Mocked social status starting with 'R'
      }, 1000);
    });
  }

  private resetControlFields(fields: string[]): void {
    fields.forEach((field) => {
      this[field] = 'N';
    });
  }
}
