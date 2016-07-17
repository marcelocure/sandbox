module.exports = function (harvesterApp) {
    return {
        getRecorders : function (query) {
            return harvesterApp.adapter.findMany('recorders', query);
        }
    }
}