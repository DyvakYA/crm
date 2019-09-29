import axios from 'axios'

export const AXIOS = axios.create({
    baseURL: `/api`,
    timeout: 1000
});

export default {

    user: {
        authenticated: false
    },

    creatRecord(url, obj) {
        return AXIOS.post(url, obj);
    },

    getRecord(url, objId) {
        return AXIOS.get(url + objId)
    },

    updateRecord(url, obj, objId) {
        return AXIOS.put(url + objId, obj);
    },

    deleteRecord(url, objId) {
        return AXIOS.delete(url + objId);
    },

    login(email, password) {
        let user = {
            email: email,
            password: password
        }
        return AXIOS.post('/login', user);
    },
    setTokenToRequests(token) {
        axios.defaults.headers.common['Authorization'] = 'Bearer ' + token;
    },

    checkAuth() {
        var jwt = localStorage.getItem('id_token')
        if (jwt) {
            this.user.authenticated = true
        } else {
            this.user.authenticated = false
        }
    }

}
