export class SignUpInfo {
    username: string;
    email: string;
    role: string;
    userPassword: string;
    deleteFlag:number;
    phoneNumber:string;
    active:boolean;

    constructor(username: string, email: string, password: string,phoneNumber:string,role:string) {
        this.username = username;
        this.email = email;
        this.userPassword = password;
        this.role=role;
        this.phoneNumber=phoneNumber;
        this.deleteFlag=0;
        this.active=true;
    }
}
