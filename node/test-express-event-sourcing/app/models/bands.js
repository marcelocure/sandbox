'use strict';
var Types = require('joi');

module.exports = function(harvesterApp) {
    harvesterApp.resource('band', {
        name: Types.string().required()
    })
};