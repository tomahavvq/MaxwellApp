(function () {
    'use strict';
    angular
        .module('maxwellApp')
        .factory('RunData', RunData);

    RunData.$inject = ['$resource', 'DateUtils'];

    function RunData($resource, DateUtils) {
        var resourceUrl = 'api/run/:id';

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
