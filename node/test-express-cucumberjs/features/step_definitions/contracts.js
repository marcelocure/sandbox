var $http = require('http-as-promised'),
    expect = require('chai').expect,
    responseBody,    
    statusCode,
    testVerb,
    testEndpoint,
    expectedResponse,
    request;

module.exports = function() {
    this.Before(function(callback){
        require('../../app');
        callback();
    });

    this.Given(/^a sample contract that performs a (.*) against (.*)$/, function (verb, endpoint, callback) {
        testVerb = verb.toLowerCase();
        testEndpoint = endpoint;
        fixture = require('../fixtures/'+testEndpoint+'.fixtures.js');
        expectedResponse = fixture[testVerb]['response'][endpoint];
        request = fixture[testVerb].request;
        callback();
    });

    this.When(/^I exercise that action$/, function (callback) {
        var url = 'http://localhost:3000/' + testEndpoint;
        return $http[testVerb](url, {json: request})
        .then( res => {
            responseBody = res[0].body;
            statusCode = res[0].statusCode.toString();
        });
    });

    this.Then(/^I receive the adequate response with http status (.*)$/, function (status, callback) {
        expect(expectedResponse[0]).to.include.keys(responseBody[testEndpoint][0]);
        expect(statusCode).to.equal(status);
        callback();
    });
};