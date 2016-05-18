var schedule = require('node-schedule');
 
var rule = new schedule.RecurrenceRule();
rule.hour = 01;
rule.minute = 30;
 
var j = schedule.scheduleJob(rule, function(){
  console.log('This will be printed at 1:30 am');
});