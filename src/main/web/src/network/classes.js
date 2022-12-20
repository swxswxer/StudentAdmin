import {request} from "@/network/requests";


export function getAllClass() {
    return request({
        url: process.env.VUE_APP_CLASS_QUERY_ALL,
    })
}