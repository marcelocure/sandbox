var express = require('express'),
    app = express(),
    bands = require('./seeds/bands'),
    bodyParser = require('body-parser'),
    uuid = require('uuid-v4');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/bands', function(req, res) {
    res.json(bands);
});

app.post('/bands', function(req, res) {
    var body = req.body;
    body.bands[0].id = uuid();
    bands.bands.push(body.bands);
    res.status(201);
    res.json(body);
});

app.listen(3000, function() {
    console.log('Listening on port 3000');
});