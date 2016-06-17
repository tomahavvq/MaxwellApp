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
        $stateProvider.state('calc', {
            parent: 'ui',
            url: '/calc',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Calculators'
            },
            views: {
                'content@': {
                    templateUrl: 'app/ui/calc/calc.html',
                    controller: 'calculatorController',
                    controllerAs: 'calc'
                }
            }
        });
    }
})();