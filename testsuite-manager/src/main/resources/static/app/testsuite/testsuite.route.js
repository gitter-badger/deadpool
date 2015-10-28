(function () {
    'use strict';

    angular
        .module('app.testsuite')
        .run(appRun);

    appRun.$inject = ['routehelper'];

    /* @ngInject */
    function appRun(routehelper) {
        routehelper.configureRoutes(getRoutes());
    }

    function getRoutes() {
        return [
            {
                url: '/testsuite',
                config: {
                    templateUrl: 'app/testsuite/testsuite.html',
                    controller: 'TestSuite',
                    controllerAs: 'vm',
                    title: 'Test Suites',
                    settings: {
                        nav: 3,
                        content: '<i class="fa fa-dashboard"></i> Test Suites'
                    }
                }
            }
        ];
    }
})();
