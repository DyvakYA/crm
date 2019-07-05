<template>
    <div id="nav">
        <router-link to="/">Users</router-link> |
        <router-link to="/callservice">Organizations</router-link> |
        <router-link to="/bootstrap">Products</router-link> |
        <router-link to="/user">User</router-link> |
        <router-link to="/login">Login</router-link>
    </div>
</template>

<script>
    export default {
        name: "nav-menu"
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