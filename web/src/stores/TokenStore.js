import {action, makeAutoObservable, runInAction, decorate, observable} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

const Loginstates = {LOGGING_IN:"Loading", LOGGEDOUT:"Logout", LOGGED_IN:"LoggedIn"};

class TokenStore {
    state = Loginstates.LOGGEDOUT;
    token = null
    logindata = {email:"", password:""}

    constructor() {
        this.token = localStorage.getItem("probeToken");

    }

    doLogin() {
        this.state = Loginstates.LOGGING_IN;
        fetch(baseUrl + "api/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authentication: this.token
            },
            body: JSON.stringify(this.logindata)
        }).then((response)=> {
            response.text().then(
                (token)=> {
                    console.log("Got Token: " + token)
                    this.token=token;
                    localStorage.setItem("probeToken",token);
                    this.state=Loginstates.LOGGED_IN;
                    console.log("Got Token: " + this.token + " and state: " + this.state)}


            )}
        ).catch(() => {this.state = Loginstates.LOGGEDOUT;
                    console.log("Login failed")})
    }


}


export const tokenstore = new TokenStore();