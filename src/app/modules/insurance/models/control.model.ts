export class Control {
  policyNumber: string;
  status: string;
  substatus: string;
  nomineeInfo: string;
  images: string[];
  enrichedData: string;
  checkboxes: {
    ch3: boolean;
    ch4: boolean;
    ch6: boolean;
    ch8: boolean;
    ch9: boolean;
  };
  displayItems: string[];
  comments: string;
  qcProcessStatus: string;

  constructor() {
    this.policyNumber = '';
    this.status = '';
    this.substatus = '';
    this.nomineeInfo = '';
    this.images = [];
    this.enrichedData = '';
    this.checkboxes = {
      ch3: false,
      ch4: false,
      ch6: false,
      ch8: false,
      ch9: false,
    };
    this.displayItems = [];
    this.comments = '';
    this.qcProcessStatus = '';
  }
}
