(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('TrainingController', StatsController);

    StatsController.$inject = ['StatsData', '$scope'];

    function StatsController($scope) {
        $scope.stats = StatsData.get({part: 'users',id: '1'});
    }
})();
