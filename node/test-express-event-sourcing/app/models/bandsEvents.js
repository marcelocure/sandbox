var mongoose = require('mongoose'),
    config = require('../config');
    db = mongoose.connect(config.connectionString);

var bandsEventsSchema = new mongoose.Schema({ 
    data:
    {
        type: {type:String},
        id: String,
        attributes: {
            eventType: String,
            eventDate: Date,
            body: {}
        }
    }
})

module.exports = db.model('bandsEvents', bandsEventsSchema);