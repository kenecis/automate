'use strict';
module.exports = angular.module('app.dashboard',[])
    .config([
        '$urlRouterProvider', '$stateProvider',
        function ($urlRouterProvider, $stateProvider) {
            $stateProvider.state('evr.dashboard', {
                url: 'dashboard',
                template: require('./dashboard.html'),
                controller: require('./dashboard.controller'),
                controllerAs: 'vm',
                abstract: true
            }).state('evr.dashboard.index', {
                url: '',
                template: require('./landing.html'),
                controller: require('./landing.controller'),
                controllerAs: 'vm'
            });
        }
    ]).service('EventModalService', require('./event-modal/event-modal.service'));