import {makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

class TrialsStore {
    companyName = ["Loading Company Name"];
    location = ["Loading Location"];
    description = ["Loading Description"];
    trialName = ["Loading trial name"];

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchTrials();
    }

    fetchTrials (){
        fetch(baseUrl + "api/trials").then(
            (response)=> response.json().then(
                (json)=> runInAction(()=>
                    this.companyName = json.map((trial)=>trial.companyName),
                    this.location = json.map((trial)=>trial.location),
                    this.description = json.map((trial)=>trial.description),
                    this.trialName = json.map((trial)=>trial.trialName)
                )
            )
        )
    }
}

export const trialsStore = new TrialsStore();