import {action, makeAutoObservable, runInAction, decorate, observable} from "mobx";
import {useNavigate} from "react-router-dom";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

const Loginstates = {LOGGING_IN:"Loading", LOGGEDOUT:"Logout", LOGGED_IN:"LoggedIn"};

class TokenStore {
    state = Loginstates.LOGGEDOUT;
    token = null
    logindata =     {email:"", password:""}

    constructor() {
        makeAutoObservable(this)
        this.token = localStorage.getItem("probeToken");
    }

    async doLogin() {
        this.state = Loginstates.LOGGING_IN;

        const response = await fetch(baseUrl + "api/login", {
            method: "POST",
            body: JSON.stringify(this.logindata),
            headers: {
                "Content-Type": "application/json"
            }
        })

        const token = await response.text()
        try {
            if (response.status === 200) {
                this.token = token;
                localStorage.setItem("probeToken", token);
                this.state = Loginstates.LOGGED_IN;
                console.log("Got Token: " + this.token + " and state: " + this.state)
            } else {
                this.state = Loginstates.LOGGEDOUT;
                console.log("Got Token: " + this.token + " and state: " + this.state)

            }
            return this.state
        }
        catch (e) {
            this.state = Loginstates.LOGGEDOUT;
            console.log("Login failed")
        }
    }
    async logOut() {
        localStorage.removeItem("probeToken");
        this.token = null
    }

    async campusnetLogin() {
        const response = await fetch(baseUrl + "api/campusnet/login", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
    }

    async checkToken() {
        this.token = localStorage.getItem("probeToken");
    }

}


export const tokenstore = new TokenStore();