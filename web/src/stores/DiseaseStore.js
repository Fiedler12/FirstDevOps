const baseUrl = process.env.NODE_ENV === 'http://localhost:3000/api/diseases';

class DiseaseStore {
    diseases = [];

    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchDiseases();
    }

    async fetchDiseases () {
        const response = await fetch(baseUrl)
        const json = await response.json()
        this.diseases = json
    }
}