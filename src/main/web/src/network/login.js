import {request} from "./requests"

export function login(username, password) {
  return request({
    url: '/login',
    method: 'post',
    data: {
      username: username,
      password: password
    },
    headers: {
      'Content-Type': 'application/form-data',
    },
  })
}
