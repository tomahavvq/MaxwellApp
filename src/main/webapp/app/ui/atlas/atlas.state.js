/**
 * Created by chevvson on 17.06.16.
 */
(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('atlas', {
            parent: 'ui',
            url: '/atlas',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Exercises'
            },
            views: {
                'content@': {
                    templateUrl: 'app/ui/atlas/atlas.html',
                    controller: 'atlasController',
                    controllerAs: 'atlas'
                }
            }
        });
    }
})();