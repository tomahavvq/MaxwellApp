(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('TrainingDetailController', TrainingDetailController);

    TrainingDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'TrainingData', 'User'];

    function TrainingDetailController($scope, $rootScope, $stateParams, entity, TrainingData, User) {
        var vm = this;
        vm.training = entity;

    }
})();
