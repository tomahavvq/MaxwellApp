/**
 * Created by chevvson on 17.06.16.
 */
(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('atlasController', atlasController);

    atlasController.$inject = ['ExerciseData', '$scope'];

    function atlasController($scope) {

        $scope.getBodyPart = function(bodyId){
            $scope.exercises = ExerciseData.query({bodyPart: bodyId});
        };

        $scope.getExerciseDetail = function(number){
            $scope.currentExercise = $scope.exercises[number];
        };

    }
})();