/*
* More details here http://mongoosejs.com/docs/guide.html
*/

var mongoose = require('mongoose');

var orderEvent = new mongoose.Schema({ 
    data:
    {
        type: {type:String},
        id: String,
        attributes: {
            eventType: String,
            eventDate: Date,
            body: {}
        },
        relationships: {
            aggregationRoots: [{}]
        }
    }
})

module.exports = mongoose.model('orderEvent', orderEvent); 