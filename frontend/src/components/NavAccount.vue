<template>
    <div id="nav">
        <router-link to="/profile">Profile</router-link> |
        <router-link to="/account">Organizations</router-link> |
        <router-link to="/loguot">Logout</router-link>
    </div>
</template>

<script>
    export default {
        name: "NavAccount"
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