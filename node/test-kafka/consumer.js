var Kafka = require('no-kafka');
var consumer = new Kafka.SimpleConsumer();
 
// data handler function can return a Promise 
var dataHandler = function (messageSet, topic, partition) {
    messageSet.forEach(function (m) {
        console.log({
            'topic':topic,
            'partition': partition,
            'offset': m.offset,
            'message': m.message.value.toString('utf8')
        });
    });
};
 
return consumer.init().then(function () {
    // Subscribe partitons 0 and 1 in a topic: 
    return consumer.subscribe('kafka-test-topic', 0, dataHandler);
});