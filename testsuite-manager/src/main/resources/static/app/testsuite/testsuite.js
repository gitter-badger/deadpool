(function () {
    'use strict';

    angular.module('app.testsuite').controller('TestSuite', TestSuite);

    /* @ngInject */
    function TestSuite($http, logger) {

        /*jshint validthis: true */
        var vm = this;
        vm.testsuites = [];

        activate();

        function activate() {
            return getTestSuites().then(function () {
                logger.info('Activated TestSuites View');
            });
        }

        function getTestSuites() {
            return $http({method: 'GET', url: '/test-suites'})
                .success(function (data, status, headers, config) {
                    vm.testsuites = data;
                    return vm.testsuites;
                }).
                error(function (data, status, headers, config) {

                });
        }
    }

})();    