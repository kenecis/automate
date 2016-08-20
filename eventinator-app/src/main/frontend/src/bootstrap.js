'use strict';
angular.element(document).ready(function(){
    angular.bootstrap(document, [
        'ui.router',
        'ngResource',
        'ui.bootstrap',
        'ngMessages',
        'app'
    ]);
});