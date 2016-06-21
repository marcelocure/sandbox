'use strict';

var BandsEvents = require('../models/bandsEvents'),
    eventEmitter = require('../eventEmitter'),
    uuid = require('uuid-v4');
    
module.exports = function (harvesterApp) {
    function createBand(event) {
        var body = event;
        body.data.id = uuid();
        body.data.attributes.eventDate = new Date();
        console.log('create-band event received on createBandEventHandler with body ' + JSON.stringify(body));
        new BandsEvents(body).save();
        return harvesterApp.adapter.create('band', body.data.attributes.body);
    }
    
    eventEmitter.on('create-band', createBand);
};