import {action, makeAutoObservable, runInAction} from "mobx";
import {tokenstore} from "./TokenStore";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

const Loginstates = {LOGGING_IN:"Loading", LOGGEDOUT:"Logout", LOGGED_IN:"LoggedIn"};



class SettingsStore {

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchSettings();
    }

    async fetchSettings (){
        const token = tokenstore.token;
        const user = JSON.parse(atob(token.split('.')[1])).user
        const userid = JSON.parse(user).id
        console.log(JSON.parse(user).id);
        const response = await fetch(baseUrl + 'api/users/' + userid);
        const json = await response.json()
        console.log(json)
        return json

    }
}