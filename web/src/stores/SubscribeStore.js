import {makeAutoObservable, runInAction} from 'mobx';

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

class SubscribeStore {
    subscribe = ["Loading subscribe"];

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchSubscribe();
    }

    fetchSubscribe (){
        fetch(baseUrl + "api/subscribe").then(
            (response)=> response.json().then(
                (json)=> runInAction(()=>this.subscribe=json)
            )
        )
    }
}

export const subscribeStore = new SubscribeStore();