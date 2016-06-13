var express = require('express'),
    app = express(),
    bands = require('./seeds/bands');

app.get('/bands', function(req, res) {
    res.json(bands);
});

app.post('/bands', function(req, res) {
    res.status(201);
    res.json(req.body);
});

app.listen(3000, function() {
    console.log('Listening on port 3000');
});