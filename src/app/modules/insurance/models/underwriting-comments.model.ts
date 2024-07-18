export class UnderwritingComments {
  policyNumber: string;
  comments: string;
  userProfile: string;

  constructor(policyNumber: string, comments: string, userProfile: string) {
    this.policyNumber = policyNumber;
    this.comments = comments;
    this.userProfile = userProfile;
  }
}