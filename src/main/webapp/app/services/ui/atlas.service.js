/**
 * Created by chevvson on 17.06.16.
// */
(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .factory('ExerciseData', ExerciseData);

    ExerciseData.$inject = ['$resource'];

    function ExerciseData ($resource) {
        return $resource('api/exercise/bodyPart/:bodyPart')

    }
})();
