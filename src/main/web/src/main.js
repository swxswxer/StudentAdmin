import Vue from 'vue'
import App from './App.vue'
import router from "@/router";
import {
    Button, Input, Container,
    Aside, Main, Header, Menu,
    Submenu, MenuItemGroup, MenuItem,
    Table, TableColumn, Tag, Loading,
    Row, Col, Avatar, Descriptions,
    DescriptionsItem, Dialog, Form, FormItem,
    Select, Option
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
Vue.use(Descriptions)
Vue.use(DescriptionsItem)
Vue.use(Dialog)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Select)
Vue.use(Option)

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
