import {makeAutoObservable} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":"";

class TrialCreationStore{
    trialdata = {company:{
        id:1
        },
        trialname:"",
        location:"",
        description:"",
        diseases: [],
    }

    contructor(){
        makeAutoObservable(this, {}, {autoBind: true});
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
        return json
    }

}

export const creationStore = new TrialCreationStore();