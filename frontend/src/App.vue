<template>
    <div id="app">
        <router-view :hellomsg="msg"></router-view>
    </div>
</template>

<script>

    export default {
        name: 'app',
        data() {
            return {
                msg: 'Welcome to your Vue.js powered Spring Boot App'
            }
        }
    }
</script>

<style lang="scss">
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 20px;
    }

    .table thead th{
        border-bottom: 0px;
    }

</style>
