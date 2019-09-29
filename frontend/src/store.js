import Vue from 'vue'
import Vuex from 'vuex'
import api from './components/backend-api'
import jwt_decode from "jwt-decode";


Vue.use(Vuex);

export default new Vuex.Store({

    state: {
        loginSuccess: false,
        loginError: false,
        token: null,
        user: null
    },
    mutations: {
        login_success(state, payload) {
            state.loginSuccess = true;
            state.token = payload.token;
            state.user = payload.user;
        },
        login_error(state, payload) {
            state.loginError = true;
            state.user.email = payload.email;
        },
        login_logout(state) {
            state.loginSuccess = false;
            state.loginError = false;
            state.token = null;
            state.user = null;
        }
    },
    actions: {
        login({commit}, {email, password}) {
            return new Promise((resolve, reject) => {
                console.log("Accessing backend with user: " + email);
                api.login(email, password).then(response => {
                    console.log("Response : '" + response.data + "' with status code " + response.status);
                    if (response.status == 200) {
                        console.log("Login successful");

                        const token = response.data
                        const userInfo = jwt_decode(token);
                        if (token && userInfo) {
                            const currentUser = {token, userInfo}
                            console.log(currentUser)

                            // place the login success state into vuex store
                            commit('login_success', {
                                token: token,
                                user: userInfo
                            });
                        }
                    }
                    resolve(response);
                }).catch(error => {
                    console.log("Error " + error);
                    // place the login error state into our vuex store
                    commit('login_error', {
                        email: email
                    });
                    reject("Invalid credentials!")
                })
            })
        },
        logout() {
            commit('login_logout');
        },
        token() {
            const token = this.getters.getToken;
            console.log(token);
            api.setTokenToRequests(token);
        }
    },
    getters: {
        isLoggedIn: state => state.loginSuccess,
        hasLoginErrored: state => state.loginError,
        getUserEmail: state => state.user.email,
        getUserPass: state => state.user.password,
        getToken: state => state.token
    },

})
