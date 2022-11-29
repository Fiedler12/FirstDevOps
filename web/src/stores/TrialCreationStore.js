import {makeAutoObservable} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":"";

class TrialCreationStore {
    trialdata = {company:{
        id:1
        },
        trialname:"",
        location:"",
        description:"",
        trialDiseases:[
        ]
    }

    diseases = [];

    submitDisease(id) {
        console.log("received disease")
        this.trialdata.trialDiseases.trialDiseaseId.disease = 1
    }

    constructor(){
        makeAutoObservable(this, {}, {autoBind: true});
        this.getDiseases();
    }

    async postTrial()
    {
        const response = await fetch(baseUrl + "api/trials/", {
            method: "POST",
            body: JSON.stringify(this.trialdata),
            headers: {
                "Content-Type": "application/json"
            }
        })
        const json = await response.json()
        console.log(json)
        return json
    }

    async getDiseases() {
        const response = await fetch(baseUrl + "api/diseases")
        const json = await response.json()
        this.diseases = json;
    }
}

export const trialCreationStore = new TrialCreationStore();