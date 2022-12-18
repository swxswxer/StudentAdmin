import {request} from "./requests"


export function getStudentInfo() {
    return request({
        url: '/student/selectAll',
        method: 'get'
    })
}