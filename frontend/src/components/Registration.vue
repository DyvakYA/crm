<template>
    <div class="registration">
        <navbarmain/>
        <b-container>
            <b-row>
                <b-col sm="12" md="4" offset-md="4">
                    <h2>Sign Up</h2>
                    <p>Sign up for a free account to get some great quotes.</p>
                    <div class="alert alert-danger" v-if="error">
                        <p>{{ error }}</p>
                    </div>
                    <div class="form-group">
                        <input
                                type="text"
                                class="form-control"
                                placeholder="Enter your email"
                                v-model="credentials.username"
                        >
                    </div>
                    <div class="form-group">
                        <input
                                type="password"
                                class="form-control"
                                placeholder="Enter your password"
                                v-model="credentials.password"
                        >
                    </div>
                    <button class="btn btn-primary" @click="submit()">Access</button>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import navbarmain from './NavMain'

    export default {
        name: 'registration',
        data() {
            return {
                credentials: {
                    username: '',
                    password: ''
                },
                error: ''
            }
        },
        methods: {
            submit() {
                var credentials = {
                    username: this.credentials.username,
                    password: this.credentials.password
                }
            }
        },
        components: {
            navbarmain
        }
    }
</script>

<style scoped>

    .center {
        margin: auto;
        position: relative;
    }
</style>