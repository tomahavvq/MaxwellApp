/**
 * Created by Matexo on 2016-06-20.
 */
(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .factory('ProductData', ProductData);

    ProductData.$inject = ['$resource'];

    function ProductData ($resource) {
        return $resource('api/product');

    }
})();
