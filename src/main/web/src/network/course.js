import {request} from "@/network/requests";

export function getAllCourse() {
    return request({
        url: process.env.VUE_APP_COURSE_QUERY_ALL,

    })
}