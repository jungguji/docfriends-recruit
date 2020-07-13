<template>
  <div class="main">
    Detail.vue
    <img alt="Vue logo" src="../assets/logo.png" />
    <ConsultDetail/>
  </div>
</template>

<script>
// @ is an alias to /src
import ConsultDetail from "@/components/Consult.vue";

export default {
  name: "Detail",
  components: {
    ConsultDetail
  }
};
</script>
