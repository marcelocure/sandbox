'use strict';

var bandsEvents = require('../models/bandsEvents'),
    eventEmitter = require('../eventEmitter');
    
module.exports = function (harvesterApp) {
    function createBand(event) {
        logger.trace('create-band event received on createBandEventHandler with body ' + JSON.stringify(event));
        var body = event.eventBody;
        return new bandsEvents(body).save();
    }
    
    eventEmitter.on('create-band', createBand);
};