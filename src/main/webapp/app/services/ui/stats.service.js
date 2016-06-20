/**
 * Created by chevvson on 17.06.16.
 */
(function() {
    'use strict';

    angular
        .module('maxwellApp')
        .factory('StatsData', StatsData);

    StatsData.$inject = ['$resource'];

    function StatsData ($resource) {
        return $resource('api/statistic/:id');
    };
})();
