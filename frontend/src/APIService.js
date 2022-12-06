const PERSONS_REST_API = 'http://localhost:1923/person';
class APIService {
    getAll(){
        return fetch(PERSONS_REST_API,{
            method: 'get',
                headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json',
                },
                'credentials': 'same-origin'
        })
        .then(res => res.json());
    }

}

export default new APIService();

