


export class config {
    static DEFAULT_BACKEND_URL = 'http://localhost:8080/';

    static backendUrl = process.env.NODE_ENV === 'development' ? this.DEFAULT_BACKEND_URL : 'http://devopstest.probe.diplomportal.dk/';
}
