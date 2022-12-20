import axios from 'axios'

export function request(config) {
    const instance = axios.create({
        baseURL: process.env.VUE_APP_BASEURL,
        timeout: 20000,
        method: 'get',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
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
        return err
    })

    return instance(config)
}
