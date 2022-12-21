import {request} from "@/network/requests";

export function getAllCourse() {
    return request({
        url: process.env.VUE_APP_COURSE_QUERY_ALL,
        method: 'get',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function addCourse(courseInfo) {
    return request({
        url: process.env.VUE_APP_COURSE_ADD,
        method: 'post',
        data:courseInfo,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function updateCourse(courseInfo) {
    return request({
        url: process.env.VUE_APP_COURSE_UPDATE,
        method: 'post',
        data: courseInfo,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}

export function deleteCourse(id) {
    return request({
        url: process.env.VUE_APP_COURSE_DELETE,
        method: 'get',
        params: {
            "id": id
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
    })
}