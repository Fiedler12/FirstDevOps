import {makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

export class TrialStore {
    trial = {};

    constructor() {
        makeAutoObservable(this, {}, {autoBind: true});
    }

    async fetchTrial(id) {
        const response = await fetch(baseUrl + "api/trials/" + id)
        const json = await response.json()
        console.log(json)
        return json

    }
 }