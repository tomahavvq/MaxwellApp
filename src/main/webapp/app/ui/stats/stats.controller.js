(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('StatsController', StatsController);

    function StatsController($scope, StatsData) {
        $scope.stats = StatsData.get({id: 1});

        $scope.choseStat = function(chosen){
            $scope.chosenstat = chosen;
        };

        $scope.isStat = function(chosen){
            return (chosen === $scope.chosenstat);
        };
    }
})();
