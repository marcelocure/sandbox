'use strict';
var joi = require('joi');

module.exports = function (fortuneApp) {
    fortuneApp.resource('recorder', {
        name: joi.string().required()
    });
};