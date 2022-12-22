let express  = require('express');
let app = express()
let router = express.Router();
let mock = require('mockjs');
let bodyParser = require('body-parser')

let mockLogin = require("./mock_login.json")

app.use(bodyParser.urlencoded({extended: false}))
app.use(bodyParser.json())

app.all('*', function(req, res, next) {
    res.header("Access-Control-Allow-Origin", req.headers.origin);
    res.header("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
    res.header("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
    res.header("Access-Control-Allow-Credentials","true");
    res.header("X-Powered-By",' 3.2.1')
    if(req.method === "OPTIONS") res.send(200);/*让options请求快速返回*/
    else  next();
});

app.use("/stu-admin", router)
app.post("/stu-admin/login", function (req, res) {
    let logInData = req.body
    console.log(logInData.username)
    let userName = logInData.username
    if (userName === "root1") {
        res.json(mock.mock(mockLogin.success_op))
    } else {
        res.json(mock.mock(mockLogin.error_op))
    }
})

router.use("/student", require("./student"))
router.use("/curriculum", require("./course"))
router.use("/clazz", require("./classes"))

app.listen(8081, function () {
    console.log("mock server start!")
})