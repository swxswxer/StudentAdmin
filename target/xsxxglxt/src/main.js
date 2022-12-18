import Vue from 'vue'
import App from './App.vue'
import router from "@/router";
import {
    Button, Input, Container, Aside, Main
} from "element-ui";

Vue.config.productionTip = false
Vue.use(Button)
Vue.use(Input)
Vue.use(Container)
Vue.use(Aside)
Vue.use(Main)

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
