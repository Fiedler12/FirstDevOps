import {makeAutoObservable} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

class DiseaseStore {

    diseases = []

    constructor() {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchDiseases();
    }

    async fetchDiseases() {
        const response = await fetch(baseUrl + "api/disease")
        const json = await response.json()
        this.diseases = json
    }
}

export const diseaseStore = new DiseaseStore()