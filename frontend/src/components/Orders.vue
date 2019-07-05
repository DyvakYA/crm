<template>
    <div class="hello">
        <navbar/>
        <b-container>
            <b-row>
                <b-col v-for="organization in organizations" cols="12" sm="6" md="4">
                    <router-link to="/orders/{{ organization.code}}">
                        <div class="organization px-3">
                            <div class="organization-header">City : {{ organization.city}}</div>
                            <div>Address : {{ organization.address}}</div>
                            <p>{{ organization.name}}</p>
                            <p>{{ organization.code}}</p>
                            <p>{{ organization.userId}}</p>
                        </div>
                    </router-link>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import navbar from './NavAccount'
    import {AXIOS} from "../components/http-common";

    export default {
        name: 'account',
        data() {
            return {
                organizations: '',
                userId: ''
            }
        },
        created: function () {
            const currentUser = JSON.parse(localStorage.getItem('currentUser'))
            this.userId = currentUser.userInfo.userId

            AXIOS.get('/organizations/' + this.userId)
                .then(response => {
                    this.organizations = response.data
                })
                .catch(err => {

                })
        },
        methods: {},
        components: {
            navbar
        }
    }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }

    .organization {
        border: 1px solid #d8dee2;
        border-radius: 5px;
        text-align: left;
    }

    .organization-header {
        background-color: transparent;
        border: 0;
        color: #333;
        text-align: center;
        font-size: 20px;
        text-shadow: none;
    }
</style>
