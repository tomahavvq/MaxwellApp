/**
 * Created by Matexo on 2016-06-20.
 */
(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('productController', productController)
    ;

    function productController($scope, ProductData){

        $scope.init = function(){
            $scope.products = ProductData.query();
        };


    }
})();
