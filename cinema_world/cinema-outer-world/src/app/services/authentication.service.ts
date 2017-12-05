export class AuthenticationService {

    activeUser = null;
    
    constructor() { }

    login(emailOrUsername: string, password: string) {
        this.activeUser = {emailOrUsername: emailOrUsername, password: password};
        sessionStorage.setItem('user', this.activeUser);
    }

    isLoggedIn(): boolean {
        return sessionStorage.getItem('user') != null;
    }
}