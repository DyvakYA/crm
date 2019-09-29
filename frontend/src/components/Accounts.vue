<template>
    <div class="accounts">
        <navbar/>
        <div class="container">
            <b-alert :show="loading" variant="info">Loading...</b-alert>
            <div class="card">
                <div class="card-header">
                    Accounts
                    <a href="#" class="icon">
                        <i v-on:click="editItem(account)">
                            <font-awesome-icon icon="plus-circle"/>
                        </i>
                    </a>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="account in accounts" v-bind:key="account.id">
                                <template v-if="editId == account.id">
                                    <td><input v-model="account.name" type="text"></td>
                                    <td>
                                        <span class="icon">
                                            <i @click="editItem(account)" class="fa fa-check"></i>
                                        </span>
                                        <span class="icon">
                                            <font-awesome-icon @click="onCancel" icon="add"/>
                                        </span>
                                    </td>
                                </template>
                                <template v-else>
                                    <td>{{account.name}}</td>
                                    <td>
                                        <a href="#" class="icon">
                                            <font-awesome-icon v-on:click="deleteItem(account)" icon="trash"/>
                                        </a>
                                        <a href="#" class="icon">
                                            <i v-on:click="editItem(account)">
                                                <font-awesome-icon icon="pencil-alt"/>
                                            </i>
                                        </a>
                                        <router-link :to="{name:'AccountPage', params:{id: account.id}}" class="icon">
                                            <i>
                                                <font-awesome-icon icon="eye"/>
                                            </i>
                                        </router-link>
                                    </td>
                                </template>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <v-dialog v-model="dialog" max-width="500px">
            <v-card>
                <v-card-title>
                    <span class="headline">{{ formTitle }}</span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12 sm6 md4>
                                <v-text-field v-model="editedItem.name" label="Account name"></v-text-field>
                            </v-flex>
                            <v-flex xs12 sm6 md4>
                                <v-text-field v-model="editedItem.id" label="Id"></v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" flat @click.native="close">Cancel</v-btn>
                    <v-btn color="blue darken-1" flat @click.native="save">Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    // import api from '@/api'
    import navbar from './NavOrganization'
    import {AXIOS} from "./backend-api";

    export default {
        data() {
            return {
                loading: false,
                dialog: false,
                accounts: [],
                model: {},
                editedIndex: -1,
                editedItem: {
                    id: 0,
                    name: '',
                    organizationId: ''
                },
                defaultItem: {
                    name: '',
                    price: 0.00,
                    code: 0,
                    id: 0,
                },
                listPrimitive: null
            }
        },
        async created() {
            console.log('created method')
            this.refreshPosts()
        },
        created: function () {
            this.getAllAccounts();
        },
        methods: {
            getAllAccounts() {
                console.log('created function')
                const organizationId = localStorage.getItem('organizationId')

                AXIOS.get('/accounts/' + organizationId)
                    .then(response => {
                        this.accounts = response.data
                    })
                    .catch(err => {

                    })
            },
            editItem(item) {
                if (item != null) {
                    this.editedIndex = this.accounts.indexOf(item)
                    this.editedItem = Object.assign({}, item)
                }
                this.dialog = true
            },
            deleteItem(item) {
                const index = this.accounts.indexOf(item)
                confirm('Are you sure you want to delete this item?') && this.listPrimitive.delete(index)
            },
            close() {
                this.dialog = false
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },
            save() {
                const url = `/accounts/`;
                console.log(this.editedItem);
                this.editedItem.organizationId = localStorage.getItem('organizationId');
                if (this.editedIndex > -1) {
                    return AXIOS.put(url, this.editedItem);
                } else {
                    return AXIOS.post(url, this.editedItem);
                }
                this.getAllAccounts();
                this.close();
            },
            async refreshPosts() {
                this.loading = true
                //this.posts = await api.getPosts()
                this.loading = false
            },
            async populatePostToEdit(post) {
                this.model = Object.assign({}, post)
            },
            async savePost() {
                if (this.model.id) {
                    // await api.updatePost(this.model.id, this.model)
                } else {
                    // await api.createPost(this.model)
                }
                this.model = {} // reset form
                await this.refreshPosts()
            },
            async deletePost(id) {
                if (confirm('Are you sure you want to delete this post?')) {
                    // if we are editing a post we deleted, remove it from the form
                    if (this.model.id === id) {
                        this.model = {}
                    }
                    // await api.deletePost(id)
                    await this.refreshPosts()
                }
            }
        }
        ,
        components: {
            navbar
        }
        ,
        computed: {
            formTitle() {
                return this.editedIndex === -1 ? 'New account' : 'Edit account'
            }
        }
        ,
        watch: {
            dialog(val) {
                val || this.close()
            }
        }
    }
</script>

<style scoped>
    h3 {
        text-align: center;
        margin-top: 30px;
        margin-bottom: 20px;
    }

    .icon {
        margin-right: 5px;
        margin-left: 5px;
    }

    .icon i {
        cursor: pointer;
    }

    .card-header {
        text-align: left;
    }
</style>
