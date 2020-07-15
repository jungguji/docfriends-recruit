<template>
  <div id="app">
    <div id="nav">
      <img alt="DocFriends" src="@/assets/docLogo.png" />
      <br />

      <router-link to="/">Home</router-link> |
      <router-link to="/login">Login</router-link> |
      <router-link to="/logout">Logout</router-link>
      
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}


.content {
  text-align: left;
  border: 1px solid;
  box-shadow: 3px 3px;
  width: 35%;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 1rem;
}

.gray-font {
  color: gray;
}

.consult-content {
  margin-bottom: 1rem;
  margin-top: 1rem;
}

</style>
