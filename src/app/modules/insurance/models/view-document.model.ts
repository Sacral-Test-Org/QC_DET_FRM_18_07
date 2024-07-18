export class ViewDocumentModel {
  policyRef: string;
  filePath: string;
  qcStatus: string;

  constructor(policyRef: string, filePath: string, qcStatus: string) {
    this.policyRef = policyRef;
    this.filePath = filePath;
    this.qcStatus = qcStatus;
  }
}