'use strict';
module.exports = angular.module('app', [])
    .config([
        '$urlRouterProvider', '$stateProvider',
        function ($urlRouterProvider, $stateProvider) {

            $urlRouterProvider.otherwise(function ($injector) {
                var $state = $injector.get('$state');
                $state.go('evr.index');
            });

            $stateProvider.state('evr', {
                url: '/',
                template: require('./common/template.html'),
                controller: require('./common/root.controller'),
                controllerAs: 'vm',
                abstract: true
            }).state('evr.index', {
                url: '',
                template: require('./common/unauthenticated.html'),
                data: {
                    requireLogin: false
                }
            });
        }
    ])
    .run([
        '$rootScope', '$state', 'RootService',
        function ($rootScope, $state, RootService) {
            $rootScope.$on('$stateChangeStart', function (e, toState) {
                RootService.principal().$promise.then(function (user) {
                    $rootScope.currentUser = user;
                    if (toState.data.requireLogin &&
                        $rootScope.currentUser !== undefined &&
                        $rootScope.currentUser.userType !== toState.data.userType) {
                        event.preventDefault();
                        RootService.logout().$promise.then(function () {
                            $state.go('evr.index');
                        });
                    }
                }, function(){
                    event.preventDefault();
                    $state.go('evr.index');
                });
            });
        }
    ])
    .service('RootService', require('./common/root.service'));