import {request} from "./requests"

export function login(username, password) {
  return request({
    url: process.env.VUE_APP_LOGIN_API,
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
