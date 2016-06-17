(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('TrainingController', StatsController);

    StatsController.$inject = ['$scope'];

    function StatsController($scope) {
        $scope.stats = StatsData.get({part: 'users',id: '1'});
        $scope.hej = "DUPA";
        $scope.chosenstat = false;

        $scope.choseStat = function(chosen){
            $scope.chosenstat = chosen;
        };

        $scope.isStat = function(chosen){
            return (chosen === $scope.chosenstat);
        };
    }
})();
