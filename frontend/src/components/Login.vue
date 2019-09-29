<template>
    <div class="login">
        <navbarmain/>
        <b-container>
            <b-row>
                <b-col cols="12" sm="6" md="4" offset-sm="3" offset-md="4">
                    <div class="auth-form px-3">
                        <div class="auth-form-header">


                        </div>
                        <div class="auth-form-body">
                            <div class="alert alert-danger" v-if="error">
                                <p>Bad login information</p>
                            </div>
                            <div class="form-group">
                                <label for="email_field">Email address</label>
                                <input
                                        id="email_field"
                                        type="text"
                                        class="form-control"
                                        placeholder="Enter your email"
                                        v-model="user.email"
                                >
                            </div>
                            <div class="form-group">
                                <label for="password">Password<a class="label-link" href="/password/reset">Forgot
                                    password?</a></label>
                                <input
                                        id="password"
                                        type="password"
                                        class="form-control"
                                        placeholder="Enter your password"
                                        v-model="user.password"
                                >
                            </div>
                            <button class="btn btn-primary btn-block" @click="submit()">Access</button>
                        </div>
                        <div class="create-account-callout mt-3">
                            <a href="/account/create">Create an account</a>
                        </div>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import navbarmain from './NavMain'

    export default {
        name: 'login',
        data() {
            return {
                loginError: false,
                user: {
                    email: '',
                    password: ''
                },
                error: false,
                errors: []
            }
        },
        methods: {
            submit() {

                const user = {
                    email: this.user.email,
                    password: this.user.password
                }

                this.errors = [];
                console.log(JSON.stringify(user))
                this.$store.dispatch("login", {email: user.email, password: user.password})
                    .then(() =>{
                        this.$store.dispatch("token");
                    })
                    .then(() => {
                        this.$router.push('/organization')
                    })
                    .catch(error => {
                        this.loginError = true;
                        this.errors.push(error);
                        this.error = true;
                    })
            }
        },
        components: {
            navbarmain
        }

    }
</script>

<style scoped>

    .auth-form-header {
        background-color: transparent;
        border: 0;
        color: #333;
        margin-bottom: 15px;
        text-align: center;
        text-shadow: none;
    }

    .auth-form-body {
        background-color: #ffff;
        border: 1px solid #d8dee2;
        border-radius: 0 0 3px 3px;
        font-size: 14px;
        padding: 20px;
    }

    .create-account-callout {
        border: 1px solid #d8dee2;
        border-radius: 5px;
        padding: 15px 20px;
        text-align: center;
    }

    .auth-form label {
        display: block;
        margin-bottom: 7px;
        text-align: left;
    }

    .btn-block {
        display: block;
        text-align: center;
        width: 100%;
    }

    .label-link {
        float: right;
    }

    label {
        font-weight: 600;
    }
</style>
