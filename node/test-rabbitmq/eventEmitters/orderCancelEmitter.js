var queue_name = 'tasks';
    connection = require('amqpConnection')
 
connection
.then(function(conn) {
    return conn.createChannel();
})
.then(function(channel) {
	return channel.assertQueue(queue_name)
    .then(function(ok) {
        return channel.sendToQueue(queue_name, new Buffer('something to do'));
    })
    .then(ackSent => {
        if (ackSent) console.log('Published message');
    });
}).catch(console.warn);