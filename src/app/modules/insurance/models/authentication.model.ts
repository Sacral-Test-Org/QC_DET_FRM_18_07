export class AuthenticationModel {
  supervisorId: string;
  password: string;
  comments: string;

  constructor(supervisorId: string, password: string, comments: string) {
    this.supervisorId = supervisorId.toUpperCase();
    this.password = password;
    this.comments = comments;
  }
}