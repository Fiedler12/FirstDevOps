import {action, makeAutoObservable, runInAction} from "mobx";
import {tokenstore} from "./TokenStore";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment
const states = {LOADING:"Loading", DONE:"done", FAILED:"FAILED"};

class TrialsStore {

    trials = []

    constructor() {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchTrials();
    }

    async fetchTrials() {
        trials.empty()
        const response = await fetch(baseUrl + "api/trials")
        const json = await response.json()
        this.trials = json
    }
    async fetchTrial(id) {
        const response = await fetch(baseUrl + "api/trials/" + id)
        const json = await response.json()
        return json
    }

    async fetchSpecific(disease) {
        trials.empty()
        const response = await fetch(baseUrl + "api/trials/disease/" + disease)
        const json = await response.json()
        this.trials = json
    }

    async postSubscription(id) {
        const token = tokenstore.token;
        this.state = states.LOADING;
        try {
            const user = JSON.parse(atob(token.split('.')[1])).user
            const userid = JSON.parse(user).id
            const response = await fetch(baseUrl + "api/trials/subscribe/" + id + "/" + userid, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    Authorization: token
                }
            })
            const json = await response.json()
                .then(this.state = states.DONE)
                .catch(this.state = states.FAILED);
            return json
        } catch (e) {
            this.state = states.FAILED;
            throw new Error("could not subscribe")
        }
    }

    async deleteSubscription(id) {
        const token = tokenstore.token;
        this.state = states.LOADING;
        try {
            const user = JSON.parse(atob(token.split('.')[1])).user
            const userid = JSON.parse(user).id
            const response = await fetch(baseUrl + "api/trials/unsubscribe/" + id + "/" + userid, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                    Authorization: token
                }
            })
            const json = await response.json()
                .then(this.state = states.DONE)
                .catch(this.state = states.FAILED);
            return json
        } catch (e) {
            this.state = states.FAILED;
            throw new Error("could not unsubscribe")
        }
    }

    async getSubscribed (id) {
        const token = tokenstore.token;
        this.state = states.LOADING;
        try {
            const user = JSON.parse(atob(token.split('.')[1])).user
            const userid = JSON.parse(user).id
            const response = await fetch(baseUrl + "api/trials/isSubscribed/" + id + "/" + userid, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    Authorization: token
                }
            })
            const json = await response.json()
                .then(this.state = states.DONE)
                .catch(this.state = states.FAILED);
            return json
        } catch (e) {
            this.state = states.FAILED;
            throw new Error("could not get subscription status")
        }
    }
}

export const trialsStore = new TrialsStore();