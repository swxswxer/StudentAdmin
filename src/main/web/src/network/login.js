import {request} from "./requests"
import {Message} from "element-ui";

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
  }).then(res => {
    if (res.success === true) {
      Message.success(res.message)
    } else {
      Message.error(res.message)
    }
    return res
  })
}
