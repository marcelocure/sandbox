'use strict';

var _regenerator = require('babel-runtime/regenerator');

var _regenerator2 = _interopRequireDefault(_regenerator);

var _stringify = require('babel-runtime/core-js/json/stringify');

var _stringify2 = _interopRequireDefault(_stringify);

var _asyncToGenerator2 = require('babel-runtime/helpers/asyncToGenerator');

var _asyncToGenerator3 = _interopRequireDefault(_asyncToGenerator2);

// async function testRethink() {
//   console.log(`connecting to ${JSON.stringify(config.rethinkdb)}`)
//   const connection = await connect(config.rethinkdb);
//   rdb.db('test').tableCreate('bands').run(connection, function(err, result) {
//     if (err) throw err;
//     console.log(JSON.stringify(result, null, 2));
//   })
//   rdb.table('authors').insert(authorSeeds).run(connection, function(err, result) {
//     if (err) throw err;
//     console.log(JSON.stringify(result, null, 2));
//   })

// }


var testRethink = function () {
  var _ref = (0, _asyncToGenerator3.default)(_regenerator2.default.mark(function _callee() {
    var r, laura;
    return _regenerator2.default.wrap(function _callee$(_context) {
      while (1) {
        switch (_context.prev = _context.next) {
          case 0:
            r = require('rethinkdbdash')({ servers: [config.rethinkdb] });
            _context.next = 3;
            return r.tableCreate('authors').run();

          case 3:
            console.log('table authors created');
            _context.next = 6;
            return r.table('authors').insert(authorSeeds).run();

          case 6:
            console.log('seeds added');
            _context.next = 9;
            return r.table('authors').filter(r.row('name').eq("Laura Roslin")).run();

          case 9:
            laura = _context.sent;

            console.log((0, _stringify2.default)(laura));

          case 11:
          case 'end':
            return _context.stop();
        }
      }
    }, _callee, this);
  }));

  return function testRethink() {
    return _ref.apply(this, arguments);
  };
}();

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

// const rdb = require('rethinkdb');
// const Promise = require('bluebird');
var config = require('./config');
// const connect = Promise.promisify(rdb.connect);
var authorSeeds = require('./seeds/authors');

testRethink();