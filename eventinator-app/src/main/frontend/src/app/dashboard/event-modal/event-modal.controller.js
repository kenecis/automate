'use strict';
module.exports = [
    '$scope',
    '$uibModalInstance',
    'EventModalService',
    function ($scope, $uibModalInstance, EventModalService) {

        $scope.eventForm = {};

        $scope.submit = function () {
            EventModalService.submit().$promise.then(function(data){
                $uibModalInstance.close(data.data);
            }, function(err){
                console.log(err);
            });
        };

        $scope.cancel = function(){
            $uibModalInstance.dismiss('Cancelled');
        };

    }
];