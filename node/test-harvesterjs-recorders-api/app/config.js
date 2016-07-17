'use strict';
var config = {};

config.connectionString = 'mongodb://127.0.0.1:27017/recorders-api-db';
config.oplogConnectionString = 'mongodb://127.0.0.1:27017/local';
config.port = process.env.PORT || 4567;

module.exports = config;
