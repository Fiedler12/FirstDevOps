import {makeAutoObservable} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":"";

export class TrialCreationStore{

    contructor(){
        makeAutoObservable(this, {}, {autoBind: true});
    }

    async handleSubmit()
    {
        const response = await fetch(baseUrl + "api/trialcreate/")
        const json = await response.json()
        return json
    }

}