import {request} from "./requests"


export function getStudentInfo() {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY_ALL,
        method: 'get'
    })
}

export function getStudentInfoByName(name) {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY_BY_NAME,
        method: 'get',
        params: {
            'name': name
        }
    })
}

export function getStudentInfoByMajor(major) {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY_BY_MAJOR,
        method: 'get',
        params: {
            'major': major
        }
    })
}

export function delectStudentById(studentId) {
    return request({
        url: process.env.VUE_APP_STUDENT_DELETE,
        method: 'get',
        params: {
            'student_id': studentId
        }
    })
}