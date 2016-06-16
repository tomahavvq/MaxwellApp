(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig ($stateProvider) {
        $stateProvider.state('ui', {
            abstract: true,
            parent: 'app'
        });
    }
})();
