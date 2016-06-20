(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('training', {
                parent: 'ui',
                url: '/training?page&sort&search',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'Training'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/ui/tren/tren.html',
                        controller: 'TrainingController',
                        controllerAs: 'vm'
                    }
                },
                params: {
                    page: {
                        value: '1',
                        squash: true
                    },
                    sort: {
                        value: 'id,asc',
                        squash: true
                    },
                    search: null
                },
                resolve: {
                    pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                        return {
                            page: PaginationUtil.parsePage($stateParams.page),
                            sort: $stateParams.sort,
                            predicate: PaginationUtil.parsePredicate($stateParams.sort),
                            ascending: PaginationUtil.parseAscending($stateParams.sort),
                            search: $stateParams.search
                        };
                    }],
                }
            })
            .state('training-detail', {
                parent: 'ui',
                url: '/training/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'Training'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/ui/tren/training-detail.html',
                        controller: 'TrainingDetailController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'TrainingData', function ($stateParams, TrainingData) {
                        return TrainingData.get({id: $stateParams.id});
                    }]
                }
            });
    }
})();
