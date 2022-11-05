import {action, makeAutoObservable, runInAction} from "mobx";
import {tokenstore} from "./TokenStore";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

const states = {LOADING:"Loading", DONE:"done", FAILED:"FAILED"};



export class SettingsStore {

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchSettings();
    }

    async fetchSettings (){
        const token = tokenstore.token;
        this.state = states.LOADING;
        try {
            const user = JSON.parse(atob(token.split('.')[1])).user
            const userid = JSON.parse(user).id
            //console.log(JSON.parse(user).id);
            const response = await fetch(baseUrl + 'api/users/' + userid, {
                headers: {
                    Authorization: token
                }
            });
            const json = await response.json()
                .then(this.state = states.DONE)
                .catch(this.state = states.FAILED);
            console.log(json)
            return json
        } catch (e) {
            this.state = states.FAILED;
            console.log("could not fetch settings")
        }
    }
    // put http request to update settings
    async updateSettings (settings){
        const token = tokenstore.token;
        this.state = states.LOADING;
        try {
            const user = JSON.parse(atob(token.split('.')[1])).user
            const userid = JSON.parse(user).id
            //console.log(JSON.parse(user).id);
            const response = await fetch(baseUrl + 'api/users/' + userid, {
                method: 'PUT',
                headers: {
                    Authorization: "Bearer " + token,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(settings)
            });
            const json = await response.json()
                .then(this.state = states.DONE)
                .catch(this.state = states.FAILED);
            console.log(json)
            return json
        } catch (e) {
            this.state = states.FAILED;
            console.log("could not update settings")
        }
    }
}
export const settingsStore = new SettingsStore();