(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .factory('TrainingData', TrainingData);

    TrainingData.$inject = ['$resource'];

    function TrainingData ($resource) {
        return $resource('api/training/user/:user', {}, {
            'getAll': { method: 'GET', isArray: false}
        });
    }
})();
