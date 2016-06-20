(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .factory('TrainingData', TrainingData);

    TrainingData.$inject = ['$resource', 'DateUtils'];

    function TrainingData($resource, DateUtils) {
        var resourceUrl = 'api/training/:id';
        return $resource(resourceUrl, {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.dateTime = DateUtils.convertLocalDateFromServer(data.dateTime);
                    return data;
                }
            }
        });
    }
})();
