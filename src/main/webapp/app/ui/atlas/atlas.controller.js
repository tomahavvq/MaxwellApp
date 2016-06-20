/**
 * Created by chevvson on 17.06.16.
 */
(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('atlasController', atlasController)
        ;

    function atlasController($scope, ExerciseData){
        $scope.currentExercise = [];

        $scope.init = function(part){
            $scope.exercises = ExerciseData.query({bodyPart: part});
            $scope.currentExercise = $scope.exercises[0];
        };

        $scope.getBodyPart = function(bodyId){
            $scope.exercises = ExerciseData.query({bodyPart: bodyId});

        };

        $scope.getExerciseDetail = function(number){
            $scope.currentExercise = $scope.exercises[number];
        };

    }
})();
