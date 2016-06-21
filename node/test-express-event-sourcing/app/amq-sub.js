var amqp = require('amqp');

var connection = amqp.createConnection(_this.options, _this.implOptions);

connection.on('ready', function () {
  connection.queue('queue-or-topic-name', function (queue) {
      // Catch all messages
      queue.bind('#');
      queue.subscribe(function (message) {
        console.log(message);
      });
  });
});