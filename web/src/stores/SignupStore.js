import {makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment
const state = {LOADING:"Loading", DONE:"done", FAILED:"FAILED"};
export class SignupStore {

    userData = {
        name: "",
        email: "",
        password: "",
        privilege: 1,
    }

    constructor() {
        makeAutoObservable(this, {}, {autoBind: true});
    }

    async postSignup() {
        const response = await fetch(baseUrl + "api/users/register", {
        method: "POST",
        body: JSON.stringify(this.userData),
        headers: {
            "Content-Type": "application/json"
        }
    })
    const json = await response.json()
    return json
    }
}
export const signupStore = new SignupStore();