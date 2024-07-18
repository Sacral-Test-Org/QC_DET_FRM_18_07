// src/app/modules/insurance/models/vendor.model.ts

export class Vendor {
  vendorCode: string;
  vendorName: string;

  constructor(vendorCode: string, vendorName: string) {
    this.vendorCode = vendorCode;
    this.vendorName = vendorName;
  }
}
