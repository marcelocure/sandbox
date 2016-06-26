var connection = require('./amqpConnection'),
    events = require("events"),
    logger = require("log4js").getLogger("configAmqp"),
    eventEmitter = new events.EventEmitter(),
    eventsExchangeName = 'events_exchange',
    eventsQueues = ['node_queue','groovy_queue'],
    Promise = require('bluebird');

function stopIfError(err, result){
    if (!err){
        result();
    } else {
        logger.error("error: ", err);
        eventEmitter.emit("shutdown",{shutdownStatus:1});
    }
}

eventEmitter.on("mq_connected", conn => {
    conn.createChannel()
    .then(channel => {
        logger.info("Channel created");
        return eventEmitter.emit("mq_channel_created",channel);
    })
});

eventEmitter.on("mq_channel_created", channel => {
    channel.assertExchange(eventsExchangeName, 'fanout', {durable: true});
    logger.info("Exchange created: ", eventsExchangeName);
    return eventEmitter.emit("exchange_created", channel);
});

eventEmitter.on("exchange_created", channel =>{    
    return Promise.map(eventsQueues, queueName => {
        return channel.assertQueue(queueName, {durable: true})
        .then(queueResult => {
            const consumerKey = '';                    
            return channel.bindQueue(queueResult.queue, eventsExchangeName, consumerKey, {})
            .then(res => {
                logger.info("Queue created: " + queueName);
                return res;
            })
        })
    }).then( () => {
        logger.info("All queues configured");
        return eventEmitter.emit("shutdown",channel.connection);
    })
});

eventEmitter.on("shutdown", conn => {
    logger.info("Closing connection");
    if (conn){
        conn.close();
    }
});

connection
.then(conn => {
    return eventEmitter.emit("mq_connected", conn);
});