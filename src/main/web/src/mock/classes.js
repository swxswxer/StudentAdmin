let express = require('express');
let mock = require('mockjs');
let router = express.Router();

let allClass = require("./mock_all_class.json")

router.get('/selectAll', function (req, res) {
    res.json(mock.mock(allClass.success))
})

module.exports = router;