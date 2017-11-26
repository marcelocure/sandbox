const zmq = require('zeromq');
const subscriber = zmq.socket('sub');

subscriber.on("message", (reply) => {
  console.log('Received message: ', reply.toString());
})

subscriber.connect("tcp://localhost:8688");
subscriber.subscribe("");

process.on('SIGINT', () => {
  subscriber.close();
  console.log('\nClosed');
});