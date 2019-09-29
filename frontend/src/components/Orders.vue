<template>
    <div class="orders">
        <navbar/>
        <div class="container">
            <b-alert :show="loading" variant="info">Loading...</b-alert>
            <div class="card">
                <div class="card-header">
                    Orders
                    <a href="#" class="icon">
                        <i v-on:click="editItem(order)">
                            <font-awesome-icon icon="plus-circle"/>
                        </i>
                    </a>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Date</th>
                                <th>Name</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="order in orders" v-bind:key="order.id">
                                <template v-if="editId == order.id">
                                    <td><input v-model="order.date" type="text"></td>
                                    <td><input v-model="order.name" type="text"></td>
                                    <td>
                                        <span class="icon">
                                            <i @click="editItem(order)" class="fa fa-check"></i>
                                        </span>
                                        <span class="icon">
                                            <font-awesome-icon @click="onCancel" icon="add"/>
                                        </span>
                                    </td>
                                </template>
                                <template v-else>
                                    <td>{{order.date}}</td>
                                    <td>{{order.name}}</td>
                                    <td>
                                        <a href="#" class="icon">
                                            <font-awesome-icon v-on:click="deleteItem(order)" icon="trash"/>
                                        </a>
                                        <a href="#" class="icon">
                                            <i v-on:click="editItem(order)">
                                                <font-awesome-icon icon="pencil-alt"/>
                                            </i>
                                        </a>
                                        <router-link :to="{name:'OrderPage', params:{id: order.id}}" class="icon">
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
                                <v-text-field v-model="editedItem.date" label="Date"></v-text-field>
                            </v-flex>
                            <v-flex xs12 sm6 md4>
                                <v-text-field v-model="editedItem.name" label="Order name"></v-text-field>
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
    import api, {AXIOS} from "./backend-api";

    export default {
        data() {
            return {
                loading: false,
                dialog: false,
                orders: [],
                model: {},
                editedIndex: -1,
                editedItem: {
                    name: '',
                    price: 0.00,
                    code: 0,
                    id: 0,
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
            this.refreshOrders()
        },
        created: function () {
            console.log('created function')
            const organizationId = localStorage.getItem('organizationId')

            AXIOS.get('/orders/organization/' + organizationId)
                .then(response => {
                    this.orders = response.data
                })
                .catch(err => {

                })
        },
        methods: {
            editItem(item) {
                this.editedIndex = this.orders.indexOf(item)
                this.editedItem = Object.assign({}, item)
                this.dialog = true
            },
            deleteItem(item) {
                const index = this.orders.indexOf(item)
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
                if (this.editedIndex > -1) {
                    this.listPrimitive.update(this.editedIndex, this.editedItem)
                } else {
                    this.listPrimitive.push(this.editedItem)
                }
                this.close()
            },
            async refreshOrders() {
                this.loading = true
                //this.posts = await api.getPosts()
                this.loading = false
            },
            async populateOrderToEdit(post) {
                this.model = Object.assign({}, post)
            },
            async saveOrder() {
                if (this.model.id) {
                    // await api.updatePost(this.model.id, this.model)
                } else {
                    // await api.createPost(this.model)
                }
                this.model = {} // reset form
                await this.refreshOrders()
            },
            async deleteOrder(id) {
                if (confirm('Are you sure you want to delete this post?')) {
                    // if we are editing a post we deleted, remove it from the form
                    if (this.model.id === id) {
                        this.model = {}
                    }
                    await api.deleteRecord('/orders/', id)
                    await this.refreshOrders()
                }
            }
        },
        components: {
            navbar
        },
        computed: {
            formTitle() {
                return this.editedIndex === -1 ? 'New order' : 'Edit order'
            }
        },
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
