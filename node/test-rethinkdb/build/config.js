'use strict';

module.exports = {
  rethinkdb: {
    host: process.env.RETHINK_HOST || 'localhost',
    port: process.env.RETHINK_PORT || 28015
  }
};