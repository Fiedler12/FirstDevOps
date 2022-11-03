import {action, makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment


class TrialsStore {
    trials = [{
        "id": 1,
        "companyid": 1,
        "trialname": "trialname",
        "company": "companyname",
        "location": "location",
        "description": "description"
    }];

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchTrials();
    }

    async fetchTrials (){
        const response = await fetch(baseUrl + "api/trials")
        const json = await response.json()
        console.log(json);
        runInAction(() => this.trials = json);

    }
}

export const trialsStore = new TrialsStore();