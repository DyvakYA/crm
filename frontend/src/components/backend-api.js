import axios from 'axios'

export const AXIOS = axios.create({
    baseURL: `/api`,
    timeout: 1000
});

export default {
    hello() {
        return AXIOS.get('hello')
    },
    getUser(userId) {
        return AXIOS.get('/user/' + userId)
    },
    createuser(firstName, lastName) {
        return AXIOS.post('/user/' + firstName + '/' + lastName);
    },

    getSecured(user, password) {
        return AXIOS.get('/seecured', {
            auth: {
                username: user,
                password: password
            }
        })
    }
}
