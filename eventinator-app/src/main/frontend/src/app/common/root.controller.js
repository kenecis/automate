'use strict';
module.exports = [
    '$rootScope',
    'RootService',
    '$state',
    function ($rootScope, RootService, $state) {
        var vm = this;
        vm.controllerName = 'RootController';

        vm.logout = function () {
            RootService.logout().$promise.then(function () {
                delete $rootScope.currentUser;
                $state.go('evr.index');
            });
        };
    }
];