'use strict';
module.exports = [
    '$uibModal',
    function ($uibModal) {
        var vm = this;
        vm.controllerName = 'LandingController';

        vm.eventSources = [];
        vm.uiConfig = {
            calendar:{
                height: 450,
                editable: true,
                header:{
                    left: 'month basicWeek basicDay agendaWeek agendaDay',
                    center: 'title',
                    right: 'today prev,next'
                }
            }
        };

        vm.openEventModal = function () {

            var modalInstance = $uibModal.open({
                templateUrl: '/modal-tpl/event-modal.html',
                controller: require('./event-modal/event-modal.controller')
            });

            modalInstance.result.then(function(data){
                console.log(data);
            }, function(reason){
                console.log(reason);
            });
        };


    }

];