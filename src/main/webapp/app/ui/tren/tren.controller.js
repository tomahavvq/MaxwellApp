(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('TrainingController', TrainingController);


    TrainingController.$inject = ['TrainingData', '$scope'];


    function TrainingController(TrainingData, $scope) {
        $scope.items = TrainingData.getAll({user: 4});
        $scope.warunek = true;
        $scope.getTrainingInfo = function (trainID) {
            $scope.selected = $scope.items[trainID];
        }
    }
})();
