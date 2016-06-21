'use strict';

var fs = require('fs'),
    harvester = require('harvesterjs'),
    config = require('./config'),
    _ = require('lodash'),
    options = {
        adapter: 'mongodb',
        connectionString: config.connectionString,
        oplogConnectionString: config.oplogConnectionString,
        inflect: true
    };
    
console.log(config.connectionString);
var harvesterApp = harvester(options);

function requireFolder(folderName) {
    fs.readdirSync('./app/'+folderName).map(function(fileName){
        console.log('Loading ('+folderName+') ' + fileName);
        require('./'+folderName+'/' + fileName)(harvesterApp);
    });
}
console.log('loading resources');
requireFolder('routes');
requireFolder('models');
requireFolder('eventHandlers');

harvesterApp.listen(config.port, () => console.log('listening on port ' + config.port));