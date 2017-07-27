const config = require('./config');
const authorSeeds = require('./seeds/authors');

async function testRethink() {
  var r = require('rethinkdbdash')({servers: [config.rethinkdb]});
  await r.tableCreate('authors').run();
  console.log('table authors created');
  await r.table('authors').insert(authorSeeds).run();
  console.log('seeds added');
  const laura = await r.table('authors').filter(r.row('name').eq("Laura Roslin")).run();
  console.log(JSON.stringify(laura));
}

testRethink();