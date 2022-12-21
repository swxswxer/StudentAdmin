import {request} from "./requests"


export function getStudentInfo() {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY_ALL,
        method: 'get',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function getStudentInfoByName(name) {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY_BY_NAME,
        method: 'get',
        params: {
            'name': name
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function getStudentInfoByMajor(major) {
    return request({
        url: process.env.VUE_APP_STUDENT_QUERY_BY_MAJOR,
        method: 'get',
        params: {
            'major': major
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function delectStudentById(studentId) {
    return request({
        url: process.env.VUE_APP_STUDENT_DELETE,
        method: 'get',
        params: {
            'student_id': studentId
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function updateStudentInfo(studentData) {
    return request({
        url: process.env.VUE_APP_STUDENT_UPDATE,
        method: 'post',
        data: studentData,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function studentAddCourse(studentId, courseIds) {
    return request({
        url: process.env.VUE_APP_STU_ADD_COURSE,
        method: 'post',
        data: {
            student_id: studentId,
            majors: courseIds
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
}

export function studentDeleteCourse(studentId, courseIds) {
    return request({
        url: process.env.VUE_APP_STU_DELETE_COURSE,
        method: 'post',
        data: {
            student_id: studentId,
            majors: courseIds
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
}

export function queryStudentCourse(studentId) {
    return request({
        url: process.env.VUE_APP_QUERY_STU_COURSE,
        method: 'get',
        params: {
            studentid: studentId,
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
}


