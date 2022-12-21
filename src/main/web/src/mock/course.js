let express = require('express');
let mock = require('mockjs');
let router = express.Router();

let allCourse = require("./mock_all_course.json")

router.get('/selectAll', function (req, res) {
    res.json(mock.mock(allCourse.success))
})

module.exports = router;