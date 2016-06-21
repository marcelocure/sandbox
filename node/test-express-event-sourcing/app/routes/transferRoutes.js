'use strict';

var logger = require('log4js').getLogger("transferRoutes"),
    $http = require('http-as-promised'),
    deviceFeatureRepository,
    config = require('../config'),
    _ = require('lodash'),
    validate = require("validate.js"),
    validations;

module.exports = function (harvesterApp) {
    harvesterApp.router.post('/deviceFeatures/:id/transfer', function(req, res){
        res.send('dadassda');
    });
};