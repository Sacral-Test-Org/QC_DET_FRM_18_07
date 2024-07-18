export class ReasonOfSkip {
  reason: string;
  comments?: string;

  constructor(reason: string, comments?: string) {
    this.reason = reason;
    this.comments = comments;
  }
}