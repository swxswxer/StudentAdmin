import {request} from "@/network/requests";

export function register(username, password) {
    return request({
        url: process.env.VUE_APP_REGISTER_API,
        method: 'post',
        data: {
            username: username,
            password: password
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
}