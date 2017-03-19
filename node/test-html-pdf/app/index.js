//https://www.npmjs.com/package/html-pdf
var fs = require('fs');
var pdf = require('html-pdf');
var html = fs.readFileSync('./app/test/businesscard.html', 'utf8');
var options = { format: 'Letter' };
 
pdf.create(html, options).toFile('./businesscard.pdf', function(err, res) {
  if (err) return console.log(err);
  console.log(res); // { filename: '/app/businesscard.pdf' } 
});