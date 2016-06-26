var queue_name = 'order-cancel';
 
var connection = require('amqpConnection')
 
connections.then(function(conn) {
    return conn.createChannel();
})
.then(function(channel) {
    return channel.assertQueue(queue_name)
    .then(function(ok) {
        return channel.consume(queue_name, function(msg) {
        if (msg !== null) {
            console.log('Received message');
            console.log(msg.content.toString());
            channel.ack(msg);
        }
    });
  });
})
.catch(console.warn);