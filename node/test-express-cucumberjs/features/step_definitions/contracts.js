var $http = require('http-as-promised'),
    base_url = 'http://localhost:3000/',
    expect = require('chai').expect,
    responseBody,    
    statusCode,
    testVerb,
    testEndpoint;

module.exports = function() {
    this.Before(function(callback){
        require('../../app');
        callback();
    });

    this.Given(/^a sample contract that performs a (.*) against (.*)$/, function (verb, endpoint, callback) {
        testVerb = verb.toLowerCase();
        testEndpoint = endpoint;
        callback();
    });

    this.When(/^I exercise that action$/, function (callback) {
        var url = base_url + testEndpoint;
        return $http[testVerb](url)
        .then( res => {
            responseBody = res[0].body;
            statusCode = res[0].statusCode.toString();
        })
    });

    this.Then(/^I receive the adequate response with http status (.*)$/, function (status, callback) {
        expect(statusCode).to.equal(status);
        callback();
    });
};