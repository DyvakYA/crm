<template>
    <div id="nav">
        <router-link to="/leads">Leads</router-link> |
        <router-link to="/accounts">Accounts</router-link> |
        <router-link to="/contacts">Contacts</router-link> |
        <router-link to="/orders">Orders</router-link> |
        <router-link to="/products">Products</router-link> |
        <router-link to="/opportunities">Opportunities</router-link> |
        <router-link to="/logout">Logout</router-link>
    </div>
</template>

<script>
    export default {
        name: "NavOrganization"
    }
</script>

<style scoped lang="scss">
    #nav {
        padding: 30px;
        a {
            font-weight: bold;
            color: #2c3e50;
            &.router-link-exact-active {
                color: #42b983;
            }
        }
    }
</style>