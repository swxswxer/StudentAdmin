let express = require('express');
let mock = require('mockjs');
let router = express.Router();

let studentAll = require('./mock_student_all.json')
let studentByName = require('./mock_student_select_by_name.json')
let studentByMajor = require('./mock_student_select_by_major.json')
let studentDelete = require('./mock_delect_by_Id.json')
let studentCourse = require("./mock_student_course.json")
let addStuCourse = require("./mock_add_course.json")
let delStuCourse = require("./mock_delete_course.json")

router.get('/selectStudentAllCurriculum', function (req, res) {
    let stuId = req.query.studentid
    console.log(stuId)
    console.log(`stuId: ${stuId}`)
    if (stuId % 2 === 0) {
        res.json(mock.mock(studentCourse.success))
    } else {
        res.json(mock.mock(studentCourse.error))
    }
})

router.get('/selectAll', function (req, res) {
    res.json(mock.mock(studentAll.student_info))
})

router.get("/selectByName", function (req, res) {
    res.json(mock.mock(studentByName.student_info))
})
router.get("/selectByMajor", function (req, res) {
    res.json(mock.mock(studentByMajor.student_info))
})
router.get("/deleteById", function (req, res) {
    let stuId = req.query.student_id
    console.log(`delete student id: ${stuId}`)
    if (stuId % 2 === 0) {
        res.json(mock.mock(studentDelete.success_op))
    } else {
        res.json(mock.mock(studentDelete.error_op))
    }
})
router.post("/update", function (req, res) {
    let stuInfo = req.body
    console.log(`student data: ${stuInfo.studentid}`)
    if (stuInfo.studentid % 2 === 0) {
        res.json(mock.mock(studentDelete.success_op))
    } else {
        res.json(mock.mock(studentDelete.error_op))
    }
})
router.post("/add", function (req, res) {
    res.json(mock.mock({"success": true}))
})

router.post("/addCurriculum", function (req, res) {
    let stuId = req.body.student_id

    if (stuId % 2 === 0) {
        res.json(mock.mock(addStuCourse.success))
    } else {
        res.json(mock.mock(addStuCourse.error))
    }
})

router.post("/deleteCurriculum", function (req, res) {
    let stuId = req.body.student_id

    if (stuId % 2 === 0) {
        res.json(mock.mock(delStuCourse.success))
    } else {
        res.json(mock.mock(delStuCourse.error))
    }
})


module.exports = router;