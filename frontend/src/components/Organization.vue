<template>
    <div class="account">
        <navbar/>
        <b-container>
            <b-row>
                <b-col v-on:click="getOrganization(organization.id)" v-for="organization in organizations" cols="12"
                       sm="6" md="4">
                    <div id="org-form" class="organization px-3">
                        <div class="organization-header">{{ organization.name}}</div>
                        <div>Address : {{ organization.address}}</div>
                        <p>{{ organization.city}}</p>
                        <p>{{ organization.code}}</p>
                        <p>{{ organization.userId}}</p>
                    </div>

                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import navbar from './NavAccount'
    import {AXIOS} from "./backend-api";

    export default {
        name: 'account',
        data() {
            return {
                organizations: '',
                userId: ''
            }
        },
        created: function () {
            const currentUser = this.$store.state.user
            console.log(JSON.stringify(currentUser))
            this.userId = currentUser.userId;

            AXIOS.get('/organizations/' + this.userId)
                .then(response => {
                    this.organizations = response.data
                })
                .catch(err => {

                })
        },
        methods: {
            getOrganization: function (organizationId) {
                localStorage.setItem('organizationId', organizationId)
                console.log('hello world')
                this.$router.push('/orders')
            }
        },
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

    .organization:hover {
        background-color: #F8F8FF;
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
