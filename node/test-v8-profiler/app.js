var http = require('http-as-promised');
var fs = require('fs');
var profiler = require('v8-profiler');
var snapshot = profiler.takeSnapshot('snapshot1');
profiler.startProfiling('snapshot1');

http.get('https://api.nasa.gov/planetary/apod?api_key=WHMXIbIFDmEiTWAbnUUYw9Mvdj40xPLAZ0IhhN22')
.then(result => {
    console.log(JSON.stringify(result));
    console.log(snapshot);
    snapshot.export(function(error, result) {
        fs.writeFileSync('snapshot1.json', result);
        snapshot.delete();
    });
})

