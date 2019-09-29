<template>
  <div class="hello">
    <navbarmain/>
  </div>
</template>

<script>
  import navbarmain from './NavMain'

  export default {
    name: 'hello',
    props: { hellomsg: { type: String, required: true }},
    components: {
      navbarmain
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
</style>
