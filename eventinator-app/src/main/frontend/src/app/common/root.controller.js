'use strict';
module.exports = [
    '$rootScope',
    'RootService',
    '$state',
    function ($rootScope, RootService, $state) {
        var vm = this;
        vm.controllerName = 'RootController';
        vm.loginForm = {};

        vm.login = function () {
            var loginForm = angular.copy(vm.loginForm);
            RootService.login(loginForm).$promise.then(
                function (user) {
                    $rootScope.currentUser = user;

                }, function (error) {
                    console.log(error);
                }
            );
        };
        vm.logout = function(){
            RootService.logout().$promise.then(function(){
                delete $rootScope.currentUser;
                $state.go('evr.index');
            });
        };
    }
];