import Vue from 'vue'
import App from './App.vue'
import router from "@/router";
import {
    Button, Input, Container,
    Aside, Main, Header, Menu,
    Submenu, MenuItemGroup, MenuItem,
    Table, TableColumn, Tag, Loading,
    Row, Col, Avatar
} from "element-ui"


Vue.config.productionTip = false
Vue.use(Button)
Vue.use(Input)
Vue.use(Container)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Header)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItemGroup)
Vue.use(MenuItem)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Tag)
Vue.use(Loading)
Vue.use(Row)
Vue.use(Col)
Vue.use(Avatar)

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
