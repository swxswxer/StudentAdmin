import {request} from "./requests"


export function getStudentInfo() {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY,
        method: 'get'
    })
}