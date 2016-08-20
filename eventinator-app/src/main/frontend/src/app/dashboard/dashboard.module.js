'use strict';
module.exports = angular.module('app')
    .config([
        '$urlRouterProvider', '$stateProvider',
        function ($urlRouterProvider, $stateProvider) {
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
    ]);