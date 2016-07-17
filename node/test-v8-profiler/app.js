var profiler = require('v8-profiler');
var snapshot = profiler.takeSnapshot('snapshot1');
profiler.startProfiling('snapshot1');

require('')

profiler.stopProfiling('snapshot1');
profiler.deleteAllSnapshots();