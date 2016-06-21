'use strict';

var amqp = require('amqp'),
    Promise = require('bluebird'),
    logger = require('log4js').getLogger('amqp-pub')
;

function Publisher(config) {
	this.options = config.options;
	this.implOptions = config.implOptions;
	this.queue = config.queue;
}

Publisher.prototype.publish = function(queueName, payload) {
	var _this = this;

    return new Promise(function(resolve, reject) {
        var connection = amqp.createConnection(_this.options, _this.implOptions);
        
        logger.trace('amqp: sending message');
        logger.trace('amqp options: ', JSON.stringify(_this.options));
        logger.trace('amqp impl options: ', JSON.stringify(_this.implOptions));
        logger.trace('amqp queue: ', JSON.stringify(_this.queue));
        logger.trace('amqp queueName:', queueName);
        logger.trace('amqp payload:', JSON.stringify(payload));

        connection.on('ready', function() {
    		logger.trace('amqp: connection ready');

            connection.queue(_this.queue.name, _this.queue.options, function (queue) {                
                var exchangeOptions = {
                    "type"       :"direct",
                    "durable"    : true,
                    "autoDelete" : true
                }
                
                connection.exchange(_this.implOptions.defaultExchangeName,exchangeOptions, function (exchange) {
                    queue.bind(exchange,queueName);
                    
                    var options = {
                        "mandatory"  : true,                        
                    };
                    exchange.publish(queueName,payload,options,function(){
                        logger.info("publish");
                        resolve();    
                    });
                });
            });
        });

        connection.on('error', function(err) {
        	if (err.code !== 'ECONNRESET') {
            	logger.error('amqp: error', err);
            	reject();
            }
        });

        connection.on('heartbeat', function() {
	    	this.disconnect();
	    });

	    connection.on('close', function() {
        	logger.trace('amqp: connection closing');
    	});
    });
};

module.exports = Publisher;