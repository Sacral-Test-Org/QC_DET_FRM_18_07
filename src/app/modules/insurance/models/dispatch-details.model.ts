export class DispatchDetailsModel {
  SHIP_NO: string;
  AWB_NO: string;
  DEL_TYPE: string;
  VENDOR: string;
  DES_TYPE: string;
  PICK_REQ_NO: string;
  PR_REF: string;
  CONSIGNEE_NAME: string;
  CON_ADD1: string;
  CON_ADD2: string;
  CON_ADD3: string;
  CON_CITY: string;
  CON_STATE: string;
  DES_PIN: string;
  WT: string;
  GM: string;
  VEN_CODE: string;

  constructor(
    SHIP_NO: string = '',
    AWB_NO: string = '',
    DEL_TYPE: string = '',
    VENDOR: string = '',
    DES_TYPE: string = '',
    PICK_REQ_NO: string = '',
    PR_REF: string = '',
    CONSIGNEE_NAME: string = '',
    CON_ADD1: string = '',
    CON_ADD2: string = '',
    CON_ADD3: string = '',
    CON_CITY: string = '',
    CON_STATE: string = '',
    DES_PIN: string = '',
    WT: string = '',
    GM: string = '',
    VEN_CODE: string = ''
  ) {
    this.SHIP_NO = SHIP_NO;
    this.AWB_NO = AWB_NO;
    this.DEL_TYPE = DEL_TYPE;
    this.VENDOR = VENDOR;
    this.DES_TYPE = DES_TYPE;
    this.PICK_REQ_NO = PICK_REQ_NO;
    this.PR_REF = PR_REF;
    this.CONSIGNEE_NAME = CONSIGNEE_NAME;
    this.CON_ADD1 = CON_ADD1;
    this.CON_ADD2 = CON_ADD2;
    this.CON_ADD3 = CON_ADD3;
    this.CON_CITY = CON_CITY;
    this.CON_STATE = CON_STATE;
    this.DES_PIN = DES_PIN;
    this.WT = WT;
    this.GM = GM;
    this.VEN_CODE = VEN_CODE;
  }
}
