var Publisher = require('../amqp-pub');    
var publisher = new Publisher(config.rabbitmq.amqp);
var routingKey =  "submitOrder.key";
var json = JSON.parse(data.data)

publisher.publish(routingKey, 'message here');    