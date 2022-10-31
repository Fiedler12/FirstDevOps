import {makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

class TrailsStore {
    trails = ["Loading trails"];

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchTrails();
    }

    fetchTrails (){
        fetch(baseUrl + "api/trails").then(
            (response)=> response.json().then(
                (json)=> runInAction(()=>this.trails=json)
            )
        )
    }
}

export const trailsStore = new TrailsStore();