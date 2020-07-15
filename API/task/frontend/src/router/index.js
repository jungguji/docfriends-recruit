import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/login",
    name: "Login",
    component: () =>
      window.location = "http://localhost:8080/login"
  },
  {
    path: "/",
    name: "Main",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Main.vue")
  },
  {
    path: "/detail/:id",
    name: "Detail",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/Detail.vue")
  },
  {
    path: "/logout",
    name: "Logout",
    component: () =>
      window.location = "http://localhost:8080/logout"
  },
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
