import {action, makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment


class TrialsStore {

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchTrials();
    }

    async fetchTrials (){
        const response = await fetch(baseUrl + "api/trials")
        const json = await response.json()
        console.log(json)
        return json

    }
}

export const trialsStore = new TrialsStore();