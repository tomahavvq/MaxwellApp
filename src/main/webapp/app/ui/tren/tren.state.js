(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('tren', {
            parent: 'ui',
            url: '/tren',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Training'
            },
            views: {
                'content@': {
                    templateUrl: 'app/ui/tren/tren.html',
                    controller: 'TrainingController',
                    controllerAs: 'trainControl'
                }
            }
        });
    }
})();
