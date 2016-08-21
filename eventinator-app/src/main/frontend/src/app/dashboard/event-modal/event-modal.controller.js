'use strict';
module.exports = [
    '$scope',
    '$uibModalInstance',
    'EventModalService',
    function ($scope, $uibModalInstance, EventModalService) {
        $scope.dateFormat = 'yyyy-MM-dd';
        $scope.eventForm = {};

        $scope.defaultDate = moment().format(($scope.dateFormat.toString().toUpperCase()));

        $scope.datePicker = {
            startDate: false,
            endDate: false
        };

        $scope.open = function (event) {
            event.preventDefault();
            event.stopPropagation();

            var target = $(event.target);
            if (target[0].nodeName === 'I') {
                target = $(event.target).parent();
            }

            if (target[0].dataset.targetPicker !== undefined) {
                $scope.datePicker[target[0].dataset.targetPicker] = true;
            }

        };

        $scope.formatDate = function (date) {
            return moment(date).format($scope.dateFormat.toString().toUpperCase());
        };


        $scope.submit = function () {
            EventModalService.submit($scope.eventForm).$promise.then(function(data){
                $uibModalInstance.close(data.data);
            }, function(err){
                console.log(err);
            });
        };

        $scope.cancel = function(){
            $uibModalInstance.dismiss('Cancelled');
        };


        $scope.loadInterests = function(query){
            EventModalService.interests().$promise.then(function(data){
                console.log(data);
            });
            return EventModalService.interests().$promise;
        };

    }
];