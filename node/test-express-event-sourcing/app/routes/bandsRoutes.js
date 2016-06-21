'use strict';

var config = require('../config'),
    eventEmitter = require('../eventEmitter'),
    _ = require('lodash');

module.exports = function (harvesterApp) {
    
    function emitEvent(req) {
        var eventType = req.body.data.attributes.eventType.toLowerCase();
        eventEmitter.emit(eventType, req.body);
    }
    harvesterApp.router.post('/bands/:id/event', function(req, res){
        emitEvent(req);
        res.send('dssad')
    });
    
    harvesterApp.router.post('/bands/events', function(req, res){
        emitEvent(req);
        res.send('dssad')
    });
};