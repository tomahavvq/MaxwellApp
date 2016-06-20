/**
 * Created by Matexo on 2016-06-20.
 */
(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('product', {
            parent: 'ui',
            url: '/product',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Product'
            },
            views: {
                'content@': {
                    templateUrl: 'app/ui/product/product.html',
                    controller: 'productController',
                    controllerAs: 'product'
                }
            }
        });
    }
})();
