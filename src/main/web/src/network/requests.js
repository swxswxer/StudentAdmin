import axios from 'axios'
import {Message} from "element-ui";

export function request(config) {
    const instance = axios.create({
        baseURL: process.env.VUE_APP_BASEURL,
        timeout: 20000,
        method: 'get',
    })

    instance.interceptors.request.use(config => {
        return config
    }, err => {
        console.log(err)
    })

    instance.interceptors.response.use(res => {
        return res.data
    }, err => {
        console.log(err);
        Message.error(err)
        return err
    })

    return instance(config)
}
