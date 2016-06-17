(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('stats', {
            parent: 'ui',
            url: '/stats',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Statistics'
            },
            views: {
                'content@': {
                    templateUrl: 'app/ui/stats/stats.html',
                    controller: 'StatsController',
                    controllerAs: 'stats'
                }
            }
        });
    }
})();
